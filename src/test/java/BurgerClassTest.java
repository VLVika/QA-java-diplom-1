import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import java.util.ArrayList;
import java.util.List;

import static praktikum.IngredientType.SAUCE;

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

    @Mock
    Ingredient ingredient;

    @Test
    public void addIngredientCallOnceTest(){
        burger.addIngredient(ingredient);
        Mockito.verify(burger, Mockito.times(1)).addIngredient(ingredient);
    }

    @Test
    public void removeIngredientCallOnceTest(){
        burger.removeIngredient(5);
        Mockito.verify(burger, Mockito.times(1)).removeIngredient(5);
    }

    @Test
    public void removeIngredientCallRightValueTest(){
        burger.removeIngredient(5);
        Mockito.verify(burger).removeIngredient(5);
    }

    @Test
    public void moveIngredientCallOnceTest(){
        burger.moveIngredient(1,0);
        Mockito.verify(burger, Mockito.times(1)).moveIngredient(1,0);
    }

    @Test
    public void moveIngredientCallRightValueTest(){
        burger.moveIngredient(5,2);
        Mockito.verify(burger).moveIngredient(5,2);
    }


}
