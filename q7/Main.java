import java.util.Scanner;

class TelephoneIndex {
    private String[] names;
    private String[] phoneNumbers;

    public TelephoneIndex(String[] names, String[] phoneNumbers) {
        this.names = names;
        this.phoneNumbers = phoneNumbers;
    }
    public void displayMatchingNames(String searchName) {
        boolean found = false;
        for (int i = 0; i < names.length; i++) {
            if (names[i].toLowerCase().startsWith(searchName.toLowerCase())) {
                System.out.println(names[i] + ": " + phoneNumbers[i]);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No matching names found.");
        }
    }
    public void searchPhoneNumber(String searchName) {
        boolean found = false;
        for (int i = 0; i < names.length; i++) {
            if (names[i].equalsIgnoreCase(searchName)) {
                System.out.println("Phone number for " + names[i] + ": " + phoneNumbers[i]);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Name not found in the telephone index.");
        }
    }
}
public class Main {
    public static void main(String[] args) {
        String[] names = {"Bavan", "Sujigarasharma", "Kartik", "Sam"};
        String[] phoneNumbers = {"9344899955", "6382219010", "7664551600", "7733736300"};

        TelephoneIndex telephoneIndex = new TelephoneIndex(names, phoneNumbers);
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a name / first few characters of a name: ");
        String searchName = scanner.nextLine();

        System.out.println("Matching names & phone numbers:");
        telephoneIndex.displayMatchingNames(searchName);

        System.out.print("Enter the exact name to search for its phone number: ");
        searchName = scanner.nextLine();
        telephoneIndex.searchPhoneNumber(searchName);
    }
}
