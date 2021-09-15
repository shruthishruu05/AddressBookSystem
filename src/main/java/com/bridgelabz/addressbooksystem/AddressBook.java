package com.bridgelabz.addressbooksystem;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {
	private ArrayList<ContactPerson> contactBook = new ArrayList<ContactPerson>();
	Scanner sc = new Scanner(System.in);
	private static int numberOfConatcts = 0;
	
	public void addContacts()
	{
		System.out.println("Enter Person details:");
		
		ContactPerson person = details();
		boolean isDuplicate = contactBook.stream().anyMatch(contact -> contact.equals(person));
		if(isDuplicate) {
			System.out.println("Duplicate data entry. discarded");
		}
		else{
			contactBook.add(person);
		}
		
		
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
			String newPNumber = sc.next();
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
	public void searchByCityOrState()
	{
		System.out.println("enter the name of the city or state to perform search");
		String cityOrState = sc.next();
		for(int index=0;index<numberOfConatcts;index++) 
		{
			if(contactBook.get(index).getCity().equals(cityOrState)||contactBook.get(index).getState().equals(cityOrState))
			{
				System.out.println(contactBook.get(index));
			}
		}
	}
	
	
	public void display()
	{
		ContactPerson person;
		System.out.println("Enter name to see details");
		String name = sc.next();
		
		for(int i = 0;i<contactBook.size();i++) {
			if(contactBook.get(i).getFirstName().equals(name)) {
				person = contactBook.get(i);
				System.out.println(person);
			}
		}
	}
	private static ContactPerson details() {
		Scanner sc = new Scanner(System.in);
		ContactPerson person1 = new ContactPerson();
		
		System.out.println("Enter firstName:");
		person1.setFirstName(sc.next());
		System.out.println("Enter SecondName:");
		person1.setLastName(sc.next());
		System.out.println("Enter Address:");
		person1.setAddress(sc.next());
		System.out.println("Enter City:");
		person1.setCity(sc.next());
		System.out.println("Enter State:");
		person1.setState(sc.next());
		System.out.println("Enter Pin code:");
		person1.setZip(sc.nextInt());
		System.out.println("Enter Phone nmber:");
		person1.setPhoneNumber(sc.next());
		System.out.println("Enter email:");
		person1.setEmail(sc.next());
		return person1;
	}

}
