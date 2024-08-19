package com.training.nagarro.mini.assignment5.model;

public class Route {
    private String routeId;
    private String source;
    private String destination;
    private Train train;

    public Route(String routeId, String source, String destination, Train train) {
        this.routeId = routeId;
        this.source = source;
        this.destination = destination;
        this.train = train;
    }

    public String getRouteDetails() {
        return String.format("Route ID: %s, Source: %s, Destination: %s, Train ID: %s", routeId, source, destination, train.getTrainId());
    }
}
