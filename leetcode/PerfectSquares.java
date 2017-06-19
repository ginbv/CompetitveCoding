/*******************************************************************************
 * Copyright (c) since 2015  @Mike Tang.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *  1. Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *  2. Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in
 *     the documentation and/or other materials provided with the
 *     distribution.
 *
 *  3. Neither the name of Mike Tang nor the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE AUTHOR AS IS AND ANY EXPRESS OR
 * IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT,
 * INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,
 * STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING
 * IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 ******************************************************************************/

package mike.code.oj.leetcode;

/**
 * @author Mike
 * @project oj.code
 * @date 3/1/I16, 4:48 PM
 * @e-mail mike@mikecoder.cn
 */
public class PerfectSquares {

    public int numSquares(int n) {
        int count = 0;
        int[] s = new int[n + 1];
        for (int i = 0; i < n + 1; i++)
            s[i] = Integer.MAX_VALUE;

        for (int i = 1; i < n + 1; i++) {
            int sqrt = (int) Math.sqrt(i);
            if (i == sqrt * sqrt) {
                s[i] = 1;
                continue;
            }
            for (int j = 1; j <= sqrt; j++) {
                count ++;
                if (s[i - j * j] + 1 < s[i]) s[i] = s[i - j * j] + 1;
            }
        }

        return s[n];
    }

    public static void main(String[] args) {
        System.out.println(new PerfectSquares().numSquares(9732));
    }
}
