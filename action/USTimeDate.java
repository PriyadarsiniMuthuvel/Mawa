package action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class USTimeDate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimpleDateFormat gmtDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		gmtDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
		String Date = gmtDateFormat.format(new Date());

		//Current Date Time in GMT
		System.out.println("Current Date and Time in GMT time zone: " + Date);
	}

}
