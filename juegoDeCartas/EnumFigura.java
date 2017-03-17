package juegoDeCartas;
/**
 * Enumerador de Figura
 * @author Javier Ponferrada López
 * @version 2.0
 * */
enum EnumFigura {
	AS(1.0),
	DOS(2.0),
	TRES(3.0),
	CUATRO(4.0),
	CINCO(5.0),
	SEIS(6.0),
	SIETE(7.0),
	SOTA(0.5),
	CABALLO(0.5),
	REY(0.5);
	
	/**
	 * @return valor de la figura
	 * */
	private double valor;
	
	/**
	 * @param valor de la figura
	 * */
	private EnumFigura(double valor) {
		setValor(valor);
	}
	
	/**
	 * @return valor de la figura
	 * */
	public double getValor() {
		return valor;
	}
	
	/**
	 * @param valor de la figura a sustituir por el actual de la clase
	 * */
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	
}
