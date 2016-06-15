package com.goeuro.api.cli;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import com.goeuro.api.data.CityGeoData;

/**
 * Main class for the goeuro api command line interface
 *
 */
public class App {

    public final static String URI = "http://api.goeuro.com/api/v2/position/suggest/en/";

    public static void main(final String[] args) {
        final String city = parseArgs(args);
        if (city == null) {
            printUsage();
            System.exit(1);
        }
        final GeoDataClient client = new GeoDataClient(URI);
        List<CityGeoData> geoDataList = null;
        try {
            geoDataList = client.getGeoData(city);
        } catch (final ConnectionException e) {
            System.err.println(String.format("error getting geo data: %s",
                    e.getMessage()));
            System.exit(1);
        }
        writeCsv(geoDataList);
    }

    private static void printUsage() {
        System.out.println("Get geo-data for the given city");
        System.out.println(String.format("\nUsage:\n App CITY_NAME"));
    }

    private static String parseArgs(final String[] args) {
        if (args.length != 1) {
            return null;
        } else {
            return args[0];
        }
    }

    private static void writeCsv(final List<CityGeoData> geoDataList) {

        CSVPrinter csvPrinter = null;
        try {
            csvPrinter = new CSVPrinter(System.out,
                    CSVFormat.DEFAULT.withRecordSeparator('\n'));

            for (final CityGeoData data : geoDataList) {
                final List<String> dataRecord = new ArrayList<>();
                dataRecord.add(String.valueOf(data.getId()));
                dataRecord.add(data.getName());
                dataRecord.add(data.getType());
                dataRecord.add(String.valueOf(data.getGeoPosition()
                        .getLatitude()));
                dataRecord.add(String.valueOf(data.getGeoPosition()
                        .getLongitude()));
                csvPrinter.printRecord(dataRecord);
            }
        } catch (final IOException e) {
            System.err.println(String.format("error wrting csv: %s",
                    e.getMessage()));
        } finally {
            try {
                csvPrinter.close();
            } catch (final IOException e) {
                System.err.println(String.format(
                        "error closing the csv printer: %s", e.getMessage()));
            }
        }
    }

}
