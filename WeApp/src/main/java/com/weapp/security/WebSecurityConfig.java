/*
 * Thanks to spring.io's Spring Security Java Config Preview: Web Security
 * https://spring.io/blog/2013/07/03/spring-security-java-config-preview-web-security/
 * 
 * Thanks to Baeldung's Default Password Encoder in Spring Security 5
 * https://www.baeldung.com/spring-security-5-default-password-encoder
 */
package com.weapp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


/**
 * The Class WebSecurityConfig.
 * @EnableWebSecurity and WebSecurityConfigurerAdapter provides web security
 * Require the user to be authenticated in order to access some URL in the application
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	/** The user details service. */
	@Autowired 
	private UserDetailsService userDetailsService;

	/**
	 * Gets the password encoder.
	 *
	 * Thanks to Baeldung's Default Password Encoder in Spring Security 5
	 * https://www.baeldung.com/spring-security-5-default-password-encoder
	 * @return the password encoder
	 */
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder(); 
	}

	/**
	 * Configure.
	 *
	 * @param auth the auth
	 * @throws Exception the exception
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
		.userDetailsService(userDetailsService)
		.passwordEncoder(getPasswordEncoder());	
	}

	/**
	 * Configure.
	 * Thanks to spring.io's Spring Security Java Config Preview: Web Security
	 * for configuration of different end points based on authority level 
	 * https://spring.io/blog/2013/07/03/spring-security-java-config-preview-web-security/
	 * 
	 * Thanks to Java Code Examples for SessionCreationPolicy
	 * https://www.programcreek.com/java-api-examples/?api=org.springframework.security.config.http.SessionCreationPolicy
	 *
	 * @param http the http
	 * @throws Exception the exception
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
		.antMatchers("/", "/js/**", "/css/**", "/images/**", "/register", "/app/*", "/c/*", "/p/*").permitAll()
		.antMatchers("/dashboard", "/applications/**", "/h2_console/**").hasRole("ADMIN")
		.anyRequest().hasRole("USER").and()
		.formLogin()
		.loginPage("/login")
		.defaultSuccessUrl("/")
		.permitAll()
		.and()
		.logout()
		.logoutUrl("/logout")
		.permitAll();  
		http.csrf().ignoringAntMatchers("/h2-console/**");
		http.headers().frameOptions().sameOrigin();
		http.sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.ALWAYS);
	}
}
