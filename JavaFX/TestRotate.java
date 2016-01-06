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
	Button ok=new Button("ok");    //创建标签
	ok.setTextFill(rc);
	ok.setStyle("-fx-border-coler:red");    //给标签设置格式
	
	ok.setRotate(15);
	StackPane p=new StackPane();      //创建面板  
	p.getChildren().add(ok);
	p.setRotate(45);
	p.setStyle("-fx-border-color:red;-fx-background-color:red");     //类似于   html  的控制
	
	
	Scene scene=new Scene(p,200,200);    //创建情景   
	primaryStage.setScene(scene);        //情景添加到舞台
	primaryStage.setTitle("ok");
	primaryStage.show();
	
}


public static void main(String[]args){
	Application.launch(args);
}
}
