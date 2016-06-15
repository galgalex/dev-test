package com.goeuro.api.data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CityGeoData {

    @XmlElement(name = "_id")
    private int id;
    @XmlElement
    private String key;
    @XmlElement
    private String name;
    @XmlElement
    private String fullName;
    @XmlElement(name = "iata_airport_code")
    private String iataAirportCode;
    @XmlElement
    private String type;
    @XmlElement
    private String country;
    @XmlElement(name = "geo_position")
    private GeoPosition geoPosition;
    @XmlElement
    private int locationId;
    @XmlElement
    private boolean inEurope;
    @XmlElement
    private int countryId;
    @XmlElement
    private String countryCode;
    @XmlElement
    private String coreCountry;
    @XmlElement
    private String distance;

    @XmlElement
    private HashMap<String, String> names;
    @XmlElement
    private HashMap<String, List<String>> alternativeNames;

    private CityGeoData() {
    }

    public int getId() {
        return id;
    }

    public String getKey() {
        return key;
    }

    public String getName() {
        return name;
    }

    public String getFullName() {
        return fullName;
    }

    public String getIataAirportCode() {
        return iataAirportCode;
    }

    public String getType() {
        return type;
    }

    public String getCountry() {
        return country;
    }

    public GeoPosition getGeoPosition() {
        return geoPosition;
    }

    public int getLocationId() {
        return locationId;
    }

    public boolean isInEurope() {
        return inEurope;
    }

    public int getCountryId() {
        return countryId;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getCoreCountry() {
        return coreCountry;
    }

    public String getDistance() {
        return distance;
    }

    public Map<String, String> getNames() {
        return names;
    }

    public Map<String, List<String>> getAlternativeNames() {
        return alternativeNames;
    }

    @Override
    public String toString() {
        return "CityGeoData [id=" + id + ", key=" + key + ", name=" + name
                + ", fullName=" + fullName + ", iataAirportCode="
                + iataAirportCode + ", type=" + type + ", country=" + country
                + ", geoPosition=" + geoPosition + ", locationId=" + locationId
                + ", inEurope=" + inEurope + ", countryId=" + countryId
                + ", countryCode=" + countryCode + ", coreCountry="
                + coreCountry + ", distance=" + distance + ", names=" + names
                + ", alternativeNames=" + alternativeNames + "]";
    }
}