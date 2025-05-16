package ru.yandex.practicum;

import java.util.List;

public interface FelineInterface {

    List<String> getFood(String animalKind) throws Exception;

    String getFamily();

    int getKittens();

    int getKittens(int kittensCount);
}
