package stepDefs;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.Response;
import org.junit.jupiter.api.Assertions;
import requesters.WeatherRequester;

public class weatherStepDefs {

    private String city;
    private String country;
    private Response response;


    @Given("city is: (.*)")
    public void set_city(String city) {
        this.city = city;
    }

    @Given("country is: (.*)")
    public void set_country(String country) {
        this.country = country;
    }

    @When("we are requesting weather")
    public void request_weather() throws JsonProcessingException {
        WeatherRequester requester = new WeatherRequester();
        response = requester.requestWeather(city, country);
    }

    @Then("lon is (.*)")
    public void check_lon(Double lon) {
        Assertions.assertEquals(lon, response.getCoord().getLon(), "Wrong lon");
    }

    @Then("lat is (.*)")
    public void check_lat(Double lat) {
        Assertions.assertEquals(lat, response.getCoord().getLat(), "Wrong lat");
    }

    @Then("weather_id is (.*)")
    public void check_id(Integer weather_id) {
        Assertions.assertEquals(weather_id, response.getWeather().get(0).getWeather_id(), "Wrong id");
    }

    @Then("main is (.*)")
    public void check_main(String main) {
        Assertions.assertEquals(main, response.getWeather().get(0).getMain(), "Wrong main (wtf is it?)");
    }

    @Then("description is (.*)")
    public void check_description(String description) {
        Assertions.assertEquals(description, response.getWeather().get(0).getDescription(), "Wrong description");
    }

    @Then("icon is (.*)")
    public void check_icon(String icon) {
        Assertions.assertEquals(icon, response.getWeather().get(0).getIcon(), "Wrong icon");
    }

    @Then("base is (.*)")
    public void check_base(String base) {
        Assertions.assertEquals(base, response.getBase());
    }

    @Then("temp is (.*)")
    public void check_temp(Double temp) {
        Assertions.assertEquals(temp, response.getMain().getTemp(), "Wrong temp");
    }

    @Then("pressure is (.*)")
    public void check_pressure(Double pressure) {
        Assertions.assertEquals(pressure, response.getMain().getPressure(), "Wrong pressure");
    }

    @Then("humidity is (.*)")
    public void check_humidity(Double humidity) {
        Assertions.assertEquals(humidity, response.getMain().getHumidity(), "Wrong humidity");
    }

    @Then("temp_min is (.*)")
    public void check_temp_min(Double temp_min) {
        Assertions.assertEquals(temp_min, response.getMain().getTemp_min(), "Wrong temp_min");
    }

    @Then("temp_max is (.*)")
    public void check_temp_max(Double temp_max) {
        Assertions.assertEquals(temp_max, response.getMain().getTemp_max(), "Wrong temp_max");
    }

    @Then("visibility is (.*)")
    public void check_visibility(Double visibility) {
        Assertions.assertEquals(visibility, response.getVisibility(), "Wrong visibility");
    }

    @Then("speed is (.*)")
    public void check_speed(Double speed) {
        Assertions.assertEquals(speed, response.getWind().getWind_speed(), "Wrong wind speed");
    }

    @Then("deg is (.*)")
    public void check_deg(Double deg) {
        Assertions.assertEquals(deg, response.getWind().getWind_deg(), "Wrong wind direction");
    }

    @Then("all is (.*)")
    public void check_clouds(Integer all) {
        Assertions.assertEquals(all, response.getClouds().getAll(), "Wrong clouds info");
    }

    @Then("dt is (.*)")
    public void check_dt(Integer dt) {
        Assertions.assertEquals(dt, response.getDt(), "Wrong dt");
    }

    @Then("type is (.*)")
    public void check_type(Double type) {
        Assertions.assertEquals(type, response.getSys().getType(), "Wrong type");
    }
    @Then("sys_id is (.*)")
    public void check_sys_id(Integer sys_id) {
        Assertions.assertEquals(sys_id, response.getSys().getSys_id(), "Wrong sys id");
    }
    @Then("message is (.*)")
    public void check_message(String message) {
        Assertions.assertEquals(message, response.getSys().getMessage(), "Wrong message");
    }
    @Then("country is (.*)")
    public void check_country(String country) {
        Assertions.assertEquals(country, response.getSys().getCountry(), "Wrong country");
    }
    @Then("sunrise is (.*)")
    public void check_sunrise(Double sunrise) {
        Assertions.assertEquals(sunrise, response.getSys().getSunrise(), "Wrong sunrise time");
    }
    @Then("sunset is (.*)")
    public void check_sunset(Double sunset) {
        Assertions.assertEquals(sunset, response.getSys().getSunset(), "Wrong sunset time");
    }

}
