package com.goeuro.api.data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class GeoPosition {
    @XmlElement
    private double latitude;
    @XmlElement
    private double longitude;

    private GeoPosition() {
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    @Override
    public String toString() {
        return "GeoPosition [latitude=" + latitude + ", longitude=" + longitude
                + "]";
    }

}
