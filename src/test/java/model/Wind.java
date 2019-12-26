package model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Wind {
    @JsonProperty(value = "speed")
    private Double wind_speed;
    @JsonProperty(value = "deg")
    private Double wind_deg;

    public Double getWind_speed() {
        return wind_speed;
    }

    public void setWind_speed(Double wind_speed) {
        this.wind_speed = wind_speed;
    }

    public Double getWind_deg() {
        return wind_deg;
    }

    public void setWind_deg(Double wind_deg) {
        this.wind_deg = wind_deg;
    }
}
