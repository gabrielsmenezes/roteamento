package view;
import model.Roteador;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class RoteadorController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField campoPortaRoteador;

    @FXML
    private Button botaoInserirRoteador;

    @FXML
    private TextField campoNumeroPorta;

    @FXML
    private TextField campoRede;

    @FXML
    private TextField campoMascara;

    @FXML
    private TextField campoInterface;

    @FXML
    private Button botaoAdicionar;

    @FXML
    private TextArea log;

    @FXML
    private Button botaoApagarLog;

    @FXML
    private Button botaoIniciarRoteador;

    @FXML
    void adicionarLinhaTabelaRoteamento(ActionEvent event) {
        String linha = campoNumeroPorta.getText() +"/"+campoRede.getText()+"/"+campoMascara.getText()+"/"+campoNumeroPorta.getText();
        args.add(linha);
    }

    @FXML
    void apagarLog(MouseEvent event) {
        log.setText("");
    }

    @FXML
    void apagarTexto(MouseEvent event) {
        TextField txt = (TextField) event.getSource();
        txt.setText("");
    }

    @FXML
    void iniciarRoteador(ActionEvent event) {
        Roteador.main((String[]) args.toArray());
    }
    
    @FXML
    void inserirPortaRoteador(ActionEvent event) {
        args.add(campoPortaRoteador.getText());
    }

    @FXML
    void initialize() {
        assert campoPortaRoteador != null : "fx:id=\"campoPortaRoteador\" was not injected: check your FXML file 'Roteador.fxml'.";
        assert botaoInserirRoteador != null : "fx:id=\"botaoInserirRoteador\" was not injected: check your FXML file 'Roteador.fxml'.";
        assert campoNumeroPorta != null : "fx:id=\"campoNumeroPorta\" was not injected: check your FXML file 'Roteador.fxml'.";
        assert campoRede != null : "fx:id=\"campoRede\" was not injected: check your FXML file 'Roteador.fxml'.";
        assert campoMascara != null : "fx:id=\"campoMascara\" was not injected: check your FXML file 'Roteador.fxml'.";
        assert campoInterface != null : "fx:id=\"campoInterface\" was not injected: check your FXML file 'Roteador.fxml'.";
        assert botaoAdicionar != null : "fx:id=\"botaoAdicionar\" was not injected: check your FXML file 'Roteador.fxml'.";
        assert log != null : "fx:id=\"log\" was not injected: check your FXML file 'Roteador.fxml'.";
        assert botaoApagarLog != null : "fx:id=\"botaoApagarLog\" was not injected: check your FXML file 'Roteador.fxml'.";
        assert botaoIniciarRoteador != null : "fx:id=\"botaoIniciarRoteador\" was not injected: check your FXML file 'Roteador.fxml'.";
        inicializar();
    }
    LinkedList args;

    private void inicializar() {
        args = new LinkedList();
    }

    public TextArea getLog() {
        return log;
    }
    
}
