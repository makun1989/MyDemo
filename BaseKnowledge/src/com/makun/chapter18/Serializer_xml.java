package com.makun.chapter18;

import java.io.OutputStream;

import nu.xom.Document;
import nu.xom.Element;
import nu.xom.Serializer;

public class Serializer_xml {
	public static void main(String[] args) throws Exception {
		Person person = new Person("first name", "last name");
		Element root = new Element("people");
		root.appendChild(person.getPersonElement());
		writeToDocument(System.out, new Document(root));
	}

	public static void writeToDocument(OutputStream out, Document document) throws Exception {
		Serializer ser = new Serializer(out, "gbk");
		ser.setIndent(2);
		ser.setMaxLength(60);
		ser.write(document);
		ser.flush();
	}
}

class Person {
	String first, last;

	public Person(String first, String last) {
		this.first = first;
		this.last = last;
	}

	public Element getPersonElement() {
		Element person = new Element("person");
		Element firstName = new Element("first");
		firstName.appendChild(first);
		Element lastName = new Element("last");
		lastName.appendChild(last);
		person.appendChild(firstName);
		person.appendChild(lastName);

		return person;
	}

}