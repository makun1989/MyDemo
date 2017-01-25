package com.makun.chapter18.serializable;

import java.io.FileInputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class SerializableDemo {
	public static void main(String[] args) throws Exception{
//		Tree tree=new Tree();
//		tree.add(new Leaf("Green"));
//		tree.add(new Leaf("Red"));
//		tree.add(new Leaf("Yellow"));
//		ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("tree.out"));
//		oos.writeObject(tree);
//		oos.close();
		
		ObjectInput ois=new ObjectInputStream(new FileInputStream("tree.out"));
		Tree tree = (Tree) ois.readObject();
		ArrayList<Leaf> leafs = tree.leafs;
		for(int i=0;i<leafs.size();i++){
			System.out.println(leafs.get(i).getColor());
		}
		
	}

}
class Tree implements Serializable{
	ArrayList<Leaf> leafs=new ArrayList<Leaf>();
	public void add(Leaf leaf){
		leafs.add(leaf);
	}
}

class Leaf implements Serializable{
	private String color;
	public String getColor(){
		return color;
	}
	public Leaf(String color){
		this.color=color;
	}
}