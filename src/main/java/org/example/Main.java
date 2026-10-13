import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.IntStream;

public class Main{
    public static void main(String[] args){
        List<Integer> x = new ArrayList<>();
        List<Integer> y = new ArrayList<>();
        List<Integer> xPlusY = new ArrayList<>();  //a
        Set<Integer> zSet = new TreeSet<>();       //b
        List<Integer> xMinusY = new ArrayList<>();     //c
        int p=4;
        List<Integer> xPlusYLimitedByp= new ArrayList<>();   //d

        Random rand= new Random();
        IntStream.range(0,5).forEach(i -> x.add(rand.nextInt(11)));
        IntStream.range(0,7).forEach(i -> y.add(rand.nextInt(11)));

        Collections.sort(x);
        Collections.sort(y);

        System.out.println("Lista x este: " + x);
        System.out.println("Lista y este: " + y);

        // a)
        xPlusY.addAll(x);
        xPlusY.addAll(y);
        Collections.sort(xPlusY);
        System.out.println("a) xPlusY este: " + xPlusY);

        //b)
        zSet.addAll(x);
        zSet.retainAll(y);
        System.out.println("b) zSet este: "+ zSet);

        //c)
        xMinusY.addAll(x);
        xMinusY.removeAll(y);
        System.out.println("c) xMinusY este: " + xMinusY);

        //d)
        for(int valoare : xPlusY){
            if( valoare<=p){
                xPlusYLimitedByp.add(valoare);
            }
        }
        System.out.println("d) xPlusYLimitedByp este: "+ xPlusYLimitedByp);

    }
}
