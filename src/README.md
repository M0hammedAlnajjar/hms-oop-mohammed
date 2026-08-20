# 🏥 Hospital Management System

A console-based **Hospital Management System** developed in **Java** using Object-Oriented Programming (OOP) principles.

The project manages patients, doctors, nurses, appointments, and medical records through a structured service-based architecture.

It demonstrates important Java concepts including:

- Encapsulation
- Inheritance
- Polymorphism
- Abstraction
- Interfaces
- Method Overriding
- Method Overloading
- Arrays
- Validation
- Service Classes
- Utility Classes
- Seed Data

---

## 📌 Project Overview

The Hospital Management System provides a simple console-based solution for managing hospital information.

The system allows users to:

- Manage patients
- Manage inpatients
- Manage doctors
- Manage surgeons
- Manage nurses
- Schedule appointments
- Manage medical records
- Search for records
- Update information
- Remove records
- Calculate patient balances
- Display hospital data

The project is designed to demonstrate practical implementation of Java OOP concepts.

---

# 🛠 Technologies Used

| Technology | Purpose |
|---|---|
| Java | Main programming language |
| IntelliJ IDEA | Development environment |
| Git | Version control |
| GitHub | Repository hosting |
| Java Arrays | Data storage |
| OOP | Application architecture |

---

# 📂 Project Structure

```text
Hospital-Management-System/
│
├── src/
│   │
│   ├── entities/
│   │   ├── Person.java
│   │   ├── Patient.java
│   │   ├── InPatient.java
│   │   ├── Doctor.java
│   │   ├── Surgeon.java
│   │   ├── Nurse.java
│   │   ├── Appointment.java
│   │   └── MedicalRecord.java
│   │
│   ├── interfaces/
│   │   ├── Displayable.java
│   │   ├── Manageable.java
│   │   └── Searchable.java
│   │
│   ├── services/
│   │   ├── PatientService.java
│   │   ├── DoctorService.java
│   │   ├── NurseService.java
│   │   ├── AppointmentService.java
│   │   └── RecordService.java
│   │
│   ├── utils/
│   │   ├── HelperUtils.java
│   │   └── InputHandler.java
│   │
│   └── HospitalApp.java
│
└── README.md
```

---

# 🧠 Object-Oriented Programming Concepts

## 1. Encapsulation

All entity attributes are declared as `private`.

Example:

```java
public class Patient extends Person {

    private String bloodGroup;
    private String emergencyContact;
    private String registrationDate;
    private double outstandingBalance;
    private boolean insured;
}
```

The data is accessed and modified using getters and setters.

Example:

```java
public double getOutstandingBalance() {
    return outstandingBalance;
}

public void setOutstandingBalance(double outstandingBalance) {

    if (outstandingBalance >= 0) {
        this.outstandingBalance = outstandingBalance;
    }
}
```

This protects the internal state of objects and allows validation before changing values.

---

## 2. Inheritance

The system uses inheritance to share common attributes and behavior.

### Patient hierarchy

```text
Person
   ↑
Patient
   ↑
InPatient
```

### Doctor hierarchy

```text
Person
   ↑
Doctor
   ↑
Surgeon
```

### Nurse hierarchy

```text
Person
   ↑
Nurse
```

For example:

```java
public class Patient extends Person {
}
```

And:

```java
public class InPatient extends Patient {
}
```

This allows child classes to reuse attributes and methods from their parent classes.

---

## 3. Polymorphism

Polymorphism allows objects from child classes to be stored using parent-class references.

Example:

```java
Patient[] patients = new Patient[100];
```

This array can store both:

```java
Patient
```

and:

```java
InPatient
```

Example:

```java
if (patients[i] instanceof InPatient) {

    InPatient inPatient =
            (InPatient) patients[i];
}
```

The same concept is used with doctors and surgeons.

```java
Doctor[] doctors = new Doctor[10];
```

A `Surgeon` can be stored inside the `Doctor[]` array because:

```text
Surgeon IS-A Doctor
```

---

## 4. Abstraction

The project uses interfaces to define common behaviors.

The main interfaces are:

```text
Displayable
Manageable
Searchable
```

For example:

```java
public class Person implements Displayable {
}
```

Service classes implement:

```java
public class PatientService
        implements Manageable, Searchable {
}
```

This ensures that service classes follow a common structure.

---

# 🔄 Method Overriding

Child classes override methods inherited from their parent classes.

For example, `Patient` overrides:

```java
@Override
public void displayInfo() {

    super.displayInfo();

    System.out.println(
            "Blood Group: " + bloodGroup
    );
}
```

`InPatient` also overrides the same method:

```java
@Override
public void displayInfo() {

    super.displayInfo();

    System.out.println(
            "Admission Date: " + admissionDate
    );

    System.out.println(
            "Room Number: " + roomNumber
    );
}
```

