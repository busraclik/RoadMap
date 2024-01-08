import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.LinkedList;

import static org.junit.Assert.*;

public class RoadMapTest {
    private LinkedList<Town> testTownList;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        testTownList = new LinkedList<>();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void addSameTowns() {
        testTownList.add(new Town("Ankara",200.00));
        testTownList.add(new Town("Mersin", 300.00));
        testTownList.add(new Town("Istanbul", 400.00));

        // Test for duplicate city
        Main.addTowns1(testTownList, new Town("mersin", 300.0));
        assertEquals(3, testTownList.size());

        // Check the message for duplicate city
        String expectedMessage1 = "Duplicate city: mersin 300.0\n";
        assertEquals(expectedMessage1, outputStream.toString());
    }

    @Test
    public void checkListDistance(){
        Main.addTowns1(testTownList, new Town("Istanbul", 400.00));
        Main.addTowns1(testTownList, new Town("Ankara", 200.00));
        Main.addTowns1(testTownList, new Town("Mersin", 300.00));

        // Check if the towns are sorted by distance
        assertEquals("Ankara", testTownList.get(0).name());
        assertEquals("Mersin", testTownList.get(1).name());
        assertEquals("Istanbul", testTownList.get(2).name());

    }


}