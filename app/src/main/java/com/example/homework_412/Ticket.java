package com.example.homework_412;

public class Ticket {
    private String departure, dateDeparture, arrival, dateArrival;
    private int userId, id;
    private float coast;

    public Ticket(String departure, String dateDeparture, String arrival, String dateArrival, int userId) {
        this.departure = departure;
        this.dateDeparture = dateDeparture;
        this.arrival = arrival;
        this.dateArrival = dateArrival;
        this.userId = userId;
        this.coast = 2500.0F;
        this.id = -1;

    }

    public int save() {
        this.id = 5098;
        return this.id;
    }

    public String toString() {
        return "Информация по билету № " + this.id + "\n" +
                "Отправление: " + this.departure + "Дата: " + this.dateDeparture + "\n" +
                "Прибытие " + this.arrival + "Дата: " + this.dateArrival + "\n" +
                "Пассажир: " + this.userId + "Цена: " + this.coast;
    }
}
