package com.bridgelabz.addressbooksystem;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
public class AddressBookMain {
	private static List<AddressBook> addressBooks = new LinkedList<AddressBook>();
	private static String[] addressBookName = new String[10];
	private static int  numOfBooks =0;
	
	private boolean checkName(String name) {
		for(int i=0;i<addressBooks.size();i++) {
			if(addressBookName[i].equals(name)) return true;
		}
		return false;
	}
	
	private static void addressMenu(AddressBook addressBook) {
		Scanner sc = new Scanner(System.in);
		int option = 0;
		boolean exit = true;
		while(exit) {
			System.out.println("Select option 1: add user.  2: edit existing user.  3: display all users 4:Delete contact. 5:seach userby city 6: search user by state 7:view by city 8:view by state 9: sort by name 10:Switch Address Book");
			option  = sc.nextInt();
			switch(option) {
				case 1 :
					addressBook.addContacts();
					break;
				case 2 :
					System.out.println("Enter the first name to edit");
					addressBook.edit();
					break;
				case 3:
					System.out.println("display");
					addressBook.display();
					break;
				case 4:
					System.out.println("Enter name");
					addressBook.delete();
					break;
				case 5: 
					System.out.println("enter the name of the city");
					String cityName = sc.next();
					System.out.println("enter the first name to search for city");
					String firstName = sc.next();
					
					addressBook.searchByCity(cityName,firstName);
				case 6: 
					System.out.println("enter the name of the city");
					String stateName = sc.next();
					System.out.println("enter the first name to search for city");
					String firstName1 = sc.next();
					addressBook.searchByState(stateName,firstName1);
					break;
				case 7:
					System.out.println("enter the city name");
					String city  = sc.next();
					addressBook.personsInCity(city);
					break;
				case 8:
					System.out.println("enter the state name");
					String state  = sc.next();
					addressBook.personsInState(state);
					break;
				case 9:
					addressBook.sortByFirstName();
					break;
					
				default:
					exit = false;
					
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		System.out.println("Welcome to address book program");
		Scanner sc = new Scanner(System.in);
		
		AddressBook currentBook;
		int choice =0;
		boolean exit1 = true;
		while(exit1) {
			System.out.println("Select option 1:Add address Book 2:open Address Book 3:exit");
			choice = sc.nextInt();
			switch(choice) {
				case 1: 
					System.out.println("Enter the address book name");
					String name = sc.next();
					currentBook  = new AddressBook();
					addressBooks.add(currentBook);
					addressBookName[numOfBooks] = name;
					numOfBooks++;
					break;
				case 2:
					System.out.println("The Address books available :");
					for(int i=0;i<numOfBooks;i++) {
						System.out.println(addressBookName[i]);
					}
					System.out.println("Enter the address book name");
					String bookName = sc.next();
					int i =0;
					for(i=0;i<numOfBooks;i++) {
						if(addressBookName[i].equals(bookName)) break;
					}
					
					if(i == numOfBooks) {
						System.out.println("name Not Found");
						break;
					}
					currentBook = addressBooks.get(i);
					addressMenu(currentBook);
					break;
				default:
					exit1 = false;
			}
		}
		
		sc.close();
	}
}