This demonstrates runtime polymorphism.

---

# 🔁 Method Overloading

The project also demonstrates method overloading.

For example:

```java
public Patient findPatient(String id) {
    // Search using ID
}
```

And:

```java
public Patient findPatient(
        String firstName,
        String lastName
) {
    // Search using first and last name
}
```

The method name is the same, but the parameters are different.

Another example is contact updating:

```java
public void updateContact(String phoneNumber) {
    setPhoneNumber(phoneNumber);
}
```

```java
public void updateContact(
        String phoneNumber,
        String email
) {

    setPhoneNumber(phoneNumber);
    setEmail(email);
}
```

---

# 👤 Person

`Person` is the main parent class for people in the hospital.

It stores common information such as:

- ID
- First name
- Last name
- Date of birth
- Gender
- Phone number
- Email
- Address
- National ID
- Age
- Active status

It also provides methods such as:

```java
getFullName()
displayInfo()
displaySummary()
isAdult()
```

---

# 🧑‍⚕️ Patient

`Patient` extends `Person`.

Additional patient information includes:

- Blood group
- Emergency contact
- Registration date
- Allergies
- Medical record IDs
- Outstanding balance
- Insurance status

Important methods include:

```java
addAllergy()
hasAllergy()
listAllergies()
addRecordId()
getRecordCount()
addToBalance()
clearBalance()
updateContact()
```

---

# 🛏 InPatient

`InPatient` extends `Patient`.

It represents a patient who has been admitted to the hospital.

Additional information includes:

- Admission date
- Room number
- Daily charges
- Number of days admitted

Important methods:

```java
admit()
discharge()
totalRoomCost()
```

Room cost is calculated using:

```java
return dailyCharges * daysAdmitted;
```

---

# 👨‍⚕️ Doctor

`Doctor` extends `Person`.

Doctor information includes:

- Specialization
- Experience years
- Consultation fee
- Available slots
- Assigned patient IDs
- On-call status

Important methods include:

```java
addSlot()
removeSlot()
hasSlot()
assignPatient()
getPatientLoad()
raiseFee()
```

---

# 🩺 Surgeon

`Surgeon` extends `Doctor`.

Additional information includes:

- Number of surgeries performed
- Operation theatre access
- Upcoming surgery dates

Important methods:

```java
performSurgery()
scheduleSurgery()
getUpcomingCount()
updateFee()
```

This class demonstrates multi-level inheritance:

```text
Person
   ↑
Doctor
   ↑
Surgeon
```

---

# 👩‍⚕️ Nurse

`Nurse` extends `Person`.

Nurse information includes:

- Department ID
- Shift
- Assigned patient IDs
- Years of service

Supported shifts include:

```text
Morning
Evening
Night
```

Important methods:

```java
assignPatient()
unassignPatient()
getPatientLoad()
isNightShift()
```

---

# 📅 Appointment

The appointment component manages hospital appointments between patients and doctors.

Appointment information includes details such as:

- Appointment ID
- Patient ID
- Doctor ID
- Date
- Time
- Reason
- Status

The appointment service supports operations such as:

```text
Schedule Appointment
Cancel Appointment
Complete Appointment
Reschedule Appointment
Search Appointment
List By Status
List By Patient
```

The system also demonstrates overloaded scheduling methods.

Example:

```java
schedule(
    patientId,
    doctorId,
    date
);
```

And:

```java
schedule(
    patientId,
    doctorId,
    date,
    time
);
```

---

# 📋 Medical Record

`MedicalRecord` stores medical information related to a patient visit.

Information includes:

- Record ID
- Patient ID
- Doctor ID
- Visit date
- Diagnosis
- Prescription
- Notes
- Confidential status

Important methods include:

```java
displayInfo()
appendNote()
markConfidential()
```

---

# ⚙️ Service Layer

The system separates business operations from entity classes using service classes.

The available services are:

```text
PatientService
DoctorService
NurseService
AppointmentService
RecordService
```

---

## PatientService

Supports:

```text
Add Patient
Remove Patient
Search Patient
Find Patient
Update Contact
View All Patients
List InPatients
Calculate Total Outstanding Balance
```

---

## DoctorService

Supports:

```text
Add Doctor
Add Surgeon
Remove Doctor
Search Doctor
Search By ID
Assign Patient
List By Specialization
List Available Doctors
```

---

## NurseService

Supports:

```text
Add Nurse
Remove Nurse
Search Nurse
Search By ID
List By Shift
Reassign Shift
```

---

## AppointmentService

Supports:

```text
Schedule Appointment
Remove Appointment
Search Appointment
Cancel Appointment
Complete Appointment
Reschedule Appointment
List By Status
List By Patient
```

---

## RecordService

Supports:

```text
Add Medical Record
Remove Medical Record
Search Medical Record
Search By ID
List Records By Patient
Count Confidential Records
```

