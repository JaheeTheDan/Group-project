import java.util.Scanner;

import OffenceInfo.OffenceInfo;
import OffenceInfo.OffenceInfoMap;

public class App {
    public static void main(String[] args) throws Exception {

        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

        Scanner inputScanner = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter username");

        String userName = inputScanner.nextLine();  // Read user input
        System.out.println("Username is: " + userName);  // Output user input
        inputScanner.close();
    }

    
}
