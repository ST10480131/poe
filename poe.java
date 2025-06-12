poe
package com.mycompany.login;

import java.util.Scanner;

/**public
 *
 * @author RC_Student_lab
 */
 class Login {
    public String checkUsername(String username) {
    if (username.length() <= 5 && username.contains("_")) {
        return "Username successfully captured.";
    } else {
        return "Username is not correctly formatted. Ensure it contains an underscore and is no more than 5 characters long.";
    }

    }
   public boolean checkPassword(String password) {
    if (password.length() >= 8 &&
        password.matches(".*[A-Z].*") &&
        password.matches(".*[a-z].*") &&
        password.matches(".*[0-9].*") &&
        password.matches(".*[@$%_].*")) {
        return true;
    } else {
        return false;
    }
   }
    public String checkCellPhoneNumber(String phoneNumber) {
    // Basic format: starts with '+' followed by digits, e.g. +1234567890
    if (phoneNumber.matches("^\\+\\d{8,}$")) {
        return "Cell phone number successfully added.";
    } else {
        return "Cell phone number incorrectly formatted or does not contain international code.";
    }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Login login = new Login();

        // Username
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.println(login.checkUsername(username));

        // Password
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        if (login.checkPassword(password)) {
            System.out.println("Password successfully captured.");
        } else {
            System.out.println("Password is not correctly formatted. Ensure it has at least 8 characters, one uppercase, one lowercase, one number, and one special character (@$%_).");
        }

        // Phone number
        System.out.print("Enter cell phone number (with international code): ");
        String phoneNumber = scanner.nextLine();
        System.out.println(login.checkCellPhoneNumber(phoneNumber));

        scanner.close();
    }
}