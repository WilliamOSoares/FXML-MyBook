//MyBook//
/*******************************************************************************
Autores: Samuel Ramos dos Santos e William Oliveira Soares
Componente Curricular: MI Programação
Concluido em: 29/07/2018
Declaro que este código foi elaborado por nós de forma coletiva e não contém nenhum
trecho de código de outro colega ou de outro autor, tais como provindos de livros e
apostilas, e páginas ou documentos eletrônicos da Internet. Qualquer trecho de código
de outra autoria que não seja a nossa está destacado com uma citação para o autor e a fonte
do código, e estou ciente que estes trechos não serão considerados para fins de avaliação.
***************************************************************************************/
package exceptions;

/**
 * Classe que representa o erro quando um campo não é preenchido.
 * 
 * @author William Oliveira e Samuel Ramos.
 */
public class CampoNaoPreenchidoException extends Exception {

    public CampoNaoPreenchidoException() {}
    /**
     * Construtor padrão.
     * @param msg Mensagem.
     */
    public CampoNaoPreenchidoException(String msg) {
        super(msg);
    }
}
