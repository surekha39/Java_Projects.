package com.example.Authentication.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.Authentication.entities.User;

@Repository
public interface AuthenticationRepository extends CrudRepository<User, Integer> {

	public Optional<User> findUserByName(String name);
}
