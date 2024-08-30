package classes.Exceptions;

import enums.WorkerExceptionCode;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WorkerException extends Exception{
    public WorkerException(int exceptionCode){
        super(WorkerExceptionCode.values()[exceptionCode].message);
    }
}
