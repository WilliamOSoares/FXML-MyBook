package util;

import model.Endereco;
import model.Usuario;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Teste da classe responsável pelo o banco de dados que efetua a busca mais rápida.
 * 
 * @author William Oliveira, Samuel Ramos.
 */
public class TabelaHashTest {
        
    TabelaHash tab;
    Usuario a;
    Usuario b;
    Usuario c;
    Endereco d;
    
    @Before
    public void setUp() {
        tab = new TabelaHash();
        d = new Endereco("1", "2", "3");
        a = new Usuario("a", "123", "1", "2", "3", d, "4");
        b = new Usuario("b", "123", "1", "2", "3", d, "4");
        c = new Usuario("c", "123", "1", "2", "3", d, "4");
    }

    @Test
    public void testPut() {
        tab.put(a.getLogin(), a);
        assertEquals(1, tab.size());
        tab.put(b.getLogin(), b);
        assertEquals(2, tab.size());
        tab.put(c.getLogin(), c);
        assertEquals(3, tab.size());
    }

    @Test
    public void testGet() {
        tab.put(a.getLogin(), a);
        tab.put(b.getLogin(), b);
        tab.put(c.getLogin(), c);
        assertEquals(a, tab.get(a.getLogin()));
        assertEquals(b, tab.get(b.getLogin()));
        assertEquals(c, tab.get(c.getLogin()));
    }

    @Test
    public void testRemoveKey() {
        tab.put(a.getLogin(), a);
        assertEquals(a, tab.get(a.getLogin()));
        tab.removeKey(a.getLogin());
        assertEquals(null, tab.get(a.getLogin()));
    }

    @Test
    public void testRemoveValue() {
        tab.put(a.getLogin(), a);
        assertEquals(a, tab.get(a.getLogin()));
        tab.removeValue(a);
        assertEquals(null, tab.get(a.getLogin()));
    }

    @Test
    public void testIsEmpty() {
        assertTrue(tab.isEmpty());
        tab.put(a.getLogin(), a);
        assertFalse(tab.isEmpty());
        tab.removeKey(a.getLogin());
        assertTrue(tab.isEmpty());
    }

    @Test
    public void testSize() {
        tab.put(a.getLogin(), a);
        assertEquals(1, tab.size());
        tab.put(b.getLogin(), b);
        assertEquals(2, tab.size());
        tab.put(c.getLogin(), c);
        assertEquals(3, tab.size());
        tab.removeKey(a.getLogin());
        assertEquals(2, tab.size());
        tab.removeKey(b.getLogin());
        assertEquals(1, tab.size());
        tab.removeKey(c.getLogin());
        assertEquals(0, tab.size());
    }
    
    @Test
    public void testBasic(){
        int max = 1000;        
        System.out.println("Adicionando " + max + " com a hashTable recem criada:\n");
        
        System.out.println("Está vazio? " + tab.isEmpty());
        // start time
        long startTime = System.currentTimeMillis(); 
        for (int i = 0; i < max; i++) {
            Integer x = i;
            tab.put(x.toString(), a);
        }
        // end time
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("HashTable: " + duration + " ms"
                         + "\nQuantidade de dados no array: " + tab.size()
                         + "\nEstá vazio? " + tab.isEmpty());   
        
        System.out.println("pega 1");
        startTime = System.nanoTime();
        c = (Usuario) tab.get("10");
        System.out.println(c);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("HashTable: " + duration + " ns");
        
        System.out.println("\nRemovendo " + max + " da hashSet:\n");
        
        startTime = System.currentTimeMillis();
        for (int i = 0; i < max; i++) {
            Integer x = i;
            tab.removeKey(x.toString());
        }
        // end time
        endTime = System.currentTimeMillis();
        duration = endTime - startTime;
        System.out.println("HashTable: " + duration + " ms"
                         + "\nQuantidade de dados no array: " + tab.size()
                         + "\nEstá vazio? " + tab.isEmpty()); 
             
        System.out.println("\nAdicionando " + max + " com a hashSet ja criada:\n");
        
        startTime = System.currentTimeMillis();  
        for (int i = max; i < max*2; i++) {
            Integer x = i;
            tab.put(x.toString(), b);
        }
        // end time
        endTime = System.currentTimeMillis();
        duration = endTime - startTime;
        System.out.println("HashTable: " + duration + "ms"
                         + "\nQuantidade de dados no array: " + tab.size()
                         + "\nEstá vazio? " + tab.isEmpty());
    }
}
