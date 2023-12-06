package com.uday.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uday.entity.UserEntity;

public interface UserRepo extends JpaRepository<UserEntity, Integer>{

	public UserEntity findByGiftNum(Long giftNum);

}
