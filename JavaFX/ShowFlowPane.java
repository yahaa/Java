
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.*;
import javafx.scene.Scene;

public class ShowFlowPane extends Application {
	public void start(Stage primaryStage){
		FlowPane pane=new FlowPane();
		pane.setPadding(new Insets(11,12,13,14));
		pane.setHgap(5);
		pane.setVgap(5);
		
		pane.getChildren().addAll(new Label("first name:"),new TextField(),new Label("MI:"));
		TextField tf=new TextField();
		tf.setPrefColumnCount(1);
		pane.getChildren().addAll(tf,new Label("Last name :"),new TextField());
		Scene scene=new Scene(pane,200,250);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String []args){
		Application.launch(args);
	}

}
