package pl.javastart.task;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.javastart.task.TestUtils.createScannerWithGivenOutput;

class CoordinateSystemTest {
    private final PrintStream originalOut = System.out;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    private CoordinateSystem coordinateSystem = new CoordinateSystem();

    @Test
    void shouldDisplayPointData() {
        // given
        Scanner scanner = createScannerWithGivenOutput("1", "2");

        // when
        coordinateSystem.run(scanner);

        // then
        assertThat(outContent.toString()).contains("Punkt (1, 2)");
    }

    @Test
    void shouldBeIn1Quadrant() {
        // given
        Scanner scanner = createScannerWithGivenOutput("5", "3");

        // when
        coordinateSystem.run(scanner);

        // then
        assertThat(outContent.toString()).contains("Punkt (5, 3) leży w I ćwiartce układu współrzędnych");
    }

    @Test
    void shouldBeIn2Quadrant() {
        // given
        Scanner scanner = createScannerWithGivenOutput("-5", "3");

        // when
        coordinateSystem.run(scanner);

        // then
        assertThat(outContent.toString()).contains("Punkt (-5, 3) leży w II ćwiartce układu współrzędnych");
    }

    @Test
    void shouldBeIn3Quadrant() {
        // given
        Scanner scanner = createScannerWithGivenOutput("-5", "-3");

        // when
        coordinateSystem.run(scanner);

        // then
        assertThat(outContent.toString()).contains("Punkt (-5, -3) leży w III ćwiartce układu współrzędnych");
    }

    @Test
    void shouldBeIn4Quadrant() {
        // given
        Scanner scanner = createScannerWithGivenOutput("5", "-3");

        // when
        coordinateSystem.run(scanner);

        // then
        assertThat(outContent.toString()).contains("Punkt (5, -3) leży w IV ćwiartce układu współrzędnych");
    }

    @Test
    void shouldBeOnXAxis() {
        // given
        Scanner scanner = createScannerWithGivenOutput("-15", "0");

        // when
        coordinateSystem.run(scanner);

        // then
        assertThat(outContent.toString()).contains("Punkt (-15, 0) leży na osi X");
    }

    @Test
    void shouldBeOnXAxis2() {
        // given
        Scanner scanner = createScannerWithGivenOutput("15", "0");

        // when
        coordinateSystem.run(scanner);

        // then
        assertThat(outContent.toString()).contains("Punkt (15, 0) leży na osi X");
    }

    @Test
    void shouldBeOnYAxis() {
        // given
        Scanner scanner = createScannerWithGivenOutput("0", "15");

        // when
        coordinateSystem.run(scanner);

        // then
        assertThat(outContent.toString()).contains("Punkt (0, 15) leży na osi Y");
    }

    @Test
    void shouldBeOnYAxis2() {
        // given
        Scanner scanner = createScannerWithGivenOutput("0", "-15");

        // when
        coordinateSystem.run(scanner);

        // then
        assertThat(outContent.toString()).contains("Punkt (0, -15) leży na osi Y");
    }

    @Test
    void shouldBeInTheMiddle() {
        // given
        Scanner scanner = createScannerWithGivenOutput("0", "0");

        // when
        coordinateSystem.run(scanner);

        // then
        assertThat(outContent.toString()).contains("Punkt (0, 0) leży na środku układu współrzędnych");
    }


    @BeforeEach
    void init() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void cleanup() {
        System.setOut(originalOut);
    }
}