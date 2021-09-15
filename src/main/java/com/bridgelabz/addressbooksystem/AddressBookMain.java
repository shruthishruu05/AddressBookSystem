package com.bridgelabz.addressbooksystem;

import java.util.Scanner;

public class AddressBookMain {

			public static void main(String[] args) {
				System.out.println("welcome to address book program");
				Scanner sc = new Scanner(System.in);
				AddressBook addressBook = new AddressBook();
				int option = 0;
					while(true) {
					System.out.println("Select option 1: add user.  2: edit existing user.  3: display all users 4:Delete contact. 5:Exit");
					option  = sc.nextInt();
					switch(option) {
						case 1 :
							addressBook.addContacts();
							break;
						case 2 :
							System.out.println("Enter the user name to edit");
							addressBook.edit();
							break;
						case 3:
							addressBook.display();
							break;
						case 4:
							System.out.println("Enter name");
							addressBook.delete();
							break;
					}
				}
				
			}
		}

