package main;

import entities.*;
import services.*;
import utils.InputHandler;

public class HospitalApp {

    // =========================
    // Services
    // =========================

    private PatientService patientService =
            new PatientService();

    private DoctorService doctorService =
            new DoctorService();

    private NurseService nurseService =
            new NurseService();

    private AppointmentService appointmentService =
            new AppointmentService();

    private RecordService recordService =
            new RecordService();

    private InputHandler input =
            new InputHandler();


    // =========================
    // Main
    // =========================

    public static void main(String[] args) {

        HospitalApp app =
                new HospitalApp();

        app.run();
    }


    // =========================
    // Main Menu
    // =========================

    public void run() {

        boolean running = true;

        while (running) {

            System.out.println(
                    "\n===== HOSPITAL MANAGEMENT SYSTEM ====="
            );

            System.out.println("1. Patients");
            System.out.println("2. Doctors");
            System.out.println("3. Nurses");
            System.out.println("4. Appointments");
            System.out.println("5. Medical Records");
            System.out.println("6. Reports");
            System.out.println("7. Exit");

            String choice =
                    input.readText(
                            "Choose an option: "
                    );

            switch (choice) {

                case "1": {
                    patientMenu();
                    break;
                }

                case "2": {
                    doctorMenu();
                    break;
                }

                case "3": {
                    nurseMenu();
                    break;
                }

                case "4": {
                    appointmentMenu();
                    break;
                }

                case "5": {
                    recordMenu();
                    break;
                }

                case "6": {
                    reportsMenu();
                    break;
                }

                case "7": {

                    running = false;

                    System.out.println(
                            "Exiting Hospital Management System."
                    );

                    break;
                }

                default: {

                    System.out.println(
                            "Invalid option."
                    );
                }
            }
        }
    }


    // =========================
    // Reports Menu
    // =========================

    private void reportsMenu() {

        boolean back = false;

        while (!back) {

            System.out.println(
                    "\n===== REPORTS MENU ====="
            );

            System.out.println("1. Total Patients");
            System.out.println("2. Total Doctors");
            System.out.println("3. Total Nurses");
            System.out.println("4. Total Appointments");
            System.out.println("5. Total Medical Records");
            System.out.println("6. Total Outstanding Balance");
            System.out.println("7. Confidential Records Count");
            System.out.println("8. Back");

            String choice =
                    input.readText(
                            "Choose an option: "
                    );

            switch (choice) {

                case "1": {

                    int totalPatients =
                            patientService
                                    .getAll()
                                    .length;

                    System.out.println(
                            "Total Patients: "
                                    + totalPatients
                    );

                    break;
                }

                case "2": {

                    int totalDoctors =
                            doctorService
                                    .getAll()
                                    .length;

                    System.out.println(
                            "Total Doctors: "
                                    + totalDoctors
                    );

                    break;
                }

                case "3": {

                    int totalNurses =
                            nurseService
                                    .getAll()
                                    .length;

                    System.out.println(
                            "Total Nurses: "
                                    + totalNurses
                    );

                    break;
                }

                case "4": {

                    int totalAppointments =
                            appointmentService
                                    .getAll()
                                    .length;

                    System.out.println(
                            "Total Appointments: "
                                    + totalAppointments
                    );

                    break;
                }

                case "5": {

                    int totalRecords =
                            recordService
                                    .getAll()
                                    .length;

                    System.out.println(
                            "Total Medical Records: "
                                    + totalRecords
                    );

                    break;
                }

                case "6": {

                    double totalOutstanding =
                            patientService
                                    .totalOutstanding();

                    System.out.println(
                            "Total Outstanding Balance: "
                                    + totalOutstanding
                    );

                    break;
                }

                case "7": {

                    int confidentialRecords =
                            recordService
                                    .countConfidential();

                    System.out.println(
                            "Confidential Records Count: "
                                    + confidentialRecords
                    );

                    break;
                }

                case "8": {

                    back = true;
                    break;
                }

                default: {

                    System.out.println(
                            "Invalid option."
                    );
                }
            }
        }
    }


