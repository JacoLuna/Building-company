package classes.services;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class MenuService {
    private static int ans;

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
        return ans;
    }
    public static int setAns(int ans, List<Integer> ansArray) {
        MenuService.ans = -1;
        try {
            if (ansArray.contains(ans)){
                MenuService.ans = ans;
            }else {
                System.out.println("ERROR Option not available");
            }
        }catch (Exception e){
            System.out.println(e.toString());
        }
        return MenuService.ans;
    }
    public static int setAns(int ans) {
        MenuService.ans = -1;
        try {
            MenuService.ans = ans;
            return MenuService.ans;
        }catch (Exception e){
            System.out.println(e.toString());
        }
        return MenuService.ans;
    }
}
