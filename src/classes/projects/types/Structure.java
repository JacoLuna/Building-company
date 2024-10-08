package classes.projects.types;

import classes.interfaces.Identifiable;
import classes.interfaces.Printable;
import enums.TypeOfProject;

public abstract class Structure implements Printable, Identifiable {

    private static int globalId;
    protected int id;
    protected TypeOfProject name;
    protected float price;
    public long squareMeters;

    static {
        globalId = 0;
    }

    public Structure(TypeOfProject name, long squareMeters) {
        this.name = name;
        this.squareMeters = squareMeters;
        this.price = name.baseCost * squareMeters;
    }
    public static int getGlobalId() {
        return globalId;
    }
    @Override
    public final int getId() {
        return id;
    }
    private static void setGlobalId() {
        Structure.globalId++;
    }
    @Override
    public final void setId() {
        int value = getGlobalId();
        this.id = value++;
        setGlobalId();
    }

    protected String generalInfo(){
        return " and " + squareMeters + " square meters" + " with a price of " + price + "$";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Structure structure = (Structure) o;
        return getId() == structure.getId() && squareMeters == structure.squareMeters && name == structure.name && price == structure.price;
    }

    @Override
    public int hashCode() {
        return 21 * name.hashCode() + (int)squareMeters;
    }

    @Override
    public String toString() {
        return "Structure{" +
                "id=" + id +
                ", name=" + name +
                ", squareMeters=" + squareMeters +
                ", price=" + price +
                '}';
    }
}
