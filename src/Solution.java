import java.util.regex.Pattern;

public class Solution<E> {

    private ArrayStack<E> stackArr = new ArrayStack<>();
    private String str;


    public Solution(String str) {
        this.str = str;
    }
    public Solution(){}
    public static void main(String[] args) {


        System.out.println(new Solution().isValid("(]"));
        System.out.println(new Solution().isValid("(){()}[]"));
    }

    private  boolean isValid(String str) {
//        Pattern p = Pattern.compile("\\[|\\{|\\(");
//        Matcher m;
        ArrayStack<Character> stack = new ArrayStack<>();

        for (int i = 0; i < str.length(); i++) {
            char e = str.charAt(i);

            if (Pattern.matches("\\[|\\(|\\{",String.valueOf(e))) {
//            if (e == '[' || e == '(' || e == '{') {
                stack.push(e);
            } else {
                if (stack.isEmpty()) {
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
