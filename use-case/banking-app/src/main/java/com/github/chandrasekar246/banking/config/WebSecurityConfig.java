package com.github.chandrasekar246.banking.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

//	@Autowired
//	private UserDetailsService customerService;
//
//	@Autowired
//	private JwtAuthenticationEntryPoint unauthorizedHandler;
//	
//	@Autowired
//	private BCryptPasswordEncoder bcryptEncoder;
//	
//	@Autowired
//	private JwtAuthenticationFilter jwtAuthenticationFilter;
//
//	@Autowired
//	public void globalUserDetails(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(customerService).passwordEncoder(bcryptEncoder);
//	}
//
//	@Override
//	@Bean
//	public AuthenticationManager authenticationManagerBean() throws Exception {
//		return super.authenticationManagerBean();
//	}
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.cors().and().csrf().disable().authorizeRequests()
//				.antMatchers("/swagger-ui/**", "/v3/api-docs/**", "/token/*", "/customer/register").permitAll()
//				.anyRequest().authenticated().and().exceptionHandling().authenticationEntryPoint(unauthorizedHandler)
//				.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//		http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
//	}
	
	@Override
    protected void configure(HttpSecurity http) throws Exception{
		http.csrf().disable().authorizeRequests().anyRequest().permitAll();
    }

}
