import com.sun.javafx.collections.MappingChange;
import com.sun.org.apache.bcel.internal.classfile.Annotations;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class Main {
    static final int PRIORITY = 10;

    public static void main(String[] args) throws Exception {
        start(MyTest.class);
    }

    static void start(Class c) throws Exception {
        Method[] methods = c.getDeclaredMethods();

        //Запускаем методы с аннотацией @BeforeSuite
        boolean beforeMethod = false;
        for (Method m : methods) {
            if (m.isAnnotationPresent (BeforeSuite.class)) {
                beforeMethod = true;
                m.invoke(null);
            }
        }
        if (beforeMethod == false) {
            throw new RuntimeException("Нет @BeforeSuite");
        }

        //Выполняем тесты по приоритетам
        for (int i = PRIORITY; i >= 0; i--) {
            for (Method m : methods) {
                if (m.isAnnotationPresent(Test.class)) {
                    if (m.getDeclaredAnnotation(Test.class).priority() == i) {
                        //System.out.println(m.getDeclaredAnnotation(Test.class).priority());
                        //System.out.println(m);
                        m.invoke(null);
                    }
                }
            }
        }

        //Выполняем AfterSuite
        for (Method m : methods) {
            if (m.isAnnotationPresent (AfterSuite.class)) {
                m.invoke(null);
            }
        }
    }
}