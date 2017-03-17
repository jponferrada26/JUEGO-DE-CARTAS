package juegoDeCartas;

import java.util.regex.Pattern;

import juegoDeCartas.exceptions.NombreNoValidoException;
/**
 * @author Javier Ponferrada López
 * @version 2.0
 * */
public class Jugador implements Comparable<Jugador>{
	/**
	 * nombre del jugador
	 * */
	private String nombre;
	/**
	 * partidas jugadas por el jugador
	 * */
	private int partidaJugadas;
	/**
	 * partidas ganadas por el jugador
	 * */
	private int partidasGanadas;
	/**
	 * partidas perdidas por el jugador
	 * */
	private int partidasPerdidas;
	/**
	 * puntuacion obtenida y usada en cada ronda
	 * */
	private double puntuacion;
	/**
	 * numero de veces que se repite el jugador en el RANKING DE RONDAS
	 * */
	private int numRepeticiones;
	/**
	 * patron para validar el nombre del jugador
	 * */
	private Pattern patronNombre = Pattern.compile("([a-zA-Z\\dáéíóúÁÉÍÓÚüöÖÜ]\\s?){2,}");
	/**
	 * Constructor de Jugador
	 * @param nombre,del jugador.
	 * @throws NombreNoValidoException 
	 * @param nombre, del jugador
	 * */
	Jugador(String nombre) throws NombreNoValidoException {
		setNombre(nombre);
		setPartidaJugadas(0);
		setPartidasGanadas(0);
		setPartidasPerdidas(0);
		setPuntuacion(0);
	}
	
	/**
	 * Incrementar las partidas jugadas
	 * */
	void incrementarPartidasJugadas(){
		setPartidaJugadas(getPartidaJugadas()+1);
	}
	
	/**
	 * Incrementar las partidas Ganadas
	 * */
	void incrementarPartidasGanadas(){
		setPartidasGanadas(getPartidasGanadas()+1);
	}
	
	/**
	 * Incrementar las partidas Perdidas
	 * */
	void incrementarPartidasPerdidas(){
		setPartidasPerdidas(getPartidasPerdidas()+1);
	}
	
	/**
	 * Incrementar puntos al jugador
	 * */
	void incremenrarPuntuacion(double puntuacion){
		setPuntuacion(getPuntuacion()+puntuacion);
	}
		
	/**
	 * @return nombre del jugador.
	 * */
	String getNombre() {
		return nombre;
	}

	/**
	 * Asignamos el nombre al jugador
	 * @param nombre, a asignar al jugador.
	 * @throws NombreNoValidoException 
	 * */
	private void setNombre(String nombre) throws NombreNoValidoException {
		if(!patronNombre.matcher(nombre).matches())
			throw new NombreNoValidoException("Nombre incorrecto.");
		this.nombre = nombre;
	}

	/**
	 * @return partidas jugadas
	 * */
	int getPartidaJugadas() {
		return partidaJugadas;
	}

	/**
	 * Asigna las partidas jugadas
	 * @param partidaJugadas, a asignar al jugador
	 * */
	private void setPartidaJugadas(int partidaJugadas) {
		this.partidaJugadas = partidaJugadas;
	}



	/**
	 * @return partidas ganadas
	 * */
	int getPartidasGanadas() {
		return partidasGanadas;
	}



	/**
	 * Asignamos a partidas ganadas de jugador
	 * @param partidasGanadas, a asignar al jugador
	 * */
	private void setPartidasGanadas(int partidasGanadas) {
		this.partidasGanadas = partidasGanadas;
	}
	
	/**
	 * @return partidas perdidas
	 * */
	int getPartidasPerdidas() {
		return partidasPerdidas;
	}
	
	/**
	 * Asignamos a partidas perdidas al jugador
	 * @param partidasPerdidas, a asignar al jugador
	 * */
	private void setPartidasPerdidas(int partidasPerdidas) {
		this.partidasPerdidas = partidasPerdidas;
	}
	
	/**
	 * @return puntuacion del jugador en la ronda actual
	 * */
	double getPuntuacion() {
		return puntuacion;
	}
	
	/**
	 * @param puntuacion, a asignar al jugador
	 * */
	private void setPuntuacion(double puntuacion) {
		this.puntuacion = puntuacion;
	}
	
	/**
	 * Limpiar los puntos acumulados sobre la ronda
	 * */
	void limpiarPuntos(){
		setPuntuacion(0);
	}
	
	/**
	 * Limpiar las repeticiones del usuario en el ranking de rondas
	 * */
	void limpiarRepeticiones(){
		setNumRepeticiones(0);
	}
	
	/**
	 * @return numero de veces que el usuario se ha repetido en la ronda
	 * */
	int getNumRepeticiones() {
		return numRepeticiones;
	}
	
	/**
	 * @param numRepeticiones, a asignar al jugador
	 * */
	private void setNumRepeticiones(int numRepeticiones) {
		this.numRepeticiones = numRepeticiones;
	}
	
	/**
	 * Incrementar el numero de repeticiones en el ranking en +1
	 * */
	void incrementarNumRepeticiones(){
		setNumRepeticiones(getNumRepeticiones()+1);
	}
	
	/**
	 * Compara los jugadores para ordenarlos
	 * */
	@Override
	public int compareTo(Jugador jugador){
		int comparepg = ((Jugador) jugador).getPartidasGanadas();
		return comparepg - this.getPartidasGanadas();
	}
	
	/**
	 * Comprobar que el jugador es el mismo, tomando en cuenta el nombre del mismo
	 * */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jugador other = (Jugador) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equalsIgnoreCase(other.nombre))
			return false;
		return true;
	}
}
