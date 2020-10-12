import java.lang.annotation.Annotation;

public class MyTest {

    @AfterSuite
    public static void after() {
        System.out.println("after");
    }

    @Test()
    public static void test1() {
        System.out.println("test 1");
    }

    @BeforeSuite
    public static void before() {
        System.out.println("before");
    }

    @Test(priority = 10)
    public static void test2() {
        System.out.println("test 2");
    }

    @Test(priority = 2)
    public static void test3() {
        System.out.println("test 3");
    }

    @Test(priority = 6)
    public static void test4() {
        System.out.println("test 4");
    }

    @Test(priority = 1)
    public static void test5() {
        System.out.println("test 5");
    }
}
