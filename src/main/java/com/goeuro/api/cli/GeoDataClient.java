package com.goeuro.api.cli;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.goeuro.api.data.CityGeoData;

public class GeoDataClient {

    private final WebTarget geoDataTarget;

    public GeoDataClient(final String uri) {
        final Client client = ClientBuilder.newClient();
        this.geoDataTarget = client.target(uri);
    }

    public List<CityGeoData> getGeoData(final String city)
            throws ConnectionException {
        final WebTarget cityTarget = geoDataTarget.path(city);
        final Invocation.Builder invocationBuilder = cityTarget
                .request(MediaType.APPLICATION_JSON_TYPE);

        final Response response = invocationBuilder.get();

        if (response.getStatus() != 200) {
            response.close();
            throw new ConnectionException(
                    "server connection failed with code: "
                            + response.getStatus());
        }

        final List<CityGeoData> geoDataList = response
                .readEntity(new GenericType<List<CityGeoData>>() {
                });
        return geoDataList;
    }
}
