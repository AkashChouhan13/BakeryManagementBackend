package com.akash.project.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.akash.project.UserLoginRequest;
import com.akash.project.modal.User;
import com.akash.project.service.RegistrationService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/onlineBackery")
public class Register 
{
	@Autowired
	private RegistrationService serv;
	
	@PostMapping(value = "/register")
	public String register(@RequestBody User obj )
	{
		if(obj == null)return "Ram Ram";
		
		return serv.register(obj);
	}
	
	@GetMapping(value = "/login")
	public void login(@RequestBody User obj)
	{
		
	}
	
	@GetMapping("/verifyRegistration")
	public String verifyRegistration(@RequestParam("token") String token,@RequestParam("email") String email)
	{
		String result = serv.validateToken(token, email);
		
		return result;
	}
	
	@GetMapping("/login")
	public String login(HttpSession session, @RequestBody User loginObj)
	{
		return serv.login(session, loginObj);
	}
	
}
