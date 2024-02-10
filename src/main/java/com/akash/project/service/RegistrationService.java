package com.akash.project.service;

import java.util.Optional;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.akash.project.dao.UserRepo;
import com.akash.project.email.Email;
import com.akash.project.modal.User;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class RegistrationService 
{
	@Autowired
	private UserRepo repo;
	
	@Autowired
	Email emailobj;
	
	private String getApplicationBaseUrl() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String requestUrl = request.getRequestURL().toString();
        String contextPath = request.getContextPath();

        // Remove the request URI to get the base URL
        return requestUrl.replace(request.getRequestURI(), contextPath);
    }

	
	
	
	public String register(User obj)
	{
		Optional<User> optional = repo.findByEmailId(obj.getEmailId()) ;
		
		User user;
		if(optional.isPresent())
		{
			user = optional.get();
			if(user.getisEnable() == false)
			return "user is already preset";
		}
		
	
			HttpServletRequest request;
			
			String url = getApplicationBaseUrl();
			
			int val = (int) (Math.random() * 9000) + 1000;
			String token = "" + val;

			url = url + "/onlineBackery/verifyRegistration?token=" + token + "&email=" + obj.getEmailId();

			
			obj.setOtp(token) ;
			repo.save(obj);
			
			emailobj.sendSimpleMail(obj.getEmailId(),url);
			
			
			return "confirmation link sent via mail";
		
	}
		

		public String validateToken(String token,String email)
		{
			Optional<User> optional = repo.findByEmailId(email) ;
			User user = null;
			
			System.out.println(token);
			
			if(optional.isPresent())
				user =  optional.get();
			else return "invalid";
				
			System.out.println(user.getOtp());
			if( user.getOtp().equals(token))
			{
				user.setEnable(true);
				repo.save(user);
				return "registration successfull";
			}
			
			return "registration failed";
				
		}
		
		
		
		public String login(HttpSession session,User loginObj)
		{
			Optional<User> optional = repo.findByEmailId(loginObj.getEmailId());
			User user = null;
			
			if(optional.isPresent())
			{
				user = optional.get();
			}
			else 
			{
				return "User with this email not found please register !" ;
			}
			
			
			if(user.getPassword() != loginObj.getPassword() )
			{
				return "password not matched";
			}
			else
			{
				session.setAttribute("user", user);
				return "login sucessful";
			}
			
			
		}

}
