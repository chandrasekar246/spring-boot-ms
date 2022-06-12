package com.github.chandrasekar246.banking.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin(origins = "*", maxAge = 3600)
//@RestController
@RequestMapping("/token")
public class AuthenticationController {

//	@Autowired
//	private AuthenticationManager authenticationManager;
//
//	@Autowired
//	private JwtTokenUtil jwtTokenUtil;
//
//	@PostMapping("/generate")
//	public String generate(@RequestBody LoginUser loginUser) throws AuthenticationException {
//		authenticationManager.authenticate(
//				new UsernamePasswordAuthenticationToken(loginUser.getUsername(), loginUser.getPassword()));
//
//		return jwtTokenUtil.generateToken(loginUser.getUsername());
//	}

}
