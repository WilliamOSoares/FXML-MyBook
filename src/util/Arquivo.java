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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


/**
 * Classe responsavel para auxiliar a manipulação de arquivos.
 * 
 * @author Samuel Ramos, William Oliveira
 */
public class Arquivo implements Serializable, IArquivo{
    
    @Override
    public void salvarArquivo(Object obj, String diretorio, String nome, String extensao){
        try{
            FileOutputStream file = new FileOutputStream(diretorio + "//"+ nome+"."+extensao);
            ObjectOutputStream save = new ObjectOutputStream(file);
            
            save.writeObject(obj);
            file.close();
        }catch (IOException ex){
            
        }        
    }
    
    @Override
    public Object lerArquivo(String diretorio, String nome) throws ClassNotFoundException {
        Object obj = null;        
        try{
            FileInputStream file = new FileInputStream(diretorio+"//"+nome);
            ObjectInputStream recuperar = new ObjectInputStream(file);
            obj = recuperar.readObject();
            
        }catch (IOException ex){
            
        }
        return obj;        
    }
    
    @Override
    public void criarDiretorio(String diretorio){
        File arquivo = new File(diretorio);
        if(!arquivo.exists() || !arquivo.isDirectory()){
            boolean success = new File(diretorio).mkdir();
            if(!success){
                System.out.println("Falha ao criar o diretorio");
            }
        }
    }
    
        
    @Override
    public void listarArquivosEmDiretorio(String diretorio){
        File arq = new File(diretorio);
        if(arq.exists()){
            if(arq.isDirectory()){
                String listarDiretorio[] = arq.list();
                for(String diret: listarDiretorio){                    
                    System.out.println(diret);
                }
            }
        }
    }
    
    
}
