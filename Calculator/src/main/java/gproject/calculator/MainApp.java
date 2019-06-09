package gproject.calculator;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class MainApp extends Application 
{
        public static void main(String[] args)
        {
           launch(args); 
        }
    
    
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        primaryStage.setTitle("Calculator");
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Scene.fxml"));
        Scene scene = new Scene(root, 342,563);
        scene.getStylesheets().add(getClass().getResource("/styles/Styles.css").toExternalForm());
        primaryStage.setScene(scene);
        
        primaryStage.show();
        
    }
    

} 
    
  
    

