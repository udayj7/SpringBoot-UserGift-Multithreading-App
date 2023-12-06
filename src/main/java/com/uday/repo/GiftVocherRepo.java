package com.uday.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uday.entity.GiftVocherEntity;

public interface GiftVocherRepo extends JpaRepository<GiftVocherEntity, Integer> {
	
	public List<GiftVocherEntity> findByGiftVocherStatus(String status);
	
}
