import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;


public class BunClassTest {

    String name = "Beautiful";
    float price = 500;
    Bun bun = new Bun(name, price);


    @Test
    public void bunGetNameReturnWriteName() {
        Assert.assertEquals("Ошибка!! Метод возвращает не корректное значение!!", name, bun.getName());

    }


    @Test
    public void bunGetPriceReturnWritePrice() {
        Assert.assertEquals("Ошибка!! Метод возвращает не корректное значение!!", price, bun.getPrice(), 0.01);

    }
}
