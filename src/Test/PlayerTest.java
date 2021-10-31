package Test;


import model.Player;
import org.junit.Test;

import static org.junit.Assert.*;


public class PlayerTest {
    //getters
    public Player setupStage1(){
        return new Player("Sebastian", 19, "Lakers", 1, 40, 40, 20, 10);

    }



    public Player setupStage2(){
        return new Player();
    }


    @Test
    public void gettersTest(){
        Player pl = setupStage1();
        assertEquals("Sebastian", pl.getName());
        assertEquals(19, pl.getAge());
        assertEquals("Lakers", pl.getTeam());
        assertEquals(1, pl.getPointMatch());
        assertEquals(40, pl.getReboundsGame());
        assertEquals(40, pl.getAssistsGame());
        assertEquals(20, pl.getStealGame());
        assertEquals(10, pl.getBlockGame());
    }

    @Test
    public void setterTest(){
        Player pl = setupStage2();
        pl.setName("Sebastian");
        assertEquals("Sebastian", pl.getName());

        pl.setAge(19);
        assertEquals(19, pl.getAge());

        pl.setTeam("Lakers");
        assertEquals("Lakers", pl.getTeam());

        pl.setPointMatch(1);
        assertEquals(1, pl.getPointMatch());

        pl.setReboundsGame(40);
        assertEquals(40, pl.getReboundsGame());

        pl.setAssistsGame(40);
        assertEquals(40, pl.getAssistsGame());

        pl.setStealGame(20);
        assertEquals(20, pl.getStealGame());

        pl.setBlockGame(10);
        assertEquals(10, pl.getBlockGame());

    }
}
