package com.infoshareacademy.locator.storage;


import com.infoshareacademy.locator.model.Earthquake;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class EarthquakesStorage {
    private WebTarget target;

    public EarthquakesStorage() {
        Client client = ClientBuilder.newClient();

        this.target = client.target("http://www.earthquakescanada.nrcan.gc.ca/api/v2/locations/date/{year}.json");
    }

    public List<Earthquake> getForYear(String year) {
        Jsonb jsonb = JsonbBuilder.create();
        List<Earthquake> earthquakes = new ArrayList<>();

        Response res = target
                .resolveTemplate("year", year)
                .request("application/json").get();

        String rawData = res.readEntity(String.class);

        JsonReader reader = Json.createReader(new StringReader(rawData));

        JsonObject jsonObject = reader.readObject();

        for (String key : jsonObject.keySet()) {
            if (key.equals("metadata")) {
                continue;
            }

            JsonObject data = jsonObject.getJsonObject(key);
            Earthquake earthquake = jsonb.fromJson(data.toString(), Earthquake.class);
            earthquake.setId(key);

            earthquakes.add(earthquake);
        }

        return earthquakes;
    }
}
