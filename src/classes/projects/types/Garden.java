package classes.projects.types;

import enums.ProjectType;

public class Garden extends Building{
    String typeOfSoil;
    float squareMetersOfSoil;

    public Garden(ProjectType name, long squareMeters, String typeOfSoil, float squareMetersOfSoil) {
        super(name, squareMeters);
        this.typeOfSoil = typeOfSoil;
        this.squareMetersOfSoil = squareMetersOfSoil;
    }
}
