import java.util.*;

public class Java8Compare {
    public boolean compare(int o1, int o2) {
        return o1 == o2 ;
    }

    public boolean compare(String o1, String o2) {
        return o1.equals(o2) ;
    }

    public boolean compare(Vector<Integer> a, Vector<Integer> b) {
        Collections.sort(a);
        Collections.sort(b);

        return a.equals(b) ;
    }

    public boolean compare(ArrayList<Integer> a, ArrayList<Integer> b) {
        Collections.sort(a);
        Collections.sort(b);

        return a.equals(b) ;
    }

    public boolean compare(int[] a, int[] b) {
        return Arrays.equals(a,b) ;
    }

    public static void main(String[] args) {
        System.out.println("new Coding2().compare(1, 2)");
        System.out.println(new Java8Compare().compare(1, 2));
        System.out.println("new Coding2().compare(1, 1)");
        System.out.println(new Java8Compare().compare(1, 1));
        System.out.println("new Coding2().compare('Sourabh', 'Sourabh')");
        System.out.println(new Java8Compare().compare("Sourabh", "Sourabh"));
        System.out.println("new Coding2().compare('sourabh', 'Sourabh')");
        System.out.println(new Java8Compare().compare("sourabh", "Sourabh"));

        System.out.println("Vector :: ");
        Vector<Integer> v1 = new Vector<>();
        v1.add(10);
        v1.add(12);
        v1.add(15);

        Vector<Integer> v2 = new Vector<>();
        v2.add(15);
        v2.add(12);
        v2.add(10);
        System.out.println(new Java8Compare().compare(v1, v2));

        Vector<Integer> v3 = new Vector<>();
        v3.add(10);
        v3.add(12);
        v3.add(15);
        System.out.println(new Java8Compare().compare(v1, v3));

        System.out.println("ArrayList :: ");
        ArrayList<Integer> a1 = new ArrayList<>();
        a1.add(10);
        a1.add(12);
        a1.add(15);

        ArrayList<Integer> a2 = new ArrayList<>();
        a2.add(15);
        a2.add(12);
        a2.add(10);
        System.out.println(new Java8Compare().compare(a1, a2));

        ArrayList<Integer> a3 = new ArrayList<>();
        a3.add(10);
        a3.add(12);
        a3.add(15);
        System.out.println(new Java8Compare().compare(a1, a3));
    }
}
