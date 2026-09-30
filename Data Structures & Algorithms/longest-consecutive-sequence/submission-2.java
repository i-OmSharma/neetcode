class Solution {
    public int longestConsecutive(int[] nums) {

        if(nums.length == 0) { // if nums empty
            return 0;
        }

        Set<Integer> box = new HashSet<>(); // create hashset

        for (int num: nums) { // Put all element inside the set
            box.add(num);
        }

        int maxLength = 0;

        for (int num: box) { // iterate inside the box 
            
            //check whats the start of sequence ,num -1 is not in the box then only start 
            if(!box.contains(num - 1)) {
                int currentNum = num; // set current as the current num
                int currentLen = 1;// set current length to the the first element 

                while(box.contains(currentNum + 1)){ // iterate till we get the next element, and keep incrementing
                    currentNum++;
                    currentLen++;
                }
                maxLength = Math.max(maxLength, currentLen); // find the max length
            }
        }
        return maxLength; // return the maxLength
    }
}


/* to calculate the longgest consicutive substring we need to :
we need to make box, then put all the elements inside it,
set max length = 0;
then start iterating insid the box;
if box not contain current num -1 then make the current element the currentElement and set the current length to 1;
then we will run a while loop for the currentnum + 1 and we will keep increasign the curretnum and current length;
then we will calculete the max length for maxlength and currentlength;
at the end we will return the max length;
*/  

/* 
 * Approach to find the Longest Consecutive Sequence:
 * 1. Create a HashSet ('box') and add all elements from the array to it for O(1) lookups.
 * 2. Initialize 'maxLength' to 0.
 * 3. Iterate through each number in the set:
 *    - Check if it is the START of a sequence (i.e., 'num - 1' is NOT present in the set).
 *    - If it is a start, initialize 'currentNum' to this number and 'currentLength' to 1.
 *    - Run a while loop to check if 'currentNum + 1' exists in the set.
 *    - If it exists, increment 'currentNum' and 'currentLength'.
 *    - Update 'maxLength' with the maximum of 'maxLength' and 'currentLength'.
 * 4. Return 'maxLength' as the result.
 */