package pl.javastart.task;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CoordinateSystem coordinateSystem = new CoordinateSystem();
        Scanner scanner = new Scanner(System.in);
        coordinateSystem.run(scanner);
    }

}
