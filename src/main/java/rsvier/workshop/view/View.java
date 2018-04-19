package rsvier.workshop.view;

import java.util.Scanner;

public class View {
    private static Scanner userInput = new Scanner(System.in);

    public static Integer getIntInput(){
        try {
            return Integer.parseInt(userInput.nextLine());
        } catch (NumberFormatException ex) {
            System.out.print("Wrong input, please enter a number: ");
            return getIntInput();
        }
    }

    public static String getStringInput() {
        String s = userInput.nextLine();

        if (s == null){
            System.out.print("Please enter a String: ");
            return getStringInput();
        } else {
            return s;
        }
    }

    public void askUserYesOrNo() {
        System.out.println("Please enter \"Y\" for Yes or \"N\" for No");
    }

    public void confirmExitProgram() {
        System.out.println("You are about to exit the program.");
    }
}