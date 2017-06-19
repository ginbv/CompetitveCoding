package mike.code.oj.hiho;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Mike
 * @project oj-code
 * @date 4/I16/15, 11:28 AM
 * @e-mail mike@mikecoder.net
 */
public class P1038 {

    static class Reward implements Comparable {
        int need;
        int value;

        public Reward(int need, int value) {
            this.need = need;
            this.value = value;
        }

        public int compareTo(Object o) {
            if (this.need < ((Reward) o).need) {
                return -1;
            } else {
                return 1;
            }
        }

        @Override
        public String toString() {
            return "Reward{" + "need=" + need + ", value=" + value + '}';
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int N = scanner.nextInt();
            int M = scanner.nextInt();

            Reward[] rewards = new Reward[N];

            for (int i = 0; i < N; i++) {
                rewards[i] = new Reward(scanner.nextInt(), scanner.nextInt());
            }

            Arrays.sort(rewards);
            System.out.println(Arrays.toString(rewards));
        }
    }
}
