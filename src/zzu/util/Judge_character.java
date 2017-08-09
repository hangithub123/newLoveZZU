package zzu.util;

public class Judge_character {

	//检查是否为11位
	public boolean character(String str){
		
		if(str !=null && str.matches("[0-9]+")&&str.length()==11){
		
		return true;
		}else{
			return false;
		}
		
	}
	public static void main(String[] args) {
		Judge_character j=new Judge_character();
		boolean b=j.character("12345678901");
		System.out.println(b);

	    System.out.println((int)((Math.random()*9+1)*100000000));  //随机生成9位数
	}
}
