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
	Circle circle=new Circle();     //创建一个圆  圆的各种参数
	circle.centerXProperty().bind(tt.widthProperty().divide(2));
	circle.centerYProperty().bind(tt.heightProperty().divide(2));
	circle.setRadius(50);
	//circle.setStroke(Color.BLUE);     //笔画  并且颜色为蓝色
	//circle.setFill(Color.WHITE);      //填充
	circle.setStyle("-fx-stroke: black;-fx-fill:red;");
	
}
public static void main(String []args){
	Application.launch(args);
}

}
