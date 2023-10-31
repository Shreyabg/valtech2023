package com.valtech.training.AssignmentJDBC.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.valtech.training.AssignmentJDBC.CssAttributeParsing;

class CssAttributeParsingTest {
CssAttributeParsing sap;
	@Test
	void testHexToRgb() {
		assertEquals("rgb(46, 204, 113)",sap.hexToRgb("#2ecc71") );
	}

}
