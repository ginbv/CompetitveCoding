package mike.code.oj.hiho;

import java.util.Scanner;
import java.util.Vector;

/**
 * @author Mike
 * @project oj.code
 * @date 15/02/2017, 1:30 PM
 * @e-mail mike@mikecoder.cn
 */
public class P1289 {
    
    static class Rule {
        public String  address;
        public boolean isAllowed;
        
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            
            Rule address1 = (Rule) o;
            
            if (isAllowed != address1.isAllowed) return false;
            return address != null ? address.equals(address1.address) : address1.address == null;
        }
        
        @Override
        public int hashCode() {
            int result = address != null ? address.hashCode() : 0;
            result = 31 * result + (isAllowed ? 1 : 0);
            return result;
        }
    }
    
    public static String append8bit(String binary) {
        switch (binary.length()) {
            case 0:
                return "00000000";
            case 1:
                return "0000000" + binary;
            case 2:
                return "000000" + binary;
            case 3:
                return "00000" + binary;
            case 4:
                return "0000" + binary;
            case 5:
                return "000" + binary;
            case 6:
                return "00" + binary;
            case 7:
                return "0" + binary;
            default:
                return binary;
        }
    }
    
    // 128.127.4.100/20 => 10000000011111110000
    public static String ip2str(String ip) {
        StringBuilder stringBuilder = new StringBuilder(32);
        String res = null;
        String[] parts = ip.split("\\.");
        
        stringBuilder.append(append8bit(Integer.toBinaryString(Integer.valueOf(parts[0]))));
        stringBuilder.append(append8bit(Integer.toBinaryString(Integer.valueOf(parts[1]))));
        stringBuilder.append(append8bit(Integer.toBinaryString(Integer.valueOf(parts[2]))));
        if (parts[3].contains("/")) {
            String[] ip_mask = parts[3].split("/");
            stringBuilder.append(append8bit(Integer.toBinaryString(Integer.valueOf(ip_mask[0]))));
            res = stringBuilder.substring(0, Integer.valueOf(ip_mask[1]));
        } else {
            stringBuilder.append(append8bit(Integer.toBinaryString(Integer.valueOf(parts[3]))));
            res = stringBuilder.toString();
        }
        return res;
    }
    
    public static boolean check(String address, Vector<Rule> rules) {
        for (int i = 0; i < rules.size(); i++) {
            if (address.startsWith(rules.get(i).address)) {
                return rules.get(i).isAllowed;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int M, N;
        while (scanner.hasNext()) {
            N = scanner.nextInt();
            M = scanner.nextInt();
            scanner.nextLine();
            Vector<Rule> rules = new Vector<Rule>(N);
            for (int i = 0; i < N; i++) {
                String ruleStr = scanner.nextLine();
                Rule rule = new Rule();
                if (ruleStr.startsWith("a")) {
                    ruleStr = ruleStr.substring(6);
                    rule.isAllowed = true;
                    rule.address = ip2str(ruleStr);
                } else {
                    ruleStr = ruleStr.substring(5);
                    rule.isAllowed = false;
                    rule.address = ip2str(ruleStr);
                }
                rules.add(rule);
            }
            
            for (int i = 0; i < M; i++) {
                String IP = ip2str(scanner.nextLine());
                if (check(IP, rules)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }
}
