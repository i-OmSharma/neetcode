class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();

        for(char c : s.toCharArray()){
            if(c == '(' || c== '[' || c == '{'){
                stk.push(c);
            }
            //Check for close bracket
            else {
                // if stack is empty then there is nothing to match
                if(stk.isEmpty()) return false;

                char top = stk.pop();

                // check if pair match or not !

                if((c == ')' && top != '(') ||
                    (c == ']' && top != '[') ||
                    (c == '}' && top != '{')) {
                        return false;
                    }
                }
        }
        return stk.isEmpty();
    }
}
