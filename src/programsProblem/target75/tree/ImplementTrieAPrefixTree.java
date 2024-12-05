package programsProblem.target75.tree;

import programsProblem.utils.DriverClass;

import java.util.ArrayList;
import java.util.List;

/**
 * Implement Trie (PrefixTree)
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
public class ImplementTrieAPrefixTree implements DriverClass<Integer> {
    @Override
    public void driverMethod(){
        /* Input:
         * ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
         * [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
         * Output:
         * [null, null, true, false, true, null, true]
         */
        Trie obj = new Trie();
        obj.insert("apple");
        System.out.println(obj.search("apple"));
        System.out.println(obj.search("app"));
        System.out.println(obj.startsWith("app"));
        obj.insert("app");
        System.out.println(obj.search("app"));
    }

    /**
     * @implNote ref: <a href="https://www.geeksforgeeks.org/trie-insert-and-search/">...</a>
     */
    static class Trie {
        private final TrieNode root;

        public Trie(){
            this.root = new TrieNode();
        }

        public void insert(String word){
            TrieNode curr = this.root;
            for(char ch : word.toCharArray()){
                int ndx = ch - 'a';
                if(curr.children[ndx] == null)
                    curr.children[ndx] = new TrieNode();

                // Move the curr pointer to the already existing node for the
                // current character
                curr = curr.children[ndx];
            }
            curr.isEnd = true;
        }

        public boolean search(String word){
            TrieNode curr = this.root;
            for(char ch : word.toCharArray()){
                int ndx = ch - 'a';
                if(curr.children[ndx] == null)
                    return false;

                // Move the curr pointer to the already existing node for the
                // current character
                curr = curr.children[ndx];
            }
            return curr.isEnd;
        }

        public boolean startsWith(String prefix){
            TrieNode curr = this.root;
            for(char ch : prefix.toCharArray()){
                int ndx = ch - 'a';
                if(curr.children[ndx] == null)
                    return false;

                // Move the curr pointer to the already existing node for the
                // current character
                curr = curr.children[ndx];
            }
            return true;
        }

        static class TrieNode {
            TrieNode[] children;    //array of TrieNode for keeping record of existing chars
            boolean isEnd;  //is end of word

            public TrieNode(){
                this.children = new TrieNode[26];
                this.isEnd = false;
            }
        }
    }

    /**
     * @author suraj.gaur
     * @implNote Take huge time
     */
    static class Trie1 {
        List<String> data;

        public Trie1(){
            data = new ArrayList<>();
        }

        public void insert(String word){
            if(data != null)
                data.add(word);
        }

        public boolean search(String word){
            if(data != null && !data.isEmpty())
                for(String dt : data)
                    if(dt.equals(word))
                        return true;
            return false;
        }

        public boolean startsWith(String prefix){
            if(data != null && !data.isEmpty())
                for(String dt : data)
                    if(dt.startsWith(prefix))
                        return true;
            return false;
        }
    }
}