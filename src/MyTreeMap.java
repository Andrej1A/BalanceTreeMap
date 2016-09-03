/*
    Copyright (C) 2016  Andrej Albrecht
 
    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
import java.util.*;
import java.util.Map.Entry;

public class MyTreeMap 
{
	class Node 
	{
		Comparable key;
		Object value;
		Node left;
		Node right;
		
		Node(Comparable key, Object value)
		{
	    	this.key = key;
	    	this.value = value;
	    	this.left = null;
	    	this.right = null;
	    }
    }

	private Node root;
	private int size;
	
	// Konstruktor (Klasse MyTreeMap)
	public MyTreeMap()
	{
		this.root = null;
		this.size = 0;
	}

	/*
	 * Dieser Konstruktor erhält als Parameter eine LinkedHashMap mit Werten, 
	 * die in der TreeMap balanciert gespeichert werden sollen.
	 * Es wird davon ausgegangen, das sämtliche Werte der LinkedHashMap sortiert vorliegen.
	 */
	public MyTreeMap(LinkedHashMap<Comparable, Object> map) {
		// Initialisierung der TreeMap
		this.root = null;
		this.size = 0;
		
		// Da später bestimmte Ausschnitte der eingetragenen Werte der Map benötigt werden und
		// eine List dafür die Methode Sublist anbietet, 
		// wird in diesem Schritt eine List aus der LinkedHashMap erstellt.
		List<Entry<Comparable, Object>> mapAsList = new ArrayList<Map.Entry<Comparable,Object>>(map.entrySet());
		
		// In diesem Schritt wird die Liste mit den Einträgen der Methode balance übergeben.
		// Die Methode ruft sich rekursiv auf und erstellt eine ausbalancierte TreeMap.
		// In der nachfolgenden Zeile liefert die balance-Methode den obersten Knoten der ausbalancierten TreeMap zurück.
		this.root = balance(this.root, mapAsList);
	}

	private Node balance(Node nodeUp, List<Entry<Comparable, Object>> list) {
		// Debug-Ausgaben zum Überprüfen der Funktionsfähigkeit.
		//System.out.println("------\n\rdeep:"+(deep++)+" orient:"+orient);
		/*
		System.out.println("balance deeper node List.size:"+list.size()+" leftSize(0-"+(int)((list.size()/2)-1)+") indexMiddle:"+(int)(list.size()/2)+" rightSize("+(int)((list.size()/2)+1)+"-"+list.size()+")");
		System.out.println("left condition:"+(int)((list.size()/2)-1) +" > "+ "0");
		System.out.println("middle index:"+(int)(list.size()/2));
		System.out.println("right condition:"+(int)((list.size()/2)+1) +"<"+ list.size());
		System.out.println("-------------");
		*/
		
		// Knoten wird initialisiert, der Zurückgeliefert werden soll.
		// Beim 1. Aufruf dieser rekursiven Methode, ist dieser Knoten der Root-Knoten
		Node node = new Node(null, null);
		
		// Auf den linken Teil der Liste (Ab dem Anfang der Liste bis zum mittleren Wert der Liste) 
		// wird die balance-Methode rekursiv angewendet.
		// Der zurückgelieferte Knoten wird in der linken Abzweigung des aktuellen Knoten gespeichert.
		if(list.size()/2 > 0 && list.size()>=1){
			ArrayList<Entry<Comparable, Object>> leftList = new ArrayList<Entry<Comparable, Object>>(list.subList(0, list.size()/2));
			//System.out.println("balance deeper node List.size:"+list.size()+" leftList.size:"+leftList.size()+ " (0 - "+(int)(list.size()/2)+")");
			node.left = balance(nodeUp, leftList);
		}
		
		// Das Key-Value Paar des mittleren Wertes der aktuellen Liste wird in dem Knoten node gespeichert.
		Entry<Comparable, Object> middleNodeEntry;
		if (list.size()==1){
			middleNodeEntry = list.get(0);
		} else if (list.size()>1) {
			middleNodeEntry = list.get((list.size()/2));
		} else {
			middleNodeEntry = null;
		}
		
		if(middleNodeEntry!=null && middleNodeEntry.getKey()!=null && middleNodeEntry.getValue()!=null){
			//System.out.println("balance deeper node List.size:"+list.size()+" insert node key:"+middleNodeEntry.getKey()+" value:"+middleNodeEntry.getValue()+" index:"+(int)(list.size()/2)+" at deep:"+(deep-1));
			node.key = middleNodeEntry.getKey();
			node.value = middleNodeEntry.getValue();
		}
		
		// Auf den rechten Teil der Liste (nach dem mittleren Wert bis zum Ende der Liste) wird die balance-Methode rekursiv angewendet.
		// Der zurückgelieferte Knoten wird in der rechten Abzweigung des aktuellen Knoten gespeichert.
		if((list.size()/2+1) < list.size() && list.size()>1){
			ArrayList<Entry<Comparable, Object>> rightList = new ArrayList<Entry<Comparable, Object>>(list.subList(list.size()/2+1, list.size()));
			//System.out.println("balance deeper node List.size:"+list.size()+" rightList.size:"+rightList.size()+ " ("+(int)(list.size()/2+1)+" - "+list.size()+")");
			node.right = balance(nodeUp, rightList);
		}
		
		return node;
	}
	
	/*
	 * Diese Methode liefert von dem aktuellen Objekt (this) eine perfekt balancierte TreeMap zurück.
	 */
	public MyTreeMap getPerfectlyBalancedCopy(){
		// 1. Schritt: Alle Werte von der unbalancierten TreeMap werden in einer sortierten LinkedHashMap zurück geliefert.
		LinkedHashMap<Comparable, Object> list = this.getAllEntriesAsList();
		
		// 2. Schritt eine neue TreeMap wird initialisiert und als Parameter wird die Liste der Einträge übergeben.
		// Der Konstruktor von MyTreeMap(LinkedHashMap<Comparable, Object> list)
		// liefert eine perfekt ausbalancierte TreeMap zurück.
		MyTreeMap treeCopy = new MyTreeMap(list);
		
		return treeCopy;
	}
	
	/*
	 * Diese Methode liefert alle Werte des aktuellen TreeMap-Objekts in einer LinkedHashMap zurück.
	 */
	public LinkedHashMap<Comparable, Object> getAllEntriesAsList(){
		LinkedHashMap<Comparable, Object> list = new LinkedHashMap<Comparable, Object>();
		
		this.getNextEntry(list, this.root);
		
		return list;
	}

	public int size()
	{
		return this.size;
	}
	
	private Entry<Comparable, Object> getNextEntry(LinkedHashMap<Comparable, Object> list, Node tree){
		if (tree!=null)
		{
			getNextEntry(list, tree.left);
			list.put(tree.key, tree.value);
			getNextEntry(list, tree.right);
	    }
		return null;
	}

	private Node insertNode(Comparable key, Object value, Node tree) 
	{
		if (tree==null)
		{						// Neuen Knoten erzeugen
			tree = new Node(key, value);
			this.size++;
		}
		else
		{
			int cmp = key.compareTo(tree.key);
			if (cmp==0)
			{
				tree.value = value;
			}
			else if(cmp<0)
				tree.left = insertNode(key, value, tree.left);
			else
				tree.right = insertNode(key, value, tree.right);
		}
		
		return tree;
	}

	void put(Comparable key, Object value)
	{
		if (key!=null && value!=null)
		{
			this.root = insertNode(key, value, this.root);
		}
	}	
	
	private void inorderPrint(Node tree)
	{
		if (tree!=null)
		{
			System.out.print("<-");
			inorderPrint(tree.left);
			System.out.println("Node: ("+tree.key+","+tree.value+")");  
			System.out.print("->");
			inorderPrint(tree.right);
	    }
	} 
	 
	void print()
	{
		System.out.println("Liste der Eintr�ge");
		System.out.println("------------------");
		inorderPrint(this.root);
		System.out.println();
	}
}
