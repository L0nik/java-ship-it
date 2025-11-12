package ru.yandex.practicum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.PerishableParcel;

public class IsExpiredTest {

    PerishableParcel parcel = new PerishableParcel(
            "скоропортящаяся посылка",
            1,
            "адрес доставки",
            1,
            5
    );

    @Test
    public void shouldNotBeExpiredForSendDay1TimeToLive5CurrentDay1() {
        Assertions.assertFalse(parcel.isExpired(1));
    }

    @Test
    public void shouldNotBeExpiredForSendDay1TimeToLive5CurrentDay6() {
        Assertions.assertFalse(parcel.isExpired(6));
    }

    @Test
    public void shouldBeExpiredForSendDay1TimeToLive5CurrentDay7() {
        Assertions.assertTrue(parcel.isExpired(7));
    }
}
