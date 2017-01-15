package io.adambarreiro;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import io.adambarreiro.core.security.AuthenticationFilter;

@Configuration
@EnableWebSecurity
public class AppSecurity extends WebSecurityConfigurerAdapter {

//	@Autowired
//	private AuthenticationProvider authenticationProvider;
//
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests().antMatchers("/").denyAll();
		http.authorizeRequests().antMatchers("/subscription/**").permitAll();
		http.antMatcher("/email").addFilterBefore(new AuthenticationFilter(),
				BasicAuthenticationFilter.class);
		http.antMatcher("/event").addFilterBefore(new AuthenticationFilter(),
				BasicAuthenticationFilter.class);

		// add this line to use H2 web console
		http.headers().frameOptions().disable();
	}
//
//	@Override
//	public void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.authenticationProvider(authenticationProvider);
//	}
}