package recursion;

class WordSearch {

    // it is a bit different from the combination as the movement could go 4 different directions in 2d array
    static boolean exist(char[][] board, String word) {
        char[] w = word.toCharArray();
        for (int row=0; row<board.length; row++) {
            for (int col=0; col<board[row].length; col++) {
                if (exist(board, row, col, w, 0)) return true;
            }
        }
        return false;
    }

    static boolean exist(char[][] board, int row, int col, char[] word, int i) {
        if (i == word.length) return true;
        if (row<0 || col<0 || row == board.length || col == board[row].length) return false;
        if (board[row][col] != word[i]) return false;
        board[row][col] ^= 256;
        boolean exist = exist(board, row, col+1, word, i+1)
                || exist(board, row, col-1, word, i+1)
                || exist(board, row+1, col, word, i+1)
                || exist(board, row-1, col, word, i+1);
        board[row][col] ^= 256;
        return exist;
    }
}
