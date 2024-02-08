package com.wakeupdev.movemate.data;

import com.wakeupdev.movemate.R;
import com.wakeupdev.movemate.models.VehicleModel;

import java.util.ArrayList;
import java.util.List;

public class Vehicle {
    private int vehicleCount;
    private static List<VehicleModel> vehicles;
    public static List<VehicleModel> getAvailableVehicles() {
        List<VehicleModel> vehicles = new ArrayList<>();

        vehicles.add(new VehicleModel(
                "1",
                "Ocean Freight",
                "International",
                R.drawable.ocean_freight
        ));

        vehicles.add(new VehicleModel(
                "2",
                "Air Freight",
                "Reliable",
                R.drawable.air_freight
        ));

        vehicles.add(new VehicleModel(
                "3",
                "Cargo Freight",
                "International",
                R.drawable.cargo_freight
        ));

        vehicles.add(new VehicleModel(
                "4",
                "Road Freight",
                "Local",
                R.drawable.road_freight
        ));

        vehicles.add(new VehicleModel(
                "5",
                "Train Freight",
                "Train Freight",
                R.drawable.ocean_freight
        ));

        // Additional freight options
        vehicles.add(new VehicleModel(
                "6",
                "Pipeline Freight",
                "Pipeline Freight",
                R.drawable.cargo_freight
        ));

        vehicles.add(new VehicleModel(
                "7",
                "Intermodal Freight",
                "Intermodal Freight",
                R.drawable.road_freight
        ));

        // Add more options as needed

        return vehicles;
    }
}
