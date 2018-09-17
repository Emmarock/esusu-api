package com.emmarock.repository;

import com.emmarock.model.Contribution;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;

public interface ContributionRepository extends MongoRepository<Contribution, String> {
    Contribution findContributionsById(String contributorId);
    List<Contribution> findContributionsByContributorIdOrderByDate(String contributorId);
    List<Contribution> findContributionsByDateBetween(Date date, Date date2);
    List<Contribution> findContributionsByDate(Date date);
    List<Contribution> findContributionsByDateBetweenAndContributorId(Date date, Date date2, String contributor_id);
}
