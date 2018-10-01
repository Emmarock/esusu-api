package com.emmarock.controller;

import com.emmarock.model.Contribution;
import com.emmarock.model.Contributor;
import com.emmarock.model.NotificationTypes;
import com.emmarock.repository.ContributionRepository;
import com.emmarock.service.ContributionService;
import com.emmarock.service.NotificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.InvalidObjectException;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/contributions")
public class ContributionController {
    private final ContributionRepository contributionRepository;
    private final ContributionService contributionService;
    private final NotificationService notificationService;
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    public ContributionController(ContributionRepository contributionRepository, ContributionService contributionService, NotificationService notificationService) {
        this.contributionRepository = contributionRepository;
        this.contributionService = contributionService;
        this.notificationService = notificationService;
    }

    @PostMapping(value = "/credit", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Contribution credit(@RequestBody Contribution contribution) throws Exception {
        contribution.setTransactionType("Credit");
        Contributor contributor = contributionService.getContributor(contribution.getContributorId());
        if (!contributor.getNotificationMode().equals("TEST")){
            String message =String.format("Your account %s has been credited with %s on %s by %s ",contributor.getPhoneNumber(),
                    contribution.getAmount(), contribution.getDate(), contributor.getUsername());
            logger.info(message);
            notificationService.notifyUser(contributor.getPhoneNumber(),message, NotificationTypes.CREDIT.toString());
        }
        return contributionService.credit(contribution);
    }

    @PostMapping(value = "/debit", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Contribution debit(@RequestBody Contribution contribution) throws Exception {
        contribution.setTransactionType("Debit");
        Contributor contributor = contributionService.getContributor(contribution.getContributorId());
        if (!contributor.getNotificationMode().equals("TEST")){
            String message =String.format("Your account %s has been debited with %s on %s by %s ",contributor.getPhoneNumber(),
                    contribution.getAmount(), contribution.getDate(),contributor.getUsername());
            logger.info(message);
            notificationService.notifyUser(contributor.getPhoneNumber(),message, NotificationTypes.CREDIT.toString());
        }
        return contributionService.debit(contribution);
    }

    @PutMapping(value = "update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Contribution updateContribution(@PathVariable("id") String contributorId, @RequestBody Contribution contribution) throws InvalidObjectException {
        Contribution contribution1 = contributionRepository.findContributionsById(contributorId);
        if (contribution1!=null){
            return contributionRepository.save(contribution);
        }else {
            String message = String.format("Contribution with id %s does not ", contributorId);
            logger.info(message);
            throw new InvalidObjectException(message);
        }
    }

    @GetMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Contribution> getContributionByContributorIdOrderByDate(@PathVariable("id") String contributorId){
        return contributionRepository.findContributionsByContributorIdOrderByDate(contributorId);
    }
    @GetMapping(value = "/from/{fromDate}/to/{toDate}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<Contribution> getContributionBetweenDates(@PathVariable("fromDate") Date fromDate, @PathVariable("toDate") Date toDate){
        return contributionRepository.findContributionsByDateBetween(fromDate, toDate);
    }

    @GetMapping(value = "date/{date}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<Contribution> getContributionDate(@PathVariable("date") Date fromDate){
        return contributionRepository.findContributionsByDate(fromDate);
    }

    @PostMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<Contribution> getContributionByContributor(@PathVariable("id") String contributorId, @PathVariable Date date1, @PathVariable Date date2){
        return contributionRepository.findContributionsByDateBetweenAndContributorId(date1,date2,contributorId);
    }



}
