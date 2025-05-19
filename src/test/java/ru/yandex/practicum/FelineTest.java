package ru.yandex.practicum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    Feline feline;

    @Before
    public void initFeline() {
        feline = new Feline();
    }

    @Test
    public void eatMeatNoParamReturnListOfFoodTest() throws Exception {
        Feline felineSpy = Mockito.spy(feline);
        felineSpy.eatMeat();
        Mockito.verify(felineSpy, Mockito.times(1)).getFood("Хищник");
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
        Feline felineSpy = Mockito.spy(feline);
        felineSpy.getKittens();
        Mockito.verify(felineSpy, Mockito.times(1)).getKittens(1);
    }

}
