package classes.projects.types;

import enums.ProjectType;

public class Pool extends Building{
    float depth;
    float temperature;

    public Pool(ProjectType name, long squareMeters, float depth, float temperature) {
        super(name, squareMeters);
        this.depth = depth;
        this.temperature = temperature;
    }
}
