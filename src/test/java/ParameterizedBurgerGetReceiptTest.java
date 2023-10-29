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
public class ParameterizedBurgerGetReceiptTest {

    private final IngredientType ingrType;
    private final String name;
    private final float price;
    private final String typeIngredients;
    private final String bunName;
    private final float allPrice;

    public ParameterizedBurgerGetReceiptTest(IngredientType ingrType, String name, float price, String typeIngredients,
                                             String bunName, float allPrice) {
        this.ingrType = ingrType;
        this.name = name;
        this.price = price;
        this.typeIngredients = typeIngredients;
        this.bunName = bunName;
        this.allPrice = allPrice;
    }


    @Parameterized.Parameters(name = "{index} Тест на получение рецепта с суммой {5}")
    public static Object[][] getSumData() {
        return new Object[][]{
                {IngredientType.SAUCE, "вкусняшка", 180, "sauce", "булочка", 300},
                {IngredientType.FILLING, "не вкусняшка", 245, "filling", "булочка", 365},
                {IngredientType.FILLING, "норм", 198, "filling", "булочка", 318}
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
    public void getReceiptReturnTrueValue() {
        StringBuilder receipt = new StringBuilder(String.format("(==== %s ====)%n", bunName));
        receipt.append(String.format("= %s %s =%n", typeIngredients, name));
        receipt.append(String.format("(==== %s ====)%n", bunName));
        receipt.append(String.format("%nPrice: %f%n", allPrice));
        Ingredient ingredient = new Ingredient(ingrType, name, price);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Assert.assertEquals("Ошибка!!! Метод вернул не правильное значение!!!", receipt.toString(), burger.getReceipt());
    }


}
