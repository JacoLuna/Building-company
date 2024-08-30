package classes.People;

import classes.Exceptions.ProjectListException;
import classes.Exceptions.WorkerException;
import classes.interfaces.IHasProjects;
import classes.projects.Project;
import enums.ProjectListExceptionCode;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

public class Worker extends Employee implements IHasProjects {
    private static final Logger CONSOLE_ERROR = LogManager.getLogger("ConsoleErrorLogger");
    public Worker(String name, String lastName, String country, LocalDate BDay, int salary, String experience, String password) {
        super(name, lastName, country, BDay, salary, experience, password);
        super.type = getClass().toString().split("\\.")[2];
    }

    @Override
    public String printInformation() {
        return "";
    }

    @Override
    public LinkedList<Project> getProjects() {
        return projects;
    }

    @Override
    public void addProject(Project project) {
        try {
            if (!projects.contains(project)){
                projects.add(project);
            }else {
                throw new ProjectListException(ProjectListExceptionCode.EXISTING_PROJECT.codeNumber);
            }
        } catch (ProjectListException projectListException){
            CONSOLE_ERROR.error(projectListException.getMessage());
        }
    }

    @Override
    public void removeProject(Project project) {
        try {
            if (projects.contains(project)){
                projects.remove(project);
            }else {
                throw new ProjectListException(ProjectListExceptionCode.NOT_EXISTING_PROJECT.codeNumber);
            }
        } catch (ProjectListException projectListException){
            CONSOLE_ERROR.error(projectListException.getMessage());
        }
    }

    @Override
    public void removeProject(Integer projectIndex) {
        try {
            if (projects.get(projectIndex) != null){
                projects.remove(projectIndex);
            }else {
                throw new ProjectListException(ProjectListExceptionCode.NOT_EXISTING_INDEX.codeNumber);
            }
        } catch (ProjectListException projectListException){
            CONSOLE_ERROR.error(projectListException.getMessage());
        }
    }

    @Override
    public Project getProject(Integer projectIndex) {
        return projects.get(projectIndex);
    }

    @Override
    public int getProject(Project project) {
        return projects.indexOf(project);
    }

    public void setProject(int projectIndex, Project project){
        try {
            if (!getProject(projectIndex).equals(project)){
                projects.set(projectIndex, project);
            }else {
                throw new ProjectListException(ProjectListExceptionCode.SAME_PROJECT.codeNumber);
            }
        } catch (ProjectListException projectListException){
            CONSOLE_ERROR.error(projectListException.getMessage());
        }
    }

    @Override
    public void clearProjects(){
        try {
            if (!projects.isEmpty()){
                projects.clear();
            }else {
                throw new ProjectListException(ProjectListExceptionCode.EMPTY_LIST.codeNumber);
            }
        } catch (ProjectListException projectListException){
            CONSOLE_ERROR.error(projectListException.getMessage());
        }
    }
}
