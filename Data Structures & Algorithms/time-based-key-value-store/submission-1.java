class Pair<D,S>{
    D first;
    S second;

    Pair(D first, S second){
        this.first = first;
        this.second = second;
    }
    public D getFirst(){
        return this.first;
    }

    public S getSecond(){
        return this.second;
    }

    public void setFirst(D first){
        this.first = first;
    }

    public void setSecond(S second){
        this.second = second;
    }

}

class TimeMap {

    HashMap<String, ArrayList<Pair<String, Integer>>> hmap1;
    public TimeMap() {
        hmap1 = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!hmap1.containsKey(key)){
            hmap1.put(key, new ArrayList<Pair<String,Integer>>());
        }
        Pair<String, Integer> p1 = new Pair<>(value, timestamp);
        hmap1.get(key).add(p1);
        hmap1.get(key).sort(Comparator.comparingInt(Pair::getSecond));
    }
    
    public String get(String key, int timestamp) {
        if(hmap1.containsKey(key)){
            ArrayList<Pair<String, Integer>> list1 = hmap1.get(key);
            int index = Collections.binarySearch(list1, new Pair<>("", timestamp),
                                                Comparator.comparingInt(Pair::getSecond));
            if(index >= 0){
                return list1.get(index).getFirst();
            } else {
                int insertionP = -index-1;
                if (insertionP > 0){
                    return list1.get(insertionP -1).getFirst();
                }
            }
        }
        return "";
        
    }
}
