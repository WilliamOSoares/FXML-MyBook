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
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Classe que representa a interface gráfica do perfil do usuário.
 * 
 * @author William Oliveira e Samuel Ramos.
 */
public class Perfil extends Application{
    
    private static Scene perfilScene;
    private Scene cena;
    /**
     * Pega a cena atual.
     * @return Cena.
     */
    public Scene getCena() {
        return cena;
    }
    /**
     * Cria uma nova cena.
     * @throws Exception Erro inesperado.
     */
    public void perfil() throws Exception {
        Parent perfil =FXMLLoader.load(getClass().getResource("/view/Telas.fxml"));
        cena = new Scene(perfil);
    }
    /**
     * Metódo que torna a classe executável e mostra gráficamente a interface.
     * @param args Argumentos.
     */
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent perfil =FXMLLoader.load(getClass().getResource("/view/Telas.fxml"));
        Scene c = new Scene(perfil);
        
        stage.setScene(c);
        stage.setTitle("MyBook - Perfil");
        stage.show(); 
        setPerfilScene(c);
    }
    /**
     * Pega a cena do perfil.
     * @return Perfil.
     */
    public static Scene getPerfilScene() {
        return perfilScene;
    }
    /**
     * Altera a cena do perfil.
     * @param perfilScene Novo valor do perfilScene.
     */
    public static void setPerfilScene(Scene perfilScene) {
        Perfil.perfilScene = perfilScene;
    }
    
    
}
