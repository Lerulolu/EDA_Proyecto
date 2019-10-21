package packPruebas;

import java.util.Iterator;
import packModelo.UnorderedDoubleLinkedList;;


public class PruebaDoubleLinkedList {
	
	public static void visualizarNodos(UnorderedDoubleLinkedList<Integer> l) {
		Iterator<Integer> it = l.iterator();
		System.out.println();
		while (it.hasNext()) {
			Integer num = it.next();
			System.out.println(num);
		}
	}
	
	
	public static void main(String[] args)  {
		
		UnorderedDoubleLinkedList<Integer> l = new UnorderedDoubleLinkedList<Integer>();
		l.addToRear(1);
		l.addToRear(3);
		l.addToRear(6);
		l.addToRear(7);
		l.addToRear(9);
		l.addToRear(0);
		l.addToRear(20);
		
		l.addToFront(8);
		
		l.remove(new Integer(7));

		
		System.out.print(" Lista ...............");
		visualizarNodos(l);
		System.out.println("Num elementos: " + l.size());
		System.out.println("");

		System.out.println("Prueba RemoveFirst ...............");
		l.removeFirst();
		System.out.println(" Num elementos 7?: " + l.size());
		visualizarNodos(l);
		
		l.addToFront(8);
		System.out.println("");
		
		System.out.println("Prueba RemoveLast ...............");
		l.removeLast();
		System.out.println(" Num elementos 7?: " + l.size());
		visualizarNodos(l);
		
		l.addToRear(20);
		System.out.println("");
		
		System.out.println("Prueba Remove ...............");
		System.out.println("Remove 8");
		l.remove(8);
		visualizarNodos(l);
		System.out.println("");

		System.out.println("Remove 20");
		l.remove(20);
		visualizarNodos(l);
		System.out.println("");

		System.out.println("Remove 9");
		l.remove(9);
		visualizarNodos(l);
		System.out.println(" Num elementos 4?: " + l.size());

		
		l.addToFront(8);
		l.addToRear(20);
		System.out.println("");
				
		System.out.println("Prueba AddAfter ...............");
		System.out.println("Add 15 After 6");
		l.addAfter(15, 6);
		visualizarNodos(l);
		
		System.out.println("");
		
		System.out.println("Prueba Find ...............");
		System.out.println("8? " + l.find(8));
		System.out.println("0? " + l.find(0));
		System.out.println("7? " + l.find(7));
		System.out.println("20? " + l.find(20));

		System.out.println("");

		System.out.println("Prueba Contains ...............");
		System.out.println("8, True? " + l.contains((8)));
		System.out.println("0, True? " + l.contains((0)));
		System.out.println("7, False? " + l.contains((7)));
		System.out.println("20, True? " + l.contains((20)));

		System.out.println("");

	}
}
