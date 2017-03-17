package juegoDeCartas;
/**
 * La carta que constara de un palo y una figura.
 * @author Javier Ponferrada López
 * @version 2.0
 * */
public class Carta {
	/**
	 * Enumerador que constara de las figuras
	 * */
	public EnumFigura figura;
	/**
	 * Enumerador que constara de los palos
	 * */
	public EnumPalo palo;
	
	/**
	 * Constructor que asignara a cada uno de los palos y figuras su valor correspondiente dependiendo de la carta generada.
	 * @param palo, palo generado al sacar carta
	 * @param figura, figura generada al sacar carta
	 * */
	Carta(EnumPalo palo,EnumFigura figura){
		setPalo(palo);
		setFigura(figura);
	}
	
	/**
	 * @return Enumerador de figura
	 * */
	public EnumFigura getFigura() {
		return figura;
	}
	
	/**
	 * @param Enumerador de figura que queremos asignar al enumerador actual en la clase
	 * */
	private void setFigura(EnumFigura figura) {
		this.figura = figura;
	}
	
	/**
	 * @return Enumerador de palo
	 * */
	public EnumPalo getPalo() {
		return palo;
	}
	
	/**
	 * @param Enumerador de Palo que queremos asignar al enumerador actual en la clase
	 * */
	private void setPalo(EnumPalo palo) {
		this.palo = palo;
	}
	
	/**
	 * @return valor de la carta
	 * */
	double getValorCarta(){
		return getFigura().getValor();
	}
	
	/**
	 *@return toString de la carta
	 * */
	public String toString() {
		return "[" + figura + " de " + palo + "]";
	}
}
