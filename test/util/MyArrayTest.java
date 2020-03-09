package util;

import model.Endereco;
import model.Usuario;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Teste da classe que auxilia no armazenamento de dados em um array que duplica 
 * automaticamente.
 * 
 * @author William Oliveira e Samuel Ramos.
 */
public class MyArrayTest {
    
    private MyArray a;
    private Usuario e;
    private Usuario e2;
    private Endereco d;
    
    @Before
    public void setUp() {
        a = new MyArray();
        d = new Endereco("1", "2", "3");
        e = new Usuario("a", "123", "1", "2", "3", d, "4");
        e2 = new Usuario("b", "123", "1", "2", "3", d, "4");
    }

    @Test
    public void testAdd() {
        assertTrue(a.isEmpty());
        a.add(e);
        assertFalse(a.isEmpty());
        assertEquals(1, a.size());
        a.add(e2);
        assertEquals(2, a.size());
    }

    @Test
    public void testGet() {
        a.add(e);
        a.add(e2);
        assertEquals(e, a.get(e));
        assertEquals(e2, a.get(e2));
    }

    @Test
    public void testContains() {
        a.add(e);
        assertFalse(a.contains(e2));
        a.add(e2);
        assertTrue(a.contains(e));
        assertTrue(a.contains(e2));
    }

    @Test
    public void testSize() {
        assertEquals(0, a.size());
        a.add(e);
        assertEquals(1, a.size());
        a.add(e2);
        assertEquals(2, a.size());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(a.isEmpty());
        a.add(e);
        assertFalse(a.isEmpty());
    }

    @Test
    public void testIterator() {
        a.add(e);
        a.add(e2);        
        Iterador it = a.iterator();        
        Usuario e3 = (Usuario) it.proximo();
        assertEquals(e, e3);
        e3 = (Usuario) it.proximo();
        assertEquals(e2, e3);
        assertFalse(it.temProximo());
    }
    
}
