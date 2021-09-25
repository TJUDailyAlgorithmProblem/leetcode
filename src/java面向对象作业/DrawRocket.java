//
// Introduction to Computer Programming with Java
// TIEI - Fall 2020
//
package java面向对象作业;

import java.util.*;

/**
 * A class for assignment #1
 */
public class DrawRocket {

    /**
     * The main program
     * (don't change it)
     */
    public static void main(String[] args) {
        int n = readInt();
        while (n > 0) {
            drawRocket(n);
            System.out.println();
            n = readInt();
        }
    }

    /**
     * Simple utility function to read
     * an integer from the user
     * (don't change it)
     */
    private static int readInt() {
        Scanner console = new Scanner(System.in);
        int n = 0;
        do {
            System.out.print("Enter the size (0 to exit);: ");
            n = console.nextInt();
        } while (n < 0);
        return n;
    }

    /**
     * The function which draws the rocket of size 'size'
     * (Complete it)
     */
    private static void drawRocket(int size) {

    }

    // define your own functions below
}
