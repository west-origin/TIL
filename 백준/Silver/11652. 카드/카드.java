
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws Exception{
       BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
       int n = Integer.parseInt(bf.readLine());
       int max = 0;
       long result = 0;
       HashMap<Long, Integer> cards = new HashMap<>();
       for(int i = 0 ; i < n ; i++) {
           long card = Long.parseLong(bf.readLine());
           cards.put(card, cards.getOrDefault(card, 0)+1);
           if(cards.get(card) > max) {
               max = cards.get(card);
               result = card;
           } else if(cards.get(card) == max) { // cards.get(card) == max
               result = Math.min(result, card);
           }
       }
       System.out.println(result);
    }
}