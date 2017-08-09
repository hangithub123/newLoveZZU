package zzu.util;

import java.util.UUID;

public class GetUUID {

	//获取唯一标识符
	public String getuuid(){
		String uuid=UUID.randomUUID().toString();
		return uuid;
		
	}
}
