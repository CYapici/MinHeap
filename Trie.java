package MinHeapAlgorithm;

/**
 * Trie implementation
 * 
 * @author cagatay.yapici
 *
 */
public class Trie {
	// fields
	private TrieNode rootNode;
	private MinHeap minHeap;

	public Trie(int freq) {
		minHeap = new MinHeap();
		rootNode = new TrieNode();
		minHeap.Nodes = new Node[freq];
		minHeap.Capacity = freq;
	}

	public void Insert(String str) {
		int len = str.length();
		if (str == null || len == 0)
			return;

		TrieNode current = rootNode;
		for (int i = 0; i < len; i++) {
			char c = str.charAt(i);
			if (!current.isChildExist(c)) {
				TrieNode node = new TrieNode(c);
				current.Add(c, node);
			}
			current = current.children(c);
		}
		if (!current.IsatEnd) {
			current.Frequency = 1;
			current.IsatEnd = true;
		} else
			current.Frequency++;
		insertMinHeap(str, current);

	}

	private void insertMinHeap(String s, TrieNode current) {
		if (current.MinHeapIndex == -1) {
			Node base = minHeap.Nodes[0];
			if (minHeap.Count < minHeap.Capacity) {
				++minHeap.Count;
				Node node = new Node();
				node.Word = s;
				node.Frequency = current.Frequency;
				node.Node = current;
				node.Node.MinHeapIndex = minHeap.Count - 1;
				minHeap.Nodes[minHeap.Count - 1] = node;
				build();
			} else if (current.Frequency > base.Frequency) {
				base.Node.MinHeapIndex = -1;
				base.Node = current;
				base.Frequency = current.Frequency;
				base.Word = s;
				current.MinHeapIndex = 0;
				heapify(0);
			}
		} else {
			minHeap.Nodes[current.MinHeapIndex].Frequency++;
			heapify(current.MinHeapIndex);
		}
	}

	private void build() {
		for (int i = (minHeap.Count - 1) / 2; i >= 0; i--)
			heapify(i);
	}

	public boolean find(String s) {
		int len = s.length();
		if (s == null || len == 0)
			return false;

		TrieNode temp = rootNode;
		for (int i = 0; i < len; i++) {
			char c = s.charAt(i);
			if (!temp.isChildExist(c))
				return false;

			temp = temp.children(c);
		}
		return temp.IsatEnd;
	}

	public void heapify(int node) {
		int left = (node << 0x1) + 0x1;
		int right = (node << 0x1) + 0x2;
		int smallest = node;
		if (left < minHeap.Count && minHeap.Nodes[smallest].Frequency > minHeap.Nodes[left].Frequency)
			smallest = left;
		if (right < minHeap.Count && minHeap.Nodes[smallest].Frequency > minHeap.Nodes[right].Frequency)
			smallest = right;
		if (smallest == node)
			return;
		int index = minHeap.Nodes[smallest].Node.MinHeapIndex;
		minHeap.Nodes[smallest].Node.MinHeapIndex = minHeap.Nodes[node].Node.MinHeapIndex;
		minHeap.Nodes[node].Node.MinHeapIndex = index;
		Node temp = minHeap.Nodes[smallest];
		minHeap.Nodes[smallest] = minHeap.Nodes[node];
		minHeap.Nodes[node] = temp;
		heapify(smallest);
	}

	public void print() {
		for (int i = 0; i < minHeap.Count; i++) {
			System.out.println(
					"phrase  :\t" + minHeap.Nodes[i].Word + "\t\t\t\tdensity\t:\t" + minHeap.Nodes[i].Frequency);
		}
	}
}