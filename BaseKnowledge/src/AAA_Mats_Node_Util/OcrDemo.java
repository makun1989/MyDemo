package AAA_Mats_Node_Util;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;

public class OcrDemo {
	public static void main(String args[]) throws Throwable{
		ProcessBuilder pb = new ProcessBuilder(new String[] { "tesseract", "stdin", "stdout" });
		pb.redirectInput(new File("/home/makun/dest.png"));
		Process process = pb.start();
		int waitFor = process.waitFor();
		if(waitFor==0){
			System.out.println(true);
			InputStream inputStream = process.getInputStream();
			BufferedReader br=new BufferedReader(new InputStreamReader(inputStream));
			String aline =null;
			while((aline=br.readLine())!=null)
				System.out.println(aline);
			
		}
	}
}
