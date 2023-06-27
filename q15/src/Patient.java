public abstract class Patient {
    protected String patientName;
    protected int patientAge;
    protected String patientGender;
    protected String patientID;
    protected String patientAddress;
    public Patient(String patientName, int patientAge, String patientGender, String patientID, String patientAddress) {
        this.patientName = patientName;
        this.patientAge = patientAge;
        this.patientGender = patientGender;
        this.patientID = patientID;
        this.patientAddress = patientAddress;
    }
    public String getPatientName() {
        return patientName;
    }
    public int getPatientAge() {
        return patientAge;
    }
    public String getPatientGender() {
        return patientGender;
    }
    public String getPatientID() {
        return patientID;
    }
    public String getPatientAddress() {
        return patientAddress;
    }
    public abstract void addRecord();
    public abstract void deleteRecord();
    public abstract void viewRecord();
}
