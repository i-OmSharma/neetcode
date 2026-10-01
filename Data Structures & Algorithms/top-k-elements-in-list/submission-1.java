class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        //create map 
        Map<Integer, Integer> freqMap = new HashMap<>();
        //put value inside the map
        for(int num: nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0)+1);
        }

        //create bucket
        //Index = frequency, value = Element with that frequencey
        List<Integer>[] bucket = new List[nums.length + 1];
        for (int i = 0; i < bucket.length; i++){
            bucket[i] = new ArrayList<>();
        }

        //Put elements in their frequency bucket
        for(Map.Entry<Integer, Integer> entry: freqMap.entrySet()) {
            int freq = entry.getValue();
            int num = entry.getKey();
            bucket[freq].add(num);
        }

        //Traverse from right to left
        int[] result = new int[k];
        int idx = 0;
        for(int i = bucket.length - 1;  i >= 0 && idx < k; i--) {
            if(!bucket[i].isEmpty()) {
                for( int num: bucket[i] ) {
                    result[idx++] = num;
                    if(idx == k) break; 
                }
            }
        }
        return result;
    }
}
