package com.emmarock;

import static org.junit.Assert.assertTrue;

import com.emmarock.model.UsersDetails;
import com.emmarock.security.jwt.TokenAuthenticationService;
import org.junit.Test;
import org.springframework.security.core.userdetails.User;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void generateToken(){
        TokenAuthenticationService tokenAuthenticationService = new TokenAuthenticationService();
        UsersDetails usersDetails = new UsersDetails();
                usersDetails.setUsername("Babajide");
                usersDetails.setEmail("apatababajide@gmail.com");
                usersDetails.setBankAccountName("Apata Babajide Emmanuel");
        usersDetails.setBirthday("19/04/1989");
        usersDetails.setCity("Lagos");
        usersDetails.setGender("Male");
        System.out.println(tokenAuthenticationService.generateToken(usersDetails));
    }
}
