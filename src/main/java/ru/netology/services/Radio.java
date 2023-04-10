package ru.netology.services;

// Radio - сервисный класс
public class Radio {

    private int currentRadioStation;                    // Поле - номер текущей радиостанции
    private int currentVolume;                          // Поле - громкость звука;

    // --- Методы работы с текущим номером радиостанции ---------------------------------------------------------

    // Метод чтения значения текущей радио станции
    public int getCurrentRadioStation() {
        return currentRadioStation;                     // Возвращаем текущий номер радиостанции
    }

    // Метод установки значения текущей радио станции
    public void setCurrentRadioStation(int newCurrentRadioStation) {
        if ((newCurrentRadioStation >= 0) & (newCurrentRadioStation <= 9)) {
            currentRadioStation = newCurrentRadioStation; // Устанавливаем номер станции после проверки его допустимости
        }
    }

    // Метод увеличения номера радио станции
    public void nextRadioStation() {
        if (currentRadioStation == 9) {                 // Если текущий номер станции уже равен "9",
            currentRadioStation = 0;                    // то устанавливаем текущим номером станции "0"
            return;
        }
        setCurrentRadioStation(currentRadioStation + 1);
    }

    // Метод уменьшения номера радио станции
    public void prevRadioStation() {
        if (currentRadioStation == 0) {                 // Если текущий номер станции уже равен "0",
            currentRadioStation = 9;                    // то устанавливаем текущим номером станции "9"
            return;
        }
        setCurrentRadioStation(currentRadioStation - 1);
    }

    // --- Методы работы с громкостью ---------------------------------------------------------------------------
    // Метод чтения значения текущей громкости
    public int getCurrentVolume() {
        return currentVolume;                           // Возвращаем текущее значение громкости
    }

    // Метод установки значения текущей громкости
    public void setCurrentVolume(int newCurrentVolume) {
        if ((newCurrentVolume >= 0) & (newCurrentVolume <= 100)) {
            currentVolume = newCurrentVolume;           // Устанавливаем новую громкость
        }
    }

    // Метод увеличения громкости
    public void increaseCurrentVolume() {
        if (currentVolume == 100) {                     // Если громкость уже равна "100",
            return;                                     // то громкость не меняем
        }
        setCurrentVolume(currentVolume + 1);
    }

    // Метод уменьшения громкости
    public void decreaseCurrentVolume() {
        if (currentVolume == 0) {                       // Если громкость уже равна "0",
            return;                                     // то громкость не меняем
        }
        setCurrentVolume(currentVolume - 1);
    }
}
