package com.example.opportunity.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    public void configure (HttpSecurity http) throws Exception {
        http    .cors().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST).permitAll()//allow CORS option calls
                .antMatchers("/user/**").permitAll()
                .antMatchers("/Currencies/**").permitAll()
                .antMatchers("/Area/**").permitAll()
                .antMatchers("/BusinessLine/**").permitAll()
                .antMatchers("/BusinessUnit/**").permitAll()
                .antMatchers("/Country/**").permitAll()
                .antMatchers("/Departement/**").permitAll()
                .antMatchers("/ProductLine/**").permitAll()
                .antMatchers("/geography/**").permitAll()
                .antMatchers("/PreSalesEngineer/**").permitAll()
                .antMatchers("/Customer/**").permitAll()
                .antMatchers("/Roles/**").permitAll()
                .antMatchers("/Permissions/**").permitAll()
                .antMatchers("/Opportunity/**").permitAll()
                .antMatchers("/actuator/prometheus/**").permitAll()





                .anyRequest().authenticated();
        http
                .csrf().disable();

    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


}
