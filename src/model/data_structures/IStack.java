package model.data_structures;

public interface IStack<Item> extends Iterable<Item>
{
	/**
	 * Retorna true si la pila esta vacia
	 * @return true si la pila esta vacia, false de lo contrario
	 */
	public boolean isEmpty();
	
	/**
	 * Retorna ek numero de elementos contenidos
	 * @return retorna el numero de elementos contenidos 
	 */
	public int size();
	
	/**
	 * Inserta un nuevo elemento en la pila
	 * @param item el nuevo elemento que se va a agregar
	 */
	public void push(Item item);
	
	/**
	 * Quita y retorna el elemento agregado mas reciente
	 * @return el elemento agregado mas reciente
	 */
	public Item pop();
}
