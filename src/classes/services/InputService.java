package classes.services;

import enums.TypeOfProject;

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
            System.out.println(e.toString());
        }
        return intAns;
    }
    public int setIntAns(List<Integer> ansArray) {
        try {
            intAns = keyboard.nextInt();
            if (!ansArray.contains(intAns)){
                System.out.println("ERROR Option not available");
                intAns = -1;
            }
        }catch (Exception e){
            System.out.println(e.toString());
        }
        return intAns;
    }
    public int setIntAns(String prompt, int minValue, int maxValue) {
        try {
            do {
                System.out.print(prompt);
                intAns = keyboard.nextInt();
                if (intAns < minValue || intAns > maxValue ){
                    System.out.println("ERROR Option not available");
                }
            } while (intAns == -1);
        }catch (Exception e){
            System.out.println(e.toString());
        }
        return intAns;
    }
    public int setIntAns(int minValue, int maxValue) {
        try {
            intAns = keyboard.nextInt();
            if (intAns < minValue || intAns > maxValue ){
                intAns = -1;
                System.out.println("ERROR Option not available");
            }
        }catch (Exception e){
            System.out.println(e.toString());
        }
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

    public Date dateAns(){
        int day, month, year;
        List<Integer> months = new ArrayList<>();
        for (Month m: Month.values()){
            months.add(m.ordinal()+1);
        }
        day = setIntAns("Introduce the day ",0,31);
        month = setIntAns("Introduce the number of the month ", months);
        year = setIntAns("Introduce the year ", 1971, java.time.LocalDate.now().getYear());
        return new Date(year,month-1,day);
    }
}
