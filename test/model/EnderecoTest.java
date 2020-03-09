package model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Teste da classe endereco.
 * 
 * @author William Oliveira, Samuel Ramos.
 */
public class EnderecoTest {
    
    Endereco e;
    
    @Before
    public void setUp() {
        e = new Endereco("cidade", "estado", "pais");
    }

    @Test
    public void testGetCidade() {
        assertEquals("cidade", e.getCidade());
    }

    @Test
    public void testGetEstado() {
        assertEquals("estado", e.getEstado());
    }

    @Test
    public void testGetPais() {
        assertEquals("pais", e.getPais());
    }
    
}
