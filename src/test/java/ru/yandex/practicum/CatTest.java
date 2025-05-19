package ru.yandex.practicum;

import jdk.jfr.Description;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    Cat cat;

    @Mock
    Feline feline;

    @Before
    public void initCat() {
        cat = new Cat(feline);
    }

    @Test
    public void getSoundNoParamReturnMeowTest() {
        String catSound = cat.getSound();
        assertEquals("Метод getSound() возвращает результат отличный от ожидаемого 'Мяу'", "Мяу", catSound);
    }

    @Test
    public void getFoodNoParamReturnListOfFoodTest() throws Exception {
        List<String> felineEat = List.of("Мясо", "Птица", "Рыба");
        Mockito.when(feline.eatMeat()).thenReturn(felineEat);
        List<String> catFood = cat.getFood();
        assertEquals("Список, возвращаемый методом getFood(), не соответствует ожидаемому", felineEat, catFood);
    }

}
