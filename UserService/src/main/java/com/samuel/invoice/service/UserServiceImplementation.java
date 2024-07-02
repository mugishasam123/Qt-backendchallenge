package com.samuel.invoice.service;

import com.samuel.invoice.exception.UserException;
import com.samuel.invoice.repository.UserRepository;
import com.samuel.invoice.SecurityConfig.JwtProvider;
import com.samuel.invoice.usermodel.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    private UserRepository userRepository;
    
    @Override
	public User findUserProfileByJwt(String jwt) throws UserException {
		String email= JwtProvider.getEmailFromJwtToken(jwt);
		
		
		User user = userRepository.findByEmail(email);
		
		if(user==null) {
			throw new UserException("user not exist with email "+email);
		}
		return user;
	}
    
    
    public List<User> getAllUser()  throws UserException{
    	return userRepository.findAll();
    	
    }

	@Override
	public User findUserByEmail(String email) throws UserException {
		User user=userRepository.findByEmail(email);
		return user;
	}

	@Override
	public User findUserById(String userId) throws UserException {
		// TODO Auto-generated method stub
java.util.Optional<User> opt = userRepository.findById(userId);
		
		if(opt.isEmpty()) {
			throw new UserException("user not found with id "+userId);
		}
		return opt.get();
	}
	

	@Override
	public List<User> findAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}


	


	
}
