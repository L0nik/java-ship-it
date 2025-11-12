package ru.yandex.practicum;

import ru.yandex.practicum.delivery.FragileParcel;
import ru.yandex.practicum.delivery.PerishableParcel;
import ru.yandex.practicum.delivery.StandardParcel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DeliveryCostTest {

    @Test
    public void deliveryCostShouldBe20ForStandardParcelWeighting10Kilos() {
        StandardParcel parcel = new StandardParcel(
                "тестовая стандартная посылка",
                10,
                "тестовый адрес доставки",
                10
        );
        Assertions.assertEquals(20, parcel.calculateDeliveryCost());
    }

    @Test
    public void deliveryCostShouldBe0ForStandardParcelWeighting0Kilos() {
        StandardParcel parcel = new StandardParcel(
                "тестовая стандартная посылка",
                0,
                "тестовый адрес доставки",
                10
        );
        Assertions.assertEquals(0, parcel.calculateDeliveryCost());
    }

    @Test
    public void deliveryCostShouldBe30ForPerishableParcelWeighting10Kilos() {
        PerishableParcel parcel = new PerishableParcel(
                "тестовая скоропортящаяся посылка",
                10,
                "тестовый адрес доставки",
                10,
                5
        );
        Assertions.assertEquals(30, parcel.calculateDeliveryCost());
    }

    @Test
    public void deliveryCostShouldBe0ForPerishableParcelWeighting0Kilos() {
        PerishableParcel parcel = new PerishableParcel(
                "тестовая скоропортящаяся посылка",
                0,
                "тестовый адрес доставки",
                10,
                5
        );
        Assertions.assertEquals(0, parcel.calculateDeliveryCost());
    }

    @Test
    public void deliveryCostShouldBe40ForFragileParcelWeighting10Kilos() {
        FragileParcel parcel = new FragileParcel(
                "тестовая хрупкая посылка",
                10,
                "тестовый адрес доставки",
                10
        );
        Assertions.assertEquals(40, parcel.calculateDeliveryCost());
    }

    @Test
    public void deliveryCostShouldBe0ForFragileParcelWeighting0Kilos() {
        FragileParcel parcel = new FragileParcel(
                "тестовая хрупкая посылка",
                0,
                "тестовый адрес доставки",
                10
        );
        Assertions.assertEquals(0, parcel.calculateDeliveryCost());
    }
}
