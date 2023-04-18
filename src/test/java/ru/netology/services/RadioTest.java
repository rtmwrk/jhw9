package ru.netology.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RadioTest {
    // --- Дополнительные тесты методов сервисного класса выбора радиостанции ---------------------------------------
    // Тесты предыдущего задания оставляем, они идут в следующем блоке, ниже
    // В данном же блоке добавим тесты с учетом того фактора, что теперь количество радиостанций можно задать,
    // путем изменения поля "maxCountRadioStation" объекта Radio()
    //
    // Поэтому в тестах повторим логику ранее подготовленных тестов для блока выбора радиостанции, но фиксированное
    // значение максимального номера станции "9", заменим на значение поля "maxCountRadioStation"
    @Test
    public void shouldGetCurrentRadioStationWithVariableMax() {
        Radio receiver = new Radio(30);                    // Устанавливаем количество радиостанций

        receiver.setCurrentRadioStation(15);                            // Устанавливаем текущей станцию "15"

        int expected = 15;                                              // Номер станции должен измениться
        int actual = receiver.getCurrentRadioStation();
        Assertions.assertEquals(expected, actual);
    }

    // Тест для номера станции "-1"
    @Test
    public void shouldSetCurrentRadioStationIfMinusOneWithVariableMax() {
        Radio receiver = new Radio(30);

        receiver.setCurrentRadioStation(15);                            // Устанавливаем текущей станцию "15"
        receiver.setCurrentRadioStation(-1);                            // Попробуем изменить значение номера текущей
                                                                        // станции на невалидное
        int expected = 15;                                              // Номер станции не должен измениться
        int actual = receiver.getCurrentRadioStation();
        Assertions.assertEquals(expected, actual);
    }

    // Тест для номера станции "0"
    @Test
    public void shouldSetCurrentRadioStationIfZeroWithVariableMax() {
        Radio receiver = new Radio(30);

        receiver.setCurrentRadioStation(0);                             // Устанавливаем текущей станцию "0"

        int expected = 0;                                               // Номер станции должен измениться
        int actual = receiver.getCurrentRadioStation();
        Assertions.assertEquals(expected, actual);
    }

    // Тест для номера станции "1"
    @Test
    public void shouldSetCurrentRadioStationIfPlusOneWithVariableMax() {
        Radio receiver = new Radio(30);

        receiver.setCurrentRadioStation(1);                             // Устанавливаем текущей станцию "1"

        int expected = 1;                                               // Номер станции должен измениться
        int actual = receiver.getCurrentRadioStation();
        Assertions.assertEquals(expected, actual);
    }

    // Тест для номера станции "maxCountRadioStation - 1"
    @Test
    public void shouldSetCurrentRadioStationIfMaxCountStationMinusOne() {
        Radio receiver = new Radio(30);

        receiver.setCurrentRadioStation(28);                            // Устанавливаем номер станции кол-во станций-2

        int expected = 28;                                              // Номер должен измениться
        int actual = receiver.getCurrentRadioStation();
        Assertions.assertEquals(expected, actual);
    }

    // Тест для номера станции "maxCountRadioStation"
    @Test
    public void shouldSetCurrentRadioStationIfMaxCountStation() {
        Radio receiver = new Radio(30);

        receiver.setCurrentRadioStation(29);                            // Устанавливаем номер станции кол-во станций-1

        int expected = 29;                                              // Номер должен измениться
        int actual = receiver.getCurrentRadioStation();
        Assertions.assertEquals(expected, actual);
    }

    // Тест для номера станции "maxCountRadioStation+1"
    @Test
    public void shouldSetCurrentRadioStationIfMaxCountStationPlusOne() {
        Radio receiver = new Radio(30);

        receiver.setCurrentRadioStation(15);                            // Устанавливаем текущей станцию "15"
        receiver.setCurrentRadioStation(30);                            // Устанавливаем номер станции не валидный
                                                                        // - кол-во станций
        int expected = 15;                                              // Номер станции измениться не должен
        int actual = receiver.getCurrentRadioStation();
        Assertions.assertEquals(expected, actual);
    }

    // Тестируем метод nextRadioStation()
    // Тест для номера станции "maxCountStation-1"
    @Test
    public void shouldNextRadioStationIfMaxCountStationMinusOne() {
        Radio receiver = new Radio(30);

        receiver.setCurrentRadioStation(28);                            // Устанавливаем текущей станцию -
                                                                        // кол-во станций-1
        receiver.nextRadioStation();                                    // Номер станции должен измениться на "следующий"

        int expected = 29;
        int actual = receiver.getCurrentRadioStation();
        Assertions.assertEquals(expected, actual);
    }

    // Тест для номера станции "maxCountStation"
    @Test
    public void shouldNextRadioStationIfMaxCountStation() {
        Radio receiver = new Radio(30);

        receiver.setCurrentRadioStation(29);                            // Устанавливаем текущей станцию -
                                                                        // кол-во станций
        receiver.nextRadioStation();

        int expected = 0;                                               // Номер станции должен стать "0"
        int actual = receiver.getCurrentRadioStation();
        Assertions.assertEquals(expected, actual);
    }

    // Тестируем метод prevRadioStation()
    // Тест для номера станции "1"
    @Test
    public void shouldPrevRadioStationIfOneWithVariableMax() {
        Radio receiver = new Radio(30);

        receiver.setCurrentRadioStation(1);                             // Устанавливаем номер станции "1"
        receiver.prevRadioStation();

        int expected = 0;                                               // Номер станции должен стать "предыдущим"
        int actual = receiver.getCurrentRadioStation();
        Assertions.assertEquals(expected, actual);
    }

    // Тест для номера станции "0"
    @Test
    public void shouldPrevRadioStationIfZeroWithVariableMax() {
        Radio receiver = new Radio(30);

        receiver.setCurrentRadioStation(0);                             // Устанавливаем номер станции "0"
        receiver.prevRadioStation();

        int expected = 29;                                              // Номер станции должен стать
                                                                        // кол-во станций - 1
        int actual = receiver.getCurrentRadioStation();
        Assertions.assertEquals(expected, actual);
    }


    // --- Тестируем методы сервисного класса, связанные с выбором радиостанции -------------------------------------
    //
    // С учетом требований задания будем проводить функциональное позитивное тестирование и
    // функциональное негативное тестирование методов сервисного класса, связанных с выбором радиостанции.
    // При этом будем использовать методику эквивалентных значений и методику граничных значений.
    //
    // И так, у нас есть 4-ре метода работы с радиостанцией:
    // - getCurrentRadioStation() - возвращает номер текущей радиостанции;
    // - setCurrentRadioStation() - устанавливает номер текущей радиостанции;
    // - nextRadioStation() - изменяет номер текущей радиостанции на следующий (по установленным правилам);
    // - prevRadioStation() - изменяет номер текущей радиостанции на предыдущий (тоже по определенным правилам).

    // Тестируем метод getCurrentRadioStation()
    // Данный метод имеет единственную ветвь алгоритма, команды которой выполняются последовательно.
    // Метод также не получает никаких пользовательских данных.
    // Тестирование данного метода достаточно провести методом эквивалентных значений.
    @Test
    public void shouldGetCurrentRadioStation() {
        Radio receiver = new Radio();

        receiver.setCurrentRadioStation(3);                             // Установим валидное значение текущей станции,
                                                                        // валидное для того, чтобы исключить ошибку
                                                                        // в методе set...
        int expected = 3;
        int actual = receiver.getCurrentRadioStation();                 // Прочитаем номер текущей станции

        Assertions.assertEquals(expected, actual);                      // Сравним номер текущей станции с ожидаемым
    }

    // Тестируем метод setCurrentRadioStation()
    // При тестировании данного метода необходимо использовать уже оба метода -
    // и валидных данных, и граничных значений.
    // При тестировании методом граничных значений необходимо проверить нижнюю границу номера станции,
    // задавая в качестве номера значения "-1" (невалидное), "0" и "1" (валидные), а также проверить
    // верхнюю границу, задавая в качестве номера значения "8" и "9" (валидные) и "10" (невалидное).
    // При таком подходе мы фактически проведем и тестирование методом эквивалентных значений,
    // задавая значения из допустимого диапазона - "0", "1", "8" и т.д.
    // Получаем в итоге 6-ть проверок.

    // Тест для номера станции "-1"
    @Test
    public void shouldSetCurrentRadioStationIfMinusOne() {
        Radio receiver = new Radio();

        receiver.setCurrentRadioStation(1);                             // Зададим валидное значение номера станции

        receiver.setCurrentRadioStation(-1);                            // Попробуем изменить значение номера текущей
                                                                        // станции на невалидное

        int expected = 1;                                               // Ожидаем, что метод не позволил установить
                                                                        // невалидное значения номера станции
        int actual = receiver.getCurrentRadioStation();                 // Получаем номер текущей станции, используем
                                                                        // ранее проверенный метод
        Assertions.assertEquals(expected, actual);                      // и сравниваем ожидаемое и реальное значение
    }

    // Тест для номера станции "0"
    @Test
    public void shouldSetCurrentRadioStationIfZero() {
        Radio receiver = new Radio();

        receiver.setCurrentRadioStation(0);                             // Зададим валидное значение номера станции

        int expected = 0;                                               // Ожидаем, валидное значения номера станции

        int actual = receiver.getCurrentRadioStation();                 // Получаем номер текущей станции
        Assertions.assertEquals(expected, actual);                      // и сравниваем ожидаемое и реальное значение
    }

    // Тест для номера станции "1"
    @Test
    public void shouldSetCurrentRadioStationIfPlusOne() {
        Radio receiver = new Radio();

        receiver.setCurrentRadioStation(1);                             // Зададим валидное значение номера станции

        int expected = 1;                                               // Ожидаем, валидное значения номера станции

        int actual = receiver.getCurrentRadioStation();                 // Получаем номер текущей станции
        Assertions.assertEquals(expected, actual);                      // и сравниваем ожидаемое и реальное значение
    }

    // Тест для номера станции "8"
    @Test
    public void shouldSetCurrentRadioStationIfEight() {
        Radio receiver = new Radio();

        receiver.setCurrentRadioStation(8);                             // Зададим валидное значение номера станции

        int expected = 8;                                               // Ожидаем, валидное значения номера станции

        int actual = receiver.getCurrentRadioStation();                 // Получаем номер текущей станции
        Assertions.assertEquals(expected, actual);                      // и сравниваем ожидаемое и реальное значение
    }

    // Тест для номера станции "9"
    @Test
    public void shouldSetCurrentRadioStationIfNine() {
        Radio receiver = new Radio();

        receiver.setCurrentRadioStation(9);                             // Зададим валидное значение номера станции

        int expected = 9;                                               // Ожидаем, валидное значения номера станции

        int actual = receiver.getCurrentRadioStation();                 // Получаем номер текущей станции
        Assertions.assertEquals(expected, actual);                      // и сравниваем ожидаемое и реальное значение
    }

    // Тест для номера станции "10"
    @Test
    public void shouldSetCurrentRadioStationIfTen() {
        Radio receiver = new Radio();

        receiver.setCurrentRadioStation(9);                             // Зададим валидное значение номера станции

        receiver.setCurrentRadioStation(10);                            // Попробуем изменить значение номера текущей
                                                                        // станции на невалидное

        int expected = 9;                                               // Ожидаем, что метод не позволил установить
                                                                        // невалидное значения номера станции
        int actual = receiver.getCurrentRadioStation();                 // Получаем номер текущей станции
        Assertions.assertEquals(expected, actual);                      // и сравниваем ожидаемое и реальное значение
    }

    // Тестируем метод nextRadioStation()
    // Учитываем, что метод изменяет номер станции только через метод "setCurrentRadioStation", который
    // не позволит сохранить в поле "currentRadioStation" невалидное значение.
    // Плюс к этому сам метод "nextRadioStation" только увеличивает значение указанного поля.
    // Поэтому для тестирования применяем метод эквивалентных значений и метод граничных значений
    // по отношении к верхней границе номера станции.
    // Как и ранее при тестах верхнего граничного значения фактически проведем и тесты методом эквивалентных
    // значений, что сократит количество тестов.
    // И так, проведем тестирование метода "nextRadioStation", задавая значения станции в диапазоне:
    // - "8", "9". Значение "10" нет смысла проверять еще раз, так как фактически это будет проверка
    // метода "setCurrentRadioStation" на попытку установить невалидное значение больше граничного,
    // что уже проверено другим тестом.

    // Тест для номера станции "8"
    @Test
    public void shouldNextRadioStationIfEight() {
        Radio receiver = new Radio();

        receiver.setCurrentRadioStation(8);                             // Зададим валидное значение номера станции

        receiver.nextRadioStation();                                    // Переключаем станцию на "следующую"

        int expected = 9;                                               // Ожидаем, валидное следующее значения
                                                                        // номера станции

        int actual = receiver.getCurrentRadioStation();                 // Получаем номер текущей станции
        Assertions.assertEquals(expected, actual);                      // и сравниваем ожидаемое и реальное значение
    }

    // Тест для номера станции "9"
    @Test
    public void shouldNextRadioStationIfNine() {
        Radio receiver = new Radio();

        receiver.setCurrentRadioStation(9);                             // Зададим валидное значение номера станции

        receiver.nextRadioStation();                                    // Переключаем станцию на "следующую" - нулевую

        int expected = 0;                                               // Ожидаем, валидное следующее значения
        // номера станции

        int actual = receiver.getCurrentRadioStation();                 // Получаем номер текущей станции
        Assertions.assertEquals(expected, actual);                      // и сравниваем ожидаемое и реальное значение
    }

    // Тестируем метод prevRadioStation()
    // По аналогии с тестированием метода nextRadioStation проведем тестирование методами граничных и
    // эквивалентных значений для нижней границы диапазона номера станции, задавая значения номера станции:
    // - "1" и "0". Значение "-1" также фактически проверяется тестом при проверке метода "setCurrentRadioStation"

    // Тест для номера станции "1"
    @Test
    public void shouldPrevRadioStationIfEight() {
        Radio receiver = new Radio();

        receiver.setCurrentRadioStation(1);                             // Зададим валидное значение номера станции

        receiver.prevRadioStation();                                    // Переключаем станцию на "предыдущую"

        int expected = 0;                                               // Ожидаем, валидное следующее значения
                                                                        // номера станции

        int actual = receiver.getCurrentRadioStation();                 // Получаем номер текущей станции
        Assertions.assertEquals(expected, actual);                      // и сравниваем ожидаемое и реальное значение
    }

    // Тест для номера станции "9"
    @Test
    public void shouldPrevRadioStationIfZero() {
        Radio receiver = new Radio();

        receiver.setCurrentRadioStation(0);                             // Зададим валидное значение номера станции

        receiver.prevRadioStation();                                    // Переключаем станцию на "предыдущую" - девятую

        int expected = 9;                                               // Ожидаем, валидное следующее значения
        // номера станции

        int actual = receiver.getCurrentRadioStation();                 // Получаем номер текущей станции
        Assertions.assertEquals(expected, actual);                      // и сравниваем ожидаемое и реальное значение
    }

    // --- Тестируем методы сервисного класса, связанные с выбором громкости -------------------------------------
    //
    // Будем проводить функциональное позитивное тестирование и
    // функциональное негативное тестирование. При этом будем использовать методику эквивалентных
    // значений и методику граничных значений.
    //
    // Есть 4-ре метода работы с громкостью звука:
    // - getCurrentVolume() - возвращает номер текущей громкости;
    // - setCurrentVolume() - устанавливает номер громкости;
    // - increaseCurrentVolume() - увеличивает громкость;
    // - decreaseCurrentVolume() - уменьшает громкость.

    // Тестируем метод getCurrentVolume()
    // Логика тестирования аналогична локиге тестирования метода "getCurrentRadioStation"
    @Test
    public void shouldGetCurrentVolume() {
        Radio receiver = new Radio();

        receiver.setCurrentVolume(30);

        int expected = 30;
        int actual = receiver.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    // Тестируем метод setCurrentVolume()
    // При тестировании данного метода будем использовать уже оба метода - и валидных данных,
    // и граничных значений.
    // При тестировании методом граничных значений необходимо проверить нижнюю границу номера станции,
    // задавая в качестве номера значения "-1" (невалидное), "0" и "1" (валидные), а также проверить
    // верхнюю границу, задавая в качестве номера значения "99" и "100" (валидные) и "101" (невалидное).
    // При таком подходе мы фактически проведем и тестирование методом эквивалентных значений,
    // задавая значения из допустимого диапазона - "0", "1", "98" и т.д.
    // Получаем в итоге 6-ть проверок.

    // Тест для громкости "-1"
    @Test
    public void shouldSetCurrentVolumeIfMinusOne() {
        Radio receiver = new Radio();

        receiver.setCurrentVolume(1);                                   // Зададим валидное значение громкости

        receiver.setCurrentVolume(-1);                                  // Попробуем изменить значение

        int expected = 1;                                               // Ожидаем, что метод не позволил установить
                                                                        // невалидное значение
        int actual = receiver.getCurrentVolume();

        Assertions.assertEquals(expected, actual);                      // и сравниваем ожидаемое и реальное значение
    }

    // Тест для громкости "0"
    @Test
    public void shouldSetCurrentVolumeIfZero() {
        Radio receiver = new Radio();

        receiver.setCurrentVolume(0);

        int expected = 0;

        int actual = receiver.getCurrentVolume();
        Assertions.assertEquals(expected, actual);
    }

    // Тест для громкости "1"
    @Test
    public void shouldSetCurrentVolumeIfOne() {
        Radio receiver = new Radio();

        receiver.setCurrentVolume(1);

        int expected = 1;

        int actual = receiver.getCurrentVolume();
        Assertions.assertEquals(expected, actual);
    }

    // Тест для громкости "99"
    @Test
    public void shouldSetCurrentVolumeIfNineNine() {
        Radio receiver = new Radio();

        receiver.setCurrentVolume(99);

        int expected = 99;

        int actual = receiver.getCurrentVolume();
        Assertions.assertEquals(expected, actual);
    }

    // Тест для громкости "100"
    @Test
    public void shouldSetCurrentVolumeIfHundred() {
        Radio receiver = new Radio();

        receiver.setCurrentVolume(100);

        int expected = 100;

        int actual = receiver.getCurrentVolume();
        Assertions.assertEquals(expected, actual);
    }

    // Тест для номера станции "101"
    @Test
    public void shouldSetCurrentVolumeIfHundredOne() {
        Radio receiver = new Radio();

        receiver.setCurrentVolume(99);

        receiver.setCurrentVolume(101);

        int expected = 99;

        int actual = receiver.getCurrentVolume();
        Assertions.assertEquals(expected, actual);
    }

    // Тестируем метод increaseCurrentVolume()
    // тестирование проведем по аналогии с тестированием метода "nextRadioStation".
    // Проверим граничные валидные значения - "99" и "100". Значение "101" уже проверено другим тестом

    // Тест для номера станции "99"
    @Test
    public void shouldIncreaseCurrentVolumeIfNineNine() {
        Radio receiver = new Radio();

        receiver.setCurrentVolume(99);

        receiver.increaseCurrentVolume();

        int expected = 100;

        int actual = receiver.getCurrentVolume();
        Assertions.assertEquals(expected, actual);
    }

    // Тест для номера станции "100"
    @Test
    public void shouldIncreaseCurrentVolumeIfHundred() {
        Radio receiver = new Radio();

        receiver.setCurrentVolume(100);

        receiver.increaseCurrentVolume();

        int expected = 100;

        int actual = receiver.getCurrentVolume();
        Assertions.assertEquals(expected, actual);
    }


    // Тестируем метод decreaseCurrentVolume()
    // По аналогии с тестированием метода prevRadioStation проведем тестирование методами граничных и
    // эквивалентных значений для нижней границы диапазона номера станции, задавая значения номера станции:
    // - "1" и "0". Значение "-1" фактически уже проверено другим тестом

    // Тест для номера станции "1"
    @Test
    public void shouldDecreaseCurrentVolumeIfOne() {
        Radio receiver = new Radio();

        receiver.setCurrentVolume(1);

        receiver.decreaseCurrentVolume();

        int expected = 0;

        int actual = receiver.getCurrentVolume();
        Assertions.assertEquals(expected, actual);
    }

    // Тест для номера станции "0"
    @Test
    public void shouldDecreaseCurrentVolumeIfZero() {
        Radio receiver = new Radio();

        receiver.setCurrentVolume(0);

        receiver.decreaseCurrentVolume();

        int expected = 0;

        int actual = receiver.getCurrentVolume();
        Assertions.assertEquals(expected, actual);
    }
}
