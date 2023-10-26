package com.valtech.training.day2.test;

import static org.junit.jupiter.api.Assertions.*;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.valtech.training.day2.Arithmetic;
import com.valtech.training.day2.ArithmeticImpl;
import com.valtech.training.day2.DivideByZeroException;

@DisplayName("Arithmetic test")
class ArithmeticTest {

	
	private Arithmetic arithmetic;//=new ArithmeticImpl();
	@BeforeAll
	static void beforeAll() {
		System.out.println("Before All..");
	}
	
	@AfterAll
	static void afterAll() {
		System.out.println("After all..");
	}
	
	
	@BeforeEach
	void anything() {
		System.out.println("init...");
		 arithmetic=new ArithmeticImpl();
	}
	@AfterEach
	void anything1() {
		
		System.out.println("Destroy..");
	}
	
	@Test @DisplayName("to check if the positive nos,-ve nos are added correctly")
	void testAdd() {
	assertEquals(5,arithmetic.add(2, 3));
	assertEquals(5,arithmetic.add(3, 2));
	assertEquals(5,arithmetic.add(5, 0));
	assertEquals(5,arithmetic.add(5, -0));
	assertEquals(-5,arithmetic.add(-2, -3));
	assertEquals(-5,arithmetic.add(-8, 3));
	}

	@Test
	void testSub() {
	}

	@Test
	void testMul() {
	}
	
	static Stream<Arguments> addArgsGenerator(){
		return Stream.of(Arguments.of(1,2,3),
				Arguments.of(-1,-2,-3),
				Arguments.of(1,-2,-1),
				Arguments.of(-1,2,1)
				
				);
	}
	
	
	
	@ParameterizedTest(name="Add with method e{0} +{1}={2}")
	@MethodSource(value={"addArgsGenerator"})
	void testWithMethod(int a,int b,int c) {
		assertEquals(c, arithmetic.add(a, b));
	}
	
	
	
	
	
	@ParameterizedTest(name="Add with CSV  File{0} +{1}={2}")
	@CsvFileSource(files = {"add.csv"}
	)
	void testWithCSVFile(int a,int b,int c) {
		assertEquals(c, arithmetic.add(a, b));
	}
	
	
	
	
	@ParameterizedTest(name="Add with CSV {0} +{1}={2}")
	@CsvSource(value={"2,3,5","-2,3,1","5,-2,3","-1,-1,-2"})
	void testWithCSVParams(int a,int b,int c) {
		assertEquals(c, arithmetic.add(a, b));
	}
	
	
	//allow us to pass arguments //also need to give values for it//@ValueSource allow us to pass any type of array like byte array etc
	@ParameterizedTest(name="Add with {0}") 
	@ValueSource(strings= {"2,3,5","-2,3,1","5,-2,3","-1,-1,-2"})
	void testAddWithParams(String value) {
		String[] parts=value.split(",");
		List<Integer> values = Arrays.asList(parts).stream().map(it->Integer.parseInt(it)).collect(Collectors.toList());
		assertEquals(values.get(2), arithmetic.add(values.get(0),values.get(1)));		
	
	}
	
	
	
	@Test
	void testDivByZero() {
		assertThrows(DivideByZeroException.class,()->arithmetic.div(5, 0));
	}

	@Test
	void testDiv() throws DivideByZeroException  {
		assertEquals(1.666,5.0/3,0.001,"value not in range");//3rd argument +0.001 or -0.001 is ok (approximation)
		assertEquals(2,arithmetic.div(4, 2));
		assertEquals(2,arithmetic.div(-6, -3));
		try {
			assertEquals(2,arithmetic.div(4, 0));
			fail("should have throws ArithmeticException");
		}catch (Exception e) {
		}
		
		
	}

}