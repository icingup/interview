package org.king.concurrent;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class TaskExecutiong {
	private static final int NTHREADS = 100;
	private static final Executor exec = Executors.newFixedThreadPool(NTHREADS);
	
	public static void main(String[] args) throws IOException {
		ServerSocket socket = new ServerSocket(80);
		while(true){
			final Socket connection = socket.accept();
			Runnable task = new Runnable(){
				@Override
				public void run() {
					hanleRequest(connection);
				}
			};
			exec.execute(task);
		}
	}

	private static void hanleRequest(Socket connection){
		System.out.println("it do request connect...");
	}
	
}
