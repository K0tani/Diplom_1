package praktikum;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientParameterizedTest {
    private final IngredientType type;
    private final String name;
    private final float price;
    private Ingredient ingredient;

    public IngredientParameterizedTest(IngredientType type, String name, float price) {
        super();
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Before
    public void initObject() {
        ingredient = new Ingredient(type, name, price);
    }

    @Parameterized.Parameters(name = "Тип ингредиента: {0}.  Название ингредиента: {1}. Цена: {2}")
    public static Object[][] dataForTest() {
        return new Object[][]{
                {SAUCE, "Соус нетрадиционный", 261.40f},
                {FILLING, "Яйцо", 99.99f},
                {SAUCE, "Соус с шипами", 14},
                {FILLING, "Говядина", 0},
        };
    }

    @Test
    public void ingredientTypeTest() {
        assertEquals(type, ingredient.type);
        assertEquals(name, ingredient.name);
        assertEquals(price, ingredient.price, 0.00f);
    }
}