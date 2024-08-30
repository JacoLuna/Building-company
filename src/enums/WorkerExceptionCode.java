package enums;

public enum WorkerExceptionCode {
    EXISTING_WORKER("This worker already exists");

    public final String message;

    WorkerExceptionCode(String message){
        this.message = message;
    }
}
