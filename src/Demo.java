import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo<E> {

    private ArrayStack<E> stackArr = new ArrayStack<>();
    private String str;


    public Demo(String str) {
        this.str = str;
    }

    public static void main(String[] args) {


        System.out.println( pushSymbol("(]"));
    }

    private static boolean pushSymbol(String str) {
//        Pattern p = Pattern.compile("\\[|\\{|\\(");
//        Matcher m;
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char e = str.charAt(i);

            if (e == '[' || e == '(' || e == '{') {
                stack.push(e);
            } else {
                if (stack.isEmpty()){
                    return false;
                }
                char topE = stack.pop();
                if (e == ']' && topE != '[') {
                    return false;
                }
                if (e == ')' && topE != '(') {
                    return false;
                }
                if (e == '}' && topE != '{') {
                    return false;
                }

            }

        }
        return stack.isEmpty();
    }


}
