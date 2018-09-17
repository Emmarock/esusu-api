package com.emmarock.repository;

import com.emmarock.model.Contributor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ContributorRepository extends MongoRepository<Contributor, String> {
    Contributor findContributorById(String id);
    Contributor findContributorByUsernameOrPhoneNumber(String username, String phoneNumber);
}
