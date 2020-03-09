//MyBook
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
 * Classe responsavel para auxiliar a manipulação de dados.
 * 
 * @author Samuel Ramos, William Oliveira
 */
public class ListaEncadeada implements ILista, Serializable{
    
    private Celula primeira;
    private Celula ultima;
    private int total = 0;

    @Override
    public boolean remove(Object o) {
        Celula aux = primeira;
        Celula auxAnterior = primeira;
        Celula procurada = new Celula(o);
        while(aux != null){
            if(aux.equals(procurada)){
                if(aux.equals(primeira)){
                    primeira = primeira.getProximo();
                    total--;
                    return true;
                } else {
                    auxAnterior.setProximo(aux.getProximo());
                    aux.setProximo(null);
                    total--;
                    return true;
                }
            }
            auxAnterior = aux;
            aux = aux.getProximo();
        }
        return false;
    }

    @Override
    public boolean contem(Object o) {
        Celula aux = primeira;
        Celula procurada = new Celula(o);
        while(aux != null){
            if(aux.equals(procurada)){
                return true;
            }
            aux = aux.getProximo();
        }
        return false;
    }
    
    private class Celula implements Serializable{
        private Object conteudo;
        private Celula proximo;
    
        public Celula(Object conteudo){
            this.conteudo = conteudo;
        }
        public Celula getProximo(){
            return proximo;
        }
        public void setProximo(Celula proximo){
            this.proximo = proximo;
        }
        public Object getConteudo(){
            return conteudo;
        }
        public void setConteudo(Object conteudo){
            this.conteudo = conteudo;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final Celula other = (Celula) obj;
            return conteudo.equals(other.conteudo);
        }
        
    }

    @Override
    public boolean estaVazia() {
        return this.total==0;        
    }

    @Override
    public int tamanho() {
        return total;
    }
    
    @Override
    public void insereInicio(Object o) {
        Celula aux = new Celula(o);
        if(this.estaVazia()){
            this.primeira = aux;
            this.ultima = this.primeira;
        } else{
            aux.setProximo(this.primeira);
            this.primeira = aux;
        }
        this.total++;
    }

    @Override
    public void insereFinal(Object o) {
        if(this.estaVazia()){
            this.insereInicio(o);
        } else{
            Celula aux = new Celula(o);
            this.ultima.setProximo(aux);
            this.ultima = aux;
            this.total++;
        }
    }

    @Override
    public Object removeInicio() {
        Celula aux = this.primeira;
        if(this.estaVazia()){
            return null;
        } else{
            this.primeira = this.primeira.getProximo();
            this.total--;        
        }
        if(this.estaVazia()){
            this.ultima = this.primeira;
        }
        return aux.conteudo;
    }

    @Override
    public Object removeUltimo() {
        Celula removido = this.ultima;
        if(this.estaVazia()){
            return null;
        } else if(this.total==1){
            removeInicio();
        } else{
            Celula aux = this.primeira;
            boolean flag = true;
            while(flag){
                if(aux.getProximo() == this.ultima){
                    this.ultima = aux;
                    this.ultima.setProximo(null);
                    flag = false;
                } else{
                    aux = aux.getProximo();
                }
            }    
            this.total--;       
        }
        return removido.conteudo;
    }

    @Override
    public Object recupera(int index) {
        if (index >= 0 && index< total){
            Celula n = primeira;
            for (int i = 0; i < index; i++) {
                n = n.getProximo();
            }
            return n.getConteudo();
        }
        return null;
    }
    
    private class Iterator implements Iterador{
        private int cursor;
        
        public Iterator() {
            this.cursor = 0;
        }
        @Override
        public boolean temProximo(){
            return cursor < total;
        }
        @Override
        public Object proximo(){
            Object aux = recupera(cursor);
            cursor++;
            return aux;
        }
    }
    
    @Override
    public Iterador iterador() {
        return new Iterator();
    }

    
}
