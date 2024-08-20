package classes.services;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class MenuService {
    private static int intAns;
    private static float floatAns;
    private static long longAns;

    public static String printMenu(String tittle, String[] ans){
        StringBuilder sb = new StringBuilder(tittle + "\n");
        for (int i = 0; i < ans.length; i++) {
            sb.append(i).append(" ").append(ans[i]).append("\n");
        }
        return sb.toString();
    }
    public static String printMenu(String[] ans){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ans.length; i++) {
            sb.append(i).append(" ").append(ans[i]).append("\n");
        }
        return sb.toString();
    }
    public static int getAns(){
        return intAns;
    }
    public static int setIntAns(int ans, List<Integer> ansArray) {
        MenuService.intAns = -1;
        try {
            if (ansArray.contains(ans)){
                MenuService.intAns = ans;
            }else {
                System.out.println("ERROR Option not available");
            }
        }catch (Exception e){
            System.out.println(e.toString());
        }
        return MenuService.intAns;
    }

    public static int setIntAns(int ans, int minValue, int maxValue) {
        MenuService.intAns = -1;
        try {
            if (ans > minValue && ans < maxValue ){
                MenuService.intAns = ans;
            }else {
                System.out.println("ERROR Option not available");
            }
            return MenuService.intAns;
        }catch (Exception e){
            System.out.println(e.toString());
        }
        return MenuService.intAns;
    }

    public static float setFloatAns(float ans, List<Float> ansArray) {
        MenuService.floatAns = -1;
        try {
            if (ansArray.contains(ans)) {
                MenuService.floatAns = ans;
            } else {
                System.out.println("ERROR Option not available");
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return MenuService.floatAns;
    }

    public static float setFloatAns(float ans, float minValue, float maxValue) {
        MenuService.floatAns = -1;
        try {
            if (ans > minValue && ans < maxValue) {
                MenuService.floatAns = ans;
            } else {
                System.out.println("ERROR Option not available");
            }
            return MenuService.floatAns;
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return MenuService.floatAns;
    }

    public static long setLongAns(long ans, List<Long> ansArray) {
        MenuService.longAns = -1;
        try {
            if (ansArray.contains(ans)) {
                MenuService.longAns = ans;
            } else {
                System.out.println("ERROR Option not available");
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return MenuService.longAns;
    }

    public static long setLongAns(long ans, long minValue, long maxValue) {
        MenuService.longAns = -1;
        try {
            if (ans > minValue && ans < maxValue) {
                MenuService.longAns = ans;
            } else {
                System.out.println("ERROR Option not available");
            }
            return MenuService.longAns;
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return MenuService.longAns;
    }
}
