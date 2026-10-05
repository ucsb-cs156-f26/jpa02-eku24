package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }


    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void equals_detects_same_object() {
        assertEquals(team, team);
    }
    @Test
    public void equals_detects_different_class() {
        // team.equals(67) should be false
        assertEquals(false, team.equals(67));
    }
    @Test
    public void equals_correctly_compares_team() {
        // compare team with same name and members
        Team team2 = new Team("test-team");
        assertEquals(team, team2);
        
        // compare team with same name and different members
        Team team3 = new Team("test-team");
        team3.addMember("sus amogus");
        assertEquals(false, team.equals(team3));

        // compare team with different name
        Team team4 = new Team("sussy-team");
        assertEquals(false, team.equals(team4));
    }
    @Test
    public void hashcode_correct() {
        int result = team.hashCode();
        int expectedResult = -1226298695;
        assertEquals(expectedResult, result);
    }


}
