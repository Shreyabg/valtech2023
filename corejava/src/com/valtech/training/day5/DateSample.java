package com.valtech.training.day5;
import java.time.LocalDate;
import java.util.Date;
public class DateSample {

	public static void main(String[] args) {
		// index the year 1900
		// Date(47) means 1947
		// Month index with 0 (7-for august)
		// index Day with 1 for day 15 it is 15 itself

		Date date = new Date(47, 7, 15); // depricated
		System.out.println(date); // Fri Aug 15 00:00:00 IST 1947

		LocalDate independenceDay = LocalDate.of(1947, 8, 15);
		System.out.println(independenceDay);// 1947-08-15

	}

}
