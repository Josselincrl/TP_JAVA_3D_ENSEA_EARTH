import java.time.LocalDateTime;

public class Flight {
    private String airLineCode;
    private String airLineName;
    private String arrivalTime;
    private String departureTime;
    private String number;

    public Flight(String airLineCode, String airLineName, String arrivalTime, String departureTime, String number) {
        this.airLineCode = airLineCode;
        this.airLineName = airLineName;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
        this.number = number;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "airLineCode='" + airLineCode + '\'' +
                ", airLineName='" + airLineName + '\'' +
                ", arrivalTime=" + arrivalTime +
                ", departurTime=" + departureTime +
                ", number=" + number +
                "}\n";
    }
}
