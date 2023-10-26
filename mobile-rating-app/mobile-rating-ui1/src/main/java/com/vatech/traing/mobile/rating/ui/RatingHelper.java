package com.vatech.traing.mobile.rating.ui;

import com.valtech.training.mobileranking.MobileRankingService;
import com.valtech.training.mobileranking.MobileRankingServiceImpl;
 
public class RatingHelper {
	
	private MobileRankingService mobileRankingService= new MobileRankingServiceImpl();
	
	public int getRanking(String mobile) {
		//validation
		return mobileRankingService.rankMobile(mobile);
	}
 
}