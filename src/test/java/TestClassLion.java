import com.example.Feline;
import com.example.IFood;
import com.example.IKittens;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;
import java.util.Objects;

public class TestClassLion{
    @Test
    public void checkMaleLionHasManeTrue() throws Exception {
    Lion lion = new Lion("Самец");
       Assert.assertTrue(lion.doesHaveMane());
    }
    @Test
    public void checkFemaleLionHasManeFalse() throws Exception {
        Lion lion = new Lion("Самка");
        Assert.assertFalse(lion.doesHaveMane());
    }
    //@Test
    //public void checkUnknownLionHasManeError() throws Exception {
     //   Lion lion = new Lion("Трансформатор");
       // String expected = "Используйте допустимые значения пола животного - самец или самка";
        //Assert.assertEquals(expected,);
   // }

    @Test
    public void getOneKittensWhenNoArgument() {
      IKittens kittens = new Feline();
      Lion lion = new Lion(kittens);
      Assert.assertEquals(1, lion.getKittens());
    }
    @Test
    public void lionsDontEatHerbivoreFood() throws Exception{
        Feline feline = new Feline();
        Lion lion = new Lion(feline);
        List unExpected = List.of("Трава", "Различные растения");
        Assert.assertNotEquals(unExpected, lion.getFood());
    }
}