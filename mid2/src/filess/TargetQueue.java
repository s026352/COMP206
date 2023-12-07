package filess;

import java.io.ObjectStreamException;

public class TargetQueue extends MyQueue<Position> {
    private MyStack<String> stack;

    public TargetQueue() {
        super();
        stack = new MyStack<String>();
    }

    public void clear() {
        super.clear();
        stack.clear();
    }

    public static boolean isInt(String str) {
        if (str.isEmpty()) {
            return false;
        }
        char c;
        for (int i = 0; i < str.length(); i++) {
            c = str.charAt(i);
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    public boolean testStr(String str) {
        char lastC = ' ';
        int bracket = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(') {
                if (lastC != ' ' && lastC != '.') {
                    return false;
                }
                bracket++;
            } else if (c == ')' || c == ',') {
                if (c == ')'){
                    bracket--;
                }
                if (!Character.isDigit(lastC)) {
                    return false;
                }
            } else if (Character.isDigit(c)) {
                if (lastC != '(' && !Character.isDigit(lastC) && lastC != ',') {
                    return false;
                }
            } else if (c == '.') {
                if (lastC != ' ' && lastC != ')') {
                    return false;
                }
            } else {
                return false;
            }
            lastC = c;
        }
        return bracket == 0;
    }

    public void addTargets(String str) {
        if (!this.testStr(str)) {
            throw new IllegalArgumentException();
        }
        String num = "";
        char input = ' ';


        for (int i = 0; i < str.length(); i++) {
            input = str.charAt(i);
            if (input == '(') {
                if (!stack.isEmpty() || !num.isEmpty()) {
                    throw new IllegalArgumentException();
                }
                stack.push("(");
            } else if (Character.isDigit(input)) {
                num = num + input;
            } else if (input == ',') {
                if (!isInt(num)) {
                    throw new IllegalArgumentException();
                }
                stack.push(num);
                stack.push((","));
                num = "";
            } else if (input == ')') {
                if (stack.getSize() != 3) {
                    throw new IllegalArgumentException();
                }
                String a = this.stack.pop();
                String b = this.stack.pop();
                String c = this.stack.pop();
                if (!a.equals(",") || !isInt(b) || !c.equals("(")) {
                    throw new IllegalArgumentException();
                }
                super.enqueue(new Position(Integer.parseInt(b), Integer.parseInt(num)));
                num = "";
            } else if (input == '.') {
                if (!stack.isEmpty() || !num.isEmpty()) {
                    throw new IllegalArgumentException();
                }
            } else {
                throw new IllegalArgumentException();
            }
        }
    }
}
