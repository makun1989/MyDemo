package AAA_Mats_Node_Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class CopyToDeskUtil {
	public static void main(String[] args)throws Exception {
		copyToDisk("/home/makun/Desktop/taipei/mats-node/blee-adaptor/build/libs/blee-adaptor-3.0.0.jar");
		copyToDisk("/home/makun/Desktop/taipei/mats-nms/build/libs/nms-2.2.0.jar");
		System.out.println("done");
	}
	
	private static void copyToDisk(String srcFile)throws Exception{
		String[] split = srcFile.split("/");
		String deFileName=split[split.length-1];
		System.out.println("copied file:------>"+deFileName);
		FileInputStream resFile=new FileInputStream(new File(srcFile));
		FileOutputStream destFile=new FileOutputStream(new File("/media/makun/WU/"+deFileName));
		byte[] buf=new byte[1024];
		while(resFile.read(buf)!=-1){
			int len=buf.length;
			destFile.write(buf, 0, len);
			destFile.flush();
		};
		destFile.close();
		resFile.close();
	}
}


