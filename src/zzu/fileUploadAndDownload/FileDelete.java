package zzu.fileUploadAndDownload;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import zzu.util.Panduanstr;

public class FileDelete {

	/**
	 * 图片的删除
	 * @param oldimages 
	 */
	
	Panduanstr p=new Panduanstr();

	public String delete(String realPath,String oldimages, String[] DNames) throws Exception {
		//String oldimage:数据库中取出来的图片名。String[] deleted:前端传来的指定要删除的图片名。
		
		System.out.println("执行删除操作");
		String[] olds=null;
		olds=p.fenli(oldimages);
		ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(olds));//建保存新图片名的集合，用于后面拼接成字符串
		for(int i=0;i<arrayList.size();i++){
			System.out.println("图片："+arrayList.get(i));
			for(int j=0;j<DNames.length;j++){
				System.out.println("指定要删图片:"+DNames[j]);
				if(arrayList.get(i) != null && arrayList.get(i).equals(DNames[j])){
					System.out.println("查到要删除的图片："+arrayList.get(i));
					arrayList.remove(arrayList.get(i));
				}
			}
		}
		
		
		
		boolean isSuccessful=FileDelete.deleteiamge(realPath, DNames);
		String newnames=null;
       if(isSuccessful){
		 newnames=p.pinjie(arrayList);
		System.out.println("删除操作成功，图片拼接字符串:"+newnames);
       }
		
		return newnames;
	}
	
	
	// 删除旧的图片文件
		public static boolean deleteiamge(String realPath, String[] DNames){
			boolean isSuccesssful=false;
			int num=0;
			for (int i = 0; i < DNames.length; i++) {
				File f = new File(realPath + DNames[i]);

				if (f.exists()) {
					System.out.println("查到已有图片开始删除操作：" + f.getAbsoluteFile());
					

					if (f.delete()) {
						System.out.println("第" + i + "张图片成功被删除！");
						num+=1;
					} else {

						System.out.println("第" + i + "张图片删除失败！");
					}
				} else {
					System.out.println("要删除的图片不存在");
					
				}

			}
			if(num !=0){isSuccesssful=true;}//num 不为0，就是执行了删除操作
			return isSuccesssful;
			
			
}
		}