    // =========================
    // Medical Record Menu
    // =========================

    private void recordMenu() {

        boolean back = false;

        while (!back) {

            System.out.println(
                    "\n===== MEDICAL RECORD MENU ====="
            );

            System.out.println("1. Add Medical Record");
            System.out.println("2. View All Medical Records");
            System.out.println("3. Search Medical Record");
            System.out.println("4. Remove Medical Record");
            System.out.println("5. List By Patient");
            System.out.println("6. Count Confidential Records");
            System.out.println("7. Back");

            String choice =
                    input.readText(
                            "Choose an option: "
                    );

            switch (choice) {

                case "1": {

                    String recordId =
                            input.readText(
                                    "Enter record ID: "
                            );

                    String patientId =
                            input.readText(
                                    "Enter patient ID: "
                            );

                    String doctorId =
                            input.readText(
                                    "Enter doctor ID: "
                            );

                    String visitDate =
                            input.readText(
                                    "Enter visit date: "
                            );

                    String diagnosis =
                            input.readText(
                                    "Enter diagnosis: "
                            );

                    String prescription =
                            input.readText(
                                    "Enter prescription: "
                            );

                    String notes =
                            input.readText(
                                    "Enter notes: "
                            );

                    boolean confidential =
                            input.readYesNo(
                                    "Confidential (yes/no): "
                            );

                    MedicalRecord record =
                            new MedicalRecord(
                                    confidential,
                                    diagnosis,
                                    doctorId,
                                    notes,
                                    patientId,
                                    prescription,
                                    recordId,
                                    visitDate
                            );

                    recordService.add(record);

                    System.out.println(
                            "Medical record added successfully."
                    );

                    break;
                }

                case "2": {

                    Object[] records =
                            recordService.getAll();

                    if (records.length == 0) {

                        System.out.println(
                                "No medical records found."
                        );

                    } else {

                        for (Object recordObject : records) {

                            MedicalRecord currentRecord =
                                    (MedicalRecord) recordObject;

                            currentRecord.displayInfo();

                            System.out.println(
                                    "--------------------"
                            );
                        }
                    }

                    break;
                }

                case "3": {

                    String keyword =
                            input.readText(
                                    "Enter diagnosis or prescription: "
                            );

                    Object[] recordResults =
                            recordService.search(
                                    keyword
                            );

                    if (recordResults.length == 0) {

                        System.out.println(
                                "No medical records found."
                        );

                    } else {

                        for (Object result
                                : recordResults) {

                            MedicalRecord foundRecord =
                                    (MedicalRecord) result;

                            foundRecord.displayInfo();

                            System.out.println(
                                    "--------------------"
                            );
                        }
                    }

                    break;
                }

                case "4": {

                    String removeRecordId =
                            input.readText(
                                    "Enter record ID: "
                            );

                    recordService.removeById(
                            removeRecordId
                    );

                    break;
                }

                case "5": {

                    String patientId =
                            input.readText(
                                    "Enter patient ID: "
                            );

                    MedicalRecord[] patientRecords =
                            recordService
                                    .listByPatient(
                                            patientId
                                    );

                    if (patientRecords.length == 0) {

                        System.out.println(
                                "No medical records found for this patient."
                        );

                    } else {

                        for (MedicalRecord patientRecord
                                : patientRecords) {

                            patientRecord.displayInfo();

                            System.out.println(
                                    "--------------------"
                            );
                        }
                    }

                    break;
                }

                case "6": {

                    int confidentialCount =
                            recordService
                                    .countConfidential();

                    System.out.println(
                            "Confidential Records Count: "
                                    + confidentialCount
                    );

                    break;
                }

                case "7": {

                    back = true;
                    break;
                }

                default: {

                    System.out.println(
                            "Invalid option."
                    );
                }
            }
        }
    }


