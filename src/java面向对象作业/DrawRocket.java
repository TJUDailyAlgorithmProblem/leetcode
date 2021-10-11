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
            System.out.print("Enter the size (0 to exit): ");
            n = console.nextInt();
        } while (n < 0);
        return n;
    }

    /**
     * The function which draws the rocket of size 'size'
     * (Complete it)
     */
    private static void drawRocket(int size) {
        drawRocketHeadOrTail(size);
        separator(size);
        drawRocketArrowUp(size);
        drawRocketArrowDown(size);
        separator(size);
        drawRocketArrowDown(size);
        drawRocketArrowUp(size);
        separator(size);
        drawRocketHeadOrTail(size);
    }

    // define your own functions below
    /*draw “+=*=*=*=*=*=*+” */
    private static void separator(int size) {
        System.out.print('+');
        repeatString("=*", size * 2);
        System.out.println('+');
    }

    private static void repeatString(String s, int size) {
        for (int i = 0; i < size; i++) {
            System.out.print(s);
        }
    }

    /*draw “//**\\” */
    private static void drawRocketHeadOrTail(int size) {
        for (int i = 1; i <= 2 * size - 1; i++) {
            drawRocketHeadOrTailLine(size, i);
        }
    }

    private static void drawRocketHeadOrTailLine(int size, int slashes) {
        repeatString(" ", 2 * size - slashes);
        repeatString("/", slashes);
        repeatString("*", 2);
        repeatString("\\", slashes);
        System.out.println();
    }

    private static void drawRocketArrowUp(int size) {
        for (int i = size - 1; i >= 0; i--) {
            drawRocketArrowLine(size, i, "/\\");
        }
    }

    private static void drawRocketArrowDown(int size) {
        for (int i = 0; i <= size - 1; i++) {
            drawRocketArrowLine(size, i, "\\/");
        }
    }

    private static void drawRocketArrowLine(int size, int dots, String s) {
        System.out.print("|");
        for (int i = 0; i < 2; i++) {
            repeatString(".", dots);
            repeatString(s, size - dots);
            repeatString(".", dots);
        }
        System.out.println("|");
    }
}
