package JavaFX;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
public class JavaFx extends Application {
	
public void start(Stage primaryStage){
	Pane tt=new Pane();    
	Circle circle=new Circle();     //����һ��Բ  Բ�ĸ��ֲ���
	circle.centerXProperty().bind(tt.widthProperty().divide(2));
	circle.centerYProperty().bind(tt.heightProperty().divide(2));
	circle.setRadius(50);
	//circle.setStroke(Color.BLUE);     //�ʻ�  ������ɫΪ��ɫ
	//circle.setFill(Color.WHITE);      //���
	circle.setStyle("-fx-stroke: black;-fx-fill:red;");
	
}
public static void main(String []args){
	Application.launch(args);
}

}
