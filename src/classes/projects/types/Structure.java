package classes.projects.types;

import enums.ProjectType;

import java.util.Objects;

public abstract class Structure {

    private static int globalId = 0;
    protected int id;
    protected ProjectType name;
    public long squareMeters;

    public Structure(ProjectType name, long squareMeters) {
        this.name = name;
        this.squareMeters = squareMeters;
    }
    public static int getGlobalId() {
        return globalId;
    }
    public int getId() {
        return id;
    }
    private static void setGlobalId() {
        Structure.globalId++;
    }
    public void setId() {
        int value = getGlobalId();
        this.id = value++;
        setGlobalId();
    }

    protected String generalInfo(){
        return " and " + squareMeters + " square meters";
    }

    public abstract String showDescription();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Structure structure = (Structure) o;
        return getId() == structure.getId() && squareMeters == structure.squareMeters && name == structure.name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), name, squareMeters);
    }

    @Override
    public String toString() {
        return "Structure{" +
                "id=" + id +
                ", name=" + name +
                ", squareMeters=" + squareMeters +
                '}';
    }
}
