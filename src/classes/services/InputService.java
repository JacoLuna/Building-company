package classes.services;

import classes.Exceptions.menuException;
import enums.TypeOfProject;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;

public class InputService {
    Scanner keyboard = new Scanner(System.in);
    private int intAns;
    private float floatAns;
    private long longAns;

    public int getAns(){
        return intAns;
    }
    public int setIntAns(String prompt, List<Integer> ansArray) {
        try {
            do {
                System.out.print(prompt);
                intAns = keyboard.nextInt();
                if (!ansArray.contains(intAns)){
                    System.out.println("ERROR Option not available");
                    intAns = -1;
                }
            } while (intAns == -1);
        }catch (Exception e){
            System.out.println(e.toString());return -1;
        }
        return intAns;
    }
    public int setIntAns(List<Integer> ansArray) {
        boolean isValid = false;
        do {
            try {
                intAns = keyboard.nextInt();
                if (!ansArray.contains(intAns)){
                    throw new menuException("ERROR Option not available");
                }
                isValid = true;
            }catch (InputMismatchException | menuException e){
                System.out.println(e);
                keyboard.next();
            } catch (Exception e){
                System.out.println("Unexpected error " + e);
            }
        }while (!isValid);
        return intAns;
    }
    public int setIntAns(String prompt, int minValue, int maxValue) {
        boolean isValid = false;
        do {
            try {
                    System.out.print(prompt);
                    intAns = keyboard.nextInt();
                    if (intAns < minValue || intAns > maxValue ){
                        throw new menuException("ERROR Option not available");
                    }
                    isValid = true;
            }catch (InputMismatchException | menuException e){
                System.out.println(e);
                keyboard.next();
            }catch (Exception e){
                System.out.println("Unexpected error " + e);
            }
        } while (!isValid);
        return intAns;
    }
    public int setIntAns(int minValue, int maxValue) {
        boolean isValid = false;
        do {
            try {
                intAns = keyboard.nextInt();
                if (intAns < minValue || intAns > maxValue ){
                    throw new menuException("ERROR Option not available");
                }
                isValid = true;
            }catch (InputMismatchException | menuException e){
                System.out.println(e);
                keyboard.next();
            }catch (Exception e){
                System.out.println("Unexpected error " + e);
            }
            }while (!isValid);
        return intAns;
    }

    public float setFloatAns(String prompt, List<Float> ansArray) {
        try {
            do {
                System.out.print(prompt);
                floatAns = keyboard.nextFloat();
                if (!ansArray.contains(floatAns)) {
                    System.out.println("ERROR Option not available");
                    floatAns = -1;
                }
            } while (intAns == -1);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return floatAns;
    }
    public float setFloatAns(List<Float> ansArray) {
        try {
            floatAns = keyboard.nextFloat();
            if (!ansArray.contains(floatAns)) {
                floatAns = -1;
                System.out.println("ERROR Option not available");
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return floatAns;
    }
    public float setFloatAns(String prompt, float minValue, float maxValue) {
        try {
            do {
                System.out.print(prompt);
                floatAns = keyboard.nextFloat();
                if (floatAns > minValue && floatAns < maxValue) {
                    System.out.println("ERROR Option not available");
                    floatAns = -1;
                }
            } while (intAns == -1);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return floatAns;
    }
    public float setFloatAns(float minValue, float maxValue) {
        try {
            floatAns = keyboard.nextFloat();
            if (floatAns < minValue || floatAns > maxValue) {
                System.out.println("ERROR Option not available");
                floatAns = -1;
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return floatAns;
    }

    public long setLongAns(List<Long> ansArray) {
        try {
            longAns = keyboard.nextLong();
            if (!ansArray.contains(longAns)) {
                System.out.println("ERROR Option not available");
                longAns = -1;
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return longAns;
    }
    public long setLongAns(long minValue, long maxValue) {
        try {
            longAns = keyboard.nextLong();
            if (longAns < minValue && longAns > maxValue) {
                System.out.println("ERROR Option not available");
                longAns = -1;
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return longAns;
    }

    public String stringAns(String prompt){
        System.out.println(prompt);
        return keyboard.next();
    }

    public LocalDate readValidDate() {
        int year, month, day;
        boolean validDate = false;
        LocalDate date = null;

        while (!validDate) {
            try {
                year = setIntAns("Enter year: ", LocalDate.MIN.getYear(), LocalDate.MAX.getYear());
                month = setIntAns("Enter month (1-12): ", 1, 12);
                day = setIntAns("Enter day: ", 1, 31);
                date = LocalDate.of(year, month, day);
                validDate = true;
            } catch (DateTimeException | IllegalArgumentException e) {
                System.out.println("Invalid date. Please try again.");
            }
        }
        return date;
    }
}
