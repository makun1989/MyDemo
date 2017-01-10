package com.makun.chapter20;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class TableCreator {
	public static void main(String[] args) throws Exception {
		if(args.length<1)
		{
			System.out.println("arguments:annotated class");
			System.exit(0);
		}
		
		for(String className:args){
			Class<?> c1 = Class.forName(className);
			DBTable dbTable = c1.getAnnotation(DBTable.class);
			if(dbTable==null){
				System.out.println("No DBTable annotations in class "+className);
				continue;
			}
			
			String tableName=dbTable.name();
			if(tableName.length()<1)
				tableName=c1.getName().toUpperCase();
			List<String> columnDefs=new ArrayList<String>();
			for(Field field:c1.getDeclaredFields()){
				String columnName=null;
				Annotation[] annotations = field.getAnnotations();
				
				if(annotations==null)
					continue;
				
				if(annotations[0] instanceof SqlInteger){
					SqlInteger sInt=(SqlInteger) annotations[0];
					if(sInt.name().length()<1)
						columnName=field.getName().toUpperCase();
					else
						columnName=sInt.name();
					
					columnDefs.add(columnName+" INT "+getConstraints(sInt.contstraints()));
				}
				
				if(annotations[0] instanceof SqlString){
					SqlString sString =(SqlString) annotations[0];
					
					if(sString.name().length()<1)
						columnName=field.getName().toUpperCase();
					else
						columnName=sString.name();
					columnDefs.add(columnName+ " VARCHAR("+sString.value()+")"+getConstraints(sString.constraints()) );
					
				}
				
				StringBuilder createCommand=new StringBuilder("CREATE  TABLE "+tableName+"(");
				
				for(String columnDef:columnDefs){
					createCommand.append("\n  "+columnDef+",");
				}
				
				String tableCreate=createCommand.substring(0,createCommand.length()-1)+");";
				System.out.println("Table creation sql for "+className + " is "+tableCreate);
				
			}
			
			
			
			
		}
		
		
		
		
		
		
	}
	
	private static String getConstraints(Constraints con){
		String constraints="";
		if(con.allowNull())
			constraints+=" not null";
		if(con.primaryKey())
			constraints+=" primary key";
		if(con.unique())
			constraints+=" unique";
		return constraints;
	}
}
