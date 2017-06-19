package mike.code.oj.hackerrank.CityConstruction;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;

/**
 * @author Mike
 * @project oj.code
 * @date 27/05/2017, 4:33 PM
 * @e-mail mike@mikecoder.cn
 */

public class Solution {
    
    static class City {
        int           index = 0;
        HashSet<City> pre   = new HashSet<>();
        HashSet<City> next  = new HashSet<>();
        
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            
            City city = (City) o;
            
            return index == city.index;
        }
        
        @Override
        public int hashCode() {
            return index;
        }
        
        @Override
        public String toString() {
            return "City{" + "index=" + index + ", pre=" + pre.size() + ", next=" + next.size() + '}';
        }
    }
    
    static void fillAll(Vector<City> cities, int currentIdx) {
        if (cities.elementAt(currentIdx).pre.size() == 0) return;
    
        Stack<City> nexts = new Stack<>();
        while (!nexts.isEmpty()) {
            
        }
        for (City city : cities.elementAt(currentIdx).pre) {
            cities.elementAt(city.index).next.addAll(cities.elementAt(currentIdx).next);
            fillAll(cities, city.index);
        }
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        
        Vector<City> cities = new Vector<>();
        for (int i = 0; i < n; i++) {
            City city = new City();
            city.index = i;
            cities.add(city);
        }
        int m = in.nextInt();
        for (int a0 = 0; a0 < m; a0++) {
            int u = in.nextInt() - 1;
            int v = in.nextInt() - 1;
            
            cities.elementAt(u).next.add(cities.elementAt(v));
            cities.elementAt(v).pre.add(cities.elementAt(u));
        }
        
        for (int i = 0; i < n; i++) {
            if (cities.elementAt(i).next.size() == 0) {
                fillAll(cities, i);
            }
        }
        
        int q = in.nextInt();
        for (int a0 = 0; a0 < q; a0++) {
            int type = in.nextInt();
            int x = in.nextInt() - 1;
            int y = in.nextInt();
            
            switch (type) {
                case 1: {
                    City city = new City();
                    city.index = n;
                    n++;
                    if (y == 0) {
                        city.pre.add(cities.elementAt(x));
                        cities.add(city);
                        cities.elementAt(x).next.add(cities.elementAt(cities.size() - 1));
                        fillAll(cities, x);
                    } else {
                        city.next.add(cities.elementAt(x));
                        city.next.addAll(cities.elementAt(x).next);
                        cities.add(city);
                        cities.elementAt(x).pre.add(cities.elementAt(cities.size() - 1));
                    }
                    break;
                }
                case 2: {
                    if (cities.elementAt(x).next.contains(cities.elementAt(y - 1))) {
                        System.out.println("Yes");
                    } else {
                        System.out.println("No");
                    }
                    break;
                }
            }
        }
    }
}

