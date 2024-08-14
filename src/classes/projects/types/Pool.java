package classes.projects.types;

import enums.ProjectType;

public class Pool extends Structure {
    float depth;
    float temperature;

    public Pool(long squareMeters, float depth, float temperature) {
        super(ProjectType.POOL, squareMeters);
        this.depth = depth;
        this.temperature = temperature;
    }
    @Override
    public String showDescription() {
        return "Pool containing:" + depth + " of depth, a temperature of " + temperature + "°C" + super.generalInfo();
    }

}
