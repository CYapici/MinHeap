package MinHeapAlgorithm;

public class Density {

	private Trie trie;

	public Density(int top) {
		trie = new Trie(top);
	}

	public void Read(String word) {
		trie.Insert(word);
	}

	public void ExecuteResult() {
		trie.print();
	}

}
