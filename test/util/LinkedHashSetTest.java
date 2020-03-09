package util;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Teste da classe LinkedHashSet.
 * @author William Oliveira Soares  e Samuel Ramos.
 */
public class LinkedHashSetTest {
    
    private LinkedHashSet hs;
    
    @Before
    public void setUp() {
        hs = new LinkedHashSet();
    }

    @Test
    public void testPut() {
        hs.put("primeiro");
        assertTrue(hs.contains("primeiro"));
    }

    @Test
    public void testContains() {
        hs.put("Segundo");
        assertTrue(hs.contains("Segundo"));
    }

    @Test
    public void testRemove() {
        hs.put("Terceiro");
        assertTrue(hs.contains("Terceiro"));
        hs.remove("Terceiro");
        assertFalse(hs.contains("Terceiro"));
    }

    @Test
    public void testIsEmpty() {
        assertTrue(hs.isEmpty());
        hs.put("Quarto");
        assertFalse(hs.isEmpty());
    }

    @Test
    public void testSize() {
        assertEquals(0, hs.size());
        hs.put("Quinto");
        assertEquals(1, hs.size());
        hs.put("Sexto");
        assertEquals(2, hs.size());
        hs.remove("Quinto");
        assertEquals(1, hs.size());
    }
    
    @Test
    public void testBasic() {
        int max = 1000;
        
        System.out.println("Adicionando " + max + " com a hashSet recem criada:\n");
        
        System.out.println("Está vazio? " + hs.isEmpty());
        // start time
        long startTime = System.currentTimeMillis(); 
        for (int i = 0; i < max; i++) {
            Integer x = i;
            hs.put(x.toString());
        }
        // end time
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("LinkedHashSet: " + duration + " ms"
                         + "\nQuantidade de dados no array: " + hs.size()
                         + "\nEstá vazio? " + hs.isEmpty());   
        
        System.out.println("\nRemovendo " + max + " da hashSet:\n");
        
        startTime = System.currentTimeMillis();
        for (int i = 0; i < max; i++) {
            Integer x = i;
            hs.remove(x.toString());
        }
        // end time
        endTime = System.currentTimeMillis();
        duration = endTime - startTime;
        System.out.println("LinkedHashSet: " + duration + " ms"
                         + "\nQuantidade de dados no array: " + hs.size()
                         + "\nEstá vazio? " + hs.isEmpty()); 
        
        System.out.println("\nAdicionando " + max + " com a hashSet ja criada:\n");
        
        startTime = System.currentTimeMillis();  
        for (int i = max; i < max*2; i++) {
            Integer x = i;
            hs.put(x.toString());
        }
        // end time
        endTime = System.currentTimeMillis();
        duration = endTime - startTime;
        System.out.println("LinkedHashSet: " + duration + "ms"
                         + "\nQuantidade de dados no array: " + hs.size()
                         + "\nEstá vazio? " + hs.isEmpty());   
    }
}
