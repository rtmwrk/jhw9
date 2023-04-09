package ru.netology.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RadioTest {

    // Тестируем метод
    @Test
    public void shouldSetCurrentRadioStation() {
        Radio receiver = new Radio();

        receiver.setCurrentRadioStation(3);

        int expected = 3;
        int actual = receiver.getCurrentRadioStation();

        Assertions.assertEquals(expected, actual);
    }
}
