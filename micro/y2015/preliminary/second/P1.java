package mike.code.oj.micro.y2015.preliminary.second;

import java.util.Scanner;

/**
 * @author Mike
 * @project oj-code
 * @date 4/26/15, 2:00 PM
 * @e-mail mike@mikecoder.net
 */
public class P1 {
    static int flag;

    static int RES = 0;

    static class card {
        public char value;
        public char type;

        public card(char value, char type) {
            this.value = value;
            this.type = type;
        }

        @Override
        public String toString() {
            return '{' + value + "," + type + '}';
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int N = scanner.nextInt();
            for (int i = 0; i < N; i++) {
                RES = 0;
                int num = scanner.nextInt();
                card cards[] = new card[num];
                for (int j = 0; j < num; j++) {
                    String cardStr = scanner.next();
                    cards[j] = new card(cardStr.charAt(0), cardStr.charAt(1));
                }
                recursion(cards, 0, cards.length);
                System.out.println("Case #" + (i + 1) + ": " + RES);
            }
        }
    }

    static void recursion(card a[], int n, int N) {
        int i;
        if (n == N - 1) {
            if (checkCards(a)) {
                RES++;
            }
//                        System.out.println(Arrays.toString(a));
        } else {
            for (i = n; i < N; i++) {
                swap(a, i, n); //交换第一个数
                if (flag == 0) //如果有相同数值，此处递归可以不用，因为会重复
                    recursion(a, n + 1, N);
                //递归调用
                swap(a, i, n); //换回第一个数
            }
        }
    }

    static void swap(card b[], int i, int n) {
        card temp;
        flag = 0;
        if (i != n && b[i] == b[n])
            flag = 1;
        else {
            temp = b[i];
            b[i] = b[n];
            b[n] = temp;
        }
    }

    static boolean checkCards(card[] cards) {
        if (cards.length <= 1) return true;
        for (int i = 1; i < cards.length; i++) {
            if (cards[i].value == cards[i - 1].value)
                return false;
        }
        return true;
    }
}
