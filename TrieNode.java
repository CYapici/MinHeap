package MinHeapAlgorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author cagatay.yapici
 *
 */
public class TrieNode {
	private Map<Character, TrieNode> nodes;
	public char Chars;
	public boolean IsatEnd;
	public int Frequency = 0;
	public int MinHeapIndex = -1;

	public TrieNode() {
		this.Chars = ' ';
		IsatEnd = false;
		nodes = new HashMap<Character, TrieNode>();
	}

	public TrieNode(char data) {
		this.Chars = data;
		IsatEnd = false;
		nodes = new HashMap<Character, TrieNode>();
	}

	public TrieNode children(char data) {
		return nodes.get(data);
	}

	public boolean isChildExist(char c) {
		return children(c) != null;
	}

	public void Add(Character c, TrieNode n) {
		nodes.put(c, n);
	}
}