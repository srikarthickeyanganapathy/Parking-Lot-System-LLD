public class Ticket {
    private String lot_Id;
    private int floor_no;
    private int slot_no;
    private Vehicles vehicle;
     
    public Ticket() {}

    public Ticket(String l, int f, int s) {
        lot_Id = l;
        floor_no = f;
        slot_no = s;
    }

    public String getLot_Id() {
        return lot_Id;
    }

    public void setLot_Id(String lot_Id) {
        this.lot_Id = lot_Id;
    }

    public int getFloor_no() {
        return floor_no;
    }

    public void setFloor_no(int floor_no) {
        this.floor_no = floor_no;
    }

    public int getSlot_no() {
        return slot_no;
    }

    public void setSlot_no(int slot_no) {
        this.slot_no = slot_no;
    }

    public Vehicles getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicles vehicle) {
        this.vehicle = vehicle;
    }
}