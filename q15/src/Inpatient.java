public class Inpatient extends Patient {
    private int bedNumber;
    public Inpatient(String patientName, int patientAge, String patientGender, String patientID, String patientAddress, int bedNumber) {
        super(patientName, patientAge, patientGender, patientID, patientAddress);
        this.bedNumber = bedNumber;
    }
    public int getBedNumber() {
        return bedNumber;
    }
    public void addRecord() {
        System.out.println("Medical record added for inpatient " + patientID);
    }
    public void deleteRecord() {
        System.out.println("Medical record deleted for inpatient " + patientID);
    }
    public void viewRecord() {
        System.out.println("Viewing medical record for inpatient " + patientID);
    }
}
