package service;

import java.util.ArrayList;
import java.util.Comparator;
import model.Dump;

public class HouseholdWasteService {

    public void handleHouseholdWaste(ArrayList<Integer> arr) {
        arr.sort((Integer o1, Integer o2) -> o1 - o2);
        Dump dump = new Dump(10000, 0);
        boolean flat = true;
        while (flat) {
            int l = arr.size();
            for (int i = l - 1; i >= 0; i--) {
                
                if (arr.size() == 1) {
                    dump.setTotalGarbage(dump.getTotalGarbage() - arr.get(i));
                    flat = false;
                    break;
                }
                if (dump.getTotalGarbage() - arr.get(i) > 0) {
                    dump.setTotalGarbage(dump.getTotalGarbage() - arr.get(i));
                    System.out.println(arr.get(i));
                    dump.setTime(dump.getTime() + 8);
                    arr.remove(i);
                }

            }
            dump.setCostPaidToDump(dump.getCostPaidToDump() + 57000);
            dump.setTotalGarbage(10000);
            dump.setTime(dump.getTime() + 30);
            System.out.println(dump.getCostPaidToDump());
        }
        int totalPay = (int) (120000 * (dump.getTime() / 60.0) + dump.getCostPaidToDump());
        System.out.println(totalPay);

    }

}
