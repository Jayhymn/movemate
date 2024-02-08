package com.wakeupdev.movemate.constants;

import com.wakeupdev.movemate.enums.State;
import com.wakeupdev.movemate.models.ParcelModel;

import java.util.ArrayList;
import java.util.List;

public class Parcels {
    public static List<ParcelModel> getParcels(){
        List<ParcelModel> parcels = new ArrayList<>();

        parcels.add(
                new ParcelModel("1", "Macbook pro M2", "#NE43857340857904",
                        "Paris", "Morocco", State.IN_PROGRESS, "Arriving today!",
                        "$1400 USD",
                        "Sep 20,2023")
        );

        parcels.add(
                new ParcelModel("2", "Summer linen jacket", "#NEJ20089934122231",
                        "Barcelona", "Paris", State.IN_PROGRESS, "Arriving today!",
                        "$1200 USD",
                        "Sep 20,2023")
        );

        parcels.add(
                new ParcelModel("3", "Tapered-fit jeans AW", "#NEJ35870264978659",
                        "Colombia", "Paris", State.PENDING, "Arriving today!",
                        "$1400 USD",
                        "Sep 20,2023")
        );

        parcels.add(
                new ParcelModel("4", "Slim fit jeans AW", "#NEJ35870264978659",
                        "Bogota", "Dhaka", State.PENDING, "Arriving today!",
                        "$990 USD",
                        "Sep 20,2023")
        );

        parcels.add(
                new ParcelModel("5", "Office setup desk", "#NEJ23481570754963", "France",
                        "Germany", State.PENDING, "Arriving today!",
                        "$1450 USD",
                        "Sep 20,2023")
        );

        parcels.add(
                new ParcelModel("4", "Slim fit jeans AW", "#NEJ35870264978659",
                        "Bogota", "Dhaka", State.LOADING, "Arriving today!",
                        "$260 USD",
                        "Sep 23,2023")
        );

        parcels.add(
                new ParcelModel("5", "Office setup desk", "#NEJ23481570754963", "France",
                        "Germany", State.LOADING, "Arriving today!",
                        "$2500 USD",
                        "Sep 23,2023")
        );

        return parcels;
    }
}
