package packModelo;

public class OrderedDoubleLinkedList<T> extends DoubleLinkedList<T> implements OrderedListADT<T> {
	
	public void add(T elem)
	{
		// COMPLETAR EL CODIGO Y CALCULAR EL COSTE
		Node<T> nuevo = new Node<T>(elem);
		Comparable comparador = (Comparable) elem;
		
		if(isEmpty())
		{
			first = nuevo;
			first.next = first;
			first.prev = first;
		}
		else if(comparador.compareTo(first.prev.data) >= 0) //mayor que toda la lista --> last
		{
			nuevo.next = first;
			nuevo.prev = first.prev;
			first.prev.next = nuevo;
			first.prev = nuevo;
		}
		else if(comparador.compareTo(first.data) <= 0) //menor que toda la lista --> first
		{
			nuevo.prev = first.prev;
			nuevo.next = first;
			first.prev.next = nuevo;
			first.prev = nuevo;
			first = nuevo;
		}
		else //en el medio
		{
			Node<T> actual = first;
			while(comparador.compareTo(actual.data) > 0)
			{
				actual = actual.next;
			}
			nuevo.prev = actual;
			nuevo.next = actual.next;
			actual.next.prev = nuevo;
			actual.next = nuevo;
		}
		count++;
	}

	//No lo necesitamos, porque añadimos el elemento en el orden que le corresponde
	public void merge(DoubleLinkedList<T> zerrenda){



	}


}
