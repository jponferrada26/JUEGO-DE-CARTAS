package juegoDeCartas;

import juegoDeCartas.exceptions.*;
import utiles.*;

/**
 *Diseña e implementa un juego de cartas. Para ello, comienza implementando el juego de las siete y media.
 *Es opcional implementar otro juego. Recuerda que:
 *-A las siete y media se juega con una baraja española
 *-Pueden jugar tantos jugadores como se quiera.
 *-Al principio del juego se indicará el alias de los jugadores implicados. 
 *-Se podrá averiguar el número de partidas ganadas y perdidas por cada jugador.
 *-Se podrá mostrar el ranking de las partidas jugadas 
 *-Al iniciar cada partida se preguntará qué jugador juega y cuál no.
 *-Utiliza el método shuffle para barajar las cartas
 *
 *@author Javier Ponferrada López
 *@version 2.0
 * */
public class TestJuegoDeCartas {
	/**
	 * Menu que maneja o manipula los jugadores 
	 * */
	private static Menu menuManejoJugadores;
	/**
	 * Clase jugadores que maneja la lista de jugadores
	 * */
	static Jugadores jugadores = new Jugadores();
	/**
	 * Clase Participantes que maneja la lista de jugadores participantes
	 * */
	static Jugadores participantes = new Jugadores();
	
	public static void main(String[] args) {
		menuManejoJugadores = new Menu("---MENU-JUGADORES---",new String[]{"Añadir Jugador","Eliminar Jugador","Mostrar jugadores","Salir"});
		Menu menuGeneral = new Menu("---MENU-GENERAL---",new String[]{"Manipular Jugadores","Jugar","Salir"});
		int opcion;
		do{
			opcion=menuGeneral.gestionar();
			gestionarMenuGeneral(opcion);
		}while(opcion!=menuGeneral.getSALIR());
	}
	
	/**
	 * Gestiona el menu general
	 * @param opcion, elegida por el usuario
	 * */
	private static void gestionarMenuGeneral(int opcion) {
		switch(opcion){
		case 1:
			menuManejoJugadores();
			break;
		case 2: jugar();
			break;
		case 3:System.out.println("Hasta pronto.");
			break;
		}
	}
	
	/**
	 * gestiona las solicitudes del usuario para usar el menu de gestionar jugadores
	 * */
	private static void menuManejoJugadores() {
		int opcion;
		do{
			opcion=menuManejoJugadores.gestionar();
			gestionarMenuManejoJugador(opcion);
		}while(opcion!=menuManejoJugadores.getSALIR());
	}
	
	/**
	 * Gestiona el menu que maneja los jugadores
	 * @param opcion, elegida por el usuario
	 * */
	private static void gestionarMenuManejoJugador(int opcion) {
		switch(opcion){
		case 1:annadirJugador();
			break;
		case 2:eliminarJugador();
			break;
		case 3: System.out.println(jugadores.toString());
			break;
		case 4:
			break;
		}
		
	}
	
	/**
	 * Eliminar jugadores de la lista
	 * */
	private static void eliminarJugador() {
		try {
			System.out.println(jugadores.toString());
			jugadores.borrar(Teclado.leerCadena("Nombre:"));//indica el nombre del jugador que se desea borrar
		} catch (JugadorNoExisteException | NombreNoValidoException e) {
			System.out.println(e.getMessage());
		}

	}

	/**
	 * ñadir un jugador a la lista
	 * */
	private static void annadirJugador() {
		try {
			jugadores.annadir(Teclado.leerCadena("Nombre:"));//indica el nombre del jugador que se desea añadir
		} catch (NombreNoValidoException | JugadorYaExisteException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Jugar
	 * */
	private static void jugar() {
			//PARTIDA
			Partida partida=null;
			try {
				eleccionJugadores();//eleccion de jugadores a jugar
				partida = new Partida(participantes);//creamos partida con los jugadores elegidos
				partida.jugar();
				
			} catch (ListaVaciaException | NoExistenCartasException e) {
				System.out.println(e.getMessage());
			}finally {
				participantes.clear();
				jugadores.ordenarJugadores();
			}
		
	}
	

	/**
	 *Eleccion de jugadores a jugar
	 * @throws ListaVaciaException
	 * */
	private static void eleccionJugadores() throws ListaVaciaException{
		if(jugadores.sizeJugadores()>=2){//la lista de jugadores debe ser superior a 1 para poder añadirlos a la lista de participantes
			do{
				
				System.out.println(jugadores.toString()+"\n"+"---MAS DE 1 JUGADOR---");
					try {
						jugadorAJugar(Teclado.leerCadena("Nombre:"));//nombre de los jugadores que jugaran en la partida
					} catch (NombreNoValidoException | JugadorYaExisteException | JugadorNoExisteException e) {
						System.out.println(e.getMessage());
					}
				
			}while(DeseaContinuar.deseaContinuar("¿Otro Jugador?(s/n)") || jugadores.sizeJugadores()<2);
		}else
			throw new ListaVaciaException("La lista debe contener > 1 jugadores");
	}

	
	/**
	 *Jugador que se desea que juegue y por lo tonato se annade a la lista de participantes
	 * @throws NombreNoValidoException 
	 * @throws JugadorYaExisteException 
	 * @throws JugadorNoExisteException 
	 * @param nombre, del jugador a annadir a la lista de participantes
	 * */
	static void jugadorAJugar(String nombre) throws NombreNoValidoException, JugadorYaExisteException, JugadorNoExisteException{
		if(jugadores.contains(nombre)&&!participantes.contains(nombre))
			participantes.volcarJugadorALista(jugadores.get(jugadores.indexOf(nombre)));
		else if(!jugadores.contains(nombre))
			throw new JugadorNoExisteException("Jugador no existe en la lista.");
		else
			throw new JugadorYaExisteException("Jugador ya existe.");
			
	}
}
