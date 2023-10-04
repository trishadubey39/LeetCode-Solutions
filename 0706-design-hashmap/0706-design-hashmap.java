class MyHashMap {

    private List<List<Pair<Integer, Integer>>> mp;
    private int size = 10;

    public MyHashMap() {
        mp = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            mp.add(new LinkedList<>());
        }
    }

    private int hash(int key) {
        return key % size;
    }

    public void put(int key, int value) {
        int i = hash(key);
        List<Pair<Integer, Integer>> bucket = mp.get(i);

        for (Pair<Integer, Integer> pair : bucket) {
            if (pair.first.equals(key)) {
                pair.second = value;
                return;
            }
        }

        bucket.add(new Pair<>(key, value));
    }

    public int get(int key) {
        int i = hash(key);
        List<Pair<Integer, Integer>> bucket = mp.get(i);

        for (Pair<Integer, Integer> pair : bucket) {
            if (pair.first.equals(key)) {
                return pair.second;
            }
        }

        return -1;
    }

    public void remove(int key) {
        int i = hash(key);
        List<Pair<Integer, Integer>> bucket = mp.get(i);

        for (Pair<Integer, Integer> pair : bucket) {
            if (pair.first.equals(key)) {
                bucket.remove(pair);
                return;
            }
        }
    }
}

class Pair<K, V> {
    K first;
    V second;

    public Pair(K first, V second) {
        this.first = first;
        this.second = second;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */