package com.flywheel.dao;



import java.util.List;

import com.flywheel.beans.Flight;
public interface FlightDao {
    public List<Flight> searchFlights(String source, String destin, String date);
}
