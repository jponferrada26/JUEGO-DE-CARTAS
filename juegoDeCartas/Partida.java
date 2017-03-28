package juegoDeCartas;

import juegoDeCartas.exceptions.NoExistenCartasException;
import utiles.DeseaContinuar;

/**
 * @author Javier Ponferrada López
 * @version 2.0
 * */
public class Partida {
	/**
	 * lista de jugadores o particiapantes
	 * */
	private Jugadores listaJugadores;
	
	/**
	 * Baraja de las 40 cartas españolas
	 * */
	private Baraja baraja;

	/**
	 * Ganador de la partida
	 * */
	private Jugador ganadorPartida;
	
	/**
	 * Posicion del jugador que le toca
	 * */
	private int jugador;
	
	/**
	 * Constructor de partida
	 * @param jugadores,lista de jugadores a jugar
	 * */
	public Partida(Jugadores jugadores) {
		listaJugadores = jugadores;	
		baraja =  new Baraja();
	}
	
	/**
	 * Scar carta de la baraja
	 * @throws NoExistenCartasException
	 * @return carta generada.
	 * */
	private Carta sacarCarta() throws NoExistenCartasException{
		return baraja.sacarCarta();
	}
	
	
	/**
	 * Comprobar si el jugador puede seguir jugando, tomando en cuenta su puntuacion
	 * @return si se le permite seguir o no
	 * */
	boolean sigueJugando(){
		if(listaJugadores.get(jugador).getPuntuacion()<=7.5)
			return true;
		else 
			return false;
	}
	
	
	/**
	 * Altera el turno del jugador pasando al siguiente turno
	 * @return si es posible o no pasar al siguiente jugador
	 * */
	public boolean siguienteJugador(){
		if(jugador<listaJugadores.size()-1){
			this.jugador++;
			return true;
		}else
			return false;
	
	}
	
	/**
	 * Volver a empezar poniendo el turno de los jugadores a 0
	 * */
	void volverAEmpezar(){
		this.jugador=0;
	}
	
	/**
	 * Puntos del jugador
	 * @return puntos actuales del jugador 
	 * */
	double puntosDelJugador(){
		return listaJugadores.get(this.jugador).getPuntuacion();
	}
	
	/**
	 * Jagar la partida
	 * @throws NoExistenCartasException
	 * */
	void jugar() throws NoExistenCartasException {
		do {
			volverAEmpezar();//volver a empezar el turno del jugador
			limpiarPuntos();//Limpia los puntos de los jugadores para ponerlos a cero
			do {
				do {
					listaJugadores.get(jugador).incremenrarPuntuacion(sacarCarta().getValor());//se encarga de que el jugador al que le toque, tire carta e incremente su puntuacion
					
					System.out.println("Jugado: " + jugando() + " " + puntosDelJugador() + " puntos");

				} while (DeseaContinuar.deseaContinuar("Otra carta? (s/n)") && sigueJugando());//si desea otra carta o si se le permite seguir jugando

			} while (siguienteJugador());//comprueba si existe otro jugador en la lista de participantes y pasa al siguiente turno(jugador)

			hallarElGanador();//halla el ganador de la ronda y por lo tanto cambia el estado de partida.
			reCuento();//Altera el estado de los jugadores
			if(getGanador()!=null)
				System.out.println("GANADOR PARTIDA=> "+getGanador().getNombre());
		} while (DeseaContinuar.deseaContinuar("Quieres otra patida?-Mismos jugadores-(s/n)"));
		

	}
	
	
	/**
	 * Hallar el ganador de la partida
	 * */
	public void hallarElGanador(){
		boolean empate=false;
		double puntuacion=0;
		int posicion=-1;
		for (int i = 0; i < listaJugadores.size(); i++) {//halla el ganador y lo asigna al objeto Jugador y/o JugadorEmpleado

			if(listaJugadores.get(i).getPuntuacion()>puntuacion&&listaJugadores.get(i).getPuntuacion()<=7.5){//Si el jugador actual tiene mas puntuacion que el anterior sin pasarse
				posicion=i;
				puntuacion=listaJugadores.get(i).getPuntuacion();
			}else if(listaJugadores.get(i).getPuntuacion()==puntuacion&&listaJugadores.get(i).getPuntuacion()<=7.5){//si eciste un empate y no se han pasado
				posicion=i;
				empate=true;
				puntuacion=listaJugadores.get(i).getPuntuacion();
			}
				
		}
		if(posicion==-1)//si el jugadorGanador se encuentra a null no ha ganado nadie
			System.out.println("No ha ganado nadie");
		else if(empate){//si el jugadorEmpatado no se encuentra a null significa que hay un empate
			setGanadorPartida(listaJugadores.get(posicion));
			System.out.println("Existe empate(ha ganado el primero que tiro)");
		}else
			setGanadorPartida(listaJugadores.get(posicion));

		
		
	}
	

	
	/**
	 * @return nombre del jugador que se encuentra jugando
	 * */
	public String jugando() {
		return listaJugadores.get(jugador).getNombre();
	}
	

	/**
	 * @return ganador de la partida actual
	 * */
	Jugador getGanador() {
		return ganadorPartida;
	}

	/**
	 * @param ganadorPartida, actual
	 * */
	private void setGanadorPartida(Jugador ganadorPartida) {
		this.ganadorPartida = ganadorPartida;
	}
	
	/**
	 * Limpiar contador de puntos de todos los jugadores
	 * */
	void limpiarPuntos(){
		for (int i = 0; i < listaJugadores.size(); i++) {
			listaJugadores.get(i).limpiarPuntos();
		}
	}
	

	/**
	 * Recuento y asignacion de estados a los jugadores
	 * altera el estado de los jugadores (partidasJugadas,partidasGanadas,partidasPerdidas)
	 * */
	public void reCuento() {
		for (int i = 0; i < listaJugadores.size(); i++) {
			listaJugadores.get(i).incrementarPartidasJugadas();
			if(listaJugadores.get(i)==getGanador())
				listaJugadores.get(i).incrementarPartidasGanadas();
			else
				listaJugadores.get(i).incrementarPartidasPerdidas();
		}
		
	}

}
