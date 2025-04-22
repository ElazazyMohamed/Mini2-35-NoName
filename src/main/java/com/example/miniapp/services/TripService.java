package com.example.miniapp.services;

import com.example.miniapp.models.Trip;
import com.example.miniapp.repositories.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TripService {
    private final TripRepository tripRepository;
    @Autowired
    public TripService(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }
    public Trip addTrip(Trip trip) {
        return tripRepository.save(trip);
    }

    public List<Trip> getAllTrips() {
        return tripRepository.findAll();
    }

    public Trip getTripById(Long id) {
        return tripRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Trip not found with id " + id));
    }

    public Trip updateTrip(Long id, Trip updated) {
        Trip existing = getTripById(id);

        // Update basic properties
        if (updated.getTripDate() != null) {
            existing.setTripDate(updated.getTripDate());
        }
        if (updated.getOrigin() != null) {
            existing.setOrigin(updated.getOrigin());
        }
        if (updated.getDestination() != null) {
            existing.setDestination(updated.getDestination());
        }
        if (updated.getTripCost() != null) {
            existing.setTripCost(updated.getTripCost());
        }

        // Only update relationships if they're not null in the update
        if (updated.getCaptain() != null) {
            existing.setCaptain(updated.getCaptain());
        }
        if (updated.getCustomer() != null) {
            existing.setCustomer(updated.getCustomer());
        }

        return tripRepository.save(existing);
    }

    public void deleteTrip(Long id) {
        Trip toDelete = getTripById(id);
        tripRepository.delete(toDelete);
    }

    public List<Trip> findTripsWithinDateRange(LocalDateTime startDate, LocalDateTime endDate) {
        return tripRepository.findTripsWithinDateRange(startDate, endDate);
    }

    public List<Trip> findTripsByCaptainId(Long captainId) {
        return tripRepository.findTripsByCaptainId(captainId);
    }
}
