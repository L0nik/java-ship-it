package ru.yandex.practicum.delivery;

import java.util.ArrayList;

public class ParcelBox<T extends Parcel> {
    private final ArrayList<T> parcels;
    private final int maxWeight;

    public ParcelBox(int maxWeight) {
        this.parcels = new ArrayList<>();
        this.maxWeight = maxWeight;
    }

    public void addParcel(T parcel) {
        if (this.calculateWeight() + parcel.getWeight() > this.maxWeight) {
            System.out.println("Превышен максимальный вес коробки, посылка не добавлена");
            return;
        }
        this.parcels.add(parcel);
    }

    public ArrayList<T> getAllParcels() {
        return this.parcels;
    }

    private int calculateWeight() {
        int sum = 0;
        for (T parcel : parcels) {
            sum += parcel.getWeight();
        }
        return sum;
    }
}
