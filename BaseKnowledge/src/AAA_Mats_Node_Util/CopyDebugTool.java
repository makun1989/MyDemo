package AAA_Mats_Node_Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class CopyDebugTool {

	public static void main(String[] args) throws Exception {
		Long startTime = System.currentTimeMillis();
		copyToDisk("/home/makun/Desktop/taipei/mats-node/debug-tool/build/distributions/debug-tool.zip");
		System.out.println("done");
		Long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
	}

	private static void copyToDisk(String srcFile) throws Exception {
		String[] split = srcFile.split("/");
		String deFileName = split[split.length - 1];
		System.out.println("copied file:------>" + deFileName);
		FileInputStream resFile = new FileInputStream(new File(srcFile));
		FileOutputStream destFile = new FileOutputStream(new File("/media/makun/463F-57A4/" + deFileName));
		byte[] buf = new byte[1024];
		while (resFile.read(buf) != -1) {
			int len = buf.length;
			destFile.write(buf, 0, len);
			destFile.flush();
		}
		destFile.close();
		resFile.close();
	}
}
