package ru.yandex.practicum.delivery;

public class FragileParcel extends Parcel implements Trackable {

    private static final int DELIVERY_COST_FRAGILE = 4;

    public FragileParcel(String description, int weight, String deliveryAddress, int sendDay) {
        super(description, weight, deliveryAddress, sendDay);
    }

    @Override
    public void packageItem() {
        System.out.println("Посылка <<" + this.description + ">> обёрнута в защитную плёнку");
        super.packageItem();
    }

    @Override
    public void reportStatus(String newLocation) {
        System.out.println("Хрупкая посылка <<" + this.description + ">> изменила местоположение на " + newLocation);
    }

    @Override
    protected int getBaseCost() {
        return DELIVERY_COST_FRAGILE;
    }
}
