package ru.netology.services;

// Radio - сервисный класс
public class Radio {

    private int currentRadioStation;                    // Поле - номер текущей радиостанции
    private int currentVolume;                          // Поле - громкость звука
    private int maxCountRadioStation;                   // Поле - количество радиостанций

    // --- Конструкторы радио ------------------------------------------------------------------------------------
    // Конструктор без параметров
    public Radio() {
        this.maxCountRadioStation = 9;                     // Требование задания - по умолчанию кол-во станций 10
                                                           // (от 0 до 9)
    }

    // Конструктор с параметром - максимальное количество радиостанций
    public Radio(int maxRadioStation) {
        this.maxCountRadioStation = maxRadioStation - 1;    // Запоминаем в поле объекта maxCountRadioStation
                                                            // макисмальное кол-во станций, передаваемое параметром
                                                            // maxRadioStation
    }

    // --- Методы работы с текущим номером радиостанции ---------------------------------------------------------

    // Метод чтения значения текущей радио станции
    public int getCurrentRadioStation() {
        return currentRadioStation;                     // Возвращаем текущий номер радиостанции
    }

    // Метод установки значения текущей радио станции
    public void setCurrentRadioStation(int newCurrentRadioStation) {
        if ((newCurrentRadioStation >= 0) & (newCurrentRadioStation <= maxCountRadioStation)) {
            currentRadioStation = newCurrentRadioStation;
        }
    }

    // Метод увеличения номера радио станции
    public void nextRadioStation() {
        if (currentRadioStation == maxCountRadioStation) {
            currentRadioStation = 0;
            return;
        }
        setCurrentRadioStation(currentRadioStation + 1);
    }

    // Метод уменьшения номера радио станции
    public void prevRadioStation() {
        if (currentRadioStation == 0) {
            currentRadioStation = maxCountRadioStation;
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
