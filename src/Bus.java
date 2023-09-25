class Bus{
    private int bus_number;
    private String bus_regestration_num;
    private Driver bus_driver;
    private String bus_route;
    private int bus_capacity;

    Bus() {
        this.bus_number = 0;
        this.bus_regestration_num = "";
        this.bus_route = "";
        this.bus_capacity=0;
    }

    Bus(int bus_number, String bus_regestration_num, Driver bus_driver, String bus_route,int bus_capacity) {
        this.bus_number = bus_number;
        this.bus_regestration_num = bus_regestration_num;
        this.bus_driver = bus_driver;
        this.bus_route = bus_route;
        this.bus_capacity=bus_capacity;
    }

    void setBus_number(int bus_number) {
        this.bus_number = bus_number;
    }

    int getBus_number() {
        return bus_number;
    }

    void setBus_regestration_num(String bus_regestration_num) {
        this.bus_regestration_num = bus_regestration_num;
    }

    String getBus_regestration_num() {
        return bus_regestration_num;
    }

    void setBus_driver() {
        this.bus_driver = bus_driver;
    }

    Driver getBus_driver() {
        return bus_driver;
    }

    void setBus_route(String bus_route) {
        this.bus_route = bus_route;
    }

    String getBus_route() {
        return bus_route;
    }
    void setBus_capacity(int bus_capacity){
        this.bus_capacity=bus_capacity;
    }
    int getBus_capacity(){
        return bus_capacity;
    }


    @Override
    public String toString() {
        return
                "Bus Number=" + bus_number +
                        " Bus Model= " + bus_regestration_num +
                        " Bus Driver= " + bus_driver.toString() +
                        " Bus route= " + bus_route +
                        "bus capacity = " +bus_capacity;
    }
}
