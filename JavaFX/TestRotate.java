package JavaFX;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.layout.StackPane;

public class TestRotate extends Application {
public void start(Stage primaryStage){
	Color rc=new Color(0.2,0.3,0.5,1.0);
	Button ok=new Button("ok");    //������ǩ
	ok.setTextFill(rc);
	ok.setStyle("-fx-border-coler:red");    //����ǩ���ø�ʽ
	
	ok.setRotate(15);
	StackPane p=new StackPane();      //�������  
	p.getChildren().add(ok);
	p.setRotate(45);
	p.setStyle("-fx-border-color:red;-fx-background-color:red");     //������   html  �Ŀ���
	
	
	Scene scene=new Scene(p,200,200);    //�����龰   
	primaryStage.setScene(scene);        //�龰��ӵ���̨
	primaryStage.setTitle("ok");
	primaryStage.show();
	
}


public static void main(String[]args){
	Application.launch(args);
}
}
