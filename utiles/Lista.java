package listadoEstructuraDatos2Ejercicio3v2;

import java.util.*;

import utiles.Teclado;

/**
 * 3. Entrega la clase Lista que:
 * <ul>
 * <li>a.AnÌƒada al final de la lista</li>
 * <li>b.Inserte un elemento en una determinada posicioÌ�n</li>
 * <li>c.Modifique un elemento reemplazaÌ�ndolo por otro</li>
 * <li>d.Conozca el tamanÌƒo de la lista</li>
 * <li>e.Elimine elementos de la lista</li>
 * <li>f.Busque elementos en la lista</li>
 * <li>g.Copie la lista</li> Utiliza en un ejemplo TestLista (por ejemplo, la
 * elineacion de un equipo de futbol, con titulares y reservas) Y entregalo
 * correctamente identificado y documentado, incluye JavaDoc.
 *
 * Deberas implementar un menu con las opciones posibles para que el usuario lo
 * utilice facilmente.
 * 
 * @author Javier Ponferrada Lopez
 * @version 1.0
 */
public class Lista<E> {
	private ArrayList<E> arraylist = new ArrayList<E>();

	/**
	 * Constructor
	 * 
	 * @param arrayList,
	 *            Arraylist que desea utilizar los metodos de esta plantilla
	 */
	Lista(ArrayList<E> arrayList) {
		if (arrayList == null)
			arraylist = new ArrayList<E>();
		setArraylist(arrayList);
	}

	/**
	 * GET ArrayList
	 */
	ArrayList<E> getArraylist() {
		return arraylist;
	}

	/**
	 * SET ArrayList
	 */
	private void setArraylist(ArrayList<E> arraylist) {
		this.arraylist = arraylist;
	}

	/**
	 * AÃ±adir nuevo elemento al final de la lista
	 * 
	 * @param elemento,
	 *            que deseamos anadir al final de la lista
	 */
	void add(E elemento) {
		getArraylist().add(elemento);
	}

	/**
	 * Insertar elemento en una posicion determinada sin aplastar el elemento
	 * que se se encuentrara en el mismo
	 * 
	 * @param elemento,
	 *            elemento que deseamos anadir a la lista
	 * @param posicion,
	 *            la en la que quieres anadir dicho elemento
	 */
	boolean add(E elemento, int posicion) {
		if (posicion < 0 || posicion > size())
			return false;
		getArraylist().add(posicion, elemento);
		return true;
	}

	/**
	 * reeemplazar un elemento de la lista por uno que indiquemos
	 * 
	 * @param elemSuplantar,
	 *            elemento que desea suplantar el usuario
	 * @param elemento,
	 *            elemento por el que quiere suplantarlo.
	 */
	E reemplazar(E elemSuplantar, E elemento) {
		int indice = getArraylist().indexOf(elemSuplantar);
		if (indice == -1)
			return null;
		return getArraylist().set(indice, elemento);

	}
	
	/**
	 * Longitud de la lista
	 * 
	 * @return longitud de la lista
	 */
	int size() {
		return getArraylist().size();
	}

	/**
	 * Borrar un elemento de la lista
	 * 
	 * @param eliminar,
	 *            elemento a eliminar
	 */
	void borrarElemento(E eliminar) {
		getArraylist().remove(eliminar);
	}
	
	/**
	 * Buscar y demostrar si existe el elemento
	 * @param elemento, elemento que deseamos buscar para comprobar si existe en la lista
	 * @return si existe o no el elemento.
	 * */

	/**
	 * Buscar y demostrar si existe el elemento
	 * 
	 * @param elemento,
	 *            elemento que deseamos buscar para comprobar si existe en la
	 *            lista
	 * @return si existe o no el elemento.
	 */
	Object buscaElementos(Object elemento) {
		if (arraylist.contains(elemento))
			return getArraylist().get(indexOf(elemento));
		return null;
	}


	/**
	 * COPIA DE UN ARRAYLIST
	 * 
	 * @return copia de la lista.
	 */
	Object copiaLista() {
		return getArraylist().clone();
	}

	/**
	 * Mostrar la lista
	 * 
	 * @return la lista
	 */
	String mostrar() {
		StringBuilder cadena = new StringBuilder();
		cadena.append("------LISTA ALINEACION-----\n");
		for (Object elemento : getArraylist()) {
			cadena.append(elemento + "\n");
		}
		return cadena.toString();
	}

	int indexOf(Object elemento) {
		return getArraylist().indexOf(elemento);
	}
}
