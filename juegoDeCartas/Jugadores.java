package juegoDeCartas;


import java.util.ArrayList;
import java.util.Collections;

import juegoDeCartas.exceptions.JugadorNoExisteException;
import juegoDeCartas.exceptions.JugadorYaExisteException;
import juegoDeCartas.exceptions.NombreNoValidoException;

/**
 * @author Javier Ponferrada López
 * @version 2.0
 * */
public class Jugadores {
	/**
	 * Lista de todos jugadores
	 * */
	private ArrayList<Jugador> jugadores = new ArrayList<Jugador>();

	/**
	 * Annadir un jugador a la lista de jugadores
	 * @throws NombreNoValidoException 
	 * @throws JugadorYaExisteException 
	 * @param nombre, del jugador que se desea annadir a la lista de jugadores
	 * */
	void annadir(String nombre) throws JugadorYaExisteException, NombreNoValidoException{
		Jugador jugador = new Jugador(nombre);
		if(jugadores.contains(jugador))
			throw new JugadorYaExisteException("El jugador Ya se encuentra en la lista.");
		jugadores.add(jugador);
		
			
	}
	
	/**
	 * Eliminar un jugador de la lista de jugadores
	 * @throws NombreNoValidoException 
	 * @throws JugadorNoExisteException 
	 * @param nombre, del jugador que se desea borrar
	 * */
	void borrar(String nombre) throws JugadorNoExisteException, NombreNoValidoException{
		Jugador jugador = new Jugador(nombre);
		if(!jugadores.remove(jugador))
			throw new JugadorNoExisteException("No se ha podido borrar.");
	}
	
	
	/**
	 * toString String de la lista de jugadores
	 * @return ToString
	 * */
	public String toString() {
		StringBuilder cadena = new StringBuilder("----JUGADORES----\n");
		for (int i=0; i<size();i++) {
			cadena.append((i+1)+"-NOM="+jugadores.get(i).getNombre()+",PAJ="+jugadores.get(i).getPartidaJugadas()+",PAG="+jugadores.get(i).getPartidasGanadas()+",PAP="+jugadores.get(i).getPartidasPerdidas()+"\n");
		}
		return cadena.toString();
			
	}
	
	/**
	 * Obtiene el tamanio de la lista de jugadores
	 * @return tamanio de la lista de jugadores
	 * */
	int sizeJugadores(){
		return jugadores.size();
	}
	
	/**
	 * Comprobar si esta vacia la lista de jugadores
	 * @return si esta vacia o no la lista de jugadores
	 * */
	boolean isEmptyJugadores(){
		return jugadores.isEmpty();
	}
	
	/**
	 * Comprobar si contiene el jugador en la lista
	 * @return si contiene el jugador en la lista
	 * @param jugador,nombre de jugador
	 * */
	boolean contains(String jugador) throws NombreNoValidoException {
		return jugadores.contains(new Jugador(jugador));
	}
	
	/**
	 * Obtener el indice del jugador que existe en la lista
	 * @return la posicion del jugador en la lista
	 * @param nombre, del jugador
	 * */
	int indexOf(String nombre) throws NombreNoValidoException {
		return jugadores.indexOf(new Jugador(nombre));
	}
	
	/**
	 * @return jugador de la posicion indicada
	 * @param posicion, del jugador
	 * */
	Jugador get(int posicion) {
		return jugadores.get(posicion);
	}
	
	/**
	 * Volcar el objeto jugador a la lista de jugadores
	 * @param jugador a annadir
	 * */
	void volcarJugadorALista(Jugador jugador) throws JugadorYaExisteException{
		if(jugadores.contains(jugador))
			throw new JugadorYaExisteException("El jugador Ya se encuentra en la lista.");
		jugadores.add(jugador);
			
	}
	
	/**
	 * Ordenar la lista de jugadores por el numero de partidas ganadas
	 * */
	void ordenarJugadores(){
		Collections.sort(jugadores);
	}
	
	/**
	 * Vaciar la lista de jugadores
	 * */
	void clear(){
		jugadores.clear();
	}

	/**
	 * @return tamanio de la lista de jugadores
	 * */
	public int size() {
		return jugadores.size();
	}

}
