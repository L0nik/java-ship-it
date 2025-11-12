package ru.yandex.practicum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.ParcelBox;
import ru.yandex.practicum.delivery.StandardParcel;

public class AddingParcelToABoxTest {

    ParcelBox<StandardParcel> box;

    @BeforeEach
    public void createBox() {
        box = new ParcelBox<>(5);
    }

    @Test
    public void shouldAdd3kgParcelTo5kgBox() {
        StandardParcel parcel = new StandardParcel(
                "Стандартная посылка",
                3,
                "адрес доставки",
                1
        );
        Assertions.assertEquals(0, box.getAllParcels().size());
        box.addParcel(parcel);
        Assertions.assertEquals(1, box.getAllParcels().size());
    }

    @Test
    public void shouldAdd5kgParcelTo5kgBox() {
        StandardParcel parcel = new StandardParcel(
                "Стандартная посылка",
                5,
                "адрес доставки",
                1
        );
        Assertions.assertEquals(0, box.getAllParcels().size());
        box.addParcel(parcel);
        Assertions.assertEquals(1, box.getAllParcels().size());
    }

    @Test
    public void shouldNotAdd6kgParcelTo5kgBox() {
        StandardParcel parcel = new StandardParcel(
                "Стандартная посылка",
                6,
                "адрес доставки",
                1
        );
        Assertions.assertEquals(0, box.getAllParcels().size());
        box.addParcel(parcel);
        Assertions.assertEquals(0, box.getAllParcels().size());
    }
}
