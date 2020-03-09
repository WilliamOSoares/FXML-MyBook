// MyBook
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

/**
 * HashSet tratando conflito com lista encadeada.
 * @author William Oliveira Soares  e Samuel Ramos.
 */
public class LinkedHashSet implements IHashSet, Serializable {
    private final double FATOR_CARGA = 0.75;
    private ListaEncadeada[] data;
    private int quantLinkedList;
    private int size;
    
    /**
     * Cria a HashSet com 10 de tamanho, o array.
     */
    public LinkedHashSet() {
        this(10);
    }
    
    private LinkedHashSet(int tam) {
        data = new ListaEncadeada[tam];
        quantLinkedList = 0;
        size = 0;
    }
    
    @Override
    public void put(Object data) {       
        if(fatorDeCarga() > FATOR_CARGA){
            redefinir();
        }
        int i = funcaoHash(data); 
        if(!this.contains(data)){    
            if(this.data[i]==null){
                this.data[i] = new ListaEncadeada();
                this.data[i].insereFinal(data);
                quantLinkedList++;
                size++;
            } else {
                this.data[i].insereFinal(data);
                size++;
            }
        }
    }
    
    private int funcaoHash(Object data) {
        return Math.abs(data.hashCode() % this.data.length);
    }
    
    private double fatorDeCarga(){
        return quantLinkedList/ (double) data.length;
    }
    
    private void redefinir(){
        LinkedHashSet aux = new LinkedHashSet(data.length*2);
        for (ListaEncadeada e : data) {
            if (e != null) {
                if(e.tamanho() > 1){
                    Iterador it = e.iterador();
                    while(it.temProximo()){
                        Object o = it.proximo();
                        aux.put(o);
                    }                        
                } else if (e.tamanho() == 1) {
                    aux.put(e.removeInicio());
                }
            }
        }       
        this.data = aux.data;
    }
    
    @Override
    public boolean contains(Object data) {
        int i = funcaoHash(data);
        if(this.data[i]!=null){
            return this.data[i].contem(data);
        } else {
            return false;
        }
    }

    @Override
    public void remove(Object data) {
        int i = funcaoHash(data);
        if(this.data[i]!=null){
            if(this.data[i].remove(data)){
                size--;
            }
        }       
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }
    
}
