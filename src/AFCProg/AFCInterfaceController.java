package AFCProg;



import java.io.File;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Optional;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class AFCInterfaceController {
	 Stage primaryStage ;
	 FileChooser fileChooser ;
     String filePath ;

      @FXML
      private Button retour;
	   @FXML
	    private Button choose;
	   @FXML
	    private Label fileLabel;
	   @FXML
	    private Button confirm;
	
	
	@FXML
	void choose () 
	{   
		fileChooser = new FileChooser () ;
		fileChooser.getExtensionFilters().addAll(
	    new FileChooser.ExtensionFilter("IHM", "*.ihm"));

        File file = fileChooser.showOpenDialog(primaryStage);
        if (file != null) {
           filePath=file.getPath() ; 
           fileLabel.setText(filePath);
  
            	confirm.setDisable(false);
            	
          
            }
      
	}
	
	
	@FXML
	void confirm () 
	{   
		
	
	 try {
           File fileIn = new File(filePath) ;
           gram.AFComposer (fileIn);
           confirm.setDisable(true);
           choose.setDisable(true);
          
            Alert dialogD = new Alert(AlertType.CONFIRMATION);
			dialogD.setTitle("Resultat");
			dialogD.setHeaderText(null);
			dialogD.setContentText("l'analyse a été effuctuée ! Vous pouvez trouver les fichiers dans le dossier racine");
			dialogD.showAndWait();
           
        }   catch (Exception e) {
            e.printStackTrace();
          }
 

}
	
}
