import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class TestClassFeline {
    @Test
    public void checkCorrectGetFamily() {
        Feline feline = new Feline();
        Assert.assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void getPredatorFood() throws Exception {
        Feline feline = new Feline();
        List expected = List.of("Животные", "Птицы", "Рыба");
        Assert.assertEquals(expected, feline.eatMeat());
    }

    @Mock
    Feline feline;

    @Test
    public void whenTwoKittensIsGivenReturnsTwo() {
        feline.getKittens(2);
        Mockito.verify(feline).getKittens(2);
    }

    @Test
    public void whenNoArgumentInGetKittensGetOneKitten() {
        Feline feline = new Feline();
        Assert.assertEquals(1, feline.getKittens());
    }
}
