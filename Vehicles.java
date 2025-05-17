public class Vehicles {
    private String vehicle_type;
    private String reg_no;
    private String color;

    public Vehicles() {
    }

    Vehicles(String vehicle_type, String reg_no, String color) {
        this.vehicle_type = vehicle_type;
        this.reg_no = reg_no;
        this.color = color;
    }

    public String getVehicle_type() {
        return vehicle_type;
    }

    public void setVehicle_type(String vehicle_type) {
        this.vehicle_type = vehicle_type;
    }

    public String getReg_no() {
        return reg_no;
    }

    public void setReg_no(String reg_no) {
        this.reg_no = reg_no;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
