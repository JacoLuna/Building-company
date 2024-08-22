package classes.projects.types;

import enums.TypeOfProject;

import java.util.Objects;

public class Pool extends Structure {
    float depth;
    float temperature;

    public Pool(long squareMeters, float depth, float temperature) {
        super(TypeOfProject.POOL, squareMeters);
        this.depth = depth;
        this.temperature = temperature;
    }

    @Override
    public String printInformation() {
        return "Pool containing:" + depth + " of depth, a temperature of " + temperature + "°C" + super.generalInfo();
    }
}
