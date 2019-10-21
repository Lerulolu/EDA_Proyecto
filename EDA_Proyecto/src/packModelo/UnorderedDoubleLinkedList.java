package packModelo;

public class UnorderedDoubleLinkedList<T> extends DoubleLinkedList<T> implements UnorderedListADT<T> {
	
	public void addToFront(T elem) 
	{
	// añade un elemento al comienzo
	// COMPLETAR EL CODIGO Y CALCULAR EL COSTE
		Node<T> nuevo = new Node<T>(elem);
		if(isEmpty())
		{
			first = nuevo;
			first.next = first;
			first.prev = first;
		}
		else
		{
			nuevo.prev = first.prev;
			nuevo.next = first;
			first.prev.next = nuevo;
			first.prev = nuevo;
			first = nuevo;
		}
		count++;
	}

	public void addToRear(T elem) 
	{
	// añade un elemento al final 
	// COMPLETAR EL CODIGO Y CALCULAR EL COSTE
		Node<T> nuevo = new Node<T>(elem);
		if(isEmpty())
		{
			first = nuevo;
			first.next = nuevo;
			first.prev = nuevo;
		}
		else
		{
			Node<T> last = first.prev;
			nuevo.next = first;
			nuevo.prev = last;
			last.next = nuevo;
			first.prev = nuevo;

		}
		count++;

	}
	
	public void addAfter(T elem, T target) 
	{
	// Añade elem detrás de otro elemento concreto, target,  que ya se encuentra en la lista
	// ¡COMPLETAR OPCIONAL!
		Node<T> nuevo = new Node<T>(elem);
		//Solo hay un elemento
		if(size() == 1)
		{
			nuevo.next = first;
			nuevo.prev = first;
			first.next = nuevo;
			first.prev = nuevo;
		}
		//El target es el ultimo elemento
		else if(last().equals(target))
		{
			addToRear(elem);
		}
		else
		{
			Node<T> actual = first;
			while (!actual.data.equals(target)) {
				actual = actual.next;
			}
			//Actual apunta al elemento tras el que hay que insertar elem
			nuevo.prev = actual;
			nuevo.next = actual.next;
			actual.next.prev = nuevo;
			actual.next = nuevo;

		}
		count++;
	}

}
