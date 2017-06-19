package mike.code.oj.fun;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author Mike
 * @project oj.code
 * @date 4/24/I16, 8:54 PM
 * @e-mail mike@mikecoder.cn
 */
public class Cloths {

    private int                             min = Integer.MAX_VALUE;
    private LinkedList<LinkedList<Integer>> res = new LinkedList<LinkedList<Integer>>();

    /**
     * 找到最合算的解
     *
     * @param prices 商品价格
     * @return 所有符合标准的购买方式
     */
    public LinkedList<LinkedList<Integer>> purchase(int[] prices) {
        res.clear();
        Arrays.sort(prices);
        for (int i = 0; i < prices.length; i++) {
            _purchase(new LinkedList<Integer>(), prices, 0, i);
        }
        res = display(prices, res);
        return res;
    }

    public LinkedList<LinkedList<Integer>> display(int[] prices, LinkedList<LinkedList<Integer>> res) {
        LinkedList<LinkedList<Integer>> ret = new LinkedList<LinkedList<Integer>>();
        for (LinkedList<Integer> cloths : res) {
            LinkedList<Integer> rett = new LinkedList<Integer>();
            for (int price : cloths) {
                rett.add(prices[price]);
            }
            ret.add(rett);
        }
        return ret;
    }

    public void _purchase(LinkedList<Integer> buys, int[] prices, int current, int cursor) {
        buys.push(cursor);
        current = current + prices[cursor];

        if (current < 500) {
            for (int i = cursor + 1; i < prices.length; i++) {
                if (current < 500) {
                    _purchase(buys, prices, current, i);
                    buys.pop();
                } else {
                    if (current - 500 < min) {
                        min = current - 500;
                        res.clear();
                        res.add((LinkedList<Integer>) buys.clone());
                    } else if (current - 500 == min) {
                        res.add((LinkedList<Integer>) buys.clone());
                    }
                    return;
                }
            }
        } else {
            if (current - 500 < min) {
                min = current - 500;
                res.clear();
                res.add((LinkedList<Integer>) buys.clone());
            } else if (current - 500 == min) {
                res.add((LinkedList<Integer>) buys.clone());
            }
        }
    }

    public static void main(String[] args) {
        int[] prices1 = { 250, 21, 125, 127, 251, 126 };
        Cloths cloths = new Cloths();
        System.out.println(cloths.purchase(prices1));

        int[] prices2 = { 1, 2, 498, 499, 500 };
        System.out.println(cloths.purchase(prices2));

        int[] prices3 = {};
        System.out.println(cloths.purchase(prices3));

        int[] prices4 = { 1, 2, 3 };
        System.out.println(cloths.purchase(prices4));

        int[] prices5 = { 125, 124, 125, 250, 250, 250, 2, 3 };
        System.out.println(cloths.purchase(prices5));
    }
}
