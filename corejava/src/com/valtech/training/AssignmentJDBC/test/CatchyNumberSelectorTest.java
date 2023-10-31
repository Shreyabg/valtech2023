package com.valtech.training.AssignmentJDBC.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.valtech.training.AssignmentJDBC.CatchyNumberSelector;

class CatchyNumberSelectorTest {
CatchyNumberSelector cns;
	
	
	@Test
	void testCalculateCatchinessScore() {
		assertEquals(25, cns.calculateCatchinessScore("222222"));
	}

}
