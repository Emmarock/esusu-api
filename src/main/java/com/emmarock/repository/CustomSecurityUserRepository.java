package com.emmarock.repository;

import com.emmarock.model.SecurityUser;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by babajide.apata on 1/31/2017.
 */
public interface CustomSecurityUserRepository extends MongoRepository<SecurityUser,Long> {
    List<SecurityUser> findByUsername(String username);
}
