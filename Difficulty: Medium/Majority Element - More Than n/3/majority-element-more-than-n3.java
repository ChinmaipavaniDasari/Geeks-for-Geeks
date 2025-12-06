class Solution {
    public ArrayList<Integer> findMajority(int[] arr) {
        // Code here
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>(); // to preserve insertion order
        for(int i = 0;i<arr.length;i++){
            // map.put(arr[i], map.get(arr[i])==null?1:map.get(arr[i])+1);
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);   // Or
        }
        // Set<Integer> keys = map.keySet();
        for(Integer key : map.keySet()){  // or we can write keySet() in loop without storing in set data struct.
            if(map.get(key)>arr.length/3){
                list.add(key);
            }
        }
        Collections.sort(list);  //  to get the result in correct order
        return list;
    }
}