    // =========================
    // Appointment Menu
    // =========================

    private void appointmentMenu() {

        boolean back = false;

        while (!back) {

            System.out.println(
                    "\n===== APPOINTMENT MENU ====="
            );

            System.out.println("1. Schedule Appointment");
            System.out.println("2. Cancel Appointment");
            System.out.println("3. Complete Appointment");
            System.out.println("4. Reschedule Appointment");
            System.out.println("5. List By Status");
            System.out.println("6. List By Patient");
            System.out.println("7. Back");

            String choice =
                    input.readText(
                            "Choose an option: "
                    );

            switch (choice) {

                case "1": {

                    String patientId =
                            input.readText(
                                    "Enter patient ID: "
                            );

                    String doctorId =
                            input.readText(
                                    "Enter doctor ID: "
                            );

                    String date =
                            input.readText(
                                    "Enter appointment date: "
                            );

                    String time =
                            input.readText(
                                    "Enter appointment time: "
                            );

                    Appointment appointment =
                            appointmentService.schedule(
                                    patientId,
                                    doctorId,
                                    date,
                                    time
                            );

                    if (appointment != null) {

                        System.out.println(
                                "Appointment scheduled successfully."
                        );
                    }

                    break;
                }

                case "2": {

                    String appointmentId =
                            input.readText(
                                    "Enter appointment ID: "
                            );

                    appointmentService.cancel(
                            appointmentId
                    );

                    break;
                }

                case "3": {

                    String appointmentId =
                            input.readText(
                                    "Enter appointment ID: "
                            );

                    appointmentService.complete(
                            appointmentId
                    );

                    break;
                }

                case "4": {

                    String appointmentId =
                            input.readText(
                                    "Enter appointment ID: "
                            );

                    String newDate =
                            input.readText(
                                    "Enter new appointment date: "
                            );

                    String newTime =
                            input.readText(
                                    "Enter new appointment time: "
                            );

                    appointmentService.reschedule(
                            appointmentId,
                            newDate,
                            newTime
                    );

                    break;
                }

                case "5": {

                    String[] allowedStatus = {
                            "Scheduled",
                            "Completed",
                            "Cancelled",
                            "Rescheduled"
                    };

                    String status =
                            input.readFromAllowedSet(
                                    "Enter appointment status: ",
                                    allowedStatus
                            );

                    Appointment[] statusAppointments =
                            appointmentService
                                    .listByStatus(
                                            status
                                    );

                    if (statusAppointments.length == 0) {

                        System.out.println(
                                "No appointments found with this status."
                        );

                    } else {

                        for (Appointment statusAppointment
                                : statusAppointments) {

                            statusAppointment.displayInfo();

                            System.out.println(
                                    "--------------------"
                            );
                        }
                    }

                    break;
                }

                case "6": {

                    String patientId =
                            input.readText(
                                    "Enter patient ID: "
                            );

                    Appointment[] patientAppointments =
                            appointmentService
                                    .listByPatient(
                                            patientId
                                    );

                    if (patientAppointments.length == 0) {

                        System.out.println(
                                "No appointments found for this patient."
                        );

                    } else {

                        for (Appointment patientAppointment
                                : patientAppointments) {

                            patientAppointment.displayInfo();

                            System.out.println(
                                    "--------------------"
                            );
                        }
                    }

                    break;
                }

                case "7": {

                    back = true;
                    break;
                }

                default: {

                    System.out.println(
                            "Invalid option."
                    );
                }
            }
        }
    }


    // =========================
    // Nurse Menu
    // =========================

