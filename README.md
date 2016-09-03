# BalanceTreeMap

You can find a full description how to balance a treemap and of this source code on the blog post: http://www.andrej-albrecht.com/de/articles/TreeMap-ausbalancieren

## Installation
Clone or download the project and import it to Eclipse.

## Usage

```java
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
unbalancedTreeMap.print(); // print
	
MyTreeMap balancedTreeMap = unbalancedTreeMap.getPerfectlyBalancedCopy();
balancedTreeMap.print(); // print
```

## Contributing
1. Fork it!
2. Create your feature branch: `git checkout -b my-new-feature`
3. Commit your changes: `git commit -am 'Add some feature'`
4. Push to the branch: `git push origin my-new-feature`
5. Submit a pull request :D


## Licence
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
