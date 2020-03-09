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
package main;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Classe que representa a interface gráfica da busca.
 * 
 * @author William Oliveira e Samuel Ramos.
 */
public class Busca extends Application{
    
    private static Stage stage;     

    @Override
    public void start(Stage stage) throws Exception {
        Parent raiz = FXMLLoader.load(getClass().getResource("/view/BuscaAvancada.fxml"));
        Scene cena = new Scene(raiz);
        stage.setTitle("MyBook - Busca Avançada");
        stage.setScene(cena);
        stage.show();
        setStage(stage);        
    }
    /**
     * Metódo que torna a classe executável e mostra gráficamente a interface.
     * @param args Argumentos.
     */
    public static void main(String[] args) {
        launch(args);
    }
    /**
     * Pega o palco.
     * @return Palco.
     */
    public static Stage getStage() {
        return stage;
    }
    /**
     * Altera o palco.
     * @param stage Novo valor do palco.
     */
    public static void setStage(Stage stage) {
        Busca.stage = stage;
    }
}