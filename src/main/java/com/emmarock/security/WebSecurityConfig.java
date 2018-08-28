package com.emmarock.security;


import com.emmarock.CorsFilter;
import com.emmarock.security.jwt.JWTAuthenticationFilter;
import com.emmarock.security.jwt.JWTLoginFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.session.SessionManagementFilter;

/**
 * Created by babajide.apata on 1/31/2017.
 */
@EnableWebSecurity
@Configuration
class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Bean
	CorsFilter corsFilter() {
		CorsFilter filter = new CorsFilter();
		return filter;
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.headers().cacheControl();
		http.csrf().disable() // disable csrf for our requests.
				.addFilterBefore(corsFilter(), SessionManagementFilter.class)
				.authorizeRequests()
				.antMatchers(HttpMethod.POST,"/api/v1/oauth/token").permitAll()
				.antMatchers(HttpMethod.GET, "/home").permitAll()
				.anyRequest().authenticated()
				.and()
				// We filter the api/login requests
				.addFilterBefore(new JWTLoginFilter("/login", authenticationManager()), UsernamePasswordAuthenticationFilter.class)
				// And filter other requests to check the presence of JWT in header
				.addFilterBefore(new JWTAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// Create a default account
		auth.inMemoryAuthentication()
				.withUser("admin")
				.password("password")
				.roles("ADMIN");

	}
}
