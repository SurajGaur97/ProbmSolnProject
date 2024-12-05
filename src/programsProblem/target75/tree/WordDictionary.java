package programsProblem.target75.tree;

import programsProblem.utils.DriverClass;

/**
 * @implNote Designing a Data Structure, in which we can Add and Search Words with wild card search functionality.
 */
public class WordDictionary implements DriverClass<Integer> {
    @Override
    public void driverMethod(){
        Trie obj = new Trie();
        obj.addWord("bad");
        obj.addWord("bae");
        obj.addWord("dad");
        obj.addWord("badu");
        System.out.println(obj.search("pad"));
        System.out.println(obj.search("bad"));
        System.out.println(obj.search(".ad"));
        System.out.println(obj.search("b..."));
    }

    static class Trie {
        private final TrieNode root;

        public Trie(){
            this.root = new TrieNode();
        }

        public void addWord(String word){
            TrieNode curr = this.root;
            for(char ch : word.toCharArray()){
                int ndx = ch - 'a';
                if(curr.characters[ndx] == null)
                    curr.characters[ndx] = new TrieNode();
                curr = curr.characters[ndx];
            }
            curr.isEnd = true;
        }

        public boolean search(String word){
            return searchHelper(this.root, word);
        }

        public boolean searchHelper(TrieNode root, String word){
            TrieNode curr = root;
            for(int i = 0;i < word.length();i++){
                char ch = word.charAt(i);
                if(ch == '.'){
                    for(int j = 0;j < 26;j++)
                        if(curr.characters[j] != null && searchHelper(curr.characters[j], word.substring(i + 1)))
                            return true;
                    return false;
                } else if(curr.characters[ch - 'a'] == null)
                    return false;
                curr = curr.characters[ch - 'a'];
            }
            return curr.isEnd;
        }

        static class TrieNode {
            TrieNode[] characters;
            boolean isEnd;

            public TrieNode(){
                this.characters = new TrieNode[26];
                this.isEnd = false;
            }
        }
    }

}
