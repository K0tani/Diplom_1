package praktikum;
import org.junit.Assert;
import org.junit.Test;

public class IngredientTest {
    @Test
    public void getNameTest() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "Огурчик Рик", 611);
        String actual = ingredient.getName();
        Assert.assertEquals(ingredient.name, actual);
    }

    @Test
    public void getPriceTest() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Соус Space-X", 900);
        float actual = ingredient.getPrice();
        Assert.assertEquals(ingredient.price, actual, 0);
    }
}
