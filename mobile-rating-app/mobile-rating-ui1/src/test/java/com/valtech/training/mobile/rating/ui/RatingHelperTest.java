package com.valtech.training.mobile.rating.ui;

import static org.junit.Assert.*;

import org.junit.Test;

import com.vatech.traing.mobile.rating.ui.RatingHelper;

import junit.framework.Assert;
import junit.framework.TestCase;


 
public class RatingHelperTest extends TestCase{
 
	@Test
	public void testGetRating() {
		RatingHelper helper = new RatingHelper();
		Assert.assertEquals(0, helper.getRanking("9535925188"));
	}
 
}