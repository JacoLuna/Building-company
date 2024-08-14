package classes.projects.types;

import enums.ProjectType;
import enums.TypeOfSoil;

public class Garden extends Structure {
    TypeOfSoil typeOfSoil;
    float squareMetersOfSoil;

    public Garden(long squareMeters, TypeOfSoil typeOfSoil, float squareMetersOfSoil) {
        super(ProjectType.GARDEN, squareMeters);
        this.typeOfSoil = typeOfSoil;
        this.squareMetersOfSoil = squareMetersOfSoil;
    }

    @Override
    public String showDescription() {
        return "Garde containing:" + typeOfSoil.label + " soil " + squareMetersOfSoil + " square meters of soil" + super.generalInfo();
    }
}
