class TimeMap {

    Map<String, String> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        String newKey = key + ":" + timestamp;
        map.put(newKey, value);
    }
    
    public String get(String key, int timestamp) {
        int t = timestamp;
        while(t>0){
            if(map.containsKey(key+":"+t)){
                return map.get(key+":"+t);
            }
            t--;
        }
        return "";
    }
}
