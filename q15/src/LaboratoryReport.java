public class LaboratoryReport implements MedicalRecord {
    private String testName;
    public LaboratoryReport(String testName) {
        this.testName = testName;
    }
    public String getTestName() {
        return testName;
    }
    public void addRecord() {
        System.out.println("Laboratory report added");
    }
    public void deleteRecord() {
        System.out.println("Laboratory report deleted");
    }
    public void viewRecord() {
        System.out.println("Viewing laboratory report");
    }
}
