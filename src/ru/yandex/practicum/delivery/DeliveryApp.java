package ru.yandex.practicum.delivery;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeliveryApp {

    private static final Scanner scanner = new Scanner(System.in);
    private static List<Parcel> allParcels = new ArrayList<>();
    private static List<Trackable> trackableParcels = new ArrayList<>();
    private static ParcelBox<StandardParcel> standardParcelBox = new ParcelBox<>(10);
    private static ParcelBox<FragileParcel> fragileParcelBox = new ParcelBox<>(10);
    private static ParcelBox<PerishableParcel> perishableParcelBox = new ParcelBox<>(10);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            showMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addParcel();
                    break;
                case 2:
                    sendParcels();
                    break;
                case 3:
                    calculateCosts();
                    break;
                case 4:
                    reportStatuses();
                    break;
                case 5:
                    showBoxContent();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1 — Добавить посылку");
        System.out.println("2 — Отправить все посылки");
        System.out.println("3 — Посчитать стоимость доставки");
        System.out.println("4 — Показать статусы отслеживаемых посылок");
        System.out.println("5 — Показать содержимое коробки");
        System.out.println("0 — Завершить");
    }

    // реализуйте методы ниже

    private static void addParcel() {
        // Подсказка: спросите тип посылки и необходимые поля, создайте объект и добавьте в allParcels
        System.out.println("Выберите тип посылки:");
        System.out.println("1 — стандартная");
        System.out.println("2 — хрупкая");
        System.out.println("3 — скоропортящаяся");
        int parcelType = Integer.parseInt(scanner.nextLine());

        if (parcelType < 1 || parcelType > 3) {
            System.out.println("Неправильно выбран тип посылки");
            return;
        }

        System.out.println("Введите краткое описание посылки:");
        String description = scanner.nextLine();
        System.out.println("Введите вес посылки в килограммах:");
        int weight = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите адрес доставки:");
        String deliveryAddress = scanner.nextLine();
        System.out.println("Введите дату отправки:");
        int sendDay = Integer.parseInt(scanner.nextLine());

        if (parcelType == 1) {
            StandardParcel newParcel = new StandardParcel(description, weight, deliveryAddress, sendDay);
            allParcels.add(newParcel);
            standardParcelBox.addParcel(newParcel);
        } else if (parcelType == 2) {
            FragileParcel newParcel = new FragileParcel(description, weight, deliveryAddress, sendDay);
            allParcels.add(newParcel);
            trackableParcels.add((Trackable) newParcel);
            fragileParcelBox.addParcel(newParcel);
        } else {
            System.out.println("Введите срок годности в днях:");
            int timeToLive = Integer.parseInt(scanner.nextLine());
            PerishableParcel newParcel = new PerishableParcel(description, weight, deliveryAddress, sendDay, timeToLive);
            allParcels.add(newParcel);
            perishableParcelBox.addParcel(newParcel);
        }
    }

    private static void sendParcels() {
        // Пройти по allParcels, вызвать packageItem() и deliver()
        for (Parcel parcel : allParcels) {
            parcel.packageItem();
            parcel.deliver();
        }
    }

    private static void calculateCosts() {
        // Посчитать общую стоимость всех доставок и вывести на экран
        int sum = 0;
        for (Parcel parcel : allParcels) {
            sum += parcel.calculateDeliveryCost();
        }
        System.out.println("Общая стоимость доставки: " + sum);
    }

    private static void reportStatuses() {
        System.out.println("Введите новое местоположение:");
        String newLocation = scanner.nextLine();
        for (Trackable trackableParcel : trackableParcels) {
            trackableParcel.reportStatus(newLocation);
        }
    }

    private static void showBoxContent() {
        System.out.println("Выберите тип коробки:");
        System.out.println("1 — коробка со стандартными посылками");
        System.out.println("2 — коробка с хрупкими посылками");
        System.out.println("3 — коробка со скоропортящимися посылками");

        int boxType = Integer.parseInt(scanner.nextLine());
        switch (boxType) {
            case 1:
                printParcels(standardParcelBox.getAllParcels());
                break;
            case 2:
                printParcels(fragileParcelBox.getAllParcels());
                break;
            case 3:
                printParcels(perishableParcelBox.getAllParcels());
                break;
        }
    }

    private static <T extends Parcel> void printParcels(ArrayList<T> parcels) {
        for(T parcel : parcels)
            System.out.println(parcel.getDescription());
    }

}

