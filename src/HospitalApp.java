import entities.*;
import services.*;

public class HospitalApp {

    // Patient service available to all methods
    private PatientService patientService = new PatientService();
    private DoctorService doctorService = new DoctorService();
    private NurseService nurseService = new NurseService();
    private AppointmentService appointmentService = new AppointmentService();
    private RecordService recordService = new RecordService();

    public static void main(String[] args) {

        HospitalApp app = new HospitalApp();
        app.run();
    }

    // Start the hospital system
    public void run() {

        boolean running = true;

        while (running) {

            System.out.println("\n===== HOSPITAL MANAGEMENT SYSTEM =====");
            System.out.println("1. Patients");
            System.out.println("2. Doctors");
            System.out.println("3. Nurses");
            System.out.println("4. Appointments");
            System.out.println("5. Medical Records");
            System.out.println("6. Reports");
            System.out.println("7. Exit");

            String choice = IO.readln("Choose an option: ");

            switch (choice) {

                case "1":
                    patientMenu();
                    break;
                case "2":
                    doctorMenu();
                    break;

                case "3":
                    nurseMenu();
                    break;

                case "4":
                    appointmentMenu();
                    break;
                case "5":
                    recordMenu();
                    break;
                case "6":
                    break;

                case "7":
                    running = false;
                    System.out.println("Exiting Hospital Management System.");
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private void recordMenu() {

        boolean back = false;

        while (!back) {

            System.out.println("\n===== MEDICAL RECORD MENU =====");
            System.out.println("1. Add Medical Record");
            System.out.println("2. View All Medical Records");
            System.out.println("3. Search Medical Record");
            System.out.println("4. Remove Medical Record");
            System.out.println("5. List By Patient");
            System.out.println("6. Count Confidential Records");
            System.out.println("7. Back");

            String choice = IO.readln("Choose an option: ");

            switch (choice) {

                case "1":

                    String recordId =
                            IO.readln("Enter record ID: ");

                    String patientId =
                            IO.readln("Enter patient ID: ");

                    String doctorId =
                            IO.readln("Enter doctor ID: ");

                    String visitDate =
                            IO.readln("Enter visit date: ");

                    String diagnosis =
                            IO.readln("Enter diagnosis: ");

                    String prescription =
                            IO.readln("Enter prescription: ");

                    String notes =
                            IO.readln("Enter notes: ");

                    boolean confidential = Boolean.parseBoolean(
                            IO.readln("Confidential (true/false): ")
                    );

                    MedicalRecord record = new MedicalRecord(
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

                    System.out.println("Medical record added successfully.");

                    break;

                case "2":

                    Object[] records = recordService.getAll();

                    if (records.length == 0) {

                        System.out.println("No medical records found.");

                    } else {

                        for (Object recordObject : records) {

                            MedicalRecord currentRecord =
                                    (MedicalRecord) recordObject;

                            currentRecord.displayInfo();

                            System.out.println("--------------------");
                        }
                    }

                    break;

                case "3":

                    String keyword =
                            IO.readln("Enter diagnosis or prescription: ");

                    Object[] recordResults =
                            recordService.search(keyword);

                    if (recordResults.length == 0) {

                        System.out.println("No medical records found.");

                    } else {

                        for (Object result : recordResults) {

                            MedicalRecord foundRecord =
                                    (MedicalRecord) result;

                            foundRecord.displayInfo();

                            System.out.println("--------------------");
                        }
                    }

                    break;

                case "4":

                    String removeRecordId =
                            IO.readln("Enter record ID: ");

                    recordService.removeById(removeRecordId);

                    System.out.println("Medical record removed.");

                    break;

                case "5":

                    String patientId =
                            IO.readln("Enter patient ID: ");

                    MedicalRecord[] patientRecords =
                            recordService.listByPatient(patientId);

                    if (patientRecords.length == 0) {

                        System.out.println("No medical records found for this patient.");

                    } else {

                        for (MedicalRecord patientRecord : patientRecords) {

                            patientRecord.displayInfo();
                            System.out.println("--------------------");
                        }
                    }

                    break;

                case "6":
                    break;

                case "7":
                    back = true;
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private void appointmentMenu() {

        boolean back = false;

        while (!back) {

            System.out.println("\n===== APPOINTMENT MENU =====");
            System.out.println("1. Schedule Appointment");
            System.out.println("2. Cancel Appointment");
            System.out.println("3. Complete Appointment");
            System.out.println("4. Reschedule Appointment");
            System.out.println("5. List By Status");
            System.out.println("6. List By Patient");
            System.out.println("7. Back");

            String choice = IO.readln("Choose an option: ");

            switch (choice) {

                case "1":

                    String patientId = IO.readln("Enter patient ID: ");
                    String doctorId = IO.readln("Enter doctor ID: ");
                    String date = IO.readln("Enter appointment date: ");
                    String time = IO.readln("Enter appointment time: ");

                    appointmentService.schedule(
                            patientId,
                            doctorId,
                            date,
                            time
                    );

                    System.out.println("Appointment scheduled successfully.");

                    break;
                case "2":

                    String appointmentId =
                            IO.readln("Enter appointment ID: ");

                    appointmentService.cancel(appointmentId);

                    System.out.println("Appointment cancelled.");

                    break;
                case "3":

                    String completeAppointmentId =
                            IO.readln("Enter appointment ID: ");

                    appointmentService.complete(completeAppointmentId);

                    System.out.println("Appointment completed.");

                    break;

                case "4":

                    String rescheduleId =
                            IO.readln("Enter appointment ID: ");

                    String newDate =
                            IO.readln("Enter new appointment date: ");

                    String newTime =
                            IO.readln("Enter new appointment time: ");

                    appointmentService.reschedule(
                            rescheduleId,
                            newDate,
                            newTime
                    );

                    System.out.println("Appointment rescheduled successfully.");

                    break;

                case "5":

                    String status =
                            IO.readln("Enter appointment status: ");

                    Appointment[] statusAppointments =
                            appointmentService.listByStatus(status);

                    if (statusAppointments.length == 0) {

                        System.out.println("No appointments found with this status.");

                    } else {

                        for (Appointment statusAppointment : statusAppointments) {

                            statusAppointment.displayInfo();
                            System.out.println("--------------------");
                        }
                    }

                    break;

                case "6":

                            patientId =
                            IO.readln("Enter patient ID: ");

                    Appointment[] patientAppointments =
                            appointmentService.listByPatient(patientId);

                    if (patientAppointments.length == 0) {

                        System.out.println("No appointments found for this patient.");

                    } else {

                        for (Appointment patientAppointment : patientAppointments) {

                            patientAppointment.displayInfo();
                            System.out.println("--------------------");
                        }
                    }

                    break;
                case "7":
                    back = true;
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }
    private void nurseMenu() {

        boolean back = false;

        while (!back) {

            System.out.println("\n===== NURSE MENU =====");
            System.out.println("1. Add Nurse");
            System.out.println("2. View All Nurses");
            System.out.println("3. Search Nurse");
            System.out.println("4. Remove Nurse");
            System.out.println("5. List By Shift");
            System.out.println("6. Reassign Nurse");
            System.out.println("7. Back");

            String choice = IO.readln("Choose an option: ");

            switch (choice) {

                case "1":

                    String nurseId = IO.readln("Enter nurse ID: ");
                    String firstName = IO.readln("Enter first name: ");
                    String lastName = IO.readln("Enter last name: ");
                    String dateOfBirth = IO.readln("Enter date of birth: ");
                    String gender = IO.readln("Enter gender: ");
                    String phoneNumber = IO.readln("Enter phone number: ");
                    String email = IO.readln("Enter email: ");
                    String address = IO.readln("Enter address: ");
                    String nationalId = IO.readln("Enter national ID: ");

                    int age = Integer.parseInt(
                            IO.readln("Enter age: ")
                    );

                    boolean active = Boolean.parseBoolean(
                            IO.readln("Active (true/false): ")
                    );

                    String departmentId = IO.readln("Enter department ID: ");
                    String shift = IO.readln("Enter shift: ");

                    int yearsOfService = Integer.parseInt(
                            IO.readln("Enter years of service: ")
                    );

                    Nurse nurse = new Nurse(
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

                    System.out.println("Nurse added successfully.");

                    break;

                case "2":

                    Object[] nurses = nurseService.getAll();

                    if (nurses.length == 0) {

                        System.out.println("No nurses found.");

                    } else {

                        for (Object nurseObject : nurses) {

                            Nurse currentNurse = (Nurse) nurseObject;

                            currentNurse.displayInfo();
                            System.out.println("--------------------");
                        }
                    }

                    break;

                case "3":

                    String keyword = IO.readln("Enter nurse name: ");

                    Object[] nurseResults = nurseService.search(keyword);

                    if (nurseResults.length == 0) {

                        System.out.println("No nurse found.");

                    } else {

                        for (Object result : nurseResults) {

                            Nurse foundNurse = (Nurse) result;

                            foundNurse.displayInfo();
                            System.out.println("--------------------");
                        }
                    }

                    break;
                case "4":

                    nurseId = IO.readln("Enter nurse ID: ");

                    nurseService.removeById(nurseId);

                    System.out.println("Nurse removed.");

                    break;

                case "5":

                    shift = IO.readln("Enter shift: ");

                    Nurse[] shiftNurses = nurseService.listByShift(shift);

                    if (shiftNurses.length == 0) {

                        System.out.println("No nurses found for this shift.");

                    } else {

                        for (Nurse shiftNurse : shiftNurses) {

                            shiftNurse.displayInfo();
                            System.out.println("--------------------");
                        }
                    }

                    break;

                case "6":

                    nurseId = IO.readln("Enter nurse ID: ");
                    String newShift = IO.readln("Enter new shift: ");

                    nurseService.reassign(
                            nurseId,
                            newShift
                    );

                    System.out.println("Nurse reassigned.");

                    break;

                case "7":
                    back = true;
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private void doctorMenu() {

            boolean back = false;

            while (!back) {

                System.out.println("\n===== DOCTOR MENU =====");
                System.out.println("1. Add Doctor");
                System.out.println("2. View All Doctors");
                System.out.println("3. Search Doctor");
                System.out.println("4. Remove Doctor");
                System.out.println("5. Add Surgeon");
                System.out.println("6. Assign Patient");
                System.out.println("7. List By Specialization");
                System.out.println("8. Available Doctors");
                System.out.println("9. Back");

                String choice = IO.readln("Choose an option: ");

                switch (choice) {

                    case "1":

                        String doctorId = IO.readln("Enter doctor ID: ");
                        String firstName = IO.readln("Enter first name: ");
                        String lastName = IO.readln("Enter last name: ");
                        String dateOfBirth = IO.readln("Enter date of birth: ");
                        String gender = IO.readln("Enter gender: ");
                        String phoneNumber = IO.readln("Enter phone number: ");
                        String email = IO.readln("Enter email: ");
                        String address = IO.readln("Enter address: ");
                        String nationalId = IO.readln("Enter national ID: ");

                        int age = Integer.parseInt(
                                IO.readln("Enter age: ")
                        );

                        boolean active = Boolean.parseBoolean(
                                IO.readln("Active (true/false): ")
                        );

                        String specialization =
                                IO.readln("Enter specialization: ");

                        int experienceYears = Integer.parseInt(
                                IO.readln("Enter experience years: ")
                        );

                        double consultationFee = Double.parseDouble(
                                IO.readln("Enter consultation fee: ")
                        );

                        boolean onCall = Boolean.parseBoolean(
                                IO.readln("On call (true/false): ")
                        );

                        Doctor doctor = new Doctor(
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

                        System.out.println("Doctor added successfully.");

                        break;

                    case "2":

                        Object[] doctors = doctorService.getAll();

                        if (doctors.length == 0) {

                            System.out.println("No doctors found.");

                        } else {

                            for (Object doctorObject : doctors) {

                                Doctor currentDoctor = (Doctor) doctorObject;

                                currentDoctor.displayInfo();
                                System.out.println("--------------------");
                            }
                        }

                        break;

                    case "3":

                        String keyword = IO.readln("Enter doctor name or specialization: ");

                        Object[] doctorResults = doctorService.search(keyword);

                        if (doctorResults.length == 0) {

                            System.out.println("No doctor found.");

                        } else {

                            for (Object result : doctorResults) {

                                Doctor foundDoctor = (Doctor) result;

                                foundDoctor.displayInfo();
                                System.out.println("--------------------");
                            }
                        }

                        break;

                    case "4":

                         doctorId = IO.readln("Enter doctor ID: ");

                        doctorService.removeById(doctorId);

                        System.out.println("Doctor removed.");

                        break;

                    case "5":

                        String surgeonId = IO.readln("Enter surgeon ID: ");
                         firstName = IO.readln("Enter first name: ");
                         lastName = IO.readln("Enter last name: ");
                         dateOfBirth = IO.readln("Enter date of birth: ");
                         gender = IO.readln("Enter gender: ");
                         phoneNumber = IO.readln("Enter phone number: ");
                         email = IO.readln("Enter email: ");
                         address = IO.readln("Enter address: ");
                         nationalId = IO.readln("Enter national ID: ");

                         age = Integer.parseInt(
                                IO.readln("Enter age: ")
                        );

                         active = Boolean.parseBoolean(
                                IO.readln("Active (true/false): ")
                        );

                         consultationFee = Double.parseDouble(
                                IO.readln("Enter consultation fee: ")
                        );

                        experienceYears = Integer.parseInt(
                                IO.readln("Enter experience years: ")
                        );

                         onCall = Boolean.parseBoolean(
                                IO.readln("On call (true/false): ")
                        );

                         specialization =
                                IO.readln("Enter specialization: ");

                        int surgeriesPerformed = Integer.parseInt(
                                IO.readln("Enter surgeries performed: ")
                        );

                        boolean theatreAccess = Boolean.parseBoolean(
                                IO.readln("Operation theatre access (true/false): ")
                        );

                        Surgeon surgeon = new Surgeon(
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

                        doctorService.addSurgeon(surgeon);

                        System.out.println("Surgeon added successfully.");

                        break;

                    case "6":

                        doctorId = IO.readln("Enter doctor ID: ");
                        String patientId = IO.readln("Enter patient ID: ");

                        doctorService.assignPatient(
                                doctorId,
                                patientId
                        );

                        System.out.println("Patient assigned to doctor.");

                        break;

                    case "7":

                         specialization =
                                IO.readln("Enter specialization: ");

                        Doctor[] specializedDoctors =
                                doctorService.listBySpecialization(specialization);

                        if (specializedDoctors.length == 0) {

                            System.out.println(
                                    "No doctors found for this specialization."
                            );

                        } else {

                            for (Doctor specializedDoctor : specializedDoctors) {

                                specializedDoctor.displayInfo();
                                System.out.println("--------------------");
                            }
                        }

                        break;

                    case "8":

                        Doctor[] availableDoctors =
                                doctorService.availableDoctors();

                        if (availableDoctors.length == 0) {

                            System.out.println("No available doctors found.");

                        } else {

                            for (Doctor availableDoctor : availableDoctors) {

                                availableDoctor.displayInfo();
                                System.out.println("--------------------");
                            }
                        }

                        break;
                    case "9":
                        back = true;
                        break;

                    default:
                        System.out.println("Invalid option.");
                }
            }
        }


    // Patient menu
    public void patientMenu() {

        boolean back = false;

        while (!back) {

            System.out.println("\n===== PATIENT MENU =====");
            System.out.println("1. Add Patient");
            System.out.println("2. View All Patients");
            System.out.println("3. Search Patient");
            System.out.println("4. Update Patient");
            System.out.println("5. Remove Patient");
            System.out.println("6. List InPatients");
            System.out.println("7. Total Outstanding");
            System.out.println("8. Back");

            String choice = IO.readln("Choose an option: ");

            switch (choice) {

                case "1":

                    String id = IO.readln("Enter patient ID: ");
                    String firstName = IO.readln("Enter first name: ");
                    String lastName = IO.readln("Enter last name: ");

                    Patient patient = new Patient(
                            id,
                            firstName,
                            lastName
                    );

                    patientService.add(patient);

                    System.out.println("Patient added successfully.");

                    break;

                case "2":

                    Object[] patients = patientService.getAll();

                    if (patients.length == 0) {
                        System.out.println("No patients found.");
                    } else {

                        for (Object patientObject : patients) {

                            Patient currentPatient = (Patient) patientObject;
                            currentPatient.displayInfo();
                            System.out.println("--------------------");
                        }
                    }

                    break;

                case "3":

                    String keyword = IO.readln("Enter patient name: ");

                    Object[] searchResults = patientService.search(keyword);

                    if (searchResults.length == 0) {

                        System.out.println("No patient found.");

                    } else {

                        for (Object result : searchResults) {

                            Patient foundPatient = (Patient) result;

                            foundPatient.displayInfo();
                            System.out.println("--------------------");
                        }
                    }

                    break;

                case "4":

                    String updateId = IO.readln("Enter patient ID: ");
                    String newPhone = IO.readln("Enter new phone number: ");
                    String newEmail = IO.readln("Enter new email: ");

                    patientService.updateContact(
                            updateId,
                            newPhone,
                            newEmail
                    );

                    break;
                case "5":

                    String removeId = IO.readln("Enter patient ID: ");

                    patientService.removeById(removeId);

                    System.out.println("Patient removed.");

                    break;

                case "6":

                    InPatient[] inPatients = patientService.listInPatients();

                    if (inPatients.length == 0) {
                        System.out.println("No InPatients found.");
                    } else {

                        for (InPatient inPatient : inPatients) {
                            inPatient.displayInfo();
                            System.out.println("--------------------");
                        }
                    }

                    break;

                case "7":

                    double totalOutstanding = patientService.totalOutstanding();

                    System.out.println(
                            "Total Outstanding Balance: " + totalOutstanding
                    );

                    break;

                case "8":
                    back = true;
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}