package com.project.backend.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.backend.entities.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
