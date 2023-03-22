package example.project.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import java.lang.Math;

/**
 * A class defining the definition of a driving scenario, which is dependent on the domain/application.
 * This must be modified and updated with class Snapshot.
 */
public class Scenario {
    String roadType;
    String weatherCondition;
    List<Float> initEgoCarPos;  // (x, y)
    List<Float> initCarInFrontPos;  // (x, y)

    public Scenario() {
        roadType = null;
        weatherCondition = null;
        initEgoCarPos = null;
        initCarInFrontPos = null;
    }

    public Scenario(String scenarioDescription) {
        // parse scenarioDescription and save the result to the class attributes
        // not implemented
    }

    public float euclideanDistance() {
        double distance = Math.sqrt(Math.pow(initEgoCarPos.get(0)-initCarInFrontPos.get(0),2.0) + Math.pow(initEgoCarPos.get(1)-initCarInFrontPos.get(1),2.0));
    
        return (float) distance;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        Scenario scenario = (Scenario) obj;
        return roadType.equals(scenario.roadType)
            && weatherCondition.equals(scenario.weatherCondition)
            && Math.abs(euclideanDistance() - scenario.euclideanDistance()) < 0.5;
        
        // Let's define our equality as follows:
        // (1) roadType and weatherCondition must be the same.
        // (2) If Euclidean distance between the egoCar and car-in-front is less than 0.05, then they are equal in terms of car positions.
    }

    // For testing whether distance calculations are correct
    public static void main(String[] args) {
        Scenario scenario = new Scenario();
        scenario.initEgoCarPos = Arrays.asList(0F, 0F);
        scenario.initCarInFrontPos = Arrays.asList(0.5F, 0.5F);

        float distance = scenario.euclideanDistance();

        System.out.println(distance);
    }
}
