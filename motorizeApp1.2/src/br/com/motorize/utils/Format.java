package br.com.motorize.utils;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class Format {

	public Date StringToDate(String s){

		
		
		Date result = null;

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

		try {

			Date date = (Date) formatter.parse(s);
		//	System.out.println(date);
		//	System.out.println(formatter.format(date));
			
			result = date;
			
			return result;

		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

}
