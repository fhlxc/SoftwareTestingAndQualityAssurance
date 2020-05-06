package problem.medium;

import problems.utils.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 */
public class LinkedListComponents {
    public int numComponents(ListNode head, int[] g) {

        Map<Integer, Boolean> flag = new HashMap<>();
        //Map<Integer, ListNode> map=new HashMap<>();
        ListNode x = head;
        while (x != null) {
            //  map.put(x.val, x);
            flag.put(x.val, false);
            x = x.next;
        }
        for (int i = 0; i < g.length; i++) {
            flag.put(g[i], true);
        }
        x = head;
         
        int c = 1;
        
        boolean current = true;
        while (x != null) {
            if (current != flag.get(x.val)) {
                if (flag.get(x.val))
                    c++;
                current = !current;
            }
            x = x.next;
        }
        return c;

    }
}
