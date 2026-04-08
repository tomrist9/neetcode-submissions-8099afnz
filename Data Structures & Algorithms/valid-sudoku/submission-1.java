class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character>[] rows = new HashSet[9];
        Set<Character>[] cols = new HashSet[9];
        Set<Character>[] boxes = new HashSet[9];

        for(int i=0; i<9; i++){
            rows[i]= new HashSet<>();
            cols[i]= new HashSet<>();
            boxes[i]= new HashSet<>();
        }

      for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.') continue; // boş hüceyrə

                // Sıra yoxlaması
                if (!rows[i].add(c)) return false;
                // Sütun yoxlaması
                if (!cols[j].add(c)) return false;

                // 3x3 kvadrat indeksi hesablayırıq
                int boxIndex = (i / 3) * 3 + (j / 3);
                   if (!boxes[boxIndex].add(c)) return false;
            }
            }
        return true;
    }
}
