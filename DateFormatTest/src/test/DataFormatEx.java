package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataFormatEx {
	public static void main(String[] args) {

		// 2020-05-25 : 전달 파라미터의 형식, String
		String param = "2020-05-25";

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		// String -> java.util.Date 로 변환해야함.
		try {
			Date d = format.parse(param);
			System.out.println(d);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// java.util.Date -> String
		// ("yyyy-MM-dd") 형태로
		
		String nowStr = format.format(new Date());
		
		System.out.println(nowStr);
		
		
	}
}
