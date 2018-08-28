package com.emmarock.service;

import com.emmarock.model.SecurityUser;
import com.emmarock.repository.SecurityUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by babajide.apata on 1/31/2017.
 */
@Service
public class SecurityUserDetailsService implements UserDetailsService{
    @Autowired
    SecurityUserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<SecurityUser> user =  repository.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException(username);
        }else{
            UserDetails details = new SecurityUserDetails(user);
            return details;
        }
    }
}
