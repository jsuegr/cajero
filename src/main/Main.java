package main;

public class Main {

	public static void main(String[] args){
		Cliente cliente1 = new Cliente("cliente 1",new int[] {1,4,5,6,3,10});
		Cliente cliente2 = new Cliente("cliente 2", new int[] {6,3,9,1,7});
		
//		Cajera cajera1 = new Cajera("cajera 1");
//		Cajera cajera2 = new Cajera("cajera 2");
		
		//timepo inicial de referencia
		long initialTime = System.currentTimeMillis();
	
//		cajera1.procesarCompra(cliente1, initialTime);
//		cajera2.procesarCompra(cliente2, initialTime);
		
		Cajera cajera1 = new Cajera("Cajera1", cliente1, initialTime);
		Cajera cajera2 = new Cajera("Cajera2", cliente2, initialTime);
		
		cajera1.start();
		cajera2.start();
	}
}
