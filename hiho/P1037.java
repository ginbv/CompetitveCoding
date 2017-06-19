package mike.code.oj.hiho;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Mike
 * @project oj-code
 * @date 4/2/15, 9:21 PM
 * @e-mail mike@mikecoder.net
 */
public class P1037 {

    static int[][]                  levels  = new int[110][110];
    static HashMap<Record, Integer> records = new HashMap<Record, Integer>();

    static class Record {
        int level;
        int no;

        public Record(int level, int no) {
            this.level = level;
            this.no = no;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Record reward = (Record) o;

            if (level != reward.level) return false;
            return this.no == reward.no;
        }

        @Override
        public int hashCode() {
            int result = level;
            result = 31 * result + no;
            return result;
        }

        @Override
        public String toString() {
            return "Record{" + "level=" + level + ", no=" + no + '}';
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            clearLevels();

            int LEVEL_NUM = scanner.nextInt();
            int MAX_REWARD = 0;
            for (int i = 0; i < LEVEL_NUM; i++) {
                for (int j = 0; j < i + 1; j++) {
                    levels[i][j] = scanner.nextInt();
                }
            }
            Record current = new Record(0, 0);
            records.put(current, levels[0][0]);

            while (!records.isEmpty()) {
                Integer currentNum = records.get(current);
                for (int i = current.no; i <= current.no + 1; i++) {
                    Record next = new Record(current.level + 1, i);
                    if (records.containsKey(next)) {
                        int nextNum = currentNum + levels[next.level][next.no];
                        records.put(next, records.get(next) < nextNum ? nextNum : records.get(next));
                        MAX_REWARD = MAX_REWARD < records.get(next) ? records.get(next) : MAX_REWARD;
                    } else {
                        int nextNum = currentNum + levels[next.level][next.no];
                        records.put(next, nextNum);
                        MAX_REWARD = MAX_REWARD < nextNum ? nextNum : MAX_REWARD;
                    }
                }
                if (records.containsKey(new Record(current.level, current.no + 1))) {
                    records.remove(current);
                    current = new Record(current.level, current.no + 1);
                } else if (records.containsKey(new Record(current.level + 1, 0))) {
                    records.remove(current);
                    current = new Record(current.level + 1, 0);
                }
                if (current.level >= LEVEL_NUM) {
                    break;
                }
            }

            System.out.println(MAX_REWARD);
        }
    }

    public static void clearLevels() {
        records.clear();
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                levels[i][j] = 0;
            }
        }
    }
}
