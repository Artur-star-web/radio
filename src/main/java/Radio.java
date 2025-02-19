public class Radio {
    private int currentStation;
    private final int stationCount;
    private int currentVolume;

    public Radio() {
        this(10); // По умолчанию 10 станций
    }

    public Radio(int stationCount) {
        if (stationCount < 1) {
            throw new IllegalArgumentException("Количество станций должно быть хотя бы 1");
        }
        this.stationCount = stationCount;
        this.currentStation = 0;
        this.currentVolume = 50; // Уровень громкости по умолчанию
    }

    public int getCurrentStation() {
        return currentStation;
    }

    public int getStationCount() {
        return this.stationCount;
    }

    public void setCurrentStation(int station) {
        if (station > 0 && station < stationCount)
        {
            this.currentStation = station;
        }
    }

    public void next() {
        if (currentStation >= stationCount - 1) {
            currentStation = 0;
        } else {
            currentStation++;
        }
    }

    public void prev() {
        if (currentStation == 0) {
            currentStation = stationCount - 1;
        } else {
            currentStation--;
        }
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void increaseVolume() {
        if (currentVolume < 100) {
            currentVolume++;
        }
    }

    public void decreaseVolume() {
        if (currentVolume > 0) {
            currentVolume--;
        }
    }

}
