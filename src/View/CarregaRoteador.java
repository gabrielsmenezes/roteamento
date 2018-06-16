/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author mrgab
 */
public class CarregaRoteador extends Application {
    
    @Override
    public void start(Stage primaryStage) throws MalformedURLException, IOException, FileNotFoundException, ClassNotFoundException {
        
         try{
            File arquivo = new File("src\\View\\Roteador.fxml");
            URL url = arquivo.toURL();
            Parent root = FXMLLoader.load(url);
            
            Scene scene = new Scene(root);
            primaryStage.setTitle("Roteador");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e ){
            e.printStackTrace();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
