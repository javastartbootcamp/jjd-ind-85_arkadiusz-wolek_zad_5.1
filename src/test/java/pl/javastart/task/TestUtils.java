package pl.javastart.task;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class TestUtils {

    static Scanner createScannerWithGivenOutput(String... lines) {
        String input = String.join("\r\n", lines);
        input += "\r\n";

        ByteArrayInputStream testIn = new ByteArrayInputStream(input.getBytes());
        return new Scanner(testIn);
    }
}
