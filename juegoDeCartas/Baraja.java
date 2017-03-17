package juegoDeCartas;

import java.util.ArrayList;
import java.util.Collections;
import juegoDeCartas.exceptions.NoExistenCartasException;

/**
 * La baraja que contiene un vector de cartas.
 * 
 * @author Javier Ponferrada López
 * @version 2.0
 */
public class Baraja {
	/**
	 * Vector que almacena 40 cartas.
	 */
	private ArrayList <Carta> cartas = new ArrayList<Carta>();
	
	/**
	 * Constructor que rellena la baraja con todas las cartas que estan
	 * compuestas por un palo y una figura.
	 */
	Baraja() {
		for (EnumPalo palo : EnumPalo.values()) {
			for (EnumFigura figura : EnumFigura.values()) {
				cartas.add(new Carta(palo, figura));
			}
		}
		Collections.shuffle(cartas);
	}

	/**
	 * Saca una carta y se la asigna una posicion de otro vector para que dicha
	 * carta pueda ser dada como null(no se volvera a sacar) y de esta forma no
	 * repetir carta.
	 * 
	 * @return carta generada
	 * @throws NoExistenCartasException
	 */
	Carta sacarCarta() throws NoExistenCartasException {
		if (!cartas.isEmpty()) {	
				return cartas.remove(0);
		} else
			throw new NoExistenCartasException("La baraja no contiene mas cartas.");

	}
	

}
