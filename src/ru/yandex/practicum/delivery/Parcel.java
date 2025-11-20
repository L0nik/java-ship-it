package ru.yandex.practicum.delivery;

public abstract class Parcel {
    protected final String description;
    protected final int weight;
    protected final String deliveryAddress;
    protected final int sendDay;

    public Parcel(String description, int weight, String deliveryAddress, int sendDay) {
        this.description = description;
        this.weight = weight;
        this.deliveryAddress = deliveryAddress;
        this.sendDay = sendDay;
    }

    protected abstract int getBaseCost();

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

    public int calculateDeliveryCost() {
        return weight * getBaseCost();
    }
}
