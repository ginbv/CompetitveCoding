package mike.code.oj.hiho;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author Mike
 * @project oj-code
 * @date 4/3/15, 11:36 AM
 * @e-mail mike@mikecoder.net
 */
public class P1086 {

    static long priority = 0;

    static class Site implements Comparable {
        String site;
        long   priority;

        @Override
        public int compareTo(Object o) {
            return priority > ((Site) o).priority ? 1 : -1;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Site site1 = (Site) o;
            return !(site != null ? !site.equals(site1.site) : site1.site != null);
        }

        @Override
        public int hashCode() {
            return site != null ? site.hashCode() : 0;
        }

        @Override
        public String toString() {
            return "Site{" + "site='" + site + '\'' + ", priority=" + priority + '}';
        }
    }

    static PriorityQueue<Site> caches = new PriorityQueue<Site>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            caches.clear();

            int N = scanner.nextInt();
            int M = scanner.nextInt();

            for (int i = 0; i < N; i++) {
                String visitSite = scanner.next();
                Site web = new Site();
                web.site = visitSite;
                web.priority = priority++;
                searchFromCache(web, M);
            }
        }
    }

    public static void searchFromCache(Site web, int M) {
        if (caches.contains(web)) {
            caches.remove(web);
            caches.add(web);
            System.out.println("Cache");
        } else if (caches.size() < M) {
            caches.add(web);
            System.out.println("Internet");
        } else {
            caches.poll();
            caches.add(web);
            System.out.println("Internet");
        }
    }
}
