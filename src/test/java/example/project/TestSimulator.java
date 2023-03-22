package example.project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import example.project.domain.Scenario;
import org.junit.jupiter.api.Test;

public class TestSimulator {

    @Test
    public void testRun() {
        Simulator simulator = new Simulator("dummy");
        Scenario scenario = new Scenario();
        assertEquals(null, simulator.run(scenario));
    }

    @Test
    public void testRun2() {
        
        Simulator simulator = new Simulator("dummy");
        Scenario scenario = new Scenario();
        ADS ads = new ADS("dummy");

        assertEquals(null, simulator.run(scenario,ads));
        
        // fail();
        // remove the above line and
        // complete a test case that calls `simulator.run(scenario, ads)` and verify if the result is null.
    }
}
