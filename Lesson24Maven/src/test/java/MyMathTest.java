import org.junit.Test;

public class MyMathTest {

    @Test(expected = ArithmeticException.class)
    public void MyMAthDevidShouldTrowExeption(){
        MyMath.devid(10,0);

    }
}
