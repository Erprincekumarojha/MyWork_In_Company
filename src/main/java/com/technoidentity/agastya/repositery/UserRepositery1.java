package com.technoidentity.agastya.repositery;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.technoidentity.agastya.model.User;

@Repository
public interface UserRepositery1 extends MongoRepository<User, String> {

}
