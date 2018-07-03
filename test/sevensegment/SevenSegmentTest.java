package sevensegment;

import java.util.Arrays;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ashu
 */
public class SevenSegmentTest {
    
    SevenSegment ss = new SevenSegment();
    
    char[][] one  ={{' ',' ',' '},{'|',' ',' '},{'|',' ',' '}};        
    char[][] four ={{' ',' ',' '},{'|','_','|'},{' ','|',' '}};
    char[][] five ={{' ','_',' '},{'|','_',' '},{' ','_','|'}};        
    char[][] seven={{' ','_',' '},{' ',' ','|'},{' ',' ','|'}};
    char[][] eight={{' ','_',' '},{'|','_','|'},{'|','_','|'}};
    char[][] invalid={{' ','_','_'},{'|','_','|'},{'|','_','|'}};
    
    String output1[] = {"0123456789","21113598014862","28698814663"};
    String output2[] = {"0123456789","2*113598014862","28698814663"};
    
    public SevenSegmentTest() {
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

    /**
     * Test of setDigit method, of class SevenSegment.
     */
    @Test
    public void testSetDigit(){
        assertEquals("Expected one.",ss.getDigit(one),'1');
        assertEquals("Expected one.",ss.getDigit(four),'4');
        assertEquals("Expected one.",ss.getDigit(five),'5');
        assertEquals("Expected one.",ss.getDigit(seven),'7');
        assertEquals("Expected one.",ss.getDigit(eight),'8');
        
        assertEquals("Expected one.",ss.getDigit(invalid),'*');
    }
    
    /**
     * Test of match method, of class SevenSegment.
     */
    @Test
    public void testMatch(){
        assertTrue(ss.match(one,one));
        assertTrue(ss.match(four,four));
        assertTrue(ss.match(five,five));
        assertTrue(ss.match(seven,seven));
        assertTrue(ss.match(eight,eight));     
    }
    
    /**
     * Test of convert method, of class SevenSegment.
     */
    @Test
    public void testCovert(){
             
        assertTrue(Arrays.equals(ss.convert("D:\\Audacy\\input1.txt"),output1));
        assertTrue(Arrays.equals(ss.convert("D:\\Audacy\\input2.txt"),output2));
    }
    
    /**
     * Test of main method, of class Runner.
     */
    @Test
    public void testMain() {
        
        System.out.println("main");
        String[] args = null;
        Runner.main(args);    
    }    
}
