package com.bridgelabz.addressbooksystem;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.Arrays;

import com.google.gson.Gson;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

public class AddressBook implements AddressBookIF
{
	ArrayList<ContactPerson> contactBook = new ArrayList<ContactPerson>();
	public  HashMap<String, ArrayList<ContactPerson>> personsByCity = new HashMap<String, ArrayList<ContactPerson>>();
	public  HashMap<String, ArrayList<ContactPerson>> personsByState = new HashMap<String, ArrayList<ContactPerson>>();
	
	Scanner sc = new Scanner(System.in);
	private static int numberOfConatcts = 0;
	 private String adressBookName;
	
	
	@Override
	public String toString() 
	{
		return "AddressBook [adressBookName=" + adressBookName + "]";
	}


	public String getAdressBookName() {
		return adressBookName;
	}


	public void setAdressBookName(String adressBookName) {
		this.adressBookName = adressBookName;
	}
	public String nameString = this.adressBookName+".txt";
	public void write() {
		AddressBookFileIO.writeData(contactBook, this.adressBookName+".txt");
	}
	
	public List<String> read() {
		return AddressBookFileIO.readDataFromFile(this.adressBookName);
	}

	public void addContacts()
	{
		System.out.println("Enter Person details:");
		
		ContactPerson person = details();
		boolean isDuplicate = contactBook.stream().anyMatch(contact -> contact.equals(person));
		if(isDuplicate) {
			System.out.println("Duplicate data entry. discarded");
		}
		else
		{
			contactBook.add(person);
			if(personsByCity.get(person.getCity()) == null) personsByCity.put(person.getCity(), new ArrayList<>());
			personsByCity.get(person.getCity()).add(person);
			if(personsByState.get(person.getState()) == null) personsByState.put(person.getState(), new ArrayList<>());
			personsByState.get(person.getState()).add(person);
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
	public void searchByCity(String city,String firstName) {
		Predicate<ContactPerson> searchPerson = (contact -> contact.getCity().equals(city)&& contact.getFirstName().equals(firstName));
		contactBook.stream().filter(searchPerson).forEach(person -> output(person));
	}
	
	public void searchByState(String state, String firstName) {
		Predicate<ContactPerson> searchPerson = (contact -> contact.getState().equals(state)&& contact.getFirstName().equals(firstName));
		contactBook.stream().filter(searchPerson).forEach(person -> output(person));
	}
	public void personsInCity(String city) {
		ArrayList<ContactPerson> list = personsByCity.get(city);
		list.stream().forEach(person -> output(person));
	}
	
	public void personsInState(String State) {
		ArrayList<ContactPerson> list = personsByState.get(State);
		list.stream().forEach(person -> output(person));
	}
	public  void sortByFirstName() {
		contactBook.stream()
					 .sorted((contact1,contact2) -> contact1.getFirstName().compareTo(contact2.getFirstName()))
					 .forEach(System.out::println);
	}
	public  void sortByZip() {
		contactBook.stream()
					 .sorted((contact1,contact2) -> contact1.getZip()-contact2.getZip())
					 .forEach(System.out::println);
	}
	public  void sortByCity() {
		contactBook.stream()
					 .sorted((contact1,contact2) -> contact1.getCity().compareTo(contact2.getCity()))
					 .forEach(System.out::println);
	}
	public  void sortByState() {
		contactBook.stream()
					 .sorted((contact1,contact2) -> contact1.getState().compareTo(contact2.getState()))
					 .forEach(System.out::println);
	}
	
	private static void output(ContactPerson person) {
		System.out.println("firstName : "+person.getFirstName());
		System.out.println("SecondName : "+ person.getLastName());
		System.out.println("Address : "+ person.getAddress());
		System.out.println("City : "+person.getCity());
		System.out.println("State : "+person.getState());
		System.out.println("Pin code : "+person.getZip());
		System.out.println("Phone nmber : "+person.getPhoneNumber() );
		System.out.println("email : "+person.getEmail());
	}
	
	public void writeDataToCSV() throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {
		
		String fileName = "./"+this.adressBookName+"Contacts.csv";
        try (Writer writer = Files.newBufferedWriter(Paths.get(fileName));) {
        	
            StatefulBeanToCsvBuilder<ContactPerson> builder = new StatefulBeanToCsvBuilder<>(writer);
            StatefulBeanToCsv<ContactPerson> beanWriter = builder.build();
            ArrayList<ContactPerson> listOfContacts= contactBook.stream().collect(Collectors.toCollection(ArrayList::new));
            beanWriter.write(listOfContacts);
            writer.close();
            System.out.println("Written !");
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public <CsvValidationException extends Throwable> void readDataFromCSV() throws IOException, CsvValidationException {
    	
    	String fileName = "./"+this.adressBookName+"Contacts.csv";
        try (Reader reader = Files.newBufferedReader(Paths.get(fileName));
             CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();){
        	
            String[] nextRecord;
            while ((nextRecord = csvReader.readNext()) != null) {
                System.out.println("First Name = " + nextRecord[2]);
                System.out.println("Last Name = " + nextRecord[3]);
                System.out.println("City = " + nextRecord[0]);
                System.out.println("State = " + nextRecord[5]);
                System.out.println("Email = " + nextRecord[1]);
                System.out.println("Phone Number = " + nextRecord[4]);
                System.out.println("Zip Code = " + nextRecord[6]);
                System.out.println("\n");
            }
        }
    }
    
    @Override
    public void writeDataToJson() throws IOException {
		
		String fileName = "./" + this.adressBookName + ".json";
		Path filePath = Paths.get(fileName);
		Gson gson = new Gson();
		String json = gson.toJson(contactBook);
		FileWriter writer = new FileWriter(String.valueOf(filePath));
		writer.write(json);
		writer.close();

	}

	@Override
    public void readDataFromJson() throws IOException {
    	
        ArrayList<ContactPerson> contactList;
        String fileName = "./"+this.adressBookName+".json";
        Path filePath = Paths.get(fileName);
        
        try (Reader reader = Files.newBufferedReader(filePath)) {
            Gson gson = new Gson();
            contactList = new ArrayList<>(Arrays.asList(gson.fromJson(reader, ContactPerson[].class)));
            for (ContactPerson contact : contactList) {
            	System.out.println("{");
                System.out.println("Firstname : " + contact.getFirstName());
                System.out.println("Lastname : " + contact.getLastName());
                System.out.println("City : " + contact.getCity());
                System.out.println("State : " + contact.getState());
                System.out.println("Zip Code : " + contact.getZip());
                System.out.println("Phone number : " + contact.getPhoneNumber());
                System.out.println("Email : " + contact.getEmail());
                System.out.println("}\n");
            }
        }
    }

}
