package com.makun.chapter18.serializable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class DeepCopyDemo {
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		
//		Student stu1=new Student(10);
//		stu1.setColor(20);
//		ObjectOutputStream oos =new ObjectOutputStream(new FileOutputStream("student.out"));
//		oos.writeObject(stu1);
//		
		
		ObjectInputStream ois =new ObjectInputStream(new FileInputStream("student.out"));
		Student stu1 = (Student) ois.readObject();
		System.out.println(stu1.color);
		System.out.println(stu1.age);
		
		
	}
}

class Student implements Serializable{
	public static int color=10;
	public static void setColor(int cor){
		color=10;
	}
	public int age;
	public Student(int age){
		this.age=age;
	}
}


