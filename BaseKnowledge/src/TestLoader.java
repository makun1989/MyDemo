import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TestLoader {
	public static void main(String[] args) throws Exception{
File destFile=new File("/home/makun/dest.png");
		ProcessBuilder pb = new ProcessBuilder(new String[] { "tesseract", "stdin", "stdout" });
		pb.redirectInput(destFile.getAbsoluteFile());
		Process process = pb.start();
		InputStream inputStream = process.getInputStream();
		BufferedReader br=new BufferedReader(new InputStreamReader(inputStream));
		String aline ;
		while((aline=br.readLine())!=null)
			System.out.println(aline);
	}
}
