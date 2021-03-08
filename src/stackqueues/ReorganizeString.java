import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class ReorganizeString {
    // the idea here is to find the highest frequent character 
    // put it in even index
    // put others in the rest
    static String reorganizeString(String S) {
        
        Map<Character, Integer> map = new HashMap<>();
        
        for(char c: S.toCharArray()) {
             map.put(c, map.getOrDefault(c, 0)+1);
        }
        
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
            (a,b) -> a.getValue() != b.getValue() ? b.getValue()-a.getValue() : a.getKey() - b.getKey()
        );
        
        pq.addAll(map.entrySet());
        
        
        int max = pq.peek().getValue();
        if (max > (S.length()+1)/2) return "";
        
        StringBuilder sb = new StringBuilder();
        
        while (!pq.isEmpty()) {
            Map.Entry<Character, Integer> first = pq.poll();
            if (sb.length() == 0 || sb.charAt(sb.length()-1) != first.getKey()) {
                sb.append(first.getKey());
                first.setValue(first.getValue()-1);
                if (first.getValue() > 0) {
                    pq.add(first);
                }
            } else {
                // if the character == the last character 
                Map.Entry<Character, Integer> second = pq.poll();
                sb.append(second.getKey());
                second.setValue(second.getValue()-1);
                if (second.getValue() > 0) {
                    pq.add(second);
                }
                pq.add(first);
            }
              
        }
        return sb.toString();
    }    
}
