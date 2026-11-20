package ru.otavin.inputcheck;

import java.util.Scanner;

public final class InputCheck {
    Scanner sc = new Scanner(System.in, "Cp866");

    
    public int read_Int() {
        while (true) {
            try {
                return Integer.parseInt(sc.next());
            } catch (NumberFormatException e) {
                System.out.println("Error: not an integer.");
            }
        }
    }

    public long read_Long() {
        while (true) {
            try {
                return Long.parseLong(sc.next());
            } catch (NumberFormatException e) {
                System.out.println("Error: not a long integer.");
            }
        }
    }

    public String read_String() {
        return sc.hasNextLine() ? sc.nextLine().trim() : "";
    }

    public String read_wordString() {
        while (true) {
            if (!sc.hasNextLine()) return "";

            String s = sc.nextLine().trim();

            if (!s.isEmpty() && !s.equals("-")) {
                return s;
            }
        }
    }

    public char read_Char(){
        while (sc.hasNext()) {
            String first = sc.next();
            if (first.length() == 1) {
                return first.charAt(0);
            } else {
                System.out.println("Error: enter a single character");
            }
        }
        return ' ';
    }

    public char read_numChar(){
        while (sc.hasNext()) {
            String first = sc.next();
            if (first.length() == 1 && Character.isDigit(first.charAt(0))) {
                return first.charAt(0);
            } else {
                System.out.println("Error: enter a single digit character");
            }
        }
        return ' ';
    }

    public void clearConsole(){
		System.out.print("\033[H\033[J");
	}
}
