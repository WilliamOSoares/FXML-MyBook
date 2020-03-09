package util;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Teste da classe responsavel para auxiliar a manipulação de dados.
 * 
 * @author Samuel Ramos, William Oliveira
 */
public class ListaEncadeadaTest {
    
    ListaEncadeada lista;
    String data1, data2, data3;
    
    @Before
    public void setUp() {
        lista = new ListaEncadeada();
        data1 = "Data1";
        data2 = "Data2";
        data3 = "Data3";
    }

    @Test
    public void testRemove() {
        lista.insereInicio(data1);
        lista.insereInicio(data2);
        lista.insereInicio(data3);
        assertTrue(lista.remove(data1));
        assertTrue(lista.remove(data2));
        assertTrue(lista.remove(data3));
        assertFalse(lista.remove(data1));
        assertFalse(lista.remove(data2));
        assertFalse(lista.remove(data3));
    }

    @Test
    public void testContem() {
        lista.insereInicio(data1);
        lista.insereInicio(data2);
        lista.insereInicio(data3);
        assertTrue(lista.contem(data1));
        assertTrue(lista.contem(data2));
        assertTrue(lista.contem(data3));
        lista.removeInicio();
        lista.removeInicio();
        lista.removeInicio();
        assertFalse(lista.contem(data1));
        assertFalse(lista.contem(data2));
        assertFalse(lista.contem(data3));
    }

    @Test
    public void testEstaVazia() {
        assertTrue(lista.estaVazia());
    }

    @Test
    public void testTamanho() {
        assertEquals(0, lista.tamanho());
        lista.insereInicio(data1);
        assertEquals(1, lista.tamanho());
        lista.insereInicio(data2);
        lista.insereInicio(data3);
        assertEquals(3, lista.tamanho());
        lista.removeUltimo();
        assertEquals(2, lista.tamanho());
        lista.removeInicio();
        lista.removeUltimo();
        assertEquals(0, lista.tamanho());
    }

    @Test
    public void testAdicionaInicioRemoveInicio() {
        lista.insereInicio(data1);
        lista.insereInicio(data2);
        lista.insereInicio(data3);
        assertFalse(lista.estaVazia());

        assertSame(data3, lista.removeInicio());
        assertFalse(lista.estaVazia());

        assertSame(data2, lista.removeInicio());
        assertFalse(lista.estaVazia());

        assertSame(data1, lista.removeInicio());
        assertTrue(lista.estaVazia());	
    }

    @Test
    public void testAdicionaInicioRemoveFinal() {
        lista.insereInicio(data1);
        lista.insereInicio(data2);
        lista.insereInicio(data3);
        assertFalse(lista.estaVazia());

        assertSame(data1, lista.removeUltimo());
        assertFalse(lista.estaVazia());

        assertSame(data2, lista.removeUltimo());
        assertFalse(lista.estaVazia());

        assertSame(data3, lista.removeUltimo());
        assertTrue(lista.estaVazia());	
    }

    @Test
    public void testAdicionaFinalRemoveInicio() {
        lista.insereFinal(data1);
        lista.insereFinal(data2);
        lista.insereFinal(data3);
        assertFalse(lista.estaVazia());

        assertSame(data1, lista.removeInicio());
        assertFalse(lista.estaVazia());

        assertSame(data2, lista.removeInicio());
        assertFalse(lista.estaVazia());

        assertSame(data3, lista.removeInicio());
        assertTrue(lista.estaVazia());	
    }

    @Test
    public void testAdicionaFinalRemoveFinal() {
        lista.insereFinal(data1);
        lista.insereFinal(data2);
        lista.insereFinal(data3);
        assertFalse(lista.estaVazia());

        assertSame(data3, lista.removeUltimo());
        assertFalse(lista.estaVazia());

        assertSame(data2, lista.removeUltimo());
        assertFalse(lista.estaVazia());

        assertSame(data1, lista.removeUltimo());
        assertTrue(lista.estaVazia());	
    }

    @Test
    public void testRecupera() {
        lista.insereFinal(data1);
        lista.insereFinal(data2);
        lista.insereInicio(data3);
        assertEquals(data3, lista.recupera(0));
        assertEquals(data1, lista.recupera(1));
        assertEquals(data2, lista.recupera(2));

        lista.removeUltimo();
        assertEquals(data3, lista.recupera(0));
        assertEquals(data1, lista.recupera(1));

        lista.removeInicio();
        assertEquals(data1, lista.recupera(0));		
    }

    @Test
    public void testIterador() {
        Iterador it = lista.iterador();
        assertFalse(it.temProximo());
        lista.insereFinal(data1);
        lista.insereFinal(data2);
        lista.insereInicio(data3);
        it = lista.iterador();
        assertTrue(it.temProximo());
        assertSame(data3, it.proximo());
        assertTrue(it.temProximo());
        assertSame(data1, it.proximo());
        assertTrue(it.temProximo());
        assertSame(data2, it.proximo());
        assertFalse(it.temProximo());
    }
    
}
