package com.uday.service;

import java.io.File;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uday.entity.GiftVocherEntity;
import com.uday.entity.UserEntity;
import com.uday.repo.GiftVocherRepo;
import com.uday.repo.UserRepo;

@Service
public class GifServiceImpl implements GifService {

	@Autowired
	private GiftVocherRepo giftRepo;

	@Autowired
	private UserRepo userRepo;

//	//Before Multithreading it allows 1 sec = 1 GiftVocher
//	@Override
//	public void processPendingTriggers() {
//
//		// get all pending records from gift_vochers table
//		List<GiftVocherEntity> records = giftRepo.findByGiftVocherStatus("Pending");
//
//		for (GiftVocherEntity entity : records) {
//			processEachRecord(entity);
//		}
//	}

	// After Multithreading it allows 1 sec = 10 GiftVocher
	@Override
	public void processPendingTriggers() {

		// get all pending records from gift_vochers table
		List<GiftVocherEntity> records = giftRepo.findByGiftVocherStatus("Pending");

		// 1 sec = 10 Gifts allow
		ExecutorService executorService = Executors.newFixedThreadPool(10);

		for (GiftVocherEntity entity : records) {

			executorService.submit(new Runnable() {

				@Override
				public void run() {
					try {
						processEachRecord(entity);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});

		}
	}

	private void processEachRecord(GiftVocherEntity entity) {
		Long giftNum = entity.getGiftNum();
		// get user data
		UserEntity findByGiftNum = userRepo.findByGiftNum(giftNum);
		updateProcessdRecord(entity);
	}

	private boolean updateProcessdRecord(GiftVocherEntity entity) {
		entity.setGiftVocherStatus("Completed");
		giftRepo.save(entity);
		return true;
	}
}
