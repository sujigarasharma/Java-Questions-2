import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hospital hospital = new Hospital();

        int choice;
        do {
            System.out.println("Hospital Management System");
            System.out.println("1. Admit Patient");
            System.out.println("2. Discharge Patient");
            System.out.println("3. Display Patients");
            System.out.println("4. Add Medical Records");
            System.out.println("5. View Medical Records");
            System.out.println("6. Delete Medical Records");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter patient name: ");
                    String patientName = scanner.next();
                    System.out.print("Enter patient age: ");
                    int patientAge = scanner.nextInt();
                    System.out.print("Enter patient gender: ");
                    String patientGender = scanner.next();
                    System.out.print("Enter patient ID: ");
                    String patientID = scanner.next();
                    System.out.print("Enter patient address: ");
                    String patientAddress = scanner.next();
                    System.out.print("Enter bed number: ");
                    int bedNumber = scanner.nextInt();

                    Inpatient inpatient = new Inpatient(patientName, patientAge, patientGender, patientID, patientAddress, bedNumber);
                    hospital.admitPatient(inpatient);
                    break;

                case 2:
                    System.out.print("Enter patient ID to discharge: ");
                    String dischargePatientID = scanner.next();

                    Patient dischargePatient = null;
                    for (Patient patient : hospital.getPatients()) {
                        if (patient.getPatientID().equals(dischargePatientID)) {
                            dischargePatient = patient;
                            break;
                        }
                    }

                    if (dischargePatient != null) {
                        hospital.dischargePatient(dischargePatient);
                    } else {
                        System.out.println("Patient not found");
                    }
                    break;

                case 3:
                    hospital.displayPatients();
                    break;

                case 4:
                    System.out.print("Enter patient ID to add medical record: ");
                    String addRecordPatientID = scanner.next();

                    Patient addRecordPatient = null;
                    for (Patient patient : hospital.getPatients()) {
                        if (patient.getPatientID().equals(addRecordPatientID)) {
                            addRecordPatient = patient;
                            break;
                        }
                    }

                    if (addRecordPatient != null) {
                        addRecordPatient.addRecord();
                    } else {
                        System.out.println("Patient not found");
                    }
                    break;

                case 5:
                    System.out.print("Enter patient ID to view medical record: ");
                    String viewRecordPatientID = scanner.next();

                    Patient viewRecordPatient = null;
                    for (Patient patient : hospital.getPatients()) {
                        if (patient.getPatientID().equals(viewRecordPatientID)) {
                            viewRecordPatient = patient;
                            break;
                        }
                    }

                    if (viewRecordPatient != null) {
                        viewRecordPatient.viewRecord();
                    } else {
                        System.out.println("Patient not found");
                    }
                    break;

                case 6:
                    System.out.print("Enter patient ID to delete medical record: ");
                    String deleteRecordPatientID = scanner.next();

                    Patient deleteRecordPatient = null;
                    for (Patient patient : hospital.getPatients()) {
                        if (patient.getPatientID().equals(deleteRecordPatientID)) {
                            deleteRecordPatient = patient;
                            break;
                        }
                    }
                    if (deleteRecordPatient != null) {
                        deleteRecordPatient.deleteRecord();
                    } else {
                        System.out.println("Patient not found");
                    }
                    break;

                case 7:
                    System.out.println("Exit");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

            System.out.println();
        } while (choice != 7);

        scanner.close();
    }
}
