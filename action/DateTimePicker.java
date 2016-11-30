package action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateTimePicker {
	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("CST"));
		Date currentDate = calendar.getTime();
		System.out.println(currentDate);
		Date date=new Date();
		  DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		String formattedDate=dateFormat.format(date);
		  System.out.println(formattedDate); 

}}
