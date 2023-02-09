package com.hunain.first_service.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hunain.first_service.Model.User;

public interface IUserRepository extends JpaRepository<User,Long>{
    
}
