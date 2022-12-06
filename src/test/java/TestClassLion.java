import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class TestClassLion {

    @Mock
    Feline feline;

    @Test
    public void checkGetKittenMocked() throws Exception{
        Lion lion = new Lion("Самка", feline);
        lion.getKittens();
        Mockito.verify(feline).getKittens();
    }

    @Test
    public void checkGetFoodMocked() throws Exception {
        Lion lion = new Lion("Самка", feline);
        lion.getFood();
        Mockito.verify(feline).getFood("Хищник");
    }

    @Test
    public void checkGetKittensIsOneKitten() throws Exception {
        Feline feline = new Feline();
        Lion lion = new Lion("Самка", feline);
        Assert.assertEquals(1, lion.getKittens());
    }

    @Test
    public void lionsEatPredatorFood() throws Exception {
        Feline feline = new Feline();
        Lion lion = new Lion("Самка", feline);
        List expected = List.of("Животные", "Птицы", "Рыба");
        Assert.assertEquals(expected, lion.getFood());
    }

    @Test
    public void checkUnknownSexLionHasManeError() {
        try {
            new Lion("Абракадабра", feline);
        } catch (Exception thrown) {
            String expected = "Используйте допустимые значения пола животного - самец или самка";
            Assert.assertEquals(expected, thrown.getMessage());
        }
    }

}
