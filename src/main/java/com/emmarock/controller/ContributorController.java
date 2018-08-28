package com.emmarock.controller;

import com.emmarock.model.Contributor;
import com.emmarock.repository.ContributorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/v1/contributor")
public class ContributorController {

    @Autowired
    ContributorRepository contributorRepository;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public Contributor createContributor(@RequestBody Contributor contributor){
        return contributorRepository.save(contributor);
    }

}
