package com.sb.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sb.app.model.User;

@Repository
public interface UserDao extends JpaRepository<User, Long> {

}
