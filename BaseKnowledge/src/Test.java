import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class Test {
	public static void main(String[] args)throws Exception {
		System.out.println(System.getProperty("user.dir"));
		File file =new File("/home/makun/Ocr-1.png");
		File destFile=new File("/home/makun/test.png");
		byte[] buf=new byte[10];
		InputStream is=new FileInputStream(file);
		OutputStream out=new FileOutputStream(destFile);
		int len;
		while((len=is.read(buf))!=-1){
			out.write(buf, 0, len);
			System.out.println(destFile.exists());
		}
	}
	
	private static void ocr() throws Throwable{

		ProcessBuilder pb = new ProcessBuilder(new String[] { "tesseract", "stdin", "stdout" });
		pb.redirectInput(new File("/home/makun/dest.png"));
		Process process = pb.start();
		InputStream outputStream = process.getInputStream();
		BufferedReader br=new BufferedReader(new InputStreamReader(outputStream));
		String aline;
		while((aline=br.readLine())!=null){
			if(aline.equals("Please Use Seat Controller to Operate Seat")){
				System.out.println(true);
			}
			System.out.println(aline);
		}
	
	}
}