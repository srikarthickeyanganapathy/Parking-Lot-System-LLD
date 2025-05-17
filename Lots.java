import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lots {
    private String lot_Id;
    private int noOfFloors;
    private int noOfSlots;
    List<Floors> floors = new ArrayList<>();

    Lots(String id, int nf, int nfs) {
        lot_Id = id;
        noOfFloors = nf;
        noOfSlots = nfs;
        for (int i = 0; i < nf; i++) {
            floors.add(new Floors(noOfSlots, i, id));
        }
    }

    public String getLot_Id() {
        return lot_Id;
    }

    public void setLot_Id(String lot_Id) {
        this.lot_Id = lot_Id;
    }

    public int getNoOfFloors() {
        return noOfFloors;
    }

    public void setNoOfFloors(int noOfFloors) {
        this.noOfFloors = noOfFloors;
    }

    public int getNoOfSlots() {
        return noOfSlots;
    }

    public void setNoOfSlots(int noOfSlots) {
        this.noOfSlots = noOfSlots;
    }

    public List<Floors> getFloors() {
        return floors;
    }

    public void setFloors(List<Floors> floors) {
        this.floors = floors;
    }

    // Add floors in the lot
    public void AddFloor(int n) {
        for (int i = noOfFloors; i < noOfFloors+n; i++) {
            floors.add(new Floors(noOfSlots, i, lot_Id));
        }
        noOfFloors += n;
    }

    // To Add slots in a Floor
    public void AddSlot(int n, int floor) {
        floors.get(floor).addSlots(n);
    }

    // display the flors and slots in the lot
    public void display() {
        for (Floors i: floors) {
            for(Slots j: i.slots) {
                System.out.println(i.getFloor_no()+" "+j.getSlot_no());
            }
        }
    }

    // display the count of slots of the respective type in each floor
    public void displayNoOfSlots(String type) {
        for (Floors i: floors) {
            int count = 0;
            for(Slots j: i.slots) {
                if((j.getSlot_type()).equals(type)) count += 1;
            }
            System.out.println("The no of slots available on floor "+i.getFloor_no()+" of type "+ type +" are "+ count);
        }
    }

    // display the free slots based on the type on each floor
    public Map<Integer, List<Integer>> displayFreeSlots(String type) {
        Map<Integer, List<Integer>> map = new HashMap<>(); 
        for (Floors i: floors) {
            List<Integer> a = new ArrayList<>();
            for(Slots j: i.slots) {
                if((j.getSlot_type()).equals(type) && !j.getAvailability()) {
                    a.add(j.getSlot_no());
                }
            }
            map.put(i.getFloor_no(), a);
        }
        return map;
    }

    // display occupied slots in each floor
    public Map<Integer, List<Integer>> displayOccupiedSlots(String type) {
        Map<Integer, List<Integer>> map = new HashMap<>(); 
        for (Floors i: floors) {
            List<Integer> a = new ArrayList<>();
            for(Slots j: i.slots) {
                if((j.getSlot_type()).equals(type) && j.getAvailability()) {
                    a.add(j.getSlot_no());
                }
            }
            map.put(i.getFloor_no(), a);
        }
        return map;
    }

    //Park vehicle in the slot
    public Ticket ParkVehicle(String type, Vehicles vehicle) {
        Map<Integer, List<Integer>> map = displayFreeSlots(type);
        Ticket t = null; 
        for(int i: map.keySet()) {
            if(!map.get(i).isEmpty())
            {
                t = floors.get(i).ParkVehicleSlots(map.get(i).get(0), vehicle);
                break;
            }
        }
        if(t == null) System.out.println("There is no available slots");
        return t;
    }

    // Unpark  vehicle from the slot
    public Vehicles UnParkVehicle(String ticket, String type) {
        String[] obj = ticket.split("_");
        Map<Integer, List<Integer>> map = displayOccupiedSlots(type); 
        return floors.get(Integer.parseInt(obj[1])).UnParkVehicleSlots(Integer.parseInt(obj[2]));
    }
}