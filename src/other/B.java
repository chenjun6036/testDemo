package other;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class B {
    public void print() {
        System.out.println("B");
    }

    public void print1() {
        System.out.println("B1");
    }

    static char[] toCharBits(long num, int size) {
        char[] charBits = new char[size];
        for (int i = size - 1; i >= 0; --i) {
            charBits[i] = (num & 1) == 0 ? '0' : '1';
            num >>>= 1;
        }
        return charBits;
    }

    public static int foo(int x) {
        return x & -x;
    }

    static int ack(int m, int n) {
        if (m == 0)
            return n + 1;
        else if (n == 0)
            return ack(m - 1, 1);
        else
            return ack(m - 1, ack(m, n - 1));
    }

    public static int evalRPN(String[] tokens) {
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+")) {
                Integer a = stack.pop();
                Integer b = stack.pop();
                stack.push(a + b);
            } else if (tokens[i].equals("-")) {
                Integer a = stack.pop();
                Integer b = stack.pop();
                stack.push(a - b);
            } else if (tokens[i].equals("*")) {
                Integer a = stack.pop();
                Integer b = stack.pop();
                stack.push(a * b);
            } else if (tokens[i].equals("/")) {
                Integer a = stack.pop();
                Integer b = stack.pop();
                stack.push(a / b);
            } else {
                stack.push(Integer.valueOf(tokens[i]));
            }
        }

        return stack.pop();
    }

    public static int maxPoints(Point[] points) {
        int max = 0;
        if (points.length != 0)
            max = 1;
        for (int i = 0; i < points.length; i++) {
            Map<Double, Integer> map = new HashMap<>();
            int dum = 0;
            int ans = 1;
            Point p1 = points[i];
            for (int j = 0; j < points.length; j++) {
                if (i == j)
                    continue;
                Point p2 = points[j];
                if (p1.x == p2.x && p1.y == p2.y) {
                    dum++;
                    continue;
                }

                if (p1.x == p2.x) {
                    if (map.get(Double.MAX_VALUE) == null)
                        map.put(Double.MAX_VALUE, 2);
                    else
                        map.put(Double.MAX_VALUE, map.get(Double.MAX_VALUE) + 1);
                    ans = ans > map.get(Double.MAX_VALUE) ? ans : map.get(Double.MAX_VALUE);
                } else {
                    Double k = (double) ((p2.y - p1.y) / (p2.x - p1.x));
                    if (map.get(k) == null)
                        map.put(k, 2);
                    else
                        map.put(k, map.get(k) + 1);
                    ans = ans > map.get(k) ? ans : map.get(k);
                }
            }
            max = max > (ans + dum) ? max : (ans + dum);
        }
        return max;
    }


    /**
     * @param args
     */
    public static void main(String[] args) {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(1, 1);
        Point p3 = new Point(1, -1);
        Point[] ps = {p1, p2, p3};
        System.out.println(maxPoints(ps));
    }
}

class Point {
    int x;
    int y;

    Point() {
        x = 0;
        y = 0;
    }

    Point(int a, int b) {
        x = a;
        y = b;
    }
}
