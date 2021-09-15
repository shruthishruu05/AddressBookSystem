package com.bridgelabz.addressbooksystem;

import java.util.Scanner;

public class AddressBook 
{
	Scanner sc = new Scanner(System.in);
	private ContactPerson contactBook[];
	private int numberOfConatcts=0;

AddressBook() {
	this.contactBook = new ContactPerson[20];
}

public  void  addContacts ()
{
	System.out.println("Enter the Contact details-->");
	System.out.println("Add Contact");
	System.out.println("Enter first name:");
	String firstName = sc.next();
	System.out.println("Enter last name");
	String lastName = sc.next();
	System.out.println("Enter city");
	String city = sc.next();
	System.out.println("Enter address");
	String address = sc.next();
	System.out.println("Enter state");
	String state = sc.next();
	System.out.println("Enter email");
	String email = sc.next();
	System.out.println("Enter Phone");
	int phoneNumber = sc.nextInt();
	System.out.println("Enter Zip");
	int zip = sc.nextInt();
	contactBook[numberOfConatcts]= new ContactPerson(firstName, lastName, address, state, city, email, phoneNumber, zip);
	numberOfConatcts++;
}
public void display()
{
	for(int index =0 ;index<numberOfConatcts;index++)
	{
		System.out.println(contactBook[index]);
	}
}

}