---

# 🌱 Seed Data

The project contains sample data to make testing easier.

When service objects are created, sample data can be automatically loaded.

Example:

```java
public PatientService() {

    seed(
            "P001",
            "Ahmed",
            "Ali",
            "1995-05-15",
            "Male",
            "91234567",
            "ahmed@gmail.com",
            "Muscat",
            "10001",
            31,
            true,
            "O+",
            "92345678",
            true,
            50.0,
            "2026-08-20"
    );
}
```

This allows the application to be tested without manually entering all data after every run.

Sample data includes:

| Type | Sample IDs |
|---|---|
| Patients | P001 - P006 |
| Doctors | D001 - D004 |
| Nurses | N001 - N003 |
| Appointments | A0 - A5 |
| Medical Records | R001 - R005 |

The doctor sample data also includes a `Surgeon`, while the patient sample data includes `InPatient` objects.

---

# 🖥 Main Menu

The application provides a console-based menu similar to:

```text
===== HOSPITAL MANAGEMENT SYSTEM =====

1. Patient Management
2. Doctor Management
3. Nurse Management
4. Appointment Management
5. Medical Record Management
6. Exit
```

Each section contains its own submenu.

---

# 👤 Patient Menu

```text
===== PATIENT MENU =====

1. Add Patient
2. Add InPatient
3. View All Patients
4. Search Patient
5. Update Patient
6. Remove Patient
7. List InPatients
8. Total Outstanding
9. Back
```

---

# 👩‍⚕️ Nurse Menu

```text
===== NURSE MENU =====

1. Add Nurse
2. View All Nurses
3. Search Nurse
4. Remove Nurse
5. List By Shift
6. Reassign Nurse
7. Back
```

---

# 📋 Medical Record Menu

```text
===== MEDICAL RECORD MENU =====

1. Add Medical Record
2. View All Medical Records
3. Search Medical Record
4. Remove Medical Record
5. List By Patient
6. Count Confidential Records
7. Back
```

---

# ✅ Input Validation

The project includes input validation to reduce invalid data.

Examples include:

### Age validation

```java
if (age >= 0 && age <= 120) {
    this.age = age;
}
```

### Outstanding balance validation

```java
if (outstandingBalance >= 0) {
    this.outstandingBalance =
            outstandingBalance;
}
```

### Empty text validation

```java
if (value == null || value.isBlank()) {
    // Invalid input
}
```

### Shift validation

Only these values are accepted:

```text
Morning
Evening
Night
```

---

# 🧰 Utility Classes

## InputHandler

`InputHandler` handles console input and validation.

Methods include:

```java
readText()
readInt()
readIntInRange()
readDouble()
readYesNo()
readFromAllowedSet()
```

This avoids repeating input-handling logic throughout the application.

---

## HelperUtils

`HelperUtils` contains reusable helper methods.

Examples include:

```java
formatName()
isOneOf()
isValidText()
```

Additional utility operations can be used for validation and formatting.

---



# 🧪 Testing the Seed Data

After running the program, you can immediately test the system.

For example:

```text
Patient Management
→ View All Patients
```

You should see sample patients such as:

```text
P001
P002
P003
P004
P005
P006
```

To test inheritance and polymorphism:

```text
Patient Management
→ List InPatients
```

Only `InPatient` objects should be displayed.

You can also test:

```text
Doctor Management
→ View All Doctors

Nurse Management
→ List By Shift

Appointment Management
→ List By Status

Medical Record Management
→ Count Confidential Records
```

---

# 📚 Java Concepts Demonstrated

This project demonstrates:

```text
Classes and Objects
Constructors
Constructor Overloading
Encapsulation
Getters and Setters
Validation
Inheritance
Multi-Level Inheritance
Method Overriding
Method Overloading
Polymorphism
Abstraction
Interfaces
Arrays
instanceof
Object Casting
Service Layer
Utility Classes
Console Input
Search Operations
CRUD Operations
```

---


Examples of structured commit messages:

```text
feat(patient): add patient management
feat(doctor): add doctor management
feat(nurse): add nurse management
feat(appointment): add appointment management
feat(record): add medical record management
fix(inpatient): fix inpatient implementation
test(main): add seed sample data
docs: add project README
```

---

# 🎯 Project Purpose

The purpose of this project is to apply Java Object-Oriented Programming concepts in a realistic hospital management scenario.

Instead of implementing OOP concepts separately, the project connects them together through:

```text
Entities
     ↓
Inheritance
     ↓
Interfaces
     ↓
Services
     ↓
Utilities
     ↓
Hospital Application
```

This provides practical experience in designing and implementing a structured Java application.

---

# 👨‍💻 Author

**Mohammed Alnajjar**

Software Developer

Oman 🇴🇲

---

# 📄 License

This project was developed for educational and training purposes.