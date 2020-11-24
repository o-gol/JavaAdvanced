public class MyMath {
    public  static double devid(int a,int b){
        if( b==0){
            throw new ArithmeticException("Cant devid on zero");
        }
        return a/b;
    }
}
