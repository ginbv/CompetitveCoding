/*******************************************************************************
 * Copyright (c) since 2015  @Mike Tang.
 * <p/>
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 * <p/>
 * 1. Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 * <p/>
 * 2. Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer in
 * the documentation and/or other materials provided with the
 * distribution.
 * <p/>
 * 3. Neither the name of Mike Tang nor the names of its
 * contributors may be used to endorse or promote products derived
 * from this software without specific prior written permission.
 * <p/>
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
import java.util.HashSet;

/**
 * @author Mike
 * @project oj.code
 * @date 4/23/I16, 2:39 PM
 * @e-mail mike@mikecoder.cn
 */
public class P4 {
    public static class Program {
        public static String[] Puzzle(int n) {
            HashSet<String> res = new HashSet<String>();
            res.add("()");
            for (int i = 1; i <= n; i++) {
                res = generate(res);
            }
            return res.toArray(new String[res.size()]);
        }

        public static HashSet<String> generate(HashSet<String> res) {
            HashSet<String> ret = new HashSet<String>();
            for (String str : res) {
                for (int i = 1; i <= str.length() - 1; i = i + 1) {
                    ret.add(str.substring(0, i) + "()" + str.substring(i, str.length()));
                }
            }
            return ret;
        }

    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(Program.Puzzle(2)));
        System.out.println(Arrays.toString(Program.Puzzle(4)));
    }
}
