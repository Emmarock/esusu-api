package com.emmarock.security.jwt;

import com.emmarock.model.SecurityUser;
import com.emmarock.model.TokenResponse;
import com.emmarock.model.UsersDetails;
import com.emmarock.service.SecurityUserDetails;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.UUID;

/**
 * Created by babajide.apata on 1/31/2017.
 */
@Service
public class TokenAuthenticationService {

    private String secret = "esusu";
    private String tokenPrefix = "Bearer";
    private String headerString = "Authorization";
    String aud = "esusu";
    public void addAuthentication(HttpServletResponse response, UsersDetails username) {
        // We generate a token now.
        String JWT = generateToken(username).getAccessToken();
        response.addHeader(headerString, tokenPrefix + " " + JWT);
    }

    public TokenResponse generateToken(UsersDetails username) {
        long expirationTime = 1000 * 60 * 60 * 24;
        UUID uuid =  UUID.randomUUID();
        TokenResponse tokenResponse = new TokenResponse();
        Date issueAt = new Date(System.currentTimeMillis() );
        Date expires = new Date(System.currentTimeMillis() + expirationTime);
        String token = Jwts.builder()
                 .claim("User", username)
                    .setSubject(username.getUsername())
                    .setIssuedAt(issueAt)
                 //   .setPayload(username.toString())
                    .setAudience(aud)
                    .setId(uuid.toString())
                    .setExpiration(expires)
                    .signWith(SignatureAlgorithm.HS512, secret)
                    .compact();
        tokenResponse.setExpiresIn(expires.toString());
        tokenResponse.setAccessToken(token);
        tokenResponse.setJti(uuid.toString());
        tokenResponse.setScope("profile");
        tokenResponse.setTokenType(tokenPrefix);
        return tokenResponse;
    }

    public Authentication getAuthentication(HttpServletRequest request) {
        String token = request.getHeader(headerString).replaceAll("Bearer ","");
        if (token != null) {
            // parse the token.
            String username = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody()
                    .getSubject();
            if (username != null) // we managed to retrieve a user
            {
                return new AuthenticatedUser(username);
            }
        }
        return null;
    }
}
