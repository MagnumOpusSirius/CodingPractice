package com.demo.cogent;

import java.util.*;
class Route {
    private String departure;
    private String destination;

    public Route(String departure, String destination) {
        this.departure = departure;
        this.destination = destination;
    }
    
    public String getDeparture() {
        return departure;
    }

    public String getDestination() {
        return destination;
    }
}
public class IndirectFlightFinder {
    public static List<Route> findIndirectFlights(List<Route> routes, String departure, String destination) {
        List<Route> indirectFlights = new ArrayList<>();

        // Find direct flights from departure to intermediate airports
        Set<String> intermediateAirports = findIntermediateAirports(routes, departure, destination);

        // Find direct flights from intermediate airports to destination
        for (String intermediateAirport : intermediateAirports) {
            Set<String> destinationAirports = findDestinationAirports(routes, intermediateAirport, destination);

            // Create indirect routes
            for (Route firstLeg : findDirectFlights(routes, departure, intermediateAirport)) {
                for (Route secondLeg : findDirectFlights(routes, intermediateAirport, destination)) {
                    indirectFlights.add(new Route(firstLeg.getDeparture(), secondLeg.getDestination()));
                }
            }
        }

        return indirectFlights;
    }

    private static Set<String> findIntermediateAirports(List<Route> routes, String departure, String destination) {
        Set<String> intermediateAirports = new HashSet<>();
        for (Route route : routes) {
            if (route.getDeparture().equals(departure) && !route.getDestination().equals(destination)) {
                intermediateAirports.add(route.getDestination());
            }
        }
        return intermediateAirports;
    }

    private static Set<String> findDestinationAirports(List<Route> routes, String departure, String destination) {
        Set<String> destinationAirports = new HashSet<>();
        for (Route route : routes) {
            if (!route.getDeparture().equals(departure) && route.getDestination().equals(destination)) {
                destinationAirports.add(route.getDeparture());
            }
        }
        return destinationAirports;
    }

    private static List<Route> findDirectFlights(List<Route> routes, String departure, String destination) {
        List<Route> directFlights = new ArrayList<>();
        for (Route route : routes) {
            if (route.getDeparture().equals(departure) && route.getDestination().equals(destination)) {
                directFlights.add(route);
            }
        }
        return directFlights;
    }

    public static void main(String[] args) {
        // Sample routes
        List<Route> routes = Arrays.asList(
                new Route("A", "B"),
                new Route("B", "C"),
                new Route("C", "D"),
                new Route("A", "D"),
                new Route("D", "E"),
                new Route("E", "F")
        );

        // Example: Find indirect flights from A to F
        String departure = "A";
        String destination = "F";

        List<Route> indirectFlights = findIndirectFlights(routes, departure, destination);

        // Display the results
        System.out.println("Indirect Flights from " + departure + " to " + destination + ":");
        for (Route indirectFlight : indirectFlights) {
            System.out.println(indirectFlight.getDeparture() + " -> " + indirectFlight.getDestination());
        }
    }
}
