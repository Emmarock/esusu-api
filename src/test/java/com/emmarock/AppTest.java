package com.emmarock;

import static org.junit.Assert.assertTrue;

import com.emmarock.model.Contributor;
import com.emmarock.security.jwt.TokenAuthenticationService;
import org.junit.Test;

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
        Contributor contributor = new Contributor();
                contributor.setUsername("Babajide");
                contributor.setEmail("apatababajide@gmail.com");
                contributor.setBankAccountName("Apata Babajide Emmanuel");
        contributor.setBirthday("19/04/1989");
        contributor.setCity("Lagos");
        contributor.setGender("Male");
        System.out.println(tokenAuthenticationService.generateToken(contributor));
    }
}
