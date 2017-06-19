package mike.code.oj.leetcode;

/**
 * @author Mike
 * @project oj-code
 * @date 4/23/15, 3:55 PM
 * @e-mail mike@mikecoder.net
 */
public class NumberofIslands {
    public static void main(String[] args) {
        char[][] map = {
                { '1', '1', '1', '0', '0' },
                { '1', '1', '0', '1', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '0', '0', '0' },
                { '0', '0', '0', '0', '0' },
        };
        System.out.println(numIslands(map));
    }

    public static int numIslands(char[][] grid) {
        int num = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    findSea(i, j, grid);
                    num++;
                }
            }
        }
        return num;
    }

    private static void findSea(int x, int y, char[][] map) {
        // BFS 从斜方向进行搜索
        map[x][y] = '2'; // 表明已经访问到
        if (y != map[0].length - 1 && map[x][y + 1] == '1') {
            findSea(x, y + 1, map);
        }
        if (y != 0 && map[x][y - 1] == '1') {
            findSea(x, y - 1, map);
        }
        if (x != map.length - 1 && map[x + 1][y] == '1') {
            findSea(x + 1, y, map);
        }
        if (x != 0 && map[x - 1][y] == '1') {
            findSea(x - 1, y, map);
        }
    }
}
