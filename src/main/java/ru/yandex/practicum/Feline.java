package ru.yandex.practicum;

import java.util.List;

public class Feline extends Animal implements FelineInterface, Predator {

    @Override
    public List<String> getFood(String animalKind) throws Exception {
        return super.getFood(animalKind);
    }

    @Override
    public List<String> eatMeat() throws Exception {
        return getFood("Хищник");
    }

    @Override
    public String getFamily() {
        return "Кошачьи";
    }

    @Override
    public int getKittens() {
        return getKittens(1);
    }

    @Override
    public int getKittens(int kittensCount) {
        return kittensCount;
    }

}
