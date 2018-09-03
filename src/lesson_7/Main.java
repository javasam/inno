package lesson_7;

import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
        Integer[] arrayInt = {1, 22, 45, 598, 32, 87, 54};
        MathBoxInterface math = new MathBox(arrayInt);
        MathBoxInterface mathProxy = (MathBoxInterface) Proxy.newProxyInstance(MathBoxInvocationHandler.class.getClassLoader(),
                new Class[]{MathBoxInterface.class}, new MathBoxInvocationHandler(math));
        mathProxy.summator();
        System.out.println(mathProxy.setArray());
    }
}
