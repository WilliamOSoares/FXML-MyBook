package main;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class TelaBusca extends Application{
    
    private static Scene telaBusca;
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
    public void abrirTelaBusca() throws Exception {
        Parent telaB =FXMLLoader.load(getClass().getResource("/view/TelaBusca.fxml"));
        cena = new Scene(telaB);
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
        Parent telaB =FXMLLoader.load(getClass().getResource("/view/TelaBusca.fxml"));
        Scene c = new Scene(telaB);
        
        stage.setScene(c);
        stage.setTitle("MyBook");
        stage.show(); 
        setTelaBusca(c);
    }
    /**
     * Pega a cena da busca.
     * @return Perfil.
     */
    public static Scene getTelaBusca() {
        return telaBusca;
    }
    
    /**
     * Altera a cena da busca.
     * @param telaBusca
     */
    public static void setTelaBusca(Scene telaBusca) {
        TelaBusca.telaBusca = telaBusca;
    }
       
}