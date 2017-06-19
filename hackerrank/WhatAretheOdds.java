package mike.code.oj.hackerrank;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Vector;

/**
 * @author Mike
 * @project oj.code
 * @date 02/04/2017, 11:20 PM
 * @e-mail mike@mikecoder.cn
 */
public class WhatAretheOdds {
    
    static HashMap<Vector<Integer>, Boolean> DP_ALICE = new HashMap<Vector<Integer>, Boolean>();
    static HashMap<Vector<Integer>, Boolean> DP_BOB   = new HashMap<Vector<Integer>, Boolean>();
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] s = new int[n];
        for (int s_i = 0; s_i < n; s_i++) {
            s[s_i] = in.nextInt();
        }
        Arrays.sort(s);
        
        DP_ALICE.clear();
        DP_BOB.clear();
        
        int res = 0;
        Vector<Integer> stones = new Vector<Integer>();
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                stones.clear();
                for (int k = 0; k < n; k++) {
                    if (i <= k && k <= j) {
                        continue;
                    } else {
                        stones.add(s[k]);
                    }
                }
                if (canWin(stones, 1)) {
                    res++;
                }
            }
        }
        System.out.println(res);
    }
    
    public static boolean canWin(Vector<Integer> stones, int flag) {
        boolean isAliceWin = true;
        if (flag % 2 == 0) { // Alice
            if (DP_ALICE.containsKey(stones)) {
                return DP_ALICE.get(stones);
            }
            isAliceWin = false;
            for (int i = 0; i < stones.size(); i++) {
                if (stones.get(i) == 0) continue;
                for (int j = 0; j < stones.get(i); j++) {
                    int origin = stones.get(i);
                    stones.set(i, j);
                    isAliceWin = isAliceWin || canWin(stones, flag + 1);
                    stones.set(i, origin);
                }
            }
            DP_ALICE.put(stones, isAliceWin);
        } else { // Bob
            if (DP_BOB.containsKey(stones)) {
                return DP_BOB.get(stones);
            }
            for (int i = 0; i < stones.size(); i++) {
                if (stones.get(i) == 0) continue;
                for (int j = 0; j < stones.get(i); j++) {
                    int origin = stones.get(i);
                    stones.set(i, j);
                    isAliceWin = isAliceWin && canWin(stones, flag + 1);
                    stones.set(i, origin);
                }
            }
            DP_BOB.put(stones, isAliceWin);
        }
        return isAliceWin;
    }
}
 