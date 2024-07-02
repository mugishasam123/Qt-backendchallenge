package com.samuel.invoice.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.samuel.invoice.usermodel.User;

@Repository
public interface UserRepository extends MongoRepository<User,String> {
    @Query("{email :?0}")
    User findByEmail(String email);
    

}
