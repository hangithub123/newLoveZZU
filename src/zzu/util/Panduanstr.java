package zzu.util;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;

public class Panduanstr {
	
	
	
	public String pinjie(List<String> imageurl){
		StringBuilder URL = new StringBuilder();
		 System.out.println("图片数量:"+imageurl.size()+",开始拼接");
		 for(int s=0;s<imageurl.size();s++){
			 if(imageurl.get(s) !=null && !imageurl.get(s).equals("")){
		 	         
		 	           URL.append(imageurl.get(s));
		 	           URL.append("ZZU");
			 }
		 }
		 System.out.println(URL);
		 
		return URL.toString();
		
	}
	public String[] fenli(String URL){
		List<String> imageURL=new ArrayList<String>();
		
		  
		 if(URL ==null){ System.out.println("传来的要分离字符串为空");}
	     String a[] = URL.split("ZZU");  
	    
	     System.out.println("图片数量:"+a.length+",开始分离");
	for(int j=0;j<a.length;j++){
		  imageURL.add(a[j].trim());
	}
	System.out.println("字符串分离成功:"+imageURL);
	String[] arr = (String[])imageURL.toArray(new String[imageURL.size()]);//list转数组
		return arr;
		
	} 
public static void main(String[] args) {
//	 String str="ABC#0#1"; 
//	 if(str.indexOf("A") ==0){  
//	 System.out.println("包含"); 
//	 }else{ System.out.println("不包含"); 
//	 } 
//	 int i=str.indexOf("#");
//	 System.out.println(i);
	
	
	
	
	 String url1="http://localhost:8080/LoveZZU/image1";
	 String url2="http://localhost:8080/LoveZZU/image2";
	 String url3="http://localhost:8080/LoveZZU/image3";
	 String url4="http://localhost:8080/LoveZZU/image4";

	 List<String> imageurl = new ArrayList();	 
	 imageurl.add(url1);
	 imageurl.add(url2);
	 imageurl.add(url3);
	 imageurl.add(url4);
	 
	 Panduanstr p=new Panduanstr();
	String url= p.pinjie(imageurl);
	String[] S= p.fenli(url);
	
	
	 
	 
	 
//	 System.out.println(imageurl.size()+"开始拼接");
//for(int s=0;s<imageurl.size();s++){
//	          String o= imageurl.get(s);
//	           o+="#";
//	           URL+=o;
//	           System.out.println(URL);
//}
//	 
//	 String s = new String(URL);   
//     String a[] = s.split("#");  
//    
//     System.out.println(a.length+"开始分离");
//for(int j=0;j<a.length;j++){
//	
//	  System.out.println(a[j].trim());  
//	  
//}
	 
	 
}
}
