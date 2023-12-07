package filess;

public class ActionQueue extends MyQueue<Direction> {
    private MyStack<String> stack;

    public ActionQueue() {
        super();
        stack = new MyStack<String>();
    }

    public void clear() {
        super.clear();
        stack.clear();
    }
    private boolean easyStr(String str) {
        for (char c : str.toCharArray()) {
            if ((c != 'N' && c != 'S' && c != 'W' && c != 'E')) {
                return false;
            }
        }
        return true;
    }
    private void enqueueDir(String str) {
        Direction d;
        for (char c : str.toCharArray()) {
            if (c == 'W') {
                d = (Direction.WEST);
            } else if (c == 'E') {
                d = (Direction.EAST);
            } else if (c == 'S') {
                d = (Direction.SOUTH);
            } else if (c == 'N') {
                d = (Direction.NORTH);
            } else {
                throw new IllegalArgumentException();
            }
            System.out.println(""+c);
            this.enqueue(d);
        }
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
    private static boolean testString(String str) {

        int bracket = 0;
        String lastC = "";
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
            } else if (c == 'N' || c == 'S' || c == 'W' || c == 'E' || Character.isDigit(c)) {
                if(isInt(lastC)){
                    return false;
                }
                continue;
            } else if (c == '[') {
                if(!isInt(lastC)){
                    return false;
                }
                bracket++;
            } else if (c == ']') {
                bracket--;
                if (lastC == "[") {
                    return false;
                }
            } else {
                return false;
            }
            lastC = "" + c;
        }
        return bracket == 0;
    }

    private static String removeB(String str) {//remove [ from beginning of String
        String newStr = "";
        for (int i = 1; i < str.length(); i++) {
            char c = str.charAt(i);
            newStr = newStr + c;
        }
        return newStr;
    }

    // 加一个进去，如果是方括号就新加一个，如果不是就加旧的里。------------------
    private void pushOne(char c) {
        String s = "";
        if(!this.stack.isEmpty()) {
            s = this.stack.pop();
        }
        s = s + c;
        this.stack.push(s);

    }

    private void pushB() {
        this.stack.push("[");
    }

    //-----------------------------------------------------------------------
    private int popNum() { // 在里面把数字找出来，然后return数字。
        String str = this.stack.pop();
        String newStr = "";
        String num = "";
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                num = num + c;
            } else {
                newStr = newStr + c;
            }
        }
        this.stack.push(newStr);
        return Integer.parseInt(num);
    }

    private void pushAll(String str) {// 为了配合bracketoff，把复制过的加到上面的括号去，
        String s;
        s = this.stack.pop();
        s = s + str;
        this.stack.push(s);
    }

    private void bracketOff() {//当出现 ] 的时候，
        int num;
        String dir;
        String newStr = "";
        dir = removeB(this.stack.pop()); //先pop出来最下面的去掉方括号
        num = popNum();//然后在上面一个找数
        for (int i = 0; i < num; i++) {
            newStr = newStr + dir;
        }
        this.pushAll(newStr);


    }

    public void loadFromEncodedString(String str) {
        if (!testString(str)) {
            throw new IllegalArgumentException();
        }
        if (this.easyStr(str)){
            this.enqueueDir(str);
        } else {
            for (char c : str.toCharArray()) {
                if (c == '[') {
                    this.pushB();
                } else if (c == ']') {
                    this.bracketOff();
                } else {
                    this.pushOne(c);
                }
            }
            if (!this.stack.isEmpty()) {
                String ss = this.stack.pop();
                this.enqueueDir(ss);
                System.out.println(ss);
            }
        }
    }
}



//        clear();
//        String k = "";
//        String d = "";
//        for (char c: str.toCharArray()){
//            if (Character.isDigit(c)){
//                k += c;
//            } else if (c == 'N' || c == 'S' || c == 'W' || c == 'E') {
//                d += c;
//            } else if (c == '[') {
//                stack.push(k);
//                stack.push(d);
//                k = "";
//                d = "";
//            } else if (c == ']') {
//                d = directions(stack.pop(), d);
//                k = stack.pop();
//                int num = Integer.parseInt(k);
//                for (int i = 0; i < num; i++){
//
//
//                    }
//                }
//
//            }





