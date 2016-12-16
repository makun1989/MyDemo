import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Test {
	public static void main(String[] args)throws Exception {
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