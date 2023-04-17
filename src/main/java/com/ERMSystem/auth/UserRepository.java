package com.ERMSystem.auth;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<SystemUser, Long> {
	
	SystemUser findByEmail(String email);
	
}
