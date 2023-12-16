import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import static praktikum.IngredientType.FILLING;
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

    @Spy
    Ingredient ingredient = new Ingredient(FILLING, "ляляля", 500);

    @Spy
    Ingredient ingredientYam = new Ingredient(SAUCE, "вкусняшка", 100);

    @Spy
    Ingredient ingredientNew = new Ingredient(SAUCE, "ythgjj", 85);



    @Test
    public void addIngredientCallOnceTest() {
        burger.addIngredient(ingredient);
        Mockito.verify(burger, Mockito.times(1)).addIngredient(ingredient);
    }

    @Test
    public void addIngredientCallRightValueTest() {
        burger.addIngredient(ingredient);
        Mockito.verify(burger).addIngredient(ingredient);
    }

    @Test
    public void removeIngredientCallOnceTest() {
        burger.removeIngredient(5);
        Mockito.verify(burger, Mockito.times(1)).removeIngredient(5);
    }

    @Test
    public void moveIngredientCallRightValueTest() {
        burger.moveIngredient(5, 2);
        Mockito.verify(burger).moveIngredient(5, 2);
    }


    @Spy
    Burger newBurger = new Burger();

    @Test
    public void removeIngredientCallValueTest() {
        newBurger.addIngredient(ingredient);
        newBurger.addIngredient(ingredientNew);
        newBurger.removeIngredient(0);
        Mockito.verify(newBurger).removeIngredient(0);

    }


    @Test
    public void moveIngredientCallValueTest() {
        newBurger.addIngredient(ingredient);
        newBurger.addIngredient(ingredientNew);
        newBurger.addIngredient(ingredientYam);
        newBurger.moveIngredient(1, 0);
        Mockito.verify(newBurger).moveIngredient(1, 0);

    }


}
