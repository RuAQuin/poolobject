/**
 * 
 */
package ubu.gii.dass.c01;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Disabled;



/**
 * @authors Sandra Romero Núñez (srn1002@alu.ubu.es)
 *			Rodrigo Pascual Arnaiz (rpa1004@alu.ubu.es)
 *			Maksim Pitinov (mpx1019@alu.ubu.es)
 *			Rubén Alonso Quintana Rubén Alonso Quintana (raq1002@alu.ubu.es)
 *
 */
public class ReusablePoolTest {

	
	@BeforeAll
	public static void setUp(){
	}

	
	@AfterAll
	public static void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link ubu.gii.dass.c01.ReusablePool#getInstance()}.
	 */
        @Test
        @DisplayName("testGetInstance")
	public void testGetInstance() {
        //Creación de instance1
    	ReusablePool instance1 = ReusablePool.getInstance();
    	assertNotNull(instance1, "La instancia1 no es nula.");
    	
    	//Creación de instance2
    	ReusablePool instance2 = ReusablePool.getInstance();
    	assertNotNull(instance2, "La instancia2 no es nula.");
        	
    	//getInstance implementa el patrón singleton correctamente
    	assertSame(instance1, instance2, "Las dos instancias tienen el mismo objeto (Singleton)");
        			
	}      

	/**
	 * Test method for {@link ubu.gii.dass.c01.ReusablePool#acquireReusable()}.
	 */
	@Test
        @DisplayName("testAcquireReusable")
        @Disabled("Not implemented yet")

	public void testAcquireReusable() {
		
	}

	/**
	 * Test method for {@link ubu.gii.dass.c01.ReusablePool#releaseReusable(ubu.gii.dass.c01.Reusable)}.
	 */
	@Test
        @DisplayName("testReleaseReusable")
        @Disabled("Not implemented yet")
	public void testReleaseReusable() {
		
	}

}
