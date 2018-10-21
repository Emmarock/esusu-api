package com.emmarock.controller;

import com.emmarock.exception.DuplicateException;
import com.emmarock.exception.NotFoundException;
import com.emmarock.model.Contributor;
import com.emmarock.model.NotificationTypes;
import com.emmarock.repository.ContributorRepository;
import com.emmarock.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/api/v1/contributor")
public class ContributorController {

    private final ContributorRepository contributorRepository;
    private final NotificationService notificationService;

    @Autowired
    public ContributorController(ContributorRepository contributorRepository,  NotificationService notificationService) {
        this.contributorRepository = contributorRepository;
        this.notificationService = notificationService;
    }

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Contributor createContributor(@RequestBody Contributor contributor) throws Exception {
        System.out.println(contributor.toString());
        if (contributorRepository.findOne(contributor.getId()) !=null){
            throw new DuplicateException("Possible duplicate registration, user already exist");
        }
        contributor.setBalance(BigInteger.ZERO);
        if (!contributor.getNotificationMode().equalsIgnoreCase("TEST")){
            String message =String.format("Welcome to Esusu, your account number is %s ",contributor.getPhoneNumber());
            notificationService.notifyUser(contributor.getPhoneNumber(),message, NotificationTypes.WELCOME.toString());
        }
        return contributorRepository.save(contributor);
    }

    @PutMapping(value = "/",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Contributor updateContributor(@RequestBody Contributor contributor){
        if (contributorRepository.findOne(contributor.getId()) !=null){
            return contributorRepository.save(contributor);
        }
        throw  new NotFoundException(String.format("Contributor with id %s does not ",contributor.getId()));
    }

    @GetMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<Contributor> getAllContributor(){
        return contributorRepository.findAll();
    }

    @GetMapping(value = "/{contributorId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Contributor getContributor(@PathVariable("contributorId") String contributorId){
        Contributor contributor  =contributorRepository.findOne(contributorId);
        if (contributor==null){
            throw  new NotFoundException(String.format("Contributor with id %s does not ",contributorId));
        }
        return contributor;
    }
    @GetMapping(value = "username/{username}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Contributor getContributorByUsername(@PathVariable("username") String username, String phoneNumber){
        return contributorRepository.findContributorByUsernameOrPhoneNumber(username, phoneNumber);
    }

}
