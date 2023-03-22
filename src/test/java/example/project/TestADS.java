package example.project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.*;

import example.project.domain.Scenario;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import java.io.PrintStream;
import java.io.ByteArrayOutputStream;

public class TestADS {

    @Test
    public void testPrintPath() {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        String path = "path";
        ADS ads = new ADS(path);

        ads.printPath();
        
        assertEquals(path, bos.toString().trim());

        System.setOut(originalOut);

        // fail();
        // delete the above line and implement this properly to test if ads.printPath() prints the ADSPath.
        // hint: see testHelloWorld() in our previous lab session.
    }

    @Test
    public void testPredict() {
        ADS ads = mock(); //new ADS("dummy");
        Scenario scenario = new Scenario("special scenario leading to the prediction of [0, 0]");
        when(ads.predict(scenario)).thenReturn(Arrays.asList(0,0));
        
        List<Object> prediction = ads.predict(scenario); // the prediction will be null since the ADS is dummy.
        assertEquals(Arrays.asList(0, 0), prediction);
        verify(ads, times(1)).predict(scenario); // verify if ads.predict(scenario) has been called only once
        verify(ads, times(0)).printPath(); // verify if ads.printPath() has been never called
    }

}