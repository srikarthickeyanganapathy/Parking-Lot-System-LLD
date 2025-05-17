public class Slots {
    private String slot_type;
    private boolean availability;
    private int slot_no;
    private Ticket ticket;

    Slots(String type, int s, int f, String p) {
        slot_type = type;
        slot_no = s;
        availability = false;
        ticket = new Ticket(p,f,s);
    }

    public String getSlot_type() {
        return slot_type;
    }

    public void setSlot_type(String slot_type) {
        this.slot_type = slot_type;
    }

    public boolean getAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public int getSlot_no() {
        return slot_no;
    }

    public void setSlot_no(int slot_no) {
        this.slot_no = slot_no;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    // create a ticket for specific slot
    public Ticket createTicket(Vehicles vehicle) {
        ticket.setVehicle(vehicle);
        return ticket;
    }
    
    // cancel the ticket for specific slot
    public Vehicles cancelTicket() {
        Vehicles dummy = ticket.getVehicle();
        ticket.setVehicle(null);
        return dummy;
    }

}