import entities.Patient;
import services.PatientService;
import entities.InPatient;
import services.DoctorService;
public class HospitalApp {

    // Patient service available to all methods
    private PatientService patientService = new PatientService();
    private DoctorService doctorService = new DoctorService();

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
                    break;

                case "4":
                    break;

                case "5":
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
                        break;

                    case "2":
                        break;

                    case "3":
                        break;

                    case "4":
                        break;

                    case "5":
                        break;

                    case "6":
                        break;

                    case "7":
                        break;

                    case "8":
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