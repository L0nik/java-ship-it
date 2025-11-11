package ru.yandex.practicum.delivery;

public abstract class Parcel {
    private final String description;
    private final int weight;
    private final String deliveryAddress;
    private final int sendDay;
    protected static final int DELIVERY_COST_STANDARD = 2;
    protected static final int DELIVERY_COST_PERISHABLE = 3;
    protected static final int DELIVERY_COST_FRAGILE = 4;

    public Parcel(String description, int weight, String deliveryAddress, int sendDay) {
        this.description = description;
        this.weight = weight;
        this.deliveryAddress = deliveryAddress;
        this.sendDay = sendDay;
    }

    public int getWeight() {
        return this.weight;
    }

    public String getDescription() {
        return this.description;
    }

    public int getSendDay() {
        return this.sendDay;
    }

    public void packageItem() {
        System.out.println("Посылка <<" + this.description + ">> упакована");
    }

    public void deliver() {
        System.out.println("Посылка <<" + this.description + ">> доставлена по адресу " + this.deliveryAddress);
    }

    public abstract int calculateDeliveryCost();
}
