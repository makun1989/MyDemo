package starschema.slm4j;

import java.io.File;

public class demo {
	public static void main(String[] args) {
		//java -jar SignatureCreator.jar sign -license license_input.txt -public key.pub -private key.pkf -sign license.txt
		String[] para={
				"sign",
				"-license","/home/makun/selef/license_input.txt",
				"-public","/home/makun/selef/key.pub",
				"-private","/home/makun/selef/key.pkf",
				"-sign","/home/makun/selef/license.txt"
		};
		for(int i=0;i<para.length;i++){
			System.out.println(i+"---------------- "+para[i]);
		}
		File file =new File ("/home/makun/selef/license_input.txt");
		System.out.println(file.getParentFile());
		
		
		//Main.main(para);
	}
}
