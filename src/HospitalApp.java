import services.PatientService;
public class HospitalApp {

    public static void main(String[] args) {
        PatientService patientService = new PatientService();
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

    private void patientMenu() {
    }
}