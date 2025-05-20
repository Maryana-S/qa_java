package ru.yandex.practicum;

import net.bytebuddy.utility.RandomString;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    Lion lion;

    @Mock
    Feline feline;

    @Before
    public void initLion() throws Exception {
        lion = new Lion("Самка", feline);
    }

    @Test
    public void getKittensNoParamReturnOneKittenTest() throws Exception {
        Mockito.when(feline.getKittens()).thenReturn(1);
        assertEquals("Метод getKittens() вернул значение отличное от ожидаемого", 1, lion.getKittens());
    }

    @Test
    public void getFoodNoParamReturnListOfFoodTest() throws Exception {
        List<String> felineFood = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(felineFood);
        List<String> lionFood = lion.getFood();
        assertEquals("Список, возвращаемый методом eatMeat(), не соответствует ожидаемому", felineFood, lionFood);
    }

    @Test
    public void lionUnavailableSexReturnExceptionTest() {
        try {
            new Lion(RandomString.make(3), feline);
        } catch (Exception e) {
            assertEquals("Используйте допустимые значения пола животного - самец или самка", e.getMessage());
            return;
        }
        throw new AssertionError("Не возникло ожидаемое исключение");
    }

}
