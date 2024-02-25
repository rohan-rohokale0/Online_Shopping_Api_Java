package com.reactprojectstudy.practice.configurations;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfiguration {

//	@Autowired
//	private JwtRequestFilter requestFilter;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf(AbstractHttpConfigurer::disable)
				.authorizeHttpRequests(
						request -> request.requestMatchers("**").permitAll()
								.requestMatchers(HttpMethod.GET, "/product/get-product/**").permitAll()
								.requestMatchers(HttpMethod.POST, "/product/add-product/**").permitAll()
								.anyRequest().authenticated())
				.sessionManagement(management -> management.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		return http.build();
	}


//	@Bean
//	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//		http.csrf(AbstractHttpConfigurer::disable)
//				.authorizeHttpRequests(request ->
//						request.
//								requestMatchers("/api/auth/**").permitAll()
//								.requestMatchers("/api/category/**").permitAll()
//
//						.anyRequest().authenticated())
//				.sessionManagement(management -> management.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
//		return http.build();
//	}
//
//	@Bean
//	public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
//		return config.getAuthenticationManager();
//	}

}

//	@Bean
//	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//		http.csrf(AbstractHttpConfigurer::disable)
//				.authorizeHttpRequests(
//						request -> request.requestMatchers("**").permitAll()
//						 .requestMatchers(HttpMethod.GET, "/product/get-product/**").permitAll()
//						 .requestMatchers(HttpMethod.POST, "/product/add-product/**").permitAll()
//						.anyRequest().authenticated())
//				.sessionManagement(management -> management.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
//		return http.build();
//	}

//
//	@Bean
//	public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
//		return configuration.getAuthenticationManager();
//	}

//	  @Bean
//	    public CorsFilter corsFilter() {
//	        UrlBasedCorsConfigurationSource source =
//	            new UrlBasedCorsConfigurationSource();
//	        CorsConfiguration config = new CorsConfiguration();
//	        config.setAllowCredentials(true);
//	        config.addAllowedOrigin("*");
//	        config.addAllowedHeader("*");
//	        config.addAllowedMethod("*");
//	        source.registerCorsConfiguration("/**", config);
//	        return new CorsFilter();
//	    }
