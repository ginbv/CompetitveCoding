package mike.code.oj.leetcode;

import java.util.HashMap;

/**
 * @author Mike
 * @project oj-code
 * @date 4/22/15, 9:33 PM
 * @e-mail mike@mikecoder.net
 */
public class ValidSudoku {
    public static void main(String[] args) {

    }

    public boolean isValidSudoku(char[][] board) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int value;
        char key;
        for (int i = 0; i < 9; i++) {
            //check horizontal line
            for (int j = 0; j < 9; j++) {
                key = board[i][j];
                if (key != '.') {
                    if (map.containsKey(key)) {
                        value = map.get(key);
                        if (value >= 1) {
                            return false;
                        }
                    } else {
                        map.put(key, 1);
                    }
                }
            }
            map.clear();
            //check vertical line
            for (int j = 0; j < 9; j++) {
                key = board[j][i];
                if (key != '.') {
                    if (map.containsKey(key)) {
                        value = map.get(key);
                        if (value >= 1) {
                            return false;
                        }
                    } else {
                        map.put(key, 1);
                    }
                }
            }
            map.clear();
        }

        //check Sudoku in square 3x3
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                for (int x = i; x < i + 3; x++) {
                    for (int y = j; y < j + 3; y++) {
                        key = board[x][y];
                        if (key != '.') {
                            if (map.containsKey(key)) {
                                value = map.get(key);
                                if (value >= 1) {
                                    return false;
                                }
                            } else {
                                map.put(key, 1);
                            }
                        }
                    }
                }
                map.clear();
            }
        }
        return true;
    }
}
