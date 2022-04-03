package test;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestJunit {
	
	
	 @BeforeEach                                         
	    void setUp() {
	        //do stuff
	    }
	 
	@Test
    void demoTestMethod() {
        assertTrue(true);
    }
}
