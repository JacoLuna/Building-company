package classes.Exceptions;

import enums.WorkerExceptionCode;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class workerException extends Exception{
    private static final Logger LOGGER = LogManager.getLogger(Logger.class);
    public workerException(int workerExceptionCodeNumber){
        super(WorkerExceptionCode.values()[workerExceptionCodeNumber].message);
    }
}
