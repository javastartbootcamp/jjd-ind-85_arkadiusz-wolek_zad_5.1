package pl.javastart.task;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CoordinateSystem {

    // uzupełnij metodę. Używaj scannera przekazanego w parametrze.
    void run(Scanner scanner) {
        Point point = new Point();
        point.setX(getCoordinate("Podaj X", scanner));
        point.setY(getCoordinate("Podaj Y", scanner));
        //System.out.println("Punkt (5, -3)");
        showPosition(point);
    }

    int getCoordinate(String description, Scanner scanner) {
        System.out.println(description);
        boolean isNumberValid = false;
        int coordinate = 0;
        while (!isNumberValid) {
            try {
                coordinate = scanner.nextInt();
                isNumberValid = true;
            } catch (InputMismatchException exception) {
                System.out.println("Proszę podać prawidłową liczbę całkowitą");
                scanner.nextLine();
            }
        }
        return coordinate;
    }

    static void showPosition(Point point) {
        System.out.print("Punkt (" + point.getX() + ", " + point.getY() + ") leży ");
        String position;
        if (point.getX() == 0 && point.getY() == 0) {
            position = "na środku układu współrzędnych";
        } else if (point.getX() == 0) {
            position = "na osi Y";
        } else if (point.getY() == 0) {
            position = "na osi X";
        } else if (point.getX() > 0 && point.getY() > 0) {
            position = "w I";
        } else if (point.getX() < 0 && point.getY() > 0) {
            position = "w II";
        } else if (point.getX() < 0 && point.getY() < 0) {
            position = "w III";
        } else {
            position = "w IV";
        }
        if (position.length() <= 5) {
            position = position + " ćwiartce układu współrzędnych";
        }
        System.out.println(position);
    }
}
