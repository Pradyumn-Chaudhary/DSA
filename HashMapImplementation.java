import java.util.*;

public class HashMapImplementation {
    static class HashMap<K, V> { //generics
        private class Node {
            K key;
            V value;

            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int n; //n - nodes
        private int N; //N - buckets
        private LinkedList<Node> buckets[]; //N - buckets.length

        @SuppressWarnings("unchecked")
        public HashMap() {
            this.N = 4;
            this.buckets = new LinkedList[4];
            for (int i = 0; i < N; i++) {
                this.buckets[i] = new LinkedList<>();
            }
        }

        private int hashFunction(K key) { //0 to N-1
            int bi = key.hashCode(); //234567 -234567
            return Math.abs(bi) % N;
        }

        private int searchInLL(K key, int bi) {
            LinkedList<Node> ll = buckets[bi];
            for (int di = 0; di < ll.size(); di++) {
                if (ll.get(di).key == key) {
                    return di;
                }
            }
            return -1;
        }

        @SuppressWarnings("unchecked")
        private void rehash() {
            LinkedList<Node> oldbucket[] = buckets;
            buckets = new LinkedList[N * 2];

            for (int i = 0; i < N * 2; i++) {
                buckets[i] = new LinkedList<>();
            }
            
            for (int i = 0; i < oldbucket.length; i++) {
                LinkedList<Node> ll = oldbucket[i];
                for (int j = 0; j < ll.size(); j++) {
                    Node node = ll.get(j);
                    put(node.key, node.value);
                }
            }
        }

        public void put(K key, V value) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi); //data index

            if (di == -1) { //key  doesn't exist
                buckets[bi].add(new Node(key, value));
                n++;
            } else { //key exist
                Node node = buckets[bi].get(di);
                node.value = value;
            }

            double lambda = (double) n / N;
            if (lambda > 2.0) {
                rehash();
            }
        }
        
        public V get(K key) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi); //data index

            if (di == -1) { //key  doesn't exist
                return null;
            } else { //key exist
                Node node = buckets[bi].get(di);
                return node.value;
            }
        }

        public boolean containsKey(K key) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi); //data index

            if (di == -1) { //key  doesn't exist
                return false;
            } else { //key exist
                return true;
            }
        }

        public V remove(K key) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi); //data index

            if (di == -1) { //key  doesn't exist
                return null;
            } else { //key exist
                Node node = buckets[bi].remove(di);
                n--;
                return node.value;
            }
        }

        public ArrayList<K> keySet() {
            ArrayList<K> keys = new ArrayList<>();
            for (int i = 0; i < buckets.length; i++) {
                LinkedList<Node> ll = buckets[i];
                for (int j = 0; j < ll.size(); j++) {
                    Node node = ll.get(j);
                    keys.add(node.key);
                }
            }
            return keys;
        }
        
        public boolean isEmpty() {
            return n == 0;
        }
    }
    
    public static void main(String[] args) {
        // Creating an instance of the HashMap
        HashMap<String, Integer> map = new HashMap<>();
    
        // Testing put() method
        System.out.println("Adding key-value pairs:");
        map.put("Apple", 10);
        map.put("Banana", 20);
        map.put("Mango", 30);
        map.put("Orange", 40);
        
        // Checking the size using internal count 'n' (for demonstration purposes)
        System.out.println("Current size (number of elements): " + map.n); // Expected Output: 4
    
        // Testing get() method
        System.out.println("\nGetting values:");
        System.out.println("Value for 'Apple': " + map.get("Apple"));   // Output: 10
        System.out.println("Value for 'Mango': " + map.get("Mango"));   // Output: 30
        System.out.println("Value for 'Grapes' (not added): " + map.get("Grapes")); // Output: null
    
        // Testing containsKey() method
        System.out.println("\nChecking if keys exist:");
        System.out.println("Contains 'Banana'? " + map.containsKey("Banana")); // Output: true
        System.out.println("Contains 'Grapes'? " + map.containsKey("Grapes")); // Output: false
    
        // Testing remove() method
        System.out.println("\nRemoving key-value pairs:");
        System.out.println("Removing 'Apple': " + map.remove("Apple")); // Output: 10
        System.out.println("Removing 'Grapes': " + map.remove("Grapes")); // Output: null (since it's not in the map)
    
        // Checking the size again
        System.out.println("Current size (after removals): " + map.n); // Expected Output: 3
    
        // Testing keySet() method
        System.out.println("\nKey Set:");
        ArrayList<String> keys = map.keySet();
        System.out.println("Keys in the map: " + keys); // Output: [Banana, Mango, Orange]
    
        // Testing isEmpty() method
        System.out.println("\nChecking if the map is empty:");
        System.out.println("Is Empty? " + map.isEmpty()); // Output: false
    
        // Removing all elements
        System.out.println("\nRemoving all elements:");
        map.remove("Banana");
        map.remove("Mango");
        map.remove("Orange");
    
        // Checking if the map is empty after removals
        System.out.println("Is Empty after removals? " + map.isEmpty()); // Output: true
    
        // Checking the size at the end
        System.out.println("Final size (should be 0): " + map.n); // Expected Output: 0
    }
    
}
