import java.awt.*;
public class BorderLayoutTest {
	public static void main(String[]args){
		Frame f=new Frame("BorderLayout");
		Button bn=new Button("North");
		Button bs=new Button("South");
		Button bw=new Button("west");
		Button be=new Button("East");
		Button bc=new Button("center");
		//f.setLayout(new BorderLayout());
		f.add(bn,"North");
		f.add(bs,"South");
		f.add(bw,"West");
		f.add(be,"East");
		f.add(bc,"Center");
		
		f.setSize(200,200);
		f.setVisible(true);
	}

}
