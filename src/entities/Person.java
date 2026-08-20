package entities;

import interfaces.Displayable;

public class Person implements Displayable {

    private String id;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String gender;
    private String phoneNumber;
    private String email;
    private String address;
    private String nationalId;
    private int age;
    private boolean active;


    // Full constructor
    public Person(
            String id,
            String firstName,
            String lastName,
            String dateOfBirth,
            String gender,
            String phoneNumber,
            String email,
            String address,
            String nationalId,
            int age,
            boolean active
    ) {

        setId(id);
        setFirstName(firstName);
        setLastName(lastName);
        setDateOfBirth(dateOfBirth);
        setGender(gender);
        setPhoneNumber(phoneNumber);
        setEmail(email);
        setAddress(address);
        setNationalId(nationalId);
        setAge(age);
        setActive(active);
    }


    // Overloaded constructor
    public Person(
            String id,
            String firstName,
            String lastName
    ) {

        setId(id);
        setFirstName(firstName);
        setLastName(lastName);
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {

        if (id != null && !id.isBlank()) {
            this.id = id;
        } else {
            System.out.println("ID cannot be empty");
        }
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {

        if (firstName != null && !firstName.isBlank()) {
            this.firstName = firstName;
        } else {
            System.out.println("First name cannot be empty");
        }
    }


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {

        if (lastName != null && !lastName.isBlank()) {
            this.lastName = lastName;
        } else {
            System.out.println("Last name cannot be empty");
        }
    }


    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {

        if (dateOfBirth != null && !dateOfBirth.isBlank()) {
            this.dateOfBirth = dateOfBirth;
        } else {
            System.out.println("Date of birth cannot be empty");
        }
    }


    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {

        if (gender != null && !gender.isBlank()) {
            this.gender = gender;
        }
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {

        if (phoneNumber != null && !phoneNumber.isBlank()) {
            this.phoneNumber = phoneNumber;
        }
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {

        if (email != null && !email.isBlank()) {
            this.email = email;
        }
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {

        if (address != null && !address.isBlank()) {
            this.address = address;
        }
    }


    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {

        if (nationalId != null && !nationalId.isBlank()) {
            this.nationalId = nationalId;
        } else {
            System.out.println("National ID cannot be empty");
        }
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {

        if (age >= 0 && age <= 120) {
            this.age = age;
        } else {
            System.out.println("Age must be between 0 and 120");
        }
    }


    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }


    public String getFullName() {
        return firstName + " " + lastName;
    }


    @Override
    public void displayInfo() {

        System.out.println("ID: " + id);
        System.out.println("Name: " + getFullName());
        System.out.println("Date of Birth: " + dateOfBirth);
        System.out.println("Gender: " + gender);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Email: " + email);
        System.out.println("Address: " + address);
        System.out.println("National ID: " + nationalId);
        System.out.println("Age: " + age);
        System.out.println("Active: " + active);
    }


    @Override
    public void displaySummary() {

        System.out.println("ID: " + id);
        System.out.println("Name: " + getFullName());
    }


    public boolean isAdult() {
        return age >= 18;
    }


    @Override
    public String toString() {

        return "Person{" +
                "id='" + id + '\'' +
                ", name='" + getFullName() + '\'' +
                ", age=" + age +
                ", active=" + active +
                '}';
    }


    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Person)) {
            return false;
        }

        Person other = (Person) obj;

        return id != null && id.equals(other.id);
    }
}