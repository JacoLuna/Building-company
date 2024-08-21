package classes.services;

import java.util.List;
import java.util.Scanner;

public class InputService {
    Scanner keyboard = new Scanner(System.in);
    private int intAns;
    private float floatAns;
    private long longAns;

    public int getAns(){
        return intAns;
    }
    public int setIntAns(String prompt, int ans, List<Integer> ansArray) {
        intAns = -1;
        try {
            do {
                System.out.print(prompt);
                intAns = setIntAns(keyboard.nextInt(), ansArray);
                if (ansArray.contains(ans)){
                    intAns = ans;
                }else {
                    System.out.println("ERROR Option not available");
                }
            } while (intAns == -1);
        }catch (Exception e){
            System.out.println(e.toString());
        }
        return intAns;
    }
    public int setIntAns(int ans, List<Integer> ansArray) {
        intAns = -1;
        try {
            if (ansArray.contains(ans)){
                intAns = ans;
            }else {
                System.out.println("ERROR Option not available");
            }
        }catch (Exception e){
            System.out.println(e.toString());
        }
        return intAns;
    }
    public int setIntAns(String prompt, int ans, int minValue, int maxValue) {
        intAns = -1;
        try {
            do {
                System.out.print(prompt);
                intAns = setIntAns(keyboard.nextInt(), minValue, maxValue);
                if (ans > minValue && ans < maxValue ){
                    intAns = ans;
                }else {
                    System.out.println("ERROR Option not available");
                }
            } while (intAns == -1);
        }catch (Exception e){
            System.out.println(e.toString());
        }
        return intAns;
    }
    public int setIntAns(int ans, int minValue, int maxValue) {
        intAns = -1;
        try {
            if (ans > minValue && ans < maxValue ){
                intAns = ans;
            }else {
                System.out.println("ERROR Option not available");
            }
        }catch (Exception e){
            System.out.println(e.toString());
        }
        return intAns;
    }

    public float setFloatAns(String prompt, float ans, List<Float> ansArray) {
        floatAns = -1;
        try {
            do {
                System.out.print(prompt);
                floatAns = setFloatAns(keyboard.nextInt(), ansArray);
                if (ansArray.contains(ans)) {
                    floatAns = ans;
                }else {
                    System.out.println("ERROR Option not available");
                }
            } while (intAns == -1);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return floatAns;
    }
    public float setFloatAns(float ans, List<Float> ansArray) {
        floatAns = -1;
        try {
            if (ansArray.contains(ans)) {
                floatAns = ans;
            } else {
                System.out.println("ERROR Option not available");
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return floatAns;
    }
    public float setFloatAns(String prompt, float ans, float minValue, float maxValue) {
        floatAns = -1;
        try {
            do {
                System.out.print(prompt);
                floatAns = setFloatAns(keyboard.nextInt(), minValue, maxValue);
                if (ans > minValue && ans < maxValue) {
                    floatAns = ans;
                }else {
                    System.out.println("ERROR Option not available");
                }
            } while (intAns == -1);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return floatAns;
    }
    public float setFloatAns(float ans, float minValue, float maxValue) {
        floatAns = -1;
        try {
            if (ans > minValue && ans < maxValue) {
                floatAns = ans;
            } else {
                System.out.println("ERROR Option not available");
            }
            return floatAns;
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return floatAns;
    }

    public long setLongAns(long ans, List<Long> ansArray) {
        longAns = -1;
        try {
            if (ansArray.contains(ans)) {
                longAns = ans;
            } else {
                System.out.println("ERROR Option not available");
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return longAns;
    }
    public long setLongAns(long ans, long minValue, long maxValue) {
        longAns = -1;
        try {
            if (ans > minValue && ans < maxValue) {
                longAns = ans;
            } else {
                System.out.println("ERROR Option not available");
            }
            return longAns;
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return longAns;
    }
}
