import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class TestClassFelineParametrized {
    private int kittensCount;
    private int expected;

    public TestClassFelineParametrized(int kittensCount, int expected) {
        this.kittensCount = kittensCount;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] differentKittensCount() {
        return new Object[][]{
                {0, 0},
                {2, 2},
                {1, 1},
                {-3, -3},
        };
    }

    @Test
    public void checkIfKittenCountAlwaysCorrect() {
        Feline feline = new Feline();
        Assert.assertEquals(expected, feline.getKittens(kittensCount));
    }
}
