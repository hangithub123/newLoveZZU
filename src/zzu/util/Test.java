package zzu.util;

import java.text.ParseException;



public class Test {

	public static void main(String[] args) throws ParseException {
		String time2="2017-04-04 11:11:11";
		GetDate data=new GetDate();
		String time=data.GetNowDate();
		System.out.println(time);
		System.out.println(data.getDataNum(time, time2));
		GetUUID uuid=new GetUUID();
		System.out.println(uuid.getuuid());
	}
	
	
	

	
} 
