package ru.yandex.practicum;

import org.junit.Before;
import org.junit.Test;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FelineTest {

    Feline feline;

    @Before
    public void initFeline() {
        feline = new Feline();
    }

    @Test
    public void eatMeatNoParamReturnListOfFoodTest() throws Exception {
        assertEquals("Метод eatMeat() вернул значение отличное от ожидаемого", List.of("Животные", "Птицы", "Рыба"), feline.eatMeat());
    }

    @Test
    public void getFamilyNoParamReturnStringFelineTest() {
        String family = feline.getFamily();
        assertEquals("Метод getFamily() вернул значение отличное от ожидаемого", "Кошачьи", family);
    }

    @Test
    public void getKittensAttributeValueEqualsReturnValueTest() {
        int kittensCount = feline.getKittens(5);
        assertEquals("Метод getKittens(int kittensCount) вернул значение отличное от ожидаемого",5, kittensCount);
    }

    @Test
    public void getKittensNoParamReturnOneKittenTest() {
        assertEquals("Метод getKittens() вернул значение отличное от 1", 1, feline.getKittens());
    }

}
