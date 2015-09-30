package com.pooja.movieticketing.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public static final String DATE_FORMAT = "yyyy/MM/dd hh:mm:ss";
	/**
	* Formats a date object when a date string is passed to it as argument.
	* 
	* @param date date in a string format
	* @return actualDate date object after it has been converted from a string format
	*/
	public static Date getDate(String date) {
		java.util.Date actualDate = new java.util.Date();

		if (date == null) {
			return null;
		} else {

			try {
				DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
				actualDate = dateFormat.parse(date);

			}
			catch (ParseException pe){
			}
		}
		return actualDate;
	}
}
