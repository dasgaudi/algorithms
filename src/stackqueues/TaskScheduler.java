import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class TaskScheduler {

    // the idea here is to add them to a PQ with the sort based on the high frequency
    // e.g) "A", "A", "A", "B", "B" -> (A,3), (B,2) in PQ
    static int lesatInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i=0; i<tasks.length; i++) {
            map.put(tasks[i], map.getOrDefault(tasks[i], 0)+1);
        }
        
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
            (a,b) -> a.getValue() != b.getValue() ? b.getValue() - a.getValue() : a.getKey() - b.getKey()
        );
        pq.addAll(map.entrySet());

        int count = 0;
        while (!pq.isEmpty()) {
            // keep k distnace
            int interval = n+1; 

            List<Map.Entry<Character, Integer>> list = new ArrayList<>();
            
            // fill the interval with the next high freq task
            while (interval>0 && !pq.isEmpty()) {
                Map.Entry<Character, Integer> entry = pq.poll();
                entry.setValue(entry.getValue()-1);
                list.add(entry);
                interval--;
                count++;
            }

            // update pq with the valid task
            for (Map.Entry<Character, Integer> entry: list) {
                if (entry.getValue() > 0) pq.add(entry);
            }

            if (pq.isEmpty()) break;

            // if interval is > 0, then the machine can only be idle
            count = count + interval;
        }
        return count;
    }    
}
