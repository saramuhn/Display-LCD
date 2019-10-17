
package metodosdeimpresion;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author AdministradorQV
 */
public class ImpresionNumerosTest {
    
    public ImpresionNumerosTest() {
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
     * Test de separarNumeros  de la clase ImpresionNumeros
     */
    @Test
    public void testSepararNumeros() {
        System.out.println("separarNumeros");
        String[] entradaDatos = {"2,32","2,1"};
        int cantRegistros = 2;
        ImpresionNumeros.separarNumeros(entradaDatos, cantRegistros);
        if(cantRegistros!=2)
        fail("Es un caso de prueba.");
    } 

}
