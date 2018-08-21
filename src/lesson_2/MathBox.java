package lesson_2;

import java.util.ArrayList;
import java.util.List;

public class MathBox {
    public int summa(Integer a, Integer b) {
        a = a + b;
        return a;
    }

    public int diff(Integer a, Integer b) {
        a = a - b;
        return a;
    }

    public long factorial(Integer a) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i > 0; i++) {
            list.add(a * (a - i));
        }
        return a;
    }

    public double dividerExceptionInside(Integer a, Integer b) {
        if (b == 0) {
            System.out.println("На ноль делить нельзя!");
        } else {
            a = a / b;
        }
        return a;
    }

    public double divider(Integer a, Integer b) throws ArithmeticException {
        a = a / b;
        return a;
    }

    public double dividerException(Integer a, Integer b) throws ZeroDivideException {
        if (b == 0) {
            throw new ZeroDivideException("Деление на ноль!");
        } else {
            a = a / b;
        }
        return a;
    }
}