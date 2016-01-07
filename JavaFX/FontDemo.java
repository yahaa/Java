
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.shape.Circle;
import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.paint.*;
import java.math.*;
public class FontDemo extends Application{
	public void start(Stage pirmaryStage){
		
			Pane pane=new StackPane();       //创建面板
			Color re=new Color(Math.random(),Math.random(),Math.random(),Math.random());     //创建随机颜色
			Font yahaa=new Font(45);
			
			Circle circle=new Circle();     //创建圆
			circle.setRadius(50);
			circle.centerXProperty().bind(pane.widthProperty().divide(2));
			circle.centerYProperty().bind(pane.heightProperty().divide(2));
			circle.setFill(re);
			circle.setStyle("-fx-stroke:red;");
			
			Label label=new Label("java Fx");
			label.setFont(Font.font("yahaa",FontWeight.BOLD,FontPosture.ITALIC,20));
			
			
			pane.getChildren().add(circle);       //把圆添加到面板
			pane.getChildren().add(label);        //把标签添加到面板上
			
			Scene scene=new Scene(pane,200,200);     //创建场景  并且添加面板
		    pirmaryStage.setScene(scene);
	        pirmaryStage.show();		
		}
		
	
	public static void main(String []args){
		Application.launch(args);
		
	}

}
