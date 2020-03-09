package model;

import util.TabelaHash;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Teste da classe Usuário.
 * 
 * @author William Oliveira, Samuel Ramos.
 */
public class UsuarioTest {
    
    Usuario u;
    Endereco e;
    
    @Before
    public void setUp() {
        e = new Endereco("cidade", "estado", "pais");
        u = new Usuario("login","senha", "nomeCompleto", "email", "dataNascimento", e, "telefone");
    }

    @Test
    public void testGetLogin() {
        assertEquals("login", u.getLogin());
    }

    @Test
    public void testGetSenha() {
        assertEquals("senha", u.getSenha());
    }

    @Test
    public void testGetTelefone() {
        assertEquals("telefone", u.getTelefone());
    }

    @Test
    public void testGetNomeCompleto() {
        assertEquals("nomeCompleto", u.getNomeCompleto());
    }

    @Test
    public void testGetEmail() {
        assertEquals("email", u.getEmail());
    }

    @Test
    public void testGetDataNascimento() {
        assertEquals("dataNascimento", u.getDataNascimento());
    }

    @Test
    public void testGetEndereco() {
        assertEquals(e , u.getEndereco());
    }

    @Test
    public void testGetAmigos() {
        assertNotNull(u.getAmigos());
    }

    @Test
    public void testGetPedidosAmizade() {
         assertNotNull(u.getPedidosAmizade());
    }

    @Test
    public void testHashCode() {
        assertNotNull(u.getPedidosAmizade());
    }

    @Test
    public void testEquals() {
        Usuario s = u;
        assertEquals(s , u);
    }
}
