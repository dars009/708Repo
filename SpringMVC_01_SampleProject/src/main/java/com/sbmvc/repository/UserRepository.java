package com.sbmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sbmvc.pojo.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
