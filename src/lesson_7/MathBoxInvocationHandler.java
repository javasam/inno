package lesson_7;

import javafx.scene.chart.PieChart;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Date;

public class MathBoxInvocationHandler implements InvocationHandler {
    private MathBoxInterface mathBoxInterface;

    public MathBoxInvocationHandler(MathBoxInterface mathBoxInterface) {
        this.mathBoxInterface = mathBoxInterface;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = "";
        if (mathBoxInterface.getClass().getAnnotation(Logged.class) != null) {
            Date date = new Date();
            System.out.println("Proxy logging on");
            System.out.println("Time: " + date.toString() + " Method name: " + method.getName());
            result = method.invoke(mathBoxInterface, args);
        }
        if (mathBoxInterface.getClass().getAnnotation(ClearData.class) != null) {
            MathBox mathProxy = new MathBox();
            Field arrayListDivided = mathProxy.getClass().getDeclaredField("arrayListDivided");
            arrayListDivided.setAccessible(true);
            arrayListDivided.set(arrayListDivided, null);
            result = true;
        }
        return result;
    }
}
