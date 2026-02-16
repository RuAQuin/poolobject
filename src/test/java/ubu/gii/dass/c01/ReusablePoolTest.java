/**
 * 
 */
package ubu.gii.dass.c01;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;



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
	 * @throws NotFreeInstanceException 
	 */
	@Test
        @DisplayName("testAcquireReusable")

	public void testAcquireReusable() throws NotFreeInstanceException {
		//Creación de la instancia
		ReusablePool instance = ReusablePool.getInstance();
    	assertNotNull(instance, "La instancia no es nula.");
		
		//Creación del primer Reusable
		Reusable reusable1 = instance.acquireReusable();
		assertNotNull(reusable1, "El primer Reusable no debe ser nulo.");
		
		//Creación del segundo Reusable
		Reusable reusable2 = instance.acquireReusable();
		assertNotNull(reusable2, "El segundo Reusable no debe ser nulo.");
		
		//Verificación de que los objetos Reusables son diferentes
		assertNotSame(reusable1, reusable2, "Los Reusable deben ser instancias diferentes");
		
	}

	/**
	 * Test method for {@link ubu.gii.dass.c01.ReusablePool#releaseReusable(ubu.gii.dass.c01.Reusable)}.
	 * @throws NotFreeInstanceException 
	 */
	@Test
        @DisplayName("testReleaseReusable")
	public void testReleaseReusable() throws NotFreeInstanceException {
		//Creación de la instancia
		ReusablePool instance = ReusablePool.getInstance();
    	assertNotNull(instance, "La instancia no es nula.");
		
		//Creación del Reusable
		Reusable reusable = instance.acquireReusable();
		assertNotNull(reusable, "El primer Reusable no debe ser nulo.");
		
		//Se libera un objeto reusable del pool.
		assertDoesNotThrow(() -> {
			instance.releaseReusable(reusable);
		}, "Se debe liberar el objeto sin lanzar ninguna excepción.");
		
	}

	/**
     * Test para comprobar que salta la excepción al pedir más objetos de los que hay
     */
    @Test
    	@DisplayName("testReusableThrowsNotFreeInstanceException")
    public void testReusableThrowsNotFreeInstanceException() {
		ReusablePool instance = ReusablePool.getInstance();
        List<Reusable> objetosAdquiridos = new ArrayList<>();
        
        try {
            // Intentamos obtener objetos hasta agotar el pool y los guardamos en la lista
            assertThrows(NotFreeInstanceException.class, () -> {
                while (true) {
                    objetosAdquiridos.add(instance.acquireReusable());
                }
            }, "Debe lanzar NotFreeInstanceException cuando ya no quedan instancias en el pool");
            
        } finally {
            // Pase lo que pase, devolvemos todos los objetos al pool para no romper otros tests
            for (Reusable r : objetosAdquiridos) {
                try {
                    instance.releaseReusable(r);
                } catch (Exception e) {
                    // Ignorar si falla 
                }
            }
        }
    }

}
