package juegoDeCartas.exceptions;
/**
 * EXCEPCION No existen cartas en la baraja
 * */
public class NoExistenCartasException extends Exception {
	public NoExistenCartasException(String msg) {
		super(msg);
	}
}
