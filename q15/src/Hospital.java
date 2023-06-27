import java.util.ArrayList;
import java.util.List;
public class Hospital {
    private List<Patient> patients;
    public Hospital() {
        patients = new ArrayList<>();
    }
    public void admitPatient(Patient patient) {
        patients.add(patient);
        System.out.println("Patient admitted: " + patient.getPatientID());
    }
    public void dischargePatient(Patient patient) {
        patients.remove(patient);
        System.out.println("Patient discharged: " + patient.getPatientID());
    }
    public void displayPatients() {
        System.out.println("Patients in the hospital:");
        for (Patient patient : patients) {
            System.out.println(patient.getPatientID() + " - " + patient.getPatientName());
        }
    }
    public void displayMedicalRecords(Patient patient) {
        patient.viewRecord();
    }
    public List<Patient> getPatients() {
        return patients;
    }
}
