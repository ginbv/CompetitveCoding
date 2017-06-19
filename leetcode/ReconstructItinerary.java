package mike.code.oj.leetcode;

import java.util.*;

/**
 * @author Mike
 * @project oj.code
 * @date 5/26/I16, 4:I16 PM
 * @e-mail mike@mikecoder.cn
 */
public class ReconstructItinerary {

    public static class Solution {

        LinkedList<String> path = new LinkedList<String>();

        public List<String> findItinerary(String[][] tickets) {
            path.clear();
            HashMap<String, ArrayList<String>> routes = new HashMap<String, ArrayList<String>>();
            for (String[] ticket : tickets) {
                if (ticket[0].equals("JFK")) {
                    ticket[0] = "A";
                }
            }
            Arrays.sort(tickets, new Comparator<String[]>() {
                public int compare(String[] o1, String[] o2) {
                    if (o1[0].equals(o2[0])) {
                        return o1[1].compareTo(o2[1]);
                    } else {
                        return o1[0].compareTo(o2[0]);
                    }
                }
            });
            for (String[] ticket : tickets) {
                if (ticket[0].equals("A")) {
                    ticket[0] = "JFK";
                }
                if (routes.containsKey(ticket[0])) {
                    routes.get(ticket[0]).add(ticket[1]);
                } else {
                    ArrayList<String> next = new ArrayList<String>();
                    next.add(ticket[1]);
                    routes.put(ticket[0], next);
                }
            }
            path.add("JFK");
            _findNext(routes, "JFK");
            ArrayList<String> res = new ArrayList<String>(path.size());
            for (String next : path) {
                res.add(0, next);
            }
            return res;
        }

        public boolean _findNext(HashMap<String, ArrayList<String>> routes, String next) {
            //            System.out.println(path);
            //            System.out.println(routes);
            if (routes.size() == 0) {
                return true;
            }
            if (!routes.containsKey(next)) {
                return false;
            } else {
                for (int i = 0; i < routes.get(next).size(); i++) {
                    String nnext = routes.get(next).get(i);
                    routes.get(next).remove(i);
                    if (routes.get(next).size() == 0) {
                        routes.remove(next);
                    }
                    path.push(nnext);
                    boolean res = _findNext(routes, nnext);
                    if (res) {
                        return true;
                    }
                    path.pop();
                    if (!routes.containsKey(next)) {
                        routes.put(next, new ArrayList<String>());
                    }
                    routes.get(next).add(i, nnext);
                }
                return false;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[][] tickets = { { "JFK", "SFO" }, { "JFK", "ATL" }, { "SFO", "ATL" }, { "ATL", "JFK" }, { "ATL", "SFO" } };
        System.out.println(solution.findItinerary(tickets));

        tickets = new String[][] { { "JFK", "KUL" }, { "JFK", "NRT" }, { "NRT", "JFK" } };
        System.out.println(solution.findItinerary(tickets));

        tickets = new String[][] { { "EZE", "TIA" }, { "EZE", "HBA" }, { "AXA", "TIA" }, { "JFK", "AXA" }, { "ANU", "JFK" },
                { "ADL", "ANU" }, { "TIA", "AUA" }, { "ANU", "AUA" }, { "ADL", "EZE" }, { "ADL", "EZE" }, { "EZE", "ADL" },
                { "AXA", "EZE" }, { "AUA", "AXA" }, { "JFK", "AXA" }, { "AXA", "AUA" }, { "AUA", "ADL" }, { "ANU", "EZE" },
                { "TIA", "ADL" }, { "EZE", "ANU" }, { "AUA", "ANU" } };
        System.out.println(solution.findItinerary(tickets));
    }
}
