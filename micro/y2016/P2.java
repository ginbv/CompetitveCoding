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

package mike.code.oj.micro.y2016;

import java.util.Arrays;

/**
 * @author Mike
 * @project oj.code
 * @date 4/23/I16, 2:21 PM
 * @e-mail mike@mikecoder.cn
 */
public class P2 {

    public static class Program {

        public static int Puzzle(int[] a) {
            int res = 0;
            Arrays.sort(a);
            if (a.length > 0 && a.length % 2 == 0) {
                res = a[a.length / 2 - 1];
            } else {
                res = a[a.length / 2];
            }

            int sum = 0;
            for (int num : a) {
                sum += num;
            }
            res = Math.min(sum / a.length, res);
            return res;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = { 3, 4, 5, 6 };
        System.out.println(Program.Puzzle(nums1));

        int[] nums2 = { 4, 14, 7 };
        System.out.println(Program.Puzzle(nums2));

        int[] nums3 = { 1 };
        System.out.println(Program.Puzzle(nums3));
    }
}
