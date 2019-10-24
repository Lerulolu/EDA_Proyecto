package packModelo;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoubleLinkedList<T> implements ListADT<T> {

	// Atributos
	protected Node<T> first; 	// apuntador al primero
	protected String descr;		// descripción
	protected int count;		// numero de elementos
	
	// Constructor
	public DoubleLinkedList() {
		first = null;
		descr = "";
		count = 0;
	}
	
	public void setDescr(String nom) {
	  descr = nom;
	}

	public String getDescr() {
	  return descr;
	}

	public T removeFirst() {
	// Elimina el primer elemento de la lista
    // Precondición: la lista tiene al menos un elemento
	// COMPLETAR EL CODIGO Y CALCULAR EL COSTE
		T t = first.data;
		if(first.next == first)
		{
			first = null;
		}
		else
		{
			first.next.prev = first.prev;
			first.prev.next = first.next;
			first = first.next;
		}
		count--;
		return t;

	}

	public T removeLast() {
	// Elimina el último elemento de la lista
	// Precondición: la lista tiene al menos un elemento
	// COMPLETAR EL CODIGO Y CALCULAR EL COSTE
		
		T t = null;
		if(first.next == first) //Solo un elemento
		{
			t = first.data;
			first = null;
		}
		else
		{
			t = first.prev.data;
			first.prev.prev.next = first;
			first.prev = first.prev.prev;
			
		}
		count--;
		return t;
	}


	public T remove(T elem) {
	//Elimina un elemento concreto de la lista
	// COMPLETAR EL CODIGO Y CALCULAR EL COSTE
		
		Node<T> actual = first.next;
		T t = null;
		
		if(this.isEmpty())
		{
			return null;
		}
		else if(elem.equals(first()))
		{
			return removeFirst();
		}
		else if(elem.equals(last()))
		{
			return removeLast();
		}
		else
		{
			while(!actual.data.equals(elem) && !actual.data.equals(first)) //Al ser una lista circular, termina cuando se llega de nuevo al primero
			{
				actual = actual.next;
			}
			t = actual.data;
			actual.prev.next = actual.next;
			actual.next.prev = actual.prev;
			count--;
			return t;
		}
	}

	public T first() {
	//Da acceso al primer elemento de la lista
	      if (isEmpty())
	      {
	    	  return null;
	      }	          
	      else
	      {
	    	  return first.data;
	      }
	}

	public T last() {
	//Da acceso al último elemento de la lista
	      if (isEmpty())
	      {  
	          return null;
	      }
	      else if(first.prev == null)
	      {
	    	  return first.data;
	      }
	      else
	      {
    		  return first.prev.data;
	      }
	}

	public boolean contains(T elem) {
	//Determina si la lista contiene un elemento concreto
	// COMPLETAR EL CODIGO Y CALCULAR EL COSTE

		if (isEmpty())
		{
			return false;
		}
		else
		{
			Node<T> actual = first.next;
			boolean enc = false;
			
			//Es el primer elemento
			if(elem.equals(first()))
			{
				enc = true;
			}
			//Es el ultimo elemento
			else if(elem.equals(last()))
			{
				enc = true;
			}
			else
			{
				while (!actual.data.equals(elem))
				{
					if (actual.data.equals(last())) 
					{
						return false;
					}
					else
					{
						actual = actual.next;
					}
				}
				enc = true;
			}
			return enc;
		}
		      
	}

	public T find(T elem) {
	//Determina si la lista contiene un elemento concreto, y develve su referencia, null en caso de que no esté
	// COMPLETAR EL CODIGO Y CALCULAR EL COSTE
		if(isEmpty())
		{
			return null;
		}
		else if(elem.equals(first()))
		{
			return first();
		}
		else if(elem.equals(last()))
		{
			return last();
		}
		else
		{
			Node<T> actual = first.next;
			boolean enc = false;
			while (!actual.data.equals(elem))
			{
				if (actual.data.equals(last())) 
				{
					return null;
				}
				else
				{
					actual = actual.next;
				}
				
			}
			return actual.data;
		}
	}

	public boolean isEmpty() 
	//Determina si la lista está vacía
	{ 
		return first == null;
	}
	
	public int size() 
	//Determina el número de elementos de la lista
	{ 
		return count;
	}
	
	/** Return an iterator to the stack that iterates through the items . */ 
	public Iterator<T> iterator() 
	{ 
		return new ListIterator(); 
	} 

	// an iterator, doesn't implement remove() since it's optional 
	private class ListIterator implements Iterator<T> { 

		// COMPLETAR EL CODIGO Y CALCULAR EL COSTE
		private Node<T> actual;
		private int i;
		
		public ListIterator()
		{
			actual = first;
			i = 0;
		}

		@Override
		public boolean hasNext() 
		{
			return (i < count);
		}

		@Override
		public T next() 
		{
			if (!hasNext()) 
			{
				throw new NoSuchElementException();
			}
			T elem = actual.data;
			actual = actual.next;
			i++;
			return elem;
		}
		
		public void remove() 
		{
			throw new UnsupportedOperationException();
		}

	} // private class
		
		
    public void visualizarNodos() 
    {
    	System.out.println(this.toString());
	}

	@Override
	public String toString() {
		String result = new String();
		Iterator<T> it = iterator();
		while (it.hasNext()) {
			T elem = it.next();
			result = result + "[" + elem.toString() + "] \n";
		}	
		return "SimpleLinkedList \n[" + result + "]";
	}

}
