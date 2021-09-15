package com.bridgelabz.addressbooksystem;

	public  class  ContactPerson {
		private String firstName;
		private String lastName;
		private String address;
		private String city;
		private String state;
		private String email;
		private int zip,phoneNumber;
		public ContactPerson(String firstName, String lastName, String address, String city, String state, String email,
				int zip, int phoneNumber) {
			super();
			this.firstName = firstName;
			this.lastName = lastName;
			this.address = address;
			this.city = city;
			this.state = state;
			this.email = email;
			this.zip = zip;
			this.phoneNumber = phoneNumber;
		}
		public String getFirstName() {
			return firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public String getAddress() {
			return address;
		}
		public String getCity() {
			return city;
		}
		public String getState() {
			return state;
		}
		public  String  getEmail () {
			return email;
		}
		public  int  getZip () {
			return zip;
		}
		public int getPhoneNumber() {
			return phoneNumber;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public void setState(String state) {
			this.state = state;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public void setZip(int zip) {
			this.zip = zip;
		}
		public void setPhoneNumber(int phoneNumber) {
			this.phoneNumber = phoneNumber;
		}
		@Override
		public String toString() {
			return "ContactPerson [firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + ", city="
					+ city + ", state=" + state + ", email=" + email + ", zip=" + zip + ", phoneNumber=" + phoneNumber
					+ "]";
		}
	}


