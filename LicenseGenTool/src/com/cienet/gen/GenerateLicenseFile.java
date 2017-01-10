package com.cienet.gen;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import starschema.slm4j.Main;

public class GenerateLicenseFile {
	public static void generateLicense(String macAddress,String ExpirationDate,String outputPath) throws Exception {
		String currentPath = System.getProperty("user.dir");
		File inputFile=new File(currentPath,"license_input.txt");
		BufferedWriter br=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(inputFile)));
		br.write("MacAddress="+macAddress);
		br.newLine();
		br.write("ExpirationDate="+ExpirationDate);
		br.flush();
		br.close();
		
		String[] para = { "sign", "-license", inputFile.getAbsolutePath(), "-public",
				"key/key.pub", "-private", "key/key.pkf", "-sign",
				outputPath+"/license.txt" };
		for (int i = 0; i < para.length; i++) {
			System.out.println(i + "---------------- " + para[i]);
		}
		File file = new File("/home/makun/selef/license_input.txt");
		System.out.println(file.getParentFile());

		Main.main(para);
		inputFile.delete();
	}
}
