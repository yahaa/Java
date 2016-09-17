package com.zihua.ui;
import javax.swing.JFrame;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

public class Test1 {
	public static void main(String[] args){	
		JFrame jf=new JFrame("xxxxxx");
	    try{
	    	 BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.osLookAndFeelDecorated;
	         org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
	         jf.setSize(500, 500);
	         jf.setVisible(true);
	    }
	    catch(Exception e){
	        //TODO exception
	    }
	   
	  
	}
}
