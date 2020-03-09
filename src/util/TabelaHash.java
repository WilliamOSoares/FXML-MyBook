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
package util;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Iterator;

/**
 * Classe responsável pelo o banco de dados que efetua a busca mais rápida.
 * 
 * @author William Oliveira, Samuel Ramos.
 */
public class TabelaHash implements IHashTable, Serializable{
    private final double FATOR_CARGA = 0.5;
    private final Entrada EMPTY = new Entrada(null, null);
    private Entrada[] entradas;
    private int size;
    
    /**
     * Cria uma tabela hash;
     */
    public TabelaHash(){
        this(30);
        this.size = 0;
    }
    /**
     * Cria uma tabela hash com o tamanho sendo o proximo numero primo a partir
     * do 30.
     * @param num Número 30;
     */
    private TabelaHash(int num){
        entradas = new Entrada[this.proxPrimo(num)];
    }
    /**
     * Retorna o proximo provavel numero primo a partir do nemero recebido por
     * parametro.
     * @param num Numero.
     * @return proximo provavel numero primo.
     */
    private int proxPrimo(int num){
        BigInteger b = new BigInteger(String.valueOf(num));
        return (int) Integer.parseInt(b.nextProbablePrime().toString());
    }
    
    @Override
    public void put(Object key, Object value) {
        Entrada e = new Entrada(key, value);
        int i = encontrarPos(funcaoHash(key), e);
        if (estaVazio(i)) {
            entradas[i] = e;
            size++;
            if (fatorCarga() > FATOR_CARGA) {
                redefinir();
            }
        }
    }
    /**
     * Retorna a provavel posiçao do objeto no array a partir do hashCode do 
     * parametro e do tamanho do array.
     * @param key Chave de busca.
     * @return numero maior que 0 e menor do que o tamanho do array.
     */
    private int funcaoHash(Object key){
        return Math.abs(key.hashCode() % entradas.length);
    } 
    /**
     * Encontra outra posicao caso a posicao no array ja esteja ocupada.
     * @param pos Posicao verificada.
     * @param e Nova entrada do programa.
     * @return Nova posicao.
     */
    private int encontrarPos(int pos, Entrada e) {
        int firstEmpty = -1;
        while (entradas[pos] != null && !entradas[pos].equals(e)) {
            if (firstEmpty == -1 && entradas[pos].equals(EMPTY)) {
                firstEmpty = pos;
            }
            pos = (pos + 1) % entradas.length;
        }
        if (entradas[pos] == null && firstEmpty != -1) {
            return firstEmpty;
        } else {
            return pos;
        }
    }
    /**
     * Verifica se a posicao esta vazia;
     * @param pos Posicao.
     * @return True se sim, False se nao.
     */
    private boolean estaVazio(int pos) {
        return entradas[pos] == null || entradas[pos].equals(EMPTY);
    }
    /**
     * Retorna o quao esta cheio o array.
     * @return Porcentagem do quao cheio o array esta.
     */
    private double fatorCarga() {
        return size() / (double) entradas.length;
    }
    /**
     * Redimenciona o array principal e coloca todos os valores no array
     * redimencionado.
     */
    private void redefinir() {
        Entrada[] aux = entradas;
        entradas = new Entrada[this.proxPrimo(entradas.length * 2)];
        this.size = 0;
        for (Entrada e : aux) {
            if (e != null && !e.equals(EMPTY)) {
                put(e.getKey(), e.getValue());
            }
        }
    }
    
    @Override
    public Object get(Object key) {
        Entrada e = new Entrada(key, null);
        int i = encontrarPos(funcaoHash(key), e);
        if(!this.estaVazio(i)){
           return entradas[i].getValue();
        }
        return null;
    }

    @Override
    public void removeKey(Object key) {
        Entrada e = new Entrada(key, null);
        int i = encontrarPos(funcaoHash(key), e);
        entradas[i] = EMPTY;
        size--;
    }

    @Override
    public void removeValue(Object value) {
        for(int i = 0; i<entradas.length; i++){
            if(entradas[i]!=null && !entradas[i].equals(EMPTY) && entradas[i].getValue().equals(value)){
                entradas[i] = EMPTY;
                i = entradas.length;
            }
        }
        size--;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }
    
    /**
     * Retorna um iterador para o array de dados.
     * @return Iterator para o conteudo do objeto.
     */
    public Iterator getIterador(){ return new MyIterator(); }
    
    private class MyIterator implements Iterator {
        int cursor = 0;
        @Override
        public boolean hasNext() {
            while(cursor < entradas.length){
                if(entradas[cursor] != null && !entradas[cursor].equals(EMPTY))
                    return true;
                cursor++;
            }
            return false;
        }

        @Override
        public Object next() {
            return entradas[cursor++].getValue();
        }
    }
}
