


class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for (String s : strs) {
            // Fix 1: 'appened' ko 'append' kiya
            sb.append(s.length()).append("#").append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;

        // Fix 2: 's' ko 'str' kiya kyunki parameter ka naam 'str' hai
        while (i < str.length()) {
            // Find the index of #
            // Fix 3: 'indexof' ko 'indexOf' kiya
            int j = str.indexOf('#', i);

            // Extract the length of next string
            int len = Integer.parseInt(str.substring(i, j));

            // Extract the actual string using the length
            // Fix 4: Variable name 'str' change karke 'word' kar diya taaki conflict na ho
            String word = str.substring(j + 1, j + 1 + len);

            result.add(word);

            // Move i to the start of next length prefix
            i = j + 1 + len;
        }
        return result;
    }
}