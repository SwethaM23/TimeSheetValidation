package Report;

import java.util.Date;

public class timestamputils {
	
	public static String getDateStamp() {
		Date date=new Date();
		return date.toString().replaceAll(":", "_").replaceAll(" ", "_");
	}

}
