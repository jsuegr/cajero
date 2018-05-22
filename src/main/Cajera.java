package main;

public class Cajera extends Thread {

	private String nombre;
	
	private Cliente cliente;
	
	private long initialTime;
	
	public Cajera(String nombre, Cliente cliente, long initialTime) {
		this.nombre = nombre;
		this.cliente = cliente;
		this.initialTime = initialTime;
	}

	public Cajera(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public long getInitialTime() {
		return initialTime;
	}

	public void setInitialTime(long initialTime) {
		this.initialTime = initialTime;
	}
	
	@Override
	public void run(){
		StringBuilder mensajeProceso= new StringBuilder();
		mensajeProceso.append("La cajera ").append(this.nombre).append(" ha comenzado a realizar el cobro de la compra del cliente")
			.append(cliente.getNombre()).append(" en el tiempo ").append(String.valueOf((System.currentTimeMillis()-initialTime)/1000)).append(" seg");
		
		System.out.println(mensajeProceso.toString());
		
		for(int i = 0; i<cliente.getCarroCompra().length;i++){
			mensajeProceso = new StringBuilder();
			this.esperarXsegundos(cliente.getCarroCompra()[i]);
			mensajeProceso.append("Procesando el producto").append(i+1).append(" --> Tiempo: ")
			.append((System.currentTimeMillis()-initialTime)/1000).append("seg. ");
			System.out.println(mensajeProceso.toString());
		}
		mensajeProceso = new StringBuilder();
		mensajeProceso.append("La cajera ").append(this.getNombre()).append(" ha terminado de procesar ")
			.append(cliente.getNombre()).append(" en el tiempo").append((System.currentTimeMillis()-initialTime)/1000).append(" seg.");
		System.out.println(mensajeProceso.toString());
		
	}

	@SuppressWarnings("null")
	public void procesarCompra(Cliente cliente, long timeStamp){
		StringBuilder mensajeProceso= new StringBuilder();
		mensajeProceso.append("La cajera ").append(this.nombre).append(" ha comenzado a realizar el cobro de la compra del cliente")
			.append(cliente.getNombre()).append(" en el tiempo ").append(String.valueOf((System.currentTimeMillis()-timeStamp)/1000)).append(" seg");
		
		System.out.println(mensajeProceso.toString());
		
		for(int i = 0; i<cliente.getCarroCompra().length;i++){
			mensajeProceso = new StringBuilder();
			this.esperarXsegundos(cliente.getCarroCompra()[i]);
			mensajeProceso.append("Procesando el producto").append(i+1).append(" --> Tiempo: ")
			.append((System.currentTimeMillis()-timeStamp)/1000).append("seg. ");
			System.out.println(mensajeProceso.toString());
		}
		mensajeProceso = new StringBuilder();
		mensajeProceso.append("La cajera ").append(this.getNombre()).append(" ha terminado de procesar ")
			.append(cliente.getNombre()).append(" en el tiempo").append((System.currentTimeMillis()-timeStamp)/1000).append(" seg.");
		System.out.println(mensajeProceso.toString());
	
	}
	
	/**
	 * @param segundos
	 */
	private void esperarXsegundos(int segundos){
		try {
			Thread.sleep(segundos*1000);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
}
