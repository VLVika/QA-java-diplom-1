import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class IngredientTypeTest {

    private final IngredientType actual;
    private final String expected;


    public IngredientTypeTest(IngredientType actual, String expected) {
        this.actual = actual;
        this.expected = expected;
    }


    @Parameterized.Parameters
    public static Object[][] getSumData() {
        return new Object[][]{
                {IngredientType.SAUCE, "SAUCE"},
                {IngredientType.FILLING, "FILLING"},
        };
    }

    @Test
    public void ingredientTypeReturnTrueValue() {
        Assert.assertTrue("Ошибка!!! Реальный результат --->" + actual + "<---Не соответствует ожидаемому --->" + expected,
                expected == actual.name());
    }

}
