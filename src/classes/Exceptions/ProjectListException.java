package classes.Exceptions;

import enums.ProjectListExceptionCode;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ProjectListException extends Exception{
    public ProjectListException(int exceptionCode){
        super(ProjectListExceptionCode.values()[exceptionCode].message);
    }
}
