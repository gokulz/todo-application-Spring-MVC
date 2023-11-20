package com.gokulcodes.todoappmvc.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class TodoListConfig {
    
    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
       
        UserDetails gk = User.builder()
                        .username("Gokul")
                        .password("{noop}test123")
                        .roles("ADMIN")
                        .build();

        return new InMemoryUserDetailsManager(gk);                
    }

    @Bean
    public SecurityFilterChain filterChain (HttpSecurity http) throws Exception{
      
        http.authorizeHttpRequests(configurer ->
                       configurer
                        .anyRequest().authenticated()
                        )

               .formLogin(form ->
                         form 
                         .loginPage("/showLoginPage")
                         .loginProcessingUrl("/authenticatedTheUser")
                          .permitAll()
                    )
                .logout(logout -> logout.permitAll()
                );             
     

        return http.build();

    }
}
