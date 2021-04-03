package com.technoidentity.agastya.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.technoidentity.agastya.repositery.UserRepositery1;




@Service

public class CustomUserDetailService  implements UserDetailsService{

	
	@Autowired(required = true)
	  UserRepositery1 repository;
	
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		
		com.technoidentity.agastya.model.User user=getUserDetails(userName);
		
		if(userName.equals(user.getUsername())) {
		   
		 return new User(user.getUsername(),user.getPassword(), new ArrayList<>());
		 
		}else {
			throw new UsernameNotFoundException("User Name Not found..?");
		}
		
	}
	public com.technoidentity.agastya.model.User getUserDetails(String username) {
		
		   Optional<com.technoidentity.agastya.model.User> user=	repository.findById(username);
		 
		   com.technoidentity.agastya.model.User u=null;
		    if(user!=null) {
		    	
		    	u=user.get();
		    	System.out.println("Data base user and password");
		    	System.out.println(u.toString());
		    	
		    }
		    
			return u;
		}
	
	
	

}
