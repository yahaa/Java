
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
		
			Pane pane=new StackPane();       //�������
			Color re=new Color(Math.random(),Math.random(),Math.random(),Math.random());     //���������ɫ
			Font yahaa=new Font(45);
			
			Circle circle=new Circle();     //����Բ
			circle.setRadius(50);
			circle.centerXProperty().bind(pane.widthProperty().divide(2));
			circle.centerYProperty().bind(pane.heightProperty().divide(2));
			circle.setFill(re);
			circle.setStyle("-fx-stroke:red;");
			
			Label label=new Label("java Fx");
			label.setFont(Font.font("yahaa",FontWeight.BOLD,FontPosture.ITALIC,20));
			
			
			pane.getChildren().add(circle);       //��Բ��ӵ����
			pane.getChildren().add(label);        //�ѱ�ǩ��ӵ������
			
			Scene scene=new Scene(pane,200,200);     //��������  ����������
		    pirmaryStage.setScene(scene);
	        pirmaryStage.show();		
		}
		
	
	public static void main(String []args){
		Application.launch(args);
		
	}

}
