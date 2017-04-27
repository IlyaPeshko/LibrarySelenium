package by.htp.selen.UI.WebDriver;

/**
 * Created by user on 24.03.17.
 */
public enum DriverTypes {
    FIREFOX ("firefox"), IE ("internet explorer"), GC ("google chrome");

    private String driverName;

    private DriverTypes(String driverName){
        this.driverName = driverName;
    }

    public String getDriverName() {
        return this.driverName;
    }
}
