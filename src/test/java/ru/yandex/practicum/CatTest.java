package ru.yandex.practicum;

import jdk.jfr.Description;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    Feline feline;

    @Test
    public void getSoundNoParamReturnMeowTest() {
        Cat cat = new Cat(feline);
        String catSound = cat.getSound();
        assertEquals("Метод getSound() возвращает результат отличный от ожидаемого 'Мяу'", "Мяу", catSound);
    }

    @Test
    public void getFoodNoParamReturnListOfFoodTest() throws Exception {
        Cat cat = new Cat(feline);
        List<String> felineEat = List.of("Мясо", "Птица", "Рыба");
        Mockito.when(feline.eatMeat()).thenReturn(felineEat);
        List<String> catFood = cat.getFood();
        Mockito.verify(feline, Mockito.times(1)).eatMeat();
        assertEquals("Список, возвращаемый методом getFood(), не соответствует ожидаемому", felineEat, catFood);
    }

}
