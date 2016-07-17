package com.client;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestNClient implements Runnable {
	public void run(){
		for(int i=0;i<100000;i++){
			System.out.println(i);
			new NClient();
		}
	}
	
	public static void main(String[]args){
		Thread a=new Thread(new TestNClient());
		a.start();
	}
}
