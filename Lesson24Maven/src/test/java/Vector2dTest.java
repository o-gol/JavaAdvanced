import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Vector2dTest {
    private  final double ESP=1e-9;
    private static Vector2d v1;

    //@Before                         //создается перед выполнением каждого метода
    @BeforeClass                      //создается перед выполнением всего класса
    public void createVector2d(){
        v1=new Vector2d();
    }

    @Test
    public void newVectorShouldHaveZeroLenght(){
        //Vector2d v1=new Vector2d(); //action
        //assertion
        Assert.assertEquals(0,v1.lenght(),ESP);
    }
    @Test
    public void newVectorXShouldBeZero(){
        //Vector2d v1=new Vector2d();
        Assert.assertEquals(0,v1.getX(),ESP);
    }

@Test
    public void newVectorYShouldBeZero(){
        //Vector2d v1=new Vector2d();
        Assert.assertEquals(0,v1.getY(),ESP);
    }

}
