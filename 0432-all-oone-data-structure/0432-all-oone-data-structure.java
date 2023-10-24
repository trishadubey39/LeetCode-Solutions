class AllOne {

    Map<String,Integer> keyToFreq;
    Map<Integer,Set<String>> freqToKeys;
    int minFreq;
    int maxFreq;

    public AllOne() {
        this.keyToFreq = new HashMap<>();
        this.freqToKeys = new HashMap<>();
        this.minFreq = Integer.MAX_VALUE;
        this.maxFreq = 0;       
    }
    
    public void inc(String key) {
        if( keyToFreq.containsKey(key) ){
            int freq = keyToFreq.get(key);
            keyToFreq.put(key, freq+1);
            freqToKeys.computeIfAbsent(freq+1, k->new HashSet<>()).add(key);

            freqToKeys.get(freq).remove(key);
            if( freqToKeys.get(freq).isEmpty() ){
                freqToKeys.remove(freq);

                if(freq == minFreq)
                    minFreq = freq+1;
            }
            maxFreq = Math.max(maxFreq, freq+1);
        }
        else {
            keyToFreq.put(key, 1);
            freqToKeys.computeIfAbsent(1, k->new HashSet<>()).add(key);
            minFreq = Math.min(minFreq, 1);
            maxFreq = Math.max(maxFreq, 1);
        }
    }
    
    public void dec(String key) {
        int freq = keyToFreq.get(key);
        if(freq == 1){
            keyToFreq.remove(key);

            freqToKeys.get(freq).remove(key);
            if( freqToKeys.get(freq).isEmpty() ){
                freqToKeys.remove(freq);

                if(freq == maxFreq)
                    maxFreq = freq-1; // 0

                if(freq == minFreq){
                    for(int i=1; i<=maxFreq; i++){
                        if( freqToKeys.containsKey(i) ){
                            minFreq = i;
                            break;
                        }
                    }
                }
            }
            // minFreq is not affected
        }
        else {
            keyToFreq.put(key, freq-1);
            freqToKeys.computeIfAbsent(freq-1, k->new HashSet<>()).add(key);

            freqToKeys.get(freq).remove(key);
            if( freqToKeys.get(freq).isEmpty() ){
                freqToKeys.remove(freq);

                if(freq == maxFreq)
                    maxFreq = freq-1;
            }
            minFreq = Math.min(minFreq, freq-1);
        }
    }
    
    public String getMaxKey() {
        return !freqToKeys.isEmpty() ? freqToKeys.get(maxFreq).iterator().next() : "";
    }
    
    public String getMinKey() {
        return !freqToKeys.isEmpty() ? freqToKeys.get(minFreq).iterator().next() : "";
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */