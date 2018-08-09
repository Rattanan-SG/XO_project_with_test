/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BoardGame.Tests;

import BoardGame.Models.BoardXO;
import java.util.HashMap;
import javafx.print.Collation;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rei
 */
public class EntityTest {
    
    public EntityTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void checkCreateBoard(){
        BoardXO board = new BoardXO();
        String[][] expectBoard = new String [3][3];
        assertArrayEquals(expectBoard, board.getBoard());
    }
    
    @Test
    public void playerPlayXOCorrect(){
        String position = "R3_C1";
        
    }
    
    
}