    private void nurseMenu() {

        boolean back = false;

        while (!back) {

            System.out.println(
                    "\n===== NURSE MENU ====="
            );

            System.out.println("1. Add Nurse");
            System.out.println("2. View All Nurses");
            System.out.println("3. Search Nurse");
            System.out.println("4. Remove Nurse");
            System.out.println("5. List By Shift");
            System.out.println("6. Reassign Nurse");
            System.out.println("7. Back");

            String choice =
                    input.readText(
                            "Choose an option: "
                    );

            switch (choice) {

                case "1": {

                    String nurseId =
                            input.readText(
                                    "Enter nurse ID: "
                            );

                    String firstName =
                            input.readText(
                                    "Enter first name: "
                            );

                    String lastName =
                            input.readText(
                                    "Enter last name: "
                            );

                    String dateOfBirth =
                            input.readText(
                                    "Enter date of birth: "
                            );

                    String gender =
                            input.readText(
                                    "Enter gender: "
                            );

                    String phoneNumber =
                            input.readText(
                                    "Enter phone number: "
                            );

                    String email =
                            input.readEmail(
                                    "Enter email: "
                            );

                    String address =
                            input.readText(
                                    "Enter address: "
                            );

                    String nationalId =
                            input.readText(
                                    "Enter national ID: "
                            );

                    int age =
                            input.readIntInRange(
                                    "Enter age: ",
                                    0,
                                    120
                            );

                    boolean active =
                            input.readYesNo(
                                    "Active (yes/no): "
                            );

                    String departmentId =
                            input.readText(
                                    "Enter department ID: "
                            );

                    String[] allowedShifts = {
                            "Morning",
                            "Evening",
                            "Night"
                    };

                    String shift =
                            input.readFromAllowedSet(
                                    "Enter shift: ",
                                    allowedShifts
                            );

                    int yearsOfService =
                            input.readIntInRange(
                                    "Enter years of service: ",
                                    0,
                                    80
                            );

                    Nurse nurse =
                            new Nurse(
                                    nurseId,
                                    firstName,
                                    lastName,
                                    dateOfBirth,
                                    gender,
                                    phoneNumber,
                                    email,
                                    address,
                                    nationalId,
                                    age,
                                    active,
                                    departmentId,
                                    shift,
                                    new String[0],
                                    yearsOfService
                            );

                    nurseService.add(nurse);

                    System.out.println(
                            "Nurse added successfully."
                    );

                    break;
                }

                case "2": {

                    Object[] nurses =
                            nurseService.getAll();

                    if (nurses.length == 0) {

                        System.out.println(
                                "No nurses found."
                        );

                    } else {

                        for (Object nurseObject
                                : nurses) {

                            Nurse currentNurse =
                                    (Nurse) nurseObject;

                            currentNurse.displayInfo();

                            System.out.println(
                                    "--------------------"
                            );
                        }
                    }

                    break;
                }

                case "3": {

                    String keyword =
                            input.readText(
                                    "Enter nurse name: "
                            );

                    Object[] nurseResults =
                            nurseService.search(
                                    keyword
                            );

                    if (nurseResults.length == 0) {

                        System.out.println(
                                "No nurse found."
                        );

                    } else {

                        for (Object result
                                : nurseResults) {

                            Nurse foundNurse =
                                    (Nurse) result;

                            foundNurse.displayInfo();

                            System.out.println(
                                    "--------------------"
                            );
                        }
                    }

                    break;
                }

                case "4": {

                    String nurseId =
                            input.readText(
                                    "Enter nurse ID: "
                            );

                    nurseService.removeById(
                            nurseId
                    );

                    break;
                }

                case "5": {

                    String[] allowedShifts = {
                            "Morning",
                            "Evening",
                            "Night"
                    };

                    String shift =
                            input.readFromAllowedSet(
                                    "Enter shift: ",
                                    allowedShifts
                            );

                    Nurse[] shiftNurses =
                            nurseService
                                    .listByShift(
                                            shift
                                    );

                    if (shiftNurses.length == 0) {

                        System.out.println(
                                "No nurses found for this shift."
                        );

                    } else {

                        for (Nurse shiftNurse
                                : shiftNurses) {

                            shiftNurse.displayInfo();

                            System.out.println(
                                    "--------------------"
                            );
                        }
                    }

                    break;
                }

                case "6": {

                    String nurseId =
                            input.readText(
                                    "Enter nurse ID: "
                            );

                    String[] allowedShifts = {
                            "Morning",
                            "Evening",
                            "Night"
                    };

                    String newShift =
                            input.readFromAllowedSet(
                                    "Enter new shift: ",
                                    allowedShifts
                            );

                    nurseService.reassign(
                            nurseId,
                            newShift
                    );

                    break;
                }

                case "7": {

                    back = true;
                    break;
                }

                default: {

                    System.out.println(
                            "Invalid option."
                    );
                }
            }
        }
    }


