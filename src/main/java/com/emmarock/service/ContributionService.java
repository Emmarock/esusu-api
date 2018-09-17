package com.emmarock.service;

import com.emmarock.model.Contribution;
import com.emmarock.model.Contributor;
import com.emmarock.repository.ContributionRepository;
import com.emmarock.repository.ContributorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class ContributionService {
    private final
    ContributionRepository contributionRepository;
    private final
    ContributorRepository contributorRepository;

    @Autowired
    public ContributionService(ContributionRepository contributionRepository, ContributorRepository contributorRepository) {
        this.contributionRepository = contributionRepository;
        this.contributorRepository = contributorRepository;
    }

    public Contribution credit(Contribution contribution) {
        return contributionAction(contribution);
    }

    private Contribution contributionAction(Contribution contribution) {
        Contributor contributor = contributorRepository.findContributorById(contribution.getContributorId());
        BigInteger balance = contributor.getBalance();
        if (contribution.getTransactionType().equals("Credit")) {
            balance = balance.add(BigInteger.valueOf(Integer.valueOf(contribution.getAmount())));
        }else if(contribution.getTransactionType().equals("Debit")){
            balance = balance.subtract(BigInteger.valueOf(Integer.valueOf(contribution.getAmount())));
        }
        contributor.setBalance(balance);
        contributorRepository.save(contributor);
        return contributionRepository.save(contribution);
    }

    public Contributor getContributor(String contributorId) {
        return contributorRepository.findContributorById(contributorId);
    }

    public Contribution debit(Contribution contribution) {
        return contributionAction(contribution);
    }
}
