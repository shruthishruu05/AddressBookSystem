package com.bridgelabz.addressbooksystem;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {
	private ArrayList<ContactPerson> contactBook = new ArrayList<ContactPerson>();
	Scanner sc = new Scanner(System.in);
	private static int numberOfConatcts = 0;
	
	public void addContacts()
	{
		ContactPerson contactPerson = new ContactPerson();
		String name = sc.next();
		for(int i=0; i<contactBook.size();i++) {
			if(contactBook.get(i).getFirstName().equals(name)) {
				System.out.println("the name is already taken,hence duplicate value");
				return;
			}
		}

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
		contactBook.add(new ContactPerson(firstName, lastName, address, state, city, email, phoneNumber, zip));
		numberOfConatcts++;
	}
	
	public void edit()
	{
		System.out.println("enter the name to edit contact details");
		String name = sc.next();
		System.out.println("enter the choice to edit details");
		System.out.println("1.First Name\\n2.Last Name\\n3.City\\n4.State\\n5.Zip Code\\n6.Phone\\n7.Email");
		int choice = sc.nextInt();
		int index =0;
		for( index =0;index<numberOfConatcts;index++)
		if(name.equals(contactBook.get(index).getFirstName()))
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
			contactBook.get(index).setFirstName(newFirstName);
			break;
		case 2:
			System.out.println("Enter new Last Name");
			String newLastName = sc.next();
			contactBook.get(index).setLastName(newLastName);
			break;
		case 3:
			System.out.println("Enter new City");
			String newCity = sc.next();
			contactBook.get(index).setCity(newCity);
			break;
		case 4:
			System.out.println("Enter new State");
			String newState = sc.next();
			contactBook.get(index).setState(newState);
			break;
		case 5:
			System.out.println("Enter new State");
			int newZip = sc.nextInt();
			contactBook.get(index).setZip(newZip);
			break;
		case 6:
			System.out.println("Enter new Phone Number");
			int newPNumber = sc.nextInt();
			contactBook.get(index).setPhoneNumber(newPNumber);
			break;
		case 7:
			System.out.println("Enter new Email");
			String newEmail = sc.next();
			contactBook.get(index).setEmail(newEmail);
			break;
		}
		
		
	}
	
	public void delete()
	{
		int index;
		System.out.println("Enter the name of the contact to delete");
		String name = sc.next();
		for( index=0;index<numberOfConatcts;index++) 
			if(contactBook.get(index).getFirstName().equals(name)) {
				break;
			}
		while(!contactBook.get(index+1).equals(null)) {
			contactBook.set(index, contactBook.get(index+1));
			index++;
		}
		contactBook.set(index,null);
		System.out.println("Deleted details of : "+ name);
	}
	
	
	public void display()
	{
		for(int index =0 ;index<numberOfConatcts;index++)
		{
			System.out.println(contactBook.get(index));
		}
	}

}