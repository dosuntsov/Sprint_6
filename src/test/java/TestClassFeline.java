import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class TestClassFeline {
    Feline feline = new Feline();

    @Test
    public void checkCorrectGetFamily() {
        Assert.assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void getPredatorFood() throws Exception {
        List expected = List.of("Животные", "Птицы", "Рыба");
        Assert.assertEquals(expected, feline.eatMeat());
    }

    @Test
    public void whenNoArgumentInGetKittensGetOneKitten() {
        Assert.assertEquals(1, feline.getKittens());
    }
}
