import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.ArrayList;


public class JsonFlightFiller {
    ArrayList<Flight> list = new ArrayList<Flight>();

    public JsonFlightFiller(String jsonString, World w) {
        try {
            InputStream is = new ByteArrayInputStream(jsonString.getBytes(StandardCharsets.UTF_8));
            JsonReader rdr = Json.createReader(is);
            JsonObject obj = rdr.readObject();
            JsonArray results = obj.getJsonArray("data");
            for (JsonObject result : results.getValuesAs(JsonObject.class)) {
                try {

                    JsonObject departure = result.getJsonObject("departure");
                    String departureTime = departure.getString("scheduled");

                    JsonObject arrival = result.getJsonObject("arrival");
                    String arrivalTime = arrival.getString("scheduled");

                    JsonObject airline = result.getJsonObject("airline");
                    String airLineCode = airline.getString(("icao"));
                    String airLineName = airline.getString(("name"));

                    JsonObject flight = result.getJsonObject("flight");
                    String number = flight.getString("number");

                    list.add(new Flight(airLineCode, airLineName,arrivalTime,departureTime, number));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}