package ru.shop.helper;
import ru.shop.models.Habar;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
public class Helper {
    public static int getRandomInt(){
        int n = 2147483640;
        final Random rnd = new Random();
        int lastlast = rnd.nextInt(n);
        int last = (lastlast + 1 + rnd.nextInt(n - 1)) % n;
        for (int i = 0; i < 30; i++) {
            int r = (lastlast + 1 + rnd.nextInt(n - 2)) % n;
            if (r == last)
                r = (lastlast + n - 1) % n;
            lastlast = last;
            last = r;
        }
        return last;
    }
    public static int costIterator(ArrayList basketList, int total_cost){
        Iterator<Habar> habarIterator = basketList.iterator();
        while (habarIterator.hasNext()) {
            Habar nextHabar = habarIterator.next();
            total_cost = total_cost+nextHabar.getCost();
        }
        return total_cost;
    }
}
