package com.rm.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.rm.workshopmongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
