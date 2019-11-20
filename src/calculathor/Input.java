/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculathor;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author angel
 */
public class Input {

    private Scanner scanner = new Scanner(System.in);

    public String readString(String message) {
        System.out.println(message);
        return this.scanner.nextLine();
    }

    public Integer readInteger(String message) {
        try {
            return this.scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("InputMismatchException: " + e.getMessage());
            return -1;
        }
    }

    public void close() {
        this.scanner.close();
    }

}
