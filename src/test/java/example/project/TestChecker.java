package example.project;

import static org.junit.jupiter.api.Assertions.assertEquals;

import example.project.domain.Scenario;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*; 
import example.project.domain.SimulationResult;

public class TestChecker {

    @Test
    public void testCheckCollisionViolations()
    {
        // setup
        Simulator simulator = mock(); // new Simulator("dummy");
        Scenario scenario = new Scenario();
        SimulationResult simulationResult = new SimulationResult();
        when(simulator.run(scenario)).thenReturn(simulationResult);

        // testing target
        Checker checker = new Checker(simulator);
        boolean isCollision = checker.checkCollisionViolations(scenario); // this invokes a null pointer exception due to the dummy simulator
        assertEquals(false, isCollision);
    }

}