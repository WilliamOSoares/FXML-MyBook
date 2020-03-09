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

/**
 * Classe que auxilia no armazenamento de dados em um array que duplica 
 * automaticamente.
 * 
 * @author William Oliveira e Samuel Ramos.
 */
public class MyArray implements Serializable, IMyArray{
    private Object[] myArray;
    private int proximo;
    
    /**
     * Inicia com um array de comparable e com 0 de quantidade, que cresce na 
     * potência de 2.
     */
    public MyArray (){
        myArray = new Object[2];
        proximo = 0;
    }
    
    @Override
    public void add(Object obj) {
        if(proximo==myArray.length){
            int size = myArray.length * 2; //duplica
            Object[] temp = new Object[size];
            for(int i=0;i<proximo;i++){
                temp[i] = myArray[i];
            }
            myArray = temp;
        }
        myArray[proximo] = obj;
        proximo = proximo + 1;
    }

    @Override
    public Object get(Object obj) {
        for(int i=0;i<proximo;i++){
           if(myArray[i].equals(obj))
               return myArray[i];
        }
        return null;
    }

    @Override
    public boolean contains(Object obj) {
        for(int i=0;i<proximo;i++){
           if(myArray[i].equals(obj))
               return true;
        }
        return false;
    }

    @Override
    public int size() {
        return proximo;
    }

    @Override
    public boolean isEmpty() {
        return proximo == 0;
    }
    
    @Override
    public Iterador iterator() {
        return new MyIterador();
    }
    
    private class MyIterador implements Iterador{
        int cursor;
        
        public MyIterador(){
            cursor = 0;
        }
        
        @Override
        public boolean temProximo() {
            return cursor < proximo;
        }

        @Override
        public Object proximo() {
            return myArray[cursor++];
        }
    
    }
}
