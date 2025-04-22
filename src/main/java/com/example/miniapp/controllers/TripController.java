package com.example.miniapp.controllers;

import com.example.miniapp.models.Trip;
import com.example.miniapp.services.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/trip")
public class TripController {
    private final TripService tripService;

    @Autowired
    public TripController(TripService tripService) {
        this.tripService = tripService;
    }

    // Add a new trip
    @PostMapping("/addTrip")
    public Trip addTrip(@RequestBody Trip trip) {
        return tripService.addTrip(trip);
    }

    // Get all trips
    @GetMapping("/allTrips")
    public List<Trip> getAllTrips() {
        return tripService.getAllTrips();
    }

    // Get a specific trip by ID
    @GetMapping("/{id}")
    public Trip getTripById(@PathVariable Long id) {
        return tripService.getTripById(id);
    }

    // Update a trip
    @PutMapping("/update/{id}")
    public Trip updateTrip(@PathVariable Long id, @RequestBody Trip trip) {
        return tripService.updateTrip(id, trip);
    }

    // Delete a trip
    @DeleteMapping("/delete/{id}")
    public String deleteTrip(@PathVariable Long id) {
        try {
            tripService.deleteTrip(id);
            return "Trip with ID: " + id + " has been deleted successfully";
        } catch (RuntimeException e) {
            // Trip doesn't exist, still return OK with a message
            return "Trip with ID: " + id + " not found";
        }
    }

    // Find trips within a date range
    @GetMapping("/findByDateRange")
    public List<Trip> findTripsWithinDateRange(
            @RequestParam String startDate,
            @RequestParam String endDate) {

        LocalDateTime startDateTime;
        LocalDateTime endDateTime;

        try {
            // Try to parse as full LocalDateTime strings (as sent by the test)
            startDateTime = LocalDateTime.parse(startDate);
            endDateTime = LocalDateTime.parse(endDate);
        } catch (Exception e) {
            // Fall back to the original ISO DATE parsing if needed
            LocalDate startLocalDate = LocalDate.parse(startDate);
            LocalDate endLocalDate = LocalDate.parse(endDate);
            startDateTime = startLocalDate.atStartOfDay();
            endDateTime = endLocalDate.atTime(LocalTime.MAX);
        }

        return tripService.findTripsWithinDateRange(startDateTime, endDateTime);
    }

    // Find trips by captain ID
    @GetMapping("/findByCaptainId")
    public List<Trip> findTripsByCaptainId(@RequestParam Long captainId) {
        return tripService.findTripsByCaptainId(captainId);
    }
}