package util;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Teste da classe auxilia no armazenamento de dados.
 * 
 * @author William Oliveira, Samuel Ramos.
 */
public class EntradaTest {
    
    String a;
    String b;
    Entrada e;
    
    @Before
    public void setUp() {
        a = "e ae";
        b = "beleza";
        e = new Entrada(a,b);
    }

    @Test
    public void testGetKey() {
        assertEquals(a, e.getKey());
    }

    @Test
    public void testSetKey() {
        assertEquals(a, e.getKey());
        e.setKey(b);
        assertNotEquals(a, e.getKey());
        assertEquals(b, e.getKey());
    }

    @Test
    public void testGetValue() {
        assertEquals(b, e.getValue());
    }

    @Test
    public void testSetValue() {
        assertEquals(b, e.getValue());
        e.setValue(a);
        assertNotEquals(b, e.getValue());
        assertEquals(a, e.getValue());
    }

    @Test
    public void testEquals() {
        Entrada f = new Entrada(a,b);
        assertTrue(e.equals(f));
        f.setKey(b);
        f.setValue(a);
        assertFalse(e.equals(f));
    }
    
}
