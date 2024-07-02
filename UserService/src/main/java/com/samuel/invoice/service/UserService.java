package com.samuel.invoice.service;

import com.samuel.invoice.exception.UserException;
import com.samuel.invoice.usermodel.User;

import java.util.List;


public interface UserService {

     
     public List<User> getAllUser()  throws UserException;
     
     public User findUserProfileByJwt(String jwt) throws UserException;
 	
 	public User findUserByEmail(String email) throws UserException;
 	
 	public User findUserById(String userId) throws UserException;

 	public List<User> findAllUsers();
     
     
    	 
     }

