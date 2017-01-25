package com.makun.chapter18.filter;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;


public class DirList {
	public static void main(String[] args) {
		File path = new File(".");
		String[] list;
		if(args.length==0)
			list=path.list();
		else
			list = path.list(new DirFilter(args[0]));
		for(String dirItem:list){
			System.out.println(dirItem);
		}
	}
}

class DirFilter implements FilenameFilter{
	Pattern pattern;
	public DirFilter(String regex){
		pattern=Pattern.compile(regex);
	}
	
	@Override
	public boolean accept(File dir, String name) {
		
		return pattern.matcher(name).matches();
	}
	
}
