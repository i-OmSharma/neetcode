class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> row = new HashSet<>();
        Set<String> col = new HashSet<>();
        Set<String> box = new HashSet<>();

        for(int i = 0; i < 9; i++) {
            for(int j = 0; j< 9; j++) {
                char num = board[i][j];

                if(num == '.') continue;

                //Check Row
                String rowKey = i + "-" + num;
                if (row.contains(rowKey)) return false;
                row.add(rowKey);

                //Check column
                String colKey = j + "-" + num;
                if(col.contains(colKey)) return false;
                col.add(colKey);

                //box Key
                String boxKey = (i/3) + "-" + (j/3) + "-" + num;
                if(box.contains(boxKey)) return false;
                box.add(boxKey);
            }
        }
        return true;
    }
}
