import org.junit.Test;

public class NetworkUtilsTest {
    @Test(timeout = 5)
    public void TimoutShouldNotBeMoreeThenFiveMS() throws InterruptedException {
        NetworkUtils.getConnection();
    }
}
