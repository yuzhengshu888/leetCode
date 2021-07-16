package design;

/**
 * @description: 208. 实现 Trie (前缀树)
 * @Author: yuzhengshu
 * @Date: 2021年7月16日 16:15
 */
public class Trie {
    Trie[] tries;
    boolean endFlag = false;

    public Trie() {
        tries = new Trie[26];
    }

    public void insert(String word) {
        if (word.length() == 1) {
            Trie trie1 = new Trie();
            trie1.endFlag = true;
            tries[word.charAt(0) - 'a'] = trie1;
            return;
        }
        Trie trie = tries[word.charAt(0) - 'a'];
        if (trie != null) {
            trie.insert(word.substring(1));
        } else {
            Trie trie1 = new Trie();
            trie1.insert(word.substring(1));
            System.out.println(1);
            tries[word.charAt(0) - 'a'] = trie1;
        }
    }

    public boolean search(String word) {
        Trie trie = this.tries[word.charAt(0) - 'a'];
        if (trie == null) {
            return false;
        } else {
            if (word.length() == 1) {
                return trie.endFlag;
            }
            return trie.search(word.substring(1));
        }
    }

    public boolean startsWith(String prefix) {
        if ("".equals(prefix)) {
            return true;
        }
        Trie trie = this.tries[prefix.charAt(0) - 'a'];
        if (trie == null) {
            return false;
        } else {
            return trie.startsWith(prefix.substring(1));
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("ba");
        trie.insert("caa");
        trie.insert("aaaa");
        trie.insert("aaaaaa");
        System.out.println(trie.search("caa"));
        System.out.println(trie.startsWith("b"));
        System.out.println(trie.startsWith("c"));
        System.out.println("___");
    }
}
