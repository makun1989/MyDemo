package com.makun.chapter18.gzip;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.zip.ZipOutputStream;

public class GZipCompress {
	public static void main(String[] args){
		try(BufferedReader br=new BufferedReader(new FileReader("abc.txt"));
				BufferedOutputStream bos=new BufferedOutputStream(new ZipOutputStream(new FileOutputStream("test.gz")));){
			
			int c;
			while((c=br.read())!=-1){
				bos.write(c);
			}
		}catch(IOException e){
			System.out.println("Something happen while compressing file.");
		}
		
		try {
			BufferedReader br2=new BufferedReader(new FileReader("test.gz"));
			String aline;
			if((aline=br2.readLine())!=null){
				System.out.println(aline);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
}
