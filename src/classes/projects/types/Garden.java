package classes.projects.types;

import enums.TypeOfProject;
import enums.TypeOfSoil;

import java.util.Objects;

public final class Garden extends Structure {
    TypeOfSoil typeOfSoil;
    float squareMetersOfSoil;

    public Garden(long squareMeters, TypeOfSoil typeOfSoil, float squareMetersOfSoil) {
        super(TypeOfProject.GARDEN, squareMeters);
        this.typeOfSoil = typeOfSoil;
        this.squareMetersOfSoil = squareMetersOfSoil;
    }

    @Override
    public String printInformation() {
        return "Garde containing:" + typeOfSoil.label + " soil " + squareMetersOfSoil + " square meters of soil" + super.generalInfo();
    }
}
