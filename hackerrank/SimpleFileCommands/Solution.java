package mike.code.oj.hackerrank.SimpleFileCommands;

import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author Mike
 * @project oj.code
 * @date 27/05/2017, 3:01 PM
 * @e-mail mike@mikecoder.cn
 */

public class Solution {
    
    static class lists {
        int currentIdx = 0;
        PriorityQueue<Integer> available;
    }
    
    static String generateFileName(int idx, String filename) {
        if (idx == 0) return filename;
        return filename + "(" + idx + ")";
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        
        HashMap<String, lists> files = new HashMap<>();
        
        for (int a0 = 0; a0 < q; a0++) {
            String command = in.next();
            String filename = in.next();
            
            switch (command) {
                case "crt": {
                    int currentIdx = 0;
                    if (!files.containsKey(filename)) {
                        lists lists = new lists();
                        lists.available = new PriorityQueue<>();
                        lists.currentIdx = currentIdx;
                        files.put(filename, lists);
                    } else {
                        lists newfile = files.get(filename);
                        if (newfile.available.size() == 0) {
                            currentIdx = newfile.currentIdx + 1;
                            files.get(filename).currentIdx++;
                        } else {
                            currentIdx = files.get(filename).available.poll();
                        }
                    }
                    System.out.println("+ " + generateFileName(currentIdx, filename));
                    break;
                }
                case "del": {
                    int idx = 0;
                    if (filename.contains("(")) {
                        idx = Integer.valueOf(filename.substring(filename.indexOf('(') + 1, filename.indexOf(')')));
                        filename = filename.substring(0, filename.indexOf('('));
                    }
                    files.get(filename).available.add(idx);
                    System.out.println("- " + generateFileName(idx, filename));
                    break;
                }
                case "rnm": {
                    int idx = 0;
                    if (filename.contains("(")) {
                        idx = Integer.valueOf(filename.substring(filename.indexOf('(') + 1, filename.indexOf(')')));
                        filename = filename.substring(0, filename.indexOf('('));
                    }
                    files.get(filename).available.add(idx);
                    
                    String movedFile = in.next();
                    int currentIdx = 0;
                    if (!files.containsKey(movedFile)) {
                        lists lists = new lists();
                        lists.available = new PriorityQueue<>();
                        lists.currentIdx = currentIdx;
                        files.put(movedFile, lists);
                    } else {
                        lists newfile = files.get(movedFile);
                        if (newfile.available.size() == 0) {
                            currentIdx = newfile.currentIdx + 1;
                            files.get(movedFile).currentIdx++;
                        } else {
                            currentIdx = files.get(movedFile).available.poll();
                        }
                    }
                    System.out.println("r " + generateFileName(idx, filename) + " -> " + generateFileName(currentIdx, movedFile));
                    break;
                }
            }
        }
    }
    
    public static void _main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        
        HashSet<String> files = new HashSet<>();
        
        for (int a0 = 0; a0 < q; a0++) {
            String command = in.next();
            String filename = in.next();
            
            switch (command) {
                case "crt": {
                    int idx = 0;
                    while (files.contains(generateFileName(idx, filename))) {
                        idx++;
                    }
                    files.add(generateFileName(idx, filename));
                    System.out.println("+ " + generateFileName(idx, filename));
                    break;
                }
                case "del": {
                    if (files.contains(filename)) {
                        files.remove(filename);
                        System.out.println("- " + filename);
                    }
                    break;
                }
                case "rnm": {
                    String newname = in.next();
                    if (files.contains(filename)) {
                        files.remove(filename);
                        int idx = 0;
                        while (files.contains(generateFileName(idx, newname))) {
                            idx++;
                        }
                        files.add(generateFileName(idx, newname));
                        System.out.println("r " + filename + " -> " + generateFileName(idx, newname));
                    }
                    break;
                }
            }
        }
    }
}

