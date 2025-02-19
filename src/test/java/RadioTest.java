import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RadioTest {

    @Test
    void shouldSetStationWithinRange() {
        Radio radio = new Radio(10);
        radio.setCurrentStation(5);
        Assertions.assertEquals(5, radio.getCurrentStation());
    }

    @Test
    void shouldNotSetStationOutOfRange() {
        Radio radio = new Radio(10);
        radio.setCurrentStation(15);
        Assertions.assertEquals(0, radio.getCurrentStation());
    }


    @Test
    void shouldWrapAroundToZeroWhenNextOnLastStation() {
        Radio radio = new Radio(10);
        radio.setCurrentStation(9);
        radio.next();
        Assertions.assertEquals(0, radio.getCurrentStation());
    }

    @Test
    void shouldIncreaseStationByOne() {
        Radio radio = new Radio(10);
        radio.setCurrentStation(5);
        radio.next();
        Assertions.assertEquals(6, radio.getCurrentStation());
    }

    @Test
    void shouldWrapAroundToLastWhenPrevOnFirstStation() {
        Radio radio = new Radio(10);
        radio.setCurrentStation(0);
        radio.prev();
        Assertions.assertEquals(9, radio.getCurrentStation());
    }

    @Test
    void shouldDecreaseStationByOne() {
        Radio radio = new Radio(10);
        radio.setCurrentStation(5);
        radio.prev();
        Assertions.assertEquals(4, radio.getCurrentStation());
    }

    @Test
    void shouldIncreaseVolume() {
        Radio radio = new Radio(10);
        radio.increaseVolume();
        Assertions.assertEquals(51, radio.getCurrentVolume());
    }

    @Test
    void shouldNotIncreaseVolumeBeyondMax() {
        Radio radio = new Radio(10);
        for (int i = 0; i < 100; i++) {
            radio.increaseVolume();
        }
        Assertions.assertEquals(100, radio.getCurrentVolume());
    }

    @Test
    void shouldDecreaseVolume() {
        Radio radio = new Radio(10);
        radio.decreaseVolume();
        Assertions.assertEquals(49, radio.getCurrentVolume());
    }

    @Test
    void shouldNotDecreaseVolumeBelowMin() {
        Radio radio = new Radio(10);
        for (int i = 0; i < 100; i++) {
            radio.decreaseVolume();
        }
        Assertions.assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    void shouldThrowExceptionForInvalidStationCount() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Radio(0));
    }

    @Test
    public void testDefaultConstructor() {
        Radio radio = new Radio();
        Assertions.assertEquals(10, radio.getStationCount(), "По умолчанию должно быть 10 станций");
    }

    @Test
    public void testCustomConstructor() {
        Radio radio = new Radio(15);
        Assertions.assertEquals(15, radio.getStationCount(), "Должно быть 15 станций");
    }

    @Test
    public void testGetStationCount() {
        Radio radio = new Radio(20);
        Assertions.assertEquals(20, radio.getStationCount(), "Должно быть 20 станций");
    }

}
