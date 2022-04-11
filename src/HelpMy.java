import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class HelpMy {

    public static void main(String[] args) throws MyException {

        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("II", 2);
        map.put("III", 3);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("VI", 6);
        map.put("VII", 7);
        map.put("VIII", 8);
        map.put("IX", 9);
        map.put("X", 10);

        Scanner s = new Scanner(System.in);
        System.out.println("введите выражение");
        String str = s.nextLine();
       // System.out.println("вы ввели "+ x);
        String[] elements = str.split(" ");

        int x;
        int y;

       try {
           x = Integer.valueOf(elements[0]);
           try {
               y = Integer.valueOf(elements[2]);
           } catch (NumberFormatException e) {
               throw new MyException("Введенные значения разных форматов");
           }

           if (x > 10 || x < 1 || y < 1 || y > 10 ) {
               throw new MyException("Введенное значение должно быть от 1 до 10");
           }
           //   System.out.println("x=" + x + ", y=" + y +"; x+y=" + (x+y));
           int result = operation(elements[1], x, y);
           System.out.println("Output: " + result);
       } catch (NumberFormatException e) {
           if (map.containsKey(elements[0])) {
               x = map.get(elements[0]);
               y = map.get(elements[2]);
               System.out.println("Output: " + RomanNumber.toRoman(operation(elements[1], x, y)));
           }
       }
    }

    private static int operation (String op, int x, int y) {
        int result = 0;
        if ("+".equals(op)) {
            result = x + y;
        }

        if ("-".equals(op)) {
            result = x - y;

        }

        if ("*".equals(op)) {
            result = x * y;
        }

        if ("/".equals(op)) {
            result =  x / y;
        }
        return result;
    }
}

class MyException extends Exception {
    MyException(String message) {
        super(message);
    }
}

class RomanNumber {

    private final static TreeMap<Integer, String> map = new TreeMap<>();

    static {
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");
    }

    public final static String toRoman(int number) {
        int l =  map.floorKey(number);
        if ( number == l ) {
            return map.get(number);
        }
        return map.get(l) + toRoman(number-l);
    }

}
