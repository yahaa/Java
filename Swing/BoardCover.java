import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;  
import java.awt.Dimension;  
import java.awt.Graphics;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

import javax.swing.JFrame;  
import javax.swing.JPanel;
public class BoardCover {

	public static void main(String []args){
		UI ui=new UI();
	}
}

class UI extends JFrame{
	private Graphics g;
	private MenuBar mb;
	private int n;
	private final int D=20;

	public UI(){
		init(5);
	}
	public void init(int k){
		//基本参数
		n=1<<k;
		this.setTitle("棋盘覆盖");
		this.setSize(new Dimension(680,710));
		this.setResizable(false);
		this.setDefaultCloseOperation(3);
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		
		//添加面板
		MyPanel pboard=new MyPanel(k,D);
		this.add(pboard);
		this.setVisible(true);
		this.setBackground(new Color(209,167,78));
		//添加菜单
		mb=new MenuBar();
		Menu start=new Menu("Start");
		
		Menu clear=new Menu("Clear");
		mb.add(start);
		mb.add(clear);
		mb.setFont(getFont());
		this.setMenuBar(mb);
		g=pboard.getGraphics();
		MouseAction lis=new MouseAction(pboard);
		pboard.addMouseListener(lis);
		MyAL ml=new MyAL(pboard);
		
	}
}

class MyAL implements ActionListener{
	private MyPanel p;
	private Graphics g;
	private int tile=0;
	public MyAL(MyPanel p){
		this.p=p;
		g=p.getGraphics();
	}
	public void actionPerformed(ActionEvent e){
        
    }
	
	public void coverb ( int tr, int tc, int dr, int dc, int size ){  
	    if ( size==1)return;  
	    int t=tile++;
	    int s=size/2; 
	    if ( dr<tr+s && dc<tc+s )         
	        coverb ( tr, tc, dr, dc, s );  
	    else{  
	        board[tr+s-1][tc+s-1]=t;  
	        coverb ( tr, tc, tr+s-1, tc+s-1, s );  
	    }  
	    if ( dr<tr+s && dc>=tc+s )             
	        coverb ( tr, tc+s, dr, dc, s );  
	    else{  
	        board[tr+s-1][tc+s]=t;  
	        coverb ( tr, tc+s, tr+s-1, tc+s, s );  
	    }  
	   
	    if ( dr>=tr+s && dc<tc+s )             
	        coverb ( tr+s, tc, dr, dc, s );  
	    else{  
	        board[tr+s][tc+s-1]=t;  
	        coverb ( tr+s, tc, tr+s, tc+s-1, s );  
	    }  
	 
	    if ( dr>=tr+s && dc>=tc+s )               
	        coverb ( tr+s, tc+s, dr, dc, s );  
	    else{  
	        board[tr+s][tc+s]=t;  
	        coverb ( tr+s, tc+s, tr+s, tc+s, s );  
	    }  
	}  

}


class MyPanel extends JPanel{
	private int n;
	private int D=20;
	private int sx,sy;
	private Integer [][]map=new Integer[33][33];
	public MyPanel(){
		n=2;
		init();
	}
	
	public MyPanel(int k,int d){
		n=1<<k;
		D=d;
		init();
	}
	
	public void init(){
		this.setLayout(null);
		this.setBackground(new Color(209,167,78));
		this.setBounds(0,0,n*D+40,n*D+40);
		for(int i=0;i<=32;i++)
			Arrays.fill(map[i],0);
		sx=1;
		sy=1;
	}
	
	public void setSXY(int x,int y){
		sx=x;
		sy=y;
	}
	
	public int getSX(){
		return sx;
	}
	
	public int getSY(){
		return sy;
	}
	
	public Integer getMap(int x,int y){
		return map[x][y];
	}
	public void setMap(int x,int y,int v){
		map[x][y]=v;
	}
	
	@Override
	public void paint(Graphics g){
		g.setColor(Color.BLACK);
		super.paint(g);
		for(int i=0;i<=n;i++){
			int x1=20+i*D;
			int y1=20;
			int x2=x1;
			int y2=y1+(n)*D;
			g.drawLine(x1, y1, x2, y2);
			x1=20;
			x2=20+(n)*D;
			y1=20+i*D;
			y2=y1;
			g.drawLine(x1, y1, x2, y2);
		}
	}
	
}



class MouseAction extends MouseAdapter {
	private Graphics g;
	private MyPanel p;
	private boolean ok=true;
	private Color []colors=new Color[6];
	
	
	public MouseAction(MyPanel p){
		this.g=p.getGraphics();
		this.p=p;
		initColor();
	}
	
	private void initColor(){
		colors[0]=new Color(0x0,0x0,0x0);
		colors[1]=new Color(0xD6,0xD6,0x08);
		colors[2]=new Color(0x71,0xF3,0x50);
		colors[3]=new Color(0xEE,0x11,0x11);
		colors[4]=new Color(0x49,0xC8,0xC8);
		colors[5]=new Color(209,167,78);
	}
	
	public int correctXY(int x) {  
        x = x / 20;  
        return x;
    }  
	
	public void mouseClicked(MouseEvent e){
		
		if(ok){
			ok=false;
			int x=correctXY(e.getX());
			int y=correctXY(e.getY());
			p.setMap(x, y, 0);
			p.setSXY(x, y);
			g.setColor(colors[p.getMap(x, y)]);
			g.fillRect(x*20,y*20+27,20, 20);
			System.out.println(x+" "+y);
		}
		
	}
	
	public void mousePressed(MouseEvent e){
		int x=correctXY(e.getX());
		int y=correctXY(e.getY());
		System.out.println(p.getMap(x,y));
		//System.out.println(x+" "+y);
	}
	
	
}
