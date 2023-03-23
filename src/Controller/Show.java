package Controller;


import java.util.concurrent.Semaphore;

public class Show extends Thread{
	int ing;
	int proc;
	double comp;
	static int vali=0;
	int igre=100;
	Semaphore s1;
	
	
	public Show(Semaphore s1) {
		this.s1= s1;
	}
   public  void run() {
	   login();
	   compra();
	   try {
		s1.acquire();
		 Validação();
	} catch (InterruptedException e) {
		e.printStackTrace();
	}finally {
		s1.release();
	}
	  
   }
   	private void Validação() {	
   		proc=(int)((Math.random()*3)+ 1);
   		vali = vali + proc;
   		if (igre >= vali) {
   			
   			igre = igre - vali;
   			System.out.println(" Venda de  "+ proc + " ingressos-- Disponivel  "+ igre + " ingressos");
   			vali = vali + proc;
   		}else {
   			System.out.println(" Ingresso insuficiente para venda ");
   		}
	
   	}
   	private void compra() {
   	
   		comp= (double)((Math.random()*2000)+ 1000)/1000;
   		if ( comp >2.5) {
   			System.out.println(" Tempo esgotado estourou o tempo da sessão");
   			 try {
   				Thread.sleep(10);
   			} catch (InterruptedException e) {
   					e.printStackTrace();
   			}
   			}else {
   				System.out.println(" Agora vamos validar sua compra ");
   		}
   	}
   	private void login() {
	ing= (int)((Math.random()*2000)+ 2)/1000;
	if( ing > 1) {
		System.out.println(" Tempo esgotado não poderar mais fazer a compra ");
		 try {
			Thread.sleep(ing);
		} catch (InterruptedException e) {
				e.printStackTrace();
		}
		
	}else {
		System.out.println(" Conseguiu fazer o Login");
	}
		}
   	}