    // =========================
    // Doctor Menu
    // =========================

    private void doctorMenu() {

        boolean back = false;

        while (!back) {

            System.out.println(
                    "\n===== DOCTOR MENU ====="
            );

            System.out.println("1. Add Doctor");
            System.out.println("2. View All Doctors");
            System.out.println("3. Search Doctor");
            System.out.println("4. Remove Doctor");
            System.out.println("5. Add Surgeon");
            System.out.println("6. Assign Patient");
            System.out.println("7. List By Specialization");
            System.out.println("8. Available Doctors");
            System.out.println("9. Back");

            String choice =
                    input.readText(
                            "Choose an option: "
                    );

            switch (choice) {

                case "1": {

                    String doctorId =
                            input.readText(
                                    "Enter doctor ID: "
                            );

                    String firstName =
                            input.readText(
                                    "Enter first name: "
                            );

                    String lastName =
                            input.readText(
                                    "Enter last name: "
                            );

                    String dateOfBirth =
                            input.readText(
                                    "Enter date of birth: "
                            );

                    String gender =
                            input.readText(
                                    "Enter gender: "
                            );

                    String phoneNumber =
                            input.readText(
                                    "Enter phone number: "
                            );

                    String email =
                            input.readEmail(
                                    "Enter email: "
                            );

                    String address =
                            input.readText(
                                    "Enter address: "
                            );

                    String nationalId =
                            input.readText(
                                    "Enter national ID: "
                            );

                    int age =
                            input.readIntInRange(
                                    "Enter age: ",
                                    0,
                                    120
                            );

                    boolean active =
                            input.readYesNo(
                                    "Active (yes/no): "
                            );

                    String specialization =
                            input.readText(
                                    "Enter specialization: "
                            );

                    int experienceYears =
                            input.readIntInRange(
                                    "Enter experience years: ",
                                    0,
                                    80
                            );

                    double consultationFee =
                            input.readDouble(
                                    "Enter consultation fee: "
                            );

                    boolean onCall =
                            input.readYesNo(
                                    "On call (yes/no): "
                            );

                    Doctor doctor =
                            new Doctor(
                                    doctorId,
                                    firstName,
                                    lastName,
                                    dateOfBirth,
                                    gender,
                                    phoneNumber,
                                    email,
                                    address,
                                    nationalId,
                                    age,
                                    active,
                                    new String[0],
                                    new String[0],
                                    consultationFee,
                                    experienceYears,
                                    onCall,
                                    specialization
                            );

                    doctorService.add(doctor);

                    System.out.println(
                            "Doctor added successfully."
                    );

                    break;
                }

                case "2": {

                    Object[] doctors =
                            doctorService.getAll();

                    if (doctors.length == 0) {

                        System.out.println(
                                "No doctors found."
                        );

                    } else {

                        for (Object doctorObject
                                : doctors) {

                            Doctor currentDoctor =
                                    (Doctor) doctorObject;

                            currentDoctor.displayInfo();

                            System.out.println(
                                    "--------------------"
                            );
                        }
                    }

                    break;
                }

                case "3": {

                    String keyword =
                            input.readText(
                                    "Enter doctor name or specialization: "
                            );

                    Object[] doctorResults =
                            doctorService.search(
                                    keyword
                            );

                    if (doctorResults.length == 0) {

                        System.out.println(
                                "No doctor found."
                        );

                    } else {

                        for (Object result
                                : doctorResults) {

                            Doctor foundDoctor =
                                    (Doctor) result;

                            foundDoctor.displayInfo();

                            System.out.println(
                                    "--------------------"
                            );
                        }
                    }

                    break;
                }

                case "4": {

                    String doctorId =
                            input.readText(
                                    "Enter doctor ID: "
                            );

                    doctorService.removeById(
                            doctorId
                    );

                    break;
                }

                case "5": {

                    String surgeonId =
                            input.readText(
                                    "Enter surgeon ID: "
                            );

                    String firstName =
                            input.readText(
                                    "Enter first name: "
                            );

                    String lastName =
                            input.readText(
                                    "Enter last name: "
                            );

                    String dateOfBirth =
                            input.readText(
                                    "Enter date of birth: "
                            );

                    String gender =
                            input.readText(
                                    "Enter gender: "
                            );

                    String phoneNumber =
                            input.readText(
                                    "Enter phone number: "
                            );

                    String email =
                            input.readEmail(
                                    "Enter email: "
                            );

                    String address =
                            input.readText(
                                    "Enter address: "
                            );

                    String nationalId =
                            input.readText(
                                    "Enter national ID: "
                            );

                    int age =
                            input.readIntInRange(
                                    "Enter age: ",
                                    0,
                                    120
                            );

                    boolean active =
                            input.readYesNo(
                                    "Active (yes/no): "
                            );

                    double consultationFee =
                            input.readDouble(
                                    "Enter consultation fee: "
                            );

                    int experienceYears =
                            input.readIntInRange(
                                    "Enter experience years: ",
                                    0,
                                    80
                            );

                    boolean onCall =
                            input.readYesNo(
                                    "On call (yes/no): "
                            );

                    String specialization =
                            input.readText(
                                    "Enter specialization: "
                            );

                    int surgeriesPerformed =
                            input.readIntInRange(
                                    "Enter surgeries performed: ",
                                    0,
                                    100000
                            );

                    boolean theatreAccess =
                            input.readYesNo(
                                    "Operation theatre access (yes/no): "
                            );

                    Surgeon surgeon =
                            new Surgeon(
                                    surgeonId,
                                    firstName,
                                    lastName,
                                    dateOfBirth,
                                    gender,
                                    phoneNumber,
                                    email,
                                    address,
                                    nationalId,
                                    age,
                                    active,
                                    new String[0],
                                    new String[0],
                                    consultationFee,
                                    experienceYears,
                                    onCall,
                                    specialization,
                                    surgeriesPerformed,
                                    theatreAccess,
                                    new String[0]
                            );

                    doctorService.addSurgeon(
                            surgeon
                    );

                    System.out.println(
                            "Surgeon added successfully."
                    );

                    break;
                }

                case "6": {

                    String doctorId =
                            input.readText(
                                    "Enter doctor ID: "
                            );

                    String patientId =
                            input.readText(
                                    "Enter patient ID: "
                            );

                    doctorService.assignPatient(
                            doctorId,
                            patientId
                    );

                    break;
                }

                case "7": {

                    String specialization =
                            input.readText(
                                    "Enter specialization: "
                            );

                    Doctor[] specializedDoctors =
                            doctorService
                                    .listBySpecialization(
                                            specialization
                                    );

                    if (specializedDoctors.length == 0) {

                        System.out.println(
                                "No doctors found for this specialization."
                        );

                    } else {

                        for (Doctor specializedDoctor
                                : specializedDoctors) {

                            specializedDoctor.displayInfo();

                            System.out.println(
                                    "--------------------"
                            );
                        }
                    }

                    break;
                }

                case "8": {

                    Doctor[] availableDoctors =
                            doctorService
                                    .availableDoctors();

                    if (availableDoctors.length == 0) {

                        System.out.println(
                                "No available doctors found."
                        );

                    } else {

                        for (Doctor availableDoctor
                                : availableDoctors) {

                            availableDoctor.displayInfo();

                            System.out.println(
                                    "--------------------"
                            );
                        }
                    }

                    break;
                }

                case "9": {

                    back = true;
                    break;
                }

                default: {

                    System.out.println(
                            "Invalid option."
                    );
                }
            }
        }
    }


