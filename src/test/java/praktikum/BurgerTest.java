package praktikum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    Burger burger = new Burger();
    @Mock
    private Bun bun;
    @Mock
    private Ingredient firstIngredient;

    @Mock
    private Ingredient secondIngredient;

    @Test
    public void setBuns() {
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(firstIngredient);
        assertEquals(firstIngredient, burger.ingredients.get(0));
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(firstIngredient);
        burger.removeIngredient(0);
        assertTrue(burger.ingredients.isEmpty());
    }

    @Test
    public void moveIngredientTest() {
        burger.ingredients.add(firstIngredient);
        burger.ingredients.add(secondIngredient);
        burger.moveIngredient(0, 1);
        assertThat(burger.ingredients.get(0), equalTo(secondIngredient));
    }

    @Test
    public void getPriceTest() {
        float expectedPrice = 56;
        burger.setBuns(bun);
        burger.addIngredient(firstIngredient);
        burger.addIngredient(firstIngredient);
        Mockito.when(bun.getPrice()).thenReturn(9f);
        Mockito.when(firstIngredient.getPrice()).thenReturn(19f);
        assertEquals(expectedPrice, burger.getPrice(), 0);
    }

    @Test
    public void getReceiptTest() {
        Bun bun = new Bun("Spy x Family", 98);
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "spyxfamily", 228);
        Ingredient salad = new Ingredient(IngredientType.FILLING, "salad", 20);
        burger.setBuns(bun);
        burger.ingredients.add(ingredient);
        burger.ingredients.add(salad);
        String actual = burger.getReceipt();
        String expected = String.format("(==== Spy x Family ====)\r\n= sauce spyxfamily " +
                "=\r\n= filling salad =\r\n" +
                "(==== Spy x Family ====)\r\n\r\nPrice: 444,000000\r\n");
        assertThat(actual, equalTo(expected));
    }
}