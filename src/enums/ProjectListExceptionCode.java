package enums;

public enum ProjectListExceptionCode {
    EXISTING_PROJECT("This project already exists in the list"),
    NOT_EXISTING_PROJECT("This project does not exist in the list"),
    NOT_EXISTING_INDEX("This index project does not exist in the list"),
    SAME_PROJECT("This project is already at this index"),
    EMPTY_LIST("This list is already empty");
    public final String message;
    ProjectListExceptionCode(String message){
        this.message = message;
    }
}
