package ru.yandex.practicum.delivery;

public class PerishableParcel extends Parcel {
    private final int timeToLive;

    public PerishableParcel(String description, int weight, String deliveryAddress, int sendDay, int timeToLive) {
        super(description, weight, deliveryAddress, sendDay);
        this.timeToLive = timeToLive;
    }

    @Override
    public int calculateDeliveryCost() {
        return DELIVERY_COST_PERISHABLE*this.getWeight();
    }

    public boolean isExpired(int currentDay) {
        return !(this.getSendDay() + this.timeToLive >= currentDay);
    }
}