    // =========================
    // Patient Menu
    // =========================

    public void patientMenu() {

        boolean back = false;

        while (!back) {

            System.out.println("\n===== PATIENT MENU =====");
            System.out.println("1. Add Patient");
            System.out.println("2. Add InPatient");
            System.out.println("3. View All Patients");
            System.out.println("4. Search Patient");
            System.out.println("5. Update Patient");
            System.out.println("6. Remove Patient");
            System.out.println("7. List InPatients");
            System.out.println("8. Total Outstanding");
            System.out.println("9. Back");

            String choice =
                    input.readText(
                            "Choose an option: "
                    );

            switch (choice) {

                case "1": {

                    String id =
                            input.readText(
                                    "Enter patient ID: "
                            );

                    String firstName =
                            input.readText(
                                    "Enter first name: "
                            );

                    String lastName =
                            input.readText(
                                    "Enter last name: "
                            );

                    String dateOfBirth =
                            input.readText(
                                    "Enter date of birth: "
                            );

                    String gender =
                            input.readText(
                                    "Enter gender: "
                            );

                    String phoneNumber =
                            input.readText(
                                    "Enter phone number: "
                            );

                    String email =
                            input.readEmail(
                                    "Enter email: "
                            );

                    String address =
                            input.readText(
                                    "Enter address: "
                            );

                    String nationalId =
                            input.readText(
                                    "Enter national ID: "
                            );

                    int age =
                            input.readIntInRange(
                                    "Enter age: ",
                                    0,
                                    120
                            );

                    boolean active =
                            input.readYesNo(
                                    "Active (yes/no): "
                            );

                    String bloodGroup =
                            input.readText(
                                    "Enter blood group: "
                            );

                    String emergencyContact =
                            input.readText(
                                    "Enter emergency contact: "
                            );

                    boolean insured =
                            input.readYesNo(
                                    "Insured (yes/no): "
                            );

                    double outstandingBalance =
                            input.readDouble(
                                    "Enter outstanding balance: "
                            );

                    String registrationDate =
                            input.readText(
                                    "Enter registration date: "
                            );


                    Patient patient =
                            new Patient(
                                    id,
                                    firstName,
                                    lastName,
                                    dateOfBirth,
                                    gender,
                                    phoneNumber,
                                    email,
                                    address,
                                    nationalId,
                                    age,
                                    active,
                                    new String[0],
                                    bloodGroup,
                                    emergencyContact,
                                    insured,
                                    new String[0],
                                    outstandingBalance,
                                    registrationDate
                            );

                    patientService.add(patient);

                    System.out.println(
                            "Patient added successfully."
                    );

                    break;
                }


                case "2": {

                    String id =
                            input.readText(
                                    "Enter patient ID: "
                            );

                    String firstName =
                            input.readText(
                                    "Enter first name: "
                            );

                    String lastName =
                            input.readText(
                                    "Enter last name: "
                            );

                    String dateOfBirth =
                            input.readText(
                                    "Enter date of birth: "
                            );

                    String gender =
                            input.readText(
                                    "Enter gender: "
                            );

                    String phoneNumber =
                            input.readText(
                                    "Enter phone number: "
                            );

                    String email =
                            input.readEmail(
                                    "Enter email: "
                            );

                    String address =
                            input.readText(
                                    "Enter address: "
                            );

                    String nationalId =
                            input.readText(
                                    "Enter national ID: "
                            );

                    int age =
                            input.readIntInRange(
                                    "Enter age: ",
                                    0,
                                    120
                            );

                    boolean active =
                            input.readYesNo(
                                    "Active (yes/no): "
                            );

                    String bloodGroup =
                            input.readText(
                                    "Enter blood group: "
                            );

                    String emergencyContact =
                            input.readText(
                                    "Enter emergency contact: "
                            );

                    boolean insured =
                            input.readYesNo(
                                    "Insured (yes/no): "
                            );

                    double outstandingBalance =
                            input.readDouble(
                                    "Enter outstanding balance: "
                            );

                    String registrationDate =
                            input.readText(
                                    "Enter registration date: "
                            );

                    String admissionDate =
                            input.readText(
                                    "Enter admission date: "
                            );

                    String roomNumber =
                            input.readText(
                                    "Enter room number: "
                            );

                    double dailyCharges =
                            input.readDouble(
                                    "Enter daily charges: "
                            );

                    int daysAdmitted =
                            input.readIntInRange(
                                    "Enter days admitted: ",
                                    0,
                                    3650
                            );


                    InPatient inPatient =
                            new InPatient(
                                    id,
                                    firstName,
                                    lastName,
                                    dateOfBirth,
                                    gender,
                                    phoneNumber,
                                    email,
                                    address,
                                    nationalId,
                                    age,
                                    active,
                                    new String[0],
                                    bloodGroup,
                                    emergencyContact,
                                    insured,
                                    new String[0],
                                    outstandingBalance,
                                    registrationDate,
                                    admissionDate,
                                    roomNumber,
                                    dailyCharges,
                                    daysAdmitted
                            );

                    patientService.add(inPatient);

                    System.out.println(
                            "InPatient added successfully."
                    );

                    break;
                }


                case "3": {

                    Object[] patients =
                            patientService.getAll();

                    if (patients.length == 0) {

                        System.out.println(
                                "No patients found."
                        );

                    } else {

                        for (Object patientObject : patients) {

                            Patient currentPatient =
                                    (Patient) patientObject;

                            currentPatient.displayInfo();

                            System.out.println(
                                    "--------------------"
                            );
                        }
                    }

                    break;
                }


                case "4": {

                    String keyword =
                            input.readText(
                                    "Enter patient name: "
                            );

                    Object[] searchResults =
                            patientService.search(
                                    keyword
                            );

                    if (searchResults.length == 0) {

                        System.out.println(
                                "No patient found."
                        );

                    } else {

                        for (Object result : searchResults) {

                            Patient foundPatient =
                                    (Patient) result;

                            foundPatient.displayInfo();

                            System.out.println(
                                    "--------------------"
                            );
                        }
                    }

                    break;
                }


                case "5": {

                    String updateId =
                            input.readText(
                                    "Enter patient ID: "
                            );

                    String newPhone =
                            input.readText(
                                    "Enter new phone number: "
                            );

                    String newEmail =
                            input.readEmail(
                                    "Enter new email: "
                            );

                    patientService.updateContact(
                            updateId,
                            newPhone,
                            newEmail
                    );

                    break;
                }


                case "6": {

                    String removeId =
                            input.readText(
                                    "Enter patient ID: "
                            );

                    patientService.removeById(
                            removeId
                    );

                    break;
                }


                case "7": {

                    InPatient[] inPatients =
                            patientService
                                    .listInPatients();

                    if (inPatients.length == 0) {

                        System.out.println(
                                "No InPatients found."
                        );

                    } else {

                        for (InPatient inPatient : inPatients) {

                            inPatient.displayInfo();

                            System.out.println(
                                    "--------------------"
                            );
                        }
                    }

                    break;
                }


                case "8": {

                    double totalOutstanding =
                            patientService
                                    .totalOutstanding();

                    System.out.println(
                            "Total Outstanding Balance: "
                                    + totalOutstanding
                    );

                    break;
                }


                case "9": {

                    back = true;
                    break;
                }


                default: {

                    System.out.println(
                            "Invalid option."
                    );
                }
            }
        }
    }}