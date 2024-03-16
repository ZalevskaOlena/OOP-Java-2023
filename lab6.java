import java.util.Arrays;
import java.util.Comparator;

abstract class Aircraft {
    private String model;
    private int seatingCapacity;
    private double cargoCapacity;
    private double flightRange;
    private double fuelConsumption;

    public Aircraft(String model, int seatingCapacity, double cargoCapacity, double flightRange, double fuelConsumption) {
        this.model = model;
        this.seatingCapacity = seatingCapacity;
        this.cargoCapacity = cargoCapacity;
        this.flightRange = flightRange;
        this.fuelConsumption = fuelConsumption;
    }

    public String getModel() {
        return model;
    }

    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    public double getCargoCapacity() {
        return cargoCapacity;
    }

    public double getFlightRange() {
        return flightRange;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public abstract String getType();

    @Override
    public String toString() {
        return  model + ", Кількість місць: " + seatingCapacity + ", Вантажопідйомність: " + cargoCapacity +
                ", Дальність польоту: " + flightRange + ", Витрати палива: " + fuelConsumption;
    }
}

class PassengerAircraft extends Aircraft {
    public PassengerAircraft(String model, int seatingCapacity, double cargoCapacity, double flightRange, double fuelConsumption) {
        super(model, seatingCapacity, cargoCapacity, flightRange, fuelConsumption);
    }

    @Override
    public String getType() {
        return "Passenger Aircraft";
    }
}

class CargoAircraft extends Aircraft {
    public CargoAircraft(String model, int seatingCapacity, double cargoCapacity, double flightRange, double fuelConsumption) {
        super(model, seatingCapacity, cargoCapacity, flightRange, fuelConsumption);
    }

    @Override
    public String getType() {
        return "Cargo Aircraft";
    }
}

class AirlineCompany {
    private Aircraft[] aircrafts;

    public AirlineCompany(Aircraft[] aircrafts) {
        this.aircrafts = aircrafts;
    }

    public int getTotalSeatingCapacity() {
        int totalSeatingCapacity = 0;
        for (Aircraft aircraft : aircrafts) {
            totalSeatingCapacity += aircraft.getSeatingCapacity();
        }
        return totalSeatingCapacity;
    }

    public double getTotalCargoCapacity() {
        double totalCargoCapacity = 0;
        for (Aircraft aircraft : aircrafts) {
            totalCargoCapacity += aircraft.getCargoCapacity();
        }
        return totalCargoCapacity;
    }

    public void sortByFlightRange() {
        Arrays.sort(aircrafts, Comparator.comparingDouble(Aircraft::getFlightRange));
    }

    public Aircraft findAircraftByFuelConsumptionRange(double minFuelConsumption, double maxFuelConsumption) {
        for (Aircraft aircraft : aircrafts) {
            double fuelConsumption = aircraft.getFuelConsumption();
            if (fuelConsumption >= minFuelConsumption && fuelConsumption <= maxFuelConsumption) {
                return aircraft;
            }
        }
        return null;
    }
}

public class lab6 {
    public static void main(String[] args) {
        try {
            PassengerAircraft aircraft1 = new PassengerAircraft("Boeing 737", 150, 5000, 2000, 10.5);
            PassengerAircraft aircraft2 = new PassengerAircraft("Airbus A320", 180, 4800, 1800, 11.2);
            CargoAircraft aircraft3 = new CargoAircraft("Boeing 747", 0, 20000, 5000, 20.0);
            PassengerAircraft aircraft4 = new PassengerAircraft("Airbus A320", 150, 4000, 1500, 9.5);

            Aircraft[] aircrafts = {aircraft1, aircraft2, aircraft3, aircraft4};

            AirlineCompany airlineCompany = new AirlineCompany(aircrafts);

            System.out.println("Згальна кількість місць: " + airlineCompany.getTotalSeatingCapacity());
            System.out.println("Загальна вантажопідйомність: " + airlineCompany.getTotalCargoCapacity());

            airlineCompany.sortByFlightRange();

            System.out.println("Відсортовані літаки за дальністю польоту:");
            for (Aircraft aircraft : aircrafts) {
                System.out.println(aircraft);
            }

            double minFuelConsumption = 10.0;
            double maxFuelConsumption = 15.0;
            Aircraft aircraftWithFuelConsumptionInRange = airlineCompany.findAircraftByFuelConsumptionRange(minFuelConsumption, maxFuelConsumption);

            if (aircraftWithFuelConsumptionInRange != null) {
                System.out.println("Літак із споживанням палива в діапозоні (" + minFuelConsumption + " - " + maxFuelConsumption + "):");
                System.out.println(aircraftWithFuelConsumptionInRange);
            } else {
                System.out.println("Не знайдено жодного літака з витратою палива в межах дальності (" + minFuelConsumption + " - " + maxFuelConsumption + ")");
            }
        } catch (Exception e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }
}


