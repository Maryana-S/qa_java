package ru.yandex.practicum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionHasManeTest {

    private final String sex;
    private final boolean hasManeResult;
    private Feline feline = Mockito.mock(Feline.class);

    public LionHasManeTest(String sex, boolean hasManeResult) {
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
        assertEquals("Значение параметра hasMane не соответствует ожидаемому", hasManeResult,  lion.hasMane);
    }

    @Test
    public void doesHaveManeNoParamReturnHaveManeTest() throws Exception {
        Lion lion = new Lion(sex, feline);
        assertEquals("Значение параметра hasMane не соответствует ожидаемому", hasManeResult, lion.doesHaveMane());
    }

}
