public class RadiologyImage implements MedicalRecord {
    private String imageType;
    public RadiologyImage(String imageType) {
        this.imageType = imageType;
    }
    public String getImageType() {
        return imageType;
    }
    public void addRecord() {
        System.out.println("Radiology image added");
    }
    public void deleteRecord() {
        System.out.println("Radiology image deleted");
    }
    public void viewRecord() {
        System.out.println("Viewing radiology image");
    }
}
