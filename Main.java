import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Lots lot = new Lots("PSLOT1", 3, 4);
        // lot.display();
        // lot.AddFloor(2);
        // lot.display();
        // System.out.println("yoyoyo");
        // lot.AddSlot(4, 2);
        // lot.displayNoOfSlots("Car");
        // lot.displayFreeSlots("Car");
        // lot.display();
        // lot.floors.get(0).slots.get(0).setAvailability(true);
        // lot.floors.get(1).slots.get(0).setAvailability(true);
        // lot.floors.get(2).slots.get(0).setAvailability(true);
        // lot.displayOccupiedSlots("Truck");
        // lot.display();
        // Ticket t = lot.ParkVehicle("Bike");
        // System.out.println(t.getLot_Id()+"_"+t.getFloor_no()+"_"+t.getSlot_no() + " has been created");
        // Ticket t1 = lot.UnParkVehicle("Bike");
        // System.out.println(t1.getLot_Id()+"_"+t1.getFloor_no()+"_"+t1.getSlot_no()+ " has been cancelled");
        Scanner sc = new Scanner(System.in);
        Lots lot = null;

        while (true) {
            System.out.println("\n==== Parking Lot Management System ====");
            System.out.println("1. Create Parking Lot");
            System.out.println("2. Display All Slots");
            System.out.println("3. Display Free Slots by Vehicle Type");
            System.out.println("4. Display Occupied Slots by Vehicle Type");
            System.out.println("5. Park Vehicle");
            System.out.println("6. Unpark Vehicle");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // clear Buffer

            switch (choice) {
                case 1:
                    System.out.print("Enter Lot ID: ");
                    String lotId = sc.nextLine();
                    System.out.print("Enter number of floors: ");
                    int numFloors = sc.nextInt();
                    System.out.print("Enter number of slots per floor: ");
                    int numSlots = sc.nextInt();
                    lot = new Lots(lotId, numFloors, numSlots);
                    System.out.println("Parking lot created successfully!");
                    break;

                case 2:
                    if (lot != null) {
                        lot.display();
                    } else {
                        System.out.println("Please create a parking lot first.");
                    }
                    break;

                case 3:
                    if (lot != null) {
                        System.out.print("Enter vehicle type (Car/Bike/etc): ");
                        String type = sc.nextLine();
                        Map<Integer, List<Integer>> free = lot.displayFreeSlots(type);
                        System.out.println("Free Slots:");
                        for (int floor : free.keySet()) {
                            System.out.println("Floor " + floor + ": " + free.get(floor));
                        }
                    } else {
                        System.out.println("Create a parking lot first.");
                    }
                    break;

                case 4:
                    if (lot != null) {
                        System.out.print("Enter vehicle type (Car/Bike/etc): ");
                        String type = sc.nextLine();
                        Map<Integer, List<Integer>> occupied = lot.displayOccupiedSlots(type);
                        System.out.println("Occupied Slots:");
                        for (int floor : occupied.keySet()) {
                            System.out.println("Floor " + floor + ": " + occupied.get(floor));
                        }
                    } else {
                        System.out.println("Create a parking lot first.");
                    }
                    break;

                case 5:
                    if (lot != null) {
                        System.out.print("Enter vehicle type to park: ");
                        String type = sc.nextLine();
                        System.out.print("Enter vehicle reg no: ");
                        String reg_no = sc.nextLine();
                        System.out.print("Enter color of the vehicle: ");
                        String color = sc.nextLine();
                        Vehicles vehicle = new Vehicles(type, reg_no, color);
                        Ticket t = lot.ParkVehicle(type, vehicle);
                        if (t.getLot_Id() != null) {
                            System.out.println("Ticket created: " + t.getLot_Id() + "_" + t.getFloor_no() + "_" + t.getSlot_no() + " for vehicle " + t.getVehicle().getReg_no());
                        } else {
                            System.out.println("No available slots for this vehicle type.");
                        }
                    } else {
                        System.out.println("Create a parking lot first.");
                    }
                    break;

                case 6:
                    if (lot != null) {
                        System.out.print("Enter vehicle type to unpark: ");
                        String type = sc.nextLine();
                        System.out.print("Enter Ticket Id to unpark: ");
                        String ticket = sc.nextLine();
                        Vehicles t1 = lot.UnParkVehicle(ticket, type);
                        if (t1 != null) {
                            System.out.println("Ticket cancelled: for vehicle " + t1.getReg_no() + " " + t1.getVehicle_type() +" "+ t1.getColor());
                        } else {
                            System.out.println("No such vehicle is parked.");
                        }
                    } else {
                        System.out.println("Create a parking lot first.");
                    }
                    break;

                case 7:
                    System.out.println("Exiting... Goodbye!");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}