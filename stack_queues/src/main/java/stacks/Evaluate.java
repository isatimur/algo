package stacks;

/**
 * Created by isati on 14.11.2016.
 */
public class Evaluate {
    public static void main(String[] args) {
        StackIterable<String> ops = new StackIterable<>();
        StackIterable<Double> vals = new StackIterable<>();

        String expr = "( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )";
        String[] array = expr.split(" ");
        for (int i = 0; i < array.length; i++) {
            String s = array[i];
            if (s.equals("(")) ;
            else if (s.equals("+")) ops.push(s);
            else if (s.equals("*")) ops.push(s);
            else if (s.equals(")")) {
                String op = ops.pop();
                if (op.equals("+")) vals.push(vals.pop() + vals.pop());
                else if (op.equals("*")) vals.push(vals.pop() * vals.pop());
            } else {
                vals.push(Double.parseDouble(s));
            }
        }
        System.out.println(vals.pop());

    }
}
