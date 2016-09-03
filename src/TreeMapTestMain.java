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

public class TreeMapTestMain {
	
	public static void main(String[] args) {
		// Eine TreeMap wird initialisiert und mit Testwerten befüllt.
		// Die Testwerte können beliebige Objekte sein, die das "java.lang.Comparable"-Interface implementieren.
		MyTreeMap unbalancedTreeMap = new MyTreeMap();
		unbalancedTreeMap.put(new String("A"), "A");
		unbalancedTreeMap.put(new String("B"), "B");
		unbalancedTreeMap.put(new String("C"), "C");
		unbalancedTreeMap.put(new String("D"), "D");
		unbalancedTreeMap.put(new String("E"), "E");
		unbalancedTreeMap.put(new String("F"), "F");
		unbalancedTreeMap.put(new String("G"), "G");
		unbalancedTreeMap.put(new String("H"), "H");
		unbalancedTreeMap.put(new String("I"), "I");
		unbalancedTreeMap.put(new String("J"), "J");
		unbalancedTreeMap.put(new String("K"), "K");
		unbalancedTreeMap.put(new String("L"), "L");
		unbalancedTreeMap.put(new String("M"), "M");
		unbalancedTreeMap.print(); // Die Werte aus der TreeMap werden auf der Konsole ausgegeben.
		
		// Von der unbalancierten TreeMap wird durch die Methode getPerfectlyBalancedCopy() eine weitere TreeMap erstellt,
		// bei der die TreeMap ausbalanciert ist.
		MyTreeMap balancedTreeMap = unbalancedTreeMap.getPerfectlyBalancedCopy();
		balancedTreeMap.print(); // print
	}
}
