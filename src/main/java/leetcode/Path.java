package leetcode;

/**
 * @author Alan
 * @Description
 * @date 2023.07.31 23:50
 */
public class Path {

    public static void main(String[] args) {
        Path path = new Path();
        char[][] chars = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        path.exist(chars,"SSE");
    }

    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for(int i = 0; i < board.length; i ++){
            for(int j = 0; j < board[0].length; j++){
                dfs(i,j,board,0,words);
            }
        }
        return false;
    }

    public boolean dfs(int i, int j, char[][] board, int k, char[] words){
        // 剪枝情况
        if( i < 0 || j < 0 ||
                i >= board.length || j >= board[0].length || board[i][j] != words[k]){
            return false;
        }
        // 找到最后一个元素了
        if(k == words.length - 1){
            return true;
        }
        // 标记当前元素已使用
        board[i][j] = '\0';
        // 继续递归周围可能正确
        boolean res =
                dfs(i + 1,j, board, k+1,words) ||
                        dfs(i,j+1, board, k+1,words) ||
                        dfs(i-1,j, board, k+1,words) ||
                        dfs(i,j-1, board, k+1,words);
        board[i][j] = words[k];
        return res;
    }
}
