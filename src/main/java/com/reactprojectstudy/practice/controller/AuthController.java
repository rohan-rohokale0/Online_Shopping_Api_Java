package com.reactprojectstudy.practice.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reactprojectstudy.practice.pojo.SignupRequest;
import com.reactprojectstudy.practice.response.ApiResponse;
import com.reactprojectstudy.practice.service.auth.AuthService;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Getter;

@RestController
@RequestMapping("/api/auth")

public class AuthController {

	private final AuthService authService;

//	@Autowired
//	private JwtUtil jwtUtil;

//	@Autowired
//	private AuthenticationManager authenticationManager;

//	@Autowired
//	private UserDetailsServiceImpl userDetailsService;

	public AuthController(AuthService authService) {
		this.authService = authService;

	}

	@PostMapping("/signup")
	public ResponseEntity<ApiResponse> signupUser(@RequestBody SignupRequest signupRequest) {
		String msg = authService.createUser(signupRequest);
		ApiResponse res = new ApiResponse(msg, true);
		return new ResponseEntity<ApiResponse>(res, HttpStatus.CREATED);
	}

//	@PostMapping("/login")
//	public AuthenticationResponse createAuthenticationToken(@RequestBody AuthenticationRequest authenticationDTO,
//			HttpServletResponse response)
//			throws BadCredentialsException, DisabledException, UsernameNotFoundException, IOException {
//		try {
//			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationDTO.getEmail(),
//					authenticationDTO.getPassword()));
//		} catch (BadCredentialsException e) {
//			throw new BadCredentialsException("Incorrect username or password!");
//		} catch (DisabledException disabledException) {
//			response.sendError(HttpServletResponse.SC_NOT_FOUND, "User is not activated");
//			return null;
//		}
//
//		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationDTO.getEmail());
//
//		final String jwt = jwtUtil.generateToken(userDetails.getUsername());
//
//		return new AuthenticationResponse(jwt);
//
//	}

}

//	@PostMapping("/login")
//	
//	 public String login(@RequestBody AuthenticationRequest request) {
//        // Authenticate the user (e.g., using Spring Security's authentication manager)
//        // If authentication is successful, generate a JWT
//        String token = JwtUtil.generateToken(request.getEmail());
//        return token;
//    }

//	public AuthenticationResponse createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest,
//			HttpServletResponse response) throws IOException {
//		try {
//			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(),
//					authenticationRequest.getPassword()));
//		} catch (BadCredentialsException e) {
//			throw new BadCredentialsException("InCorrect username or password");
//		} catch (DisabledException disabledException) {
//			response.sendError(HttpServletResponse.SC_NOT_FOUND, "User not Active");
//			return null;
//		}
//	final UserDetails userDetails=userDetailsService.loadUserByUsername(authenticationRequest.getEmail());
//	}
//}

////	public AuthenticationResponse createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)
////	{
////		re
////	}
//}
