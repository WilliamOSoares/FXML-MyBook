package model;

import java.util.Date;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Teste da classe postagem.
 * 
 * @author William Oliveira, Samuel Ramos.
 */
public class PostagemTest {
    
    Postagem p;
    
    @Before
    public void setUp() {
        p = new Postagem();
    }

    @Test
    public void testGetPostagem() {
        p.setPostagem("postado");
        assertEquals("postado", p.getPostagem());
    }

    @Test
    public void testSetPostagem() {
        assertEquals(null, p.getPostagem());
        p.setPostagem("postado");
        assertEquals("postado", p.getPostagem());
    }

    @Test
    public void testGetDescricao() {
        p.setDescricao("postei");
        assertEquals("postei", p.getDescricao());
    }

    @Test
    public void testSetDescricao() {
        assertEquals(null, p.getDescricao());
        p.setDescricao("postei");
        assertEquals("postei", p.getDescricao());
    }
    
}
