import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;

@RunWith(MockitoJUnitRunner.class)
public class BurgerClassTest {

    @Mock
    Burger burger = new Burger();

    @Mock
    Bun bun;


    @Test
    public void setBunsCallOnceTest() {
        burger.setBuns(bun);
        Mockito.verify(burger, Mockito.times(1)).setBuns(bun);
    }

    @Test
    public void setBunCallRightValueTest() {
        Bun newBun = new Bun("Булка", 800);
        burger.setBuns(newBun);
        Mockito.verify(burger).setBuns(newBun);
    }

    @Test
    public void addIngredientCallRightValueTest(){

    }

}
