package praktikum;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

    public class BunTest {
        private float price;
        private String name;
        private Bun bun;

        @Before
        public void setUp(){
            price = 59;
            name = "Булка из радтараканов";
            bun = new Bun(name, price);
        }

        @Test
        public void getNameTest(){
            String actualName = bun.getName();
            assertEquals(name, actualName);
        }

        @Test
        public void getPriceTest(){
            float actualPrice = bun.getPrice();
            assertEquals(price, actualPrice, 0);
        }
}
