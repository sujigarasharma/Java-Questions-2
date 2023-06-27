import java.util.*;

class Recruitment implements Comparable<Recruitment> {
    private String name;
    private String qualification;
    private int experience;
    private String dob;
    private String gender;

    public Recruitment(String name, String qualification, int experience, String dob, String gender) {
        this.name = name;
        this.qualification = qualification;
        this.experience = experience;
        this.dob = dob;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public String getQualification() {
        return qualification;
    }

    public int getExperience() {
        return experience;
    }

    public String getDob() {
        return dob;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public int compareTo(Recruitment other) {
        if (this.experience != other.experience) {
            return Integer.compare(this.experience, other.experience);
        } else {
            return this.name.compareTo(other.name);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of candidates: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        List<Recruitment> candidates = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            System.out.println("Candidate " + (i + 1));
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Qualification: ");
            String qualification = scanner.nextLine();
            System.out.print("Experience (in years): ");
            int experience = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Date of Birth: ");
            String dob = scanner.nextLine();
            System.out.print("Gender: ");
            String gender = scanner.nextLine();

            Recruitment candidate = new Recruitment(name, qualification, experience, dob, gender);
            candidates.add(candidate);
        }

        Collections.sort(candidates);

        System.out.println("\nCandidates sorted by experience and name:");
        for (Recruitment candidate : candidates) {
            System.out.println("Name: " + candidate.getName());
            System.out.println("Qualification: " + candidate.getQualification());
            System.out.println("Experience: " + candidate.getExperience() + " years");
            System.out.println("Date of Birth: " + candidate.getDob());
            System.out.println("Gender: " + candidate.getGender());
            System.out.println();
        }
    }
}
