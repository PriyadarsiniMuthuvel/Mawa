package action;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Casting {
	
	public static void main(String args[]) throws ParseException{
		Date sdate= new Date();
		DateFormat dateformat= new SimpleDateFormat("yyyy/mm/dd");
		String date1=dateformat.format(sdate);
		System.out.println(date1);
	}
	}

