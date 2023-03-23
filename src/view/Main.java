package view;

import java.util.concurrent.Semaphore;

import Controller.Show;


public class Main {

	public static void main(String[] args) {
		Semaphore s1= new Semaphore (1);
		for ( int i= 1; i< 10; i++) {
			Thread m = new Show (s1);
			m.start();
		}
		}

	}


