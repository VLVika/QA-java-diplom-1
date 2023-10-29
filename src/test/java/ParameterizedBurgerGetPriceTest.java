import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class ParameterizedBurgerGetPriceTest {

    private final IngredientType ingrType;
    private final String name;
    private final float price;
    private final float expected;

    public ParameterizedBurgerGetPriceTest(IngredientType ingrType, String name, float price, float expected) {
        this.ingrType = ingrType;
        this.name = name;
        this.price = price;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getSumData() {
        return new Object[][]{
                {IngredientType.SAUCE, "вкусняшка", 180, 300},
                {IngredientType.FILLING, "не вкусняшка", 245, 365},
                {IngredientType.FILLING, "норм", 198, 318}
        };
    }

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }


    @Spy
    Burger burger = new Burger();

    @Spy
    Bun bun = new Bun("булочка", 60);


    @Test
    public void getPriceReturnTrueValue() {
        Ingredient ingredient = new Ingredient(ingrType, name, price);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Assert.assertEquals("Ошибка!!! Метод вернул не правильное значение!!!", expected, burger.getPrice(), 0);
    }


}
