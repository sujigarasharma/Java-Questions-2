public class Outpatient extends Patient {
    private String appointmentDate;
    public Outpatient(String patientName, int patientAge, String patientGender, String patientID, String patientAddress, String appointmentDate) {
        super(patientName, patientAge, patientGender, patientID, patientAddress);
        this.appointmentDate = appointmentDate;
    }
    public String getAppointmentDate() {
        return appointmentDate;
    }public void addRecord() {
        System.out.println("Medical record added for outpatient " + patientID);
    }
    public void deleteRecord() {
        System.out.println("Medical record deleted for outpatient " + patientID);
    }
    public void viewRecord() {
        System.out.println("Viewing medical record for outpatient " + patientID);
    }
}
