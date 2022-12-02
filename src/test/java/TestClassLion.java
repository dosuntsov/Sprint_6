import com.example.Feline;
import com.example.IKittens;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


import java.util.List;


@RunWith(Parameterized.class)
public class TestClassLion {
    private String sex;
    private boolean hasMane;

    public TestClassLion(String sex, boolean hasMane) {
        this.sex = sex;
        this.hasMane = hasMane;
    }

    @Parameterized.Parameters
    public static Object[][] differentSex() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
        };
    }

    @Test
    public void checkKnownLionHasManeNotError() throws Exception {
        Lion lion = new Lion(sex);
        Assert.assertEquals(lion.doesHaveMane(), hasMane);
    }

    @Test
    public void checkUnknownSexLionHasManeError() {
        try {
            Lion lion = new Lion(sex);
            Assert.assertEquals(lion.doesHaveMane(), hasMane);
        } catch (Exception thrown) {
            String expected = "Используйте допустимые значения пола животного - самец или самка";
            Assert.assertEquals(expected, thrown.getMessage());
        }
    }

    @Test
    public void getOneKittensWhenNoArgument() {
        IKittens kittens = new Feline();
        Lion lion = new Lion(kittens);
        Assert.assertEquals(1, lion.getKittens());
    }

    @Test
    public void lionsDontEatHerbivoreFood() throws Exception {
        Feline feline = new Feline();
        Lion lion = new Lion(feline);
        List unExpected = List.of("Трава", "Различные растения");
        Assert.assertNotEquals(unExpected, lion.getFood());
    }
}