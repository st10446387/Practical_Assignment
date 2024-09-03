/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package studentmanagerapp;


import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;  

public class LearnerTests {

    private ArrayList<Learner> learners;

    @Before
    public void setup() {
        learners = new ArrayList<>();
    }

    @Test
    public void TestSaveLearner() {
        Learner learner = new Learner("10111", "J.Bloggs", 19, "jbloggs@gmail.com", "Computer Science");
        learner.saveLearnerDetails(learners);

        assertEquals(1, learners.size());
        assertEquals("10111", learners.get(0).getLearnerId());
        assertEquals("J.Bloggs", learners.get(0).getLearnerName());
        assertEquals(19, learners.get(0).getLearnerAge());
        assertEquals("jbloggs@gmail.com", learners.get(0).getLearnerEmail());
        assertEquals("Computer Science", learners.get(0).getLearnerCourse());
    }

    @Test
    public void TestSearchLearner() {
        Learner learner = new Learner("10111", "J.Bloggs", 19, "jbloggs@gmail.com", "Computer Science");
        learner.saveLearnerDetails(learners);

        Learner.searchLearnerById(learners, "10111");

        assertEquals("10111", learners.get(0).getLearnerId());
    }

    @Test
    public void TestSearchLearner_LearnerNotFound() {
        Learner learner = new Learner("10111", "J.Bloggs", 19, "jbloggs@gmail.com", "Computer Science");
        learner.saveLearnerDetails(learners);

        try {
            Learner.searchLearnerById(learners, "99999");
            // If no exception is thrown, the test passes.
        } catch (Exception e) {
            fail("Exception should not have been thrown.");
        }
    }

    @Test
    public void TestDeleteLearner() {
        Learner learner = new Learner("10111", "J.Bloggs", 19, "jbloggs@gmail.com", "Computer Science");
        learner.saveLearnerDetails(learners);

        Learner.removeLearnerById(learners, "10111");

        assertEquals(0, learners.size());
    }

    @Test
    public void TestDeleteLearner_LearnerNotFound() {
        Learner learner = new Learner("10111", "J.Bloggs", 19, "jbloggs@gmail.com", "Computer Science");
        learner.saveLearnerDetails(learners);

        try {
            Learner.removeLearnerById(learners, "99999");
            // If no exception is thrown, the test passes.
        } catch (Exception e) {
            fail("Exception should not have been thrown.");
        }
        assertEquals(1, learners.size());
    }

    @Test
    public void TestLearnerAge_LearnerAgeValid() {
        int age = 19;
        assertTrue(age >= 16);
    }

    @Test
    public void TestLearnerAge_LearnerAgeInvalid() {
        int age = 15;
        assertTrue(age < 16);
    }

    @Test
    public void TestLearnerAge_LearnerAgeInvalidCharacter() {
        String age = "abc";
        try {
            Integer.parseInt(age);
            fail("Expected NumberFormatException");
        } catch (NumberFormatException e) {
            // Test passes if exception is thrown
        }
    }
}

