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

public  void  edit ()
{
	System.out.println("enter the name to edit contact details");
	String name = sc.next();
	System.out.println("enter the choice to edit details");
	System.out.println("1.First Name\\n2.Last Name\\n3.City\\n4.State\\n5.Zip Code\\n6.Phone\\n7.Email");
	int choice = sc.nextInt();
	int index =0;
	for( index =0;index<numberOfConatcts;index++)
	if(name.equals(contactBook[index].getFirstName()))
	{
		System.out.println("name exists , now enter the new details");
		
		 break;
	}
	else {
		System.out.println("No contact found");
		return;
	}
	switch (choice) {
	case 1:
		System.out.println("Enter new First Name");
		String newFirstName = sc.next();
		contactBook[index].setFirstName(newFirstName);
		break;
	case 2:
		System.out.println("Enter new Last Name");
		String newLastName = sc.next();
		contactBook[index].setLastName(newLastName);
		break;
	case 3:
		System.out.println("Enter new City");
		String newCity = sc.next();
		contactBook[index].setCity(newCity);
		break;
	case 4:
		System.out.println("Enter new State");
		String newState = sc.next();
		contactBook[index].setState(newState);
		break;
	case 5:
		System.out.println("Enter new State");
		int newZip = sc.nextInt();
		contactBook[index].setZip(newZip);
		break;
	case  6 :
		System.out.println("Enter new Phone Number");
		int newPNumber = sc.nextInt();
		contactBook[index].setPhoneNumber(newPNumber);
		break;
	case 7:
		System.out.println("Enter new Email");
		String newEmail = sc.next();
		contactBook[index].setEmail(newEmail);
		break;
	}
	
	
}

public void display()
{
	for(int index =0 ;index<numberOfConatcts;index++)
	{
		System.out.println(contactBook[index]);
	}
}

}
