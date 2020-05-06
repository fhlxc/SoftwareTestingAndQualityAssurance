package problem.medium;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Why Did you create this class? what does it do?
 */
public class CarFleet {

    public int carFleet(int target, int[] position, int[] speed) {

        if (speed == null || speed.length == 0)
            return 0;
        if (speed.length == 1)
            return 1;

        int r = 0;
        Pair[] pairs = new Pair[speed.length];

        for (int i = 0; i < speed.length; i++) {
            pairs[i] = new Pair(position[i], speed[i]);
        }
        Arrays.sort(pairs, Comparator.comparingInt(a -> a.pos));
        double[] a = new double[pairs.length];
        for (int i = pairs.length - 1; i >= 0; i--) {
            a[i] = (target - pairs[i].pos) / pairs[i].speed;
        }
        boolean infleet = false;
        for (int i = a.length - 1; i > 0; i--) {
            if (a[i] < a[i - 1]) {
                r += infleet ? 0 : 1;
                infleet = false;
                continue;
            }
            if (!infleet) {
                r++;
                infleet = true;
            }
            a[i - 1] = Math.max(a[i - 1], a[i]);
        }

        r += (a[0] > a[1] ? 1 : 0);
        return r;
    }

    class Pair {
        int pos;
        int speed;

        Pair(int p, int s) {
            pos = p;
            speed = s;
        }
    }
}
