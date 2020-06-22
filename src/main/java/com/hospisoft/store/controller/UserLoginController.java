package com.hospisoft.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hospisoft.store.model.AuthenticationRequest;
import com.hospisoft.store.model.AuthenticationResponse;
import com.hospisoft.store.service.MyUserDetailsService;
import com.hospisoft.store.util.JwtUtil;

@RestController
//@CrossOrigin(origins = "${app.api.settings.cross-origin.urls}")
@CrossOrigin(origins="*")

public class UserLoginController {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired	
	private MyUserDetailsService userDetailsService;
	@Autowired
	private JwtUtil jwtTokenUtil;
	
	@RequestMapping(value = "/authenticate",method=RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest ) throws Exception {
		System.out.println("UserLoginController.createAuthenticationToken()");
		
		System.out.println(authenticationRequest.getUserName());
		System.out.println(authenticationRequest.getPassword());
		System.out.println("UserLoginController.createAuthenticationToken()");
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authenticationRequest.getUserName(), authenticationRequest.getPassword())
			);
		}
		catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
			//return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUserName());
		final String jwt = jwtTokenUtil.generateToken(userDetails);
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}
	
}
