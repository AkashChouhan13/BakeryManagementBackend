package com.akash.project.dao;


import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.akash.project.modal.User;

public interface UserRepo extends JpaRepository<User, String>
{
	Optional<User> findByEmailId(String email);
}
