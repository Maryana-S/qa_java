package ru.yandex.practicum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Spy
    private Feline feline;

    @Test
    public void eatMeatNoParamReturnListOfFoodTest() throws Exception {
        List<String> felineFood = List.of("Мясо", "Птица", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(felineFood);
        List<String> felineEat = feline.eatMeat();
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
        assertEquals("Список, возвращаемый методом eatMeat(), не соответствует ожидаемому", felineFood, felineEat);
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
        int kittensCount = feline.getKittens();
        assertEquals("Метод getKittens() вернул значение отличное от ожидаемого",1, kittensCount);
        Mockito.verify(feline, Mockito.times(1)).getKittens(1);
    }

}
