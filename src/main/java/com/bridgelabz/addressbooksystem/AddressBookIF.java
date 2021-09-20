package com.bridgelabz.addressbooksystem;

import java.io.IOException;
import java.util.List;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

public interface AddressBookIF 
{
	public void addContacts();
	public void edit();
	public void delete();
	public void display();
	public void searchByCity(String city,String firstName);
	public void searchByState(String state, String firstName);
	public void personsInCity(String city);
	public void personsInState(String State);
	public  void sortByFirstName();
	public  void sortByZip();
	public  void sortByCity();
	public  void sortByState();
	public void writeDataToCSV() throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException;
	public <CsvValidationException extends Throwable> void readDataFromCSV() throws IOException, CsvValidationException;	
}
