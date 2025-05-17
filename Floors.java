
import java.util.ArrayList;
import java.util.List;

public class Floors {
    List<Slots> slots = new ArrayList<>();
    private int noOfSlots;
    private int slot_no;
    private int floor_no;
    private String lot_no;

    Floors(int nfs, int f, String l) {
        noOfSlots = nfs;
        floor_no = f;
        lot_no = l;
        for(int i=0;i < nfs; i++) {
            if(i == 0)
                slots.add(new Slots("Truck", i+1, f, l));
            else if(i == 1 || i == 2)
                slots.add(new Slots("Bike", i+1, f, l));
            else
                slots.add(new Slots("Car", i+1, f, l));
        }
    }

    public List<Slots> getSlots() {
        return slots;
    }

    public void setSlots(List<Slots> slots) {
        this.slots = slots;
    }

    public int getNoOfSlots() {
        return noOfSlots;
    }

    public void setNoOfSlots(int noOfSlots) {
        this.noOfSlots = noOfSlots;
    }

    public int getSlot_no() {
        return slot_no;
    }

    public void setSlot_no(int slot_no) {
        this.slot_no = slot_no;
    }

    public int getFloor_no() {
        return floor_no;
    }

    public void setFloor_no(int floor_no) {
        this.floor_no = floor_no;
    }

    public String getLot_no() {
        return lot_no;
    }

    public void setLot_no(String lot_no) {
        this.lot_no = lot_no;
    }

    // Add slots in the floor
    public void addSlots(int n) {
        for (int i = noOfSlots; i < noOfSlots+n; i++) {
            slots.add(new Slots("Car", i+1, floor_no, lot_no));
        }
        noOfSlots += n;
    }

    // park a vehicle in a slot
    public Ticket ParkVehicleSlots(int slotno, Vehicles vehicle) {
        slots.get(slotno-1).setAvailability(true);
        return slots.get(slotno-1).createTicket(vehicle);
    }

    // unpark a vehicle in a slot
    public Vehicles UnParkVehicleSlots(int slotno) {
        slots.get(slotno-1).setAvailability(false);
        return slots.get(slotno-1).cancelTicket();
    }
}