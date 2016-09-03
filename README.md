# BalanceTreeMap

You can find a full description how to balance a treemap and of this source code on the blog post: http://www.andrej-albrecht.com/de/articles/TreeMap-ausbalancieren

## Installation
1. Clone or download the project and import it to Eclipse.

## Usage
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


## Contributing
1. Fork it!
2. Create your feature branch: `git checkout -b my-new-feature`
3. Commit your changes: `git commit -am 'Add some feature'`
4. Push to the branch: `git push origin my-new-feature`
5. Submit a pull request :D
