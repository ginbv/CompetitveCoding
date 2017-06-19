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
 *  3. Neither the name of Lloyd Hilaiel nor the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE AUTHOR AS IS'' AND ANY EXPRESS OR
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

import java.util.Stack;

/**
 * @author Mike
 * @project oj.code
 * @date 7/18/15, 7:14 PM
 * @e-mail mike@mikecoder.net
 */
public class SimplifyPath {

    public String simplifyPath(String path) {
        Stack<String> paths = new Stack<String>();
        String[] nodes = path.split("/");
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i].equals("..")) {
                if (paths.size() == 0) continue;
                paths.pop();
            } else if (nodes[i].equals(".")) {
                // nothing
            } else if (!nodes[i].equals("")) {
                paths.push(nodes[i]);
            }
        }
        StringBuilder strbuilder = new StringBuilder();
        for (int i = 0; i < paths.size(); i++) {
            strbuilder.append('/');
            strbuilder.append(paths.elementAt(i));
        }
        if (strbuilder.length() == 0) strbuilder.append('/');

        return strbuilder.toString();
    }

    public static void main(String[] args) {
        SimplifyPath simplifyPath = new SimplifyPath();
        System.out.println(simplifyPath.simplifyPath("/a/./b/../../c/"));

    }
}
