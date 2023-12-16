import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(MockitoJUnitRunner.class)
public class IngredientClassTest {

    IngredientType ingredientType = IngredientType.SAUCE;
    String name = "бла-бла-бла";
    float price = 150;

    
    Ingredient ingredient = new Ingredient(ingredientType, name, price);

    @Test
    public void getPriceIngredientReturnValue() {
        Assert.assertEquals("Ошибка!!! Возвращаемая цена не соответствует ожидаемой!!!", price, ingredient.getPrice(), 0);
    }

    @Test
    public void getNameIngredientReturnValue() {
        Assert.assertEquals("Ошибка!!! Возвращаемое название не соответствует ожидаем!!!", name, ingredient.getName());
    }

    @Test
    public void getTypeIngredientReturnValue() {
        Assert.assertEquals("Ошибка!!! Возвращаемое название не соответствует ожидаем!!!", ingredientType, ingredient.getType());
    }
}
