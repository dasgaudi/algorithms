
import java.util.Stack;

class DecodeString {
    static String decodeString(String s) {
        if(s.length()==0) return "";
        Stack<String> stack = new Stack<>();
        int num = 0;

        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(c>='0' && c<='9') num = num*10 + c -'0';
            else if(c=='[') {
                stack.push(num + "");
                stack.push("["); //use [ as a marker so we don't have to check whether an item is a number or not
                num = 0;
            } else if(c==']') {
                StringBuilder str = new StringBuilder();
                //keep pop until meet '['
                while(!stack.peek().equals("[")) str.insert(0, stack.pop());
                // remove the '['
                stack.pop();
                stack.push(String.valueOf(str).repeat(Math.max(0, Integer.parseInt(stack.pop()))));
            } else stack.push(c+"");
        }

        StringBuilder result = new StringBuilder();
        while(!stack.isEmpty()) result.insert(0, stack.pop());
        return result.toString();
    }

    public static void main(String[] args) {
        String s = "3[a]2[bc]";
        System.out.println("the result of the decode String "+s+" : "+decodeString(s));
    }
}