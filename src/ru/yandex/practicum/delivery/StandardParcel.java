package ru.yandex.practicum.delivery;

public class StandardParcel extends Parcel {

    private static final int DELIVERY_COST_STANDARD = 2;

    public StandardParcel(String description, int weight, String deliveryAddress, int sendDay) {
        super(description, weight, deliveryAddress, sendDay);
    }

    @Override
    protected int getBaseCost() {
        return DELIVERY_COST_STANDARD;
    }
}
