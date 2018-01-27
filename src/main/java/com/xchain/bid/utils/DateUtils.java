package com.xchain.bid.utils;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class DateUtils {

	private final static DateFormat outputFormatter = new SimpleDateFormat("MM/dd/yyyy");

	public static String getDateOnly(Date date) {
		return outputFormatter.format(date);
	}
}
