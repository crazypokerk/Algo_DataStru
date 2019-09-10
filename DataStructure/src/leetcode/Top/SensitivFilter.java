package leetcode.Top;


import java.util.HashMap;
import java.util.Map;

/**
 * @Date 2019/9/8 15:07
 */
public class SensitivFilter {
	
	private class TrieNode {
		private boolean isKeyWordEnd = false;
		
		public boolean isKeyWordEnd() {
			return isKeyWordEnd;
		}
		
		public void setKeyWordEnd(boolean keyWordEnd) {
			isKeyWordEnd = keyWordEnd;
		}
		
		private Map<Character, TrieNode> subNodes = new HashMap<>();
		
		public void addSubNode(Character c, TrieNode node) {
			subNodes.put(c, node);
		}
		
		public TrieNode getSubNode(Character c) {
			return subNodes.get(c);
		}
	}
	
	private static final String REPLACEMENT = "***";
	
	private TrieNode root = new TrieNode();
	
	private void addKeyWord(String keyword) {
		TrieNode tmp = root;
		for (int i = 0; i < keyword.length(); i++) {
			char c = keyword.charAt(i);
			TrieNode subNode = tmp.getSubNode(c);
			if (subNode == null) {
				subNode = new TrieNode();
				tmp.addSubNode(c, subNode);
			}
			
			tmp = subNode;
			
			if (i == keyword.length() - 1) {
				tmp.setKeyWordEnd(true);
			}
		}
	}
	
	public String filter(String text) {
		if (text == null) {
			return null;
		}
		
		StringBuilder sb = new StringBuilder();
		int begin = 0;
		int position = 0;
		TrieNode tmp = root;
		
		while (begin < text.length()) {
			
			char c = text.charAt(position);
			
			if (isSymbol(c)) {
				if (tmp == root) {
					sb.append(c);
					begin++;
				}
				position++;
				continue;
			}
			
			tmp = tmp.getSubNode(c);
			if (tmp == null) {
				sb.append(text.charAt(begin));
				position = ++begin;
				tmp = root;
			} else if (tmp.isKeyWordEnd()) {
				sb.append(REPLACEMENT);
				begin = ++position;
				tmp = root;
			} else {
				if (position < text.length() - 1) {
					position++;
				}
			}
		}
		sb.append(text.substring(begin));
		return sb.toString();
	}
	
	private boolean isSymbol(char c) {
		return true;
	}
	
}
