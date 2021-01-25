import java.util.function.Consumer;

public class LambdaScopeTest {
    double d=0.123;
    class LambdaScopeInner {
        double d=456.123;

        void testScope(double d){
            Consumer<Double> res=a->{
                System.out.println("a= "+a);
                System.out.println("d= "+d);
                System.out.println("this.d= "+this.d);
                //System.out.println("LambdaScopeTest.this.d= "+LambdaScopeTest.this.d);
            };
            res.accept(777.888);
        }
    }
}
