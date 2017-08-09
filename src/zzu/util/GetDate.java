package zzu.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component(value="getdata")
public class GetDate {

	//获取时间间隔天数
	 public int getDataNum(String last,String now) throws ParseException {  
	        // TODO Auto-generated method stub  
	        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
	       
           Date  d1=sdf.parse(last);  
	       Date  d2=sdf.parse(now);  
	        int n=daysBetween(d1,d2);//返回日期相差天数
	       // System.out.println(daysBetween(d1,d2));  
	      //  System.out.println(daysBetween("2012-09-08 10:10:10","2012-09-15 00:00:00"));
			return n;  
	    }  
	      
	    /**  
	     * 计算两个日期之间相差的天数  
	     * @param smdate 较小的时间 
	     * @param bdate  较大的时间 
	     * @return 相差天数 
	     * @throws ParseException  
	     * 
	     */    
	    public static int daysBetween(Date smdate,Date bdate) throws ParseException    
	    {    
	        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
	        smdate=sdf.parse(sdf.format(smdate));  
	        bdate=sdf.parse(sdf.format(bdate));  
	        Calendar cal = Calendar.getInstance();    
	        cal.setTime(smdate);    
	        long time1 = cal.getTimeInMillis();                 
	        cal.setTime(bdate);    
	        long time2 = cal.getTimeInMillis();         
	        long between_days=(time2-time1)/(1000*3600*24);  
	            
	       return Integer.parseInt(String.valueOf(between_days));           
	    }    
	  //字符串格式日期计算相差天数方法
	    public static int daysBetween(String smdate,String bdate) throws ParseException{  
	        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
	        Calendar cal = Calendar.getInstance();    
	        cal.setTime(sdf.parse(smdate));    
	        long time1 = cal.getTimeInMillis();                 
	        cal.setTime(sdf.parse(bdate));    
	        long time2 = cal.getTimeInMillis();         
	        long between_days=(time2-time1)/(1000*3600*24);  
	            
	       return Integer.parseInt(String.valueOf(between_days));     
	    }  
	    public String GetNowDate(){
	    	   Date dt=new Date();
	 		  SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置显示格式
	 		      String  nowTime= df.format(dt);
	 		
			return nowTime;}
	    
	    public String GetNowDate2(){
	    	Date dt=new Date();
	    	SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置显示格式
	    	String  nowTime= df.format(dt);
	    	
	    	return nowTime;}
	  
	    public static void main(String[] args) {
	    	GetDate g=new GetDate();
	    	System.out.println(g.GetNowDate2());
		}
}
