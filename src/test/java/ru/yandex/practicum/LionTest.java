package ru.yandex.practicum;

import net.bytebuddy.utility.RandomString;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionTest {

    private final String sex;
    private final boolean hasManeResult;
    private FelineInterface feline = Mockito.mock(Feline.class);

    public LionTest(String sex, boolean hasManeResult) {
        this.sex = sex;
        this.hasManeResult = hasManeResult;
    }

    @Parameterized.Parameters(name = "Тестовые данные: sex = {0}, hasManeResult = {1}")
    public static Object[][] getCredentials() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
        };
    }

    @Test
    public void lionAvailableSexReturnHasManeTest() throws Exception {
        Lion lion = new Lion(sex, feline);
        assertEquals("Значение параметра hasMane не соответствует ожидаемому", lion.hasMane, hasManeResult);
    }

    @Test
    public void getKittensNoParamReturnOneKittenTest() throws Exception {
        Lion lion = new Lion(sex, feline);
        Mockito.when(feline.getKittens()).thenReturn(1);
        assertEquals("Метод getKittens() вернул значение отличное от ожидаемого",1, lion.getKittens());
        Mockito.verify(feline, Mockito.times(1)).getKittens();

    }

    @Test
    public void doesHaveManeNoParamReturnHaveManeTest() throws Exception {
        Lion lion = new Lion(sex, feline);
        assertEquals("Значение параметра hasMane не соответствует ожидаемому", hasManeResult, lion.doesHaveMane());
    }

    @Test
    public void getFoodNoParamReturnListOfFoodTest() throws Exception {
        Lion lion = new Lion(sex, feline);
        List<String> felineFood = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(felineFood);
        List<String> lionFood = lion.getFood();
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
        assertEquals("Список, возвращаемый методом eatMeat(), не соответствует ожидаемому", felineFood, lionFood);
    }

    @Test
    public void lionUnavailableSexReturnExceptionTest() {
        try {
            new Lion(sex + RandomString.make(3), feline);
        } catch (Exception e) {
            assertEquals("Используйте допустимые значения пола животного - самец или самка", e.getMessage());
            return;
        }
        throw new AssertionError("Не возникло ожидаемое исключение");
    }

}
