package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonUtils {
	public  String getEmailWithTimeStamp() {
		Date date = new Date();
		return "Ramanastvd"+date.toString().replace("", "").replace(":"," ")+"@gmail.com";
	}
	public  String getEmailWithTimeStamp1() {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String timestamp = dateFormat.format(date);
        return "Ramanastvd" + timestamp + "@gmail.com";

	}

}
