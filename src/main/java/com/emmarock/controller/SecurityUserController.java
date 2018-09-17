package com.emmarock.controller;

import com.emmarock.model.TokenResponse;
import com.emmarock.model.Contributor;
import com.emmarock.security.jwt.TokenAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/oauth")
public class SecurityUserController {
    @Autowired
    TokenAuthenticationService tokenAuthenticationService;

    @PostMapping(value = "/token", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public TokenResponse getTokenForUsername(@RequestBody Contributor contributor){
        return tokenAuthenticationService.generateToken(contributor);
    }

    @GetMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public TokenResponse getClientIdAndSecret(@RequestBody Contributor contributor){
        return tokenAuthenticationService.generateToken(contributor);
    }

}
