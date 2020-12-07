import java.util.*;

/**
 * Given n users (u_1, u_2,..., u_n) and k groups (g_1, g_2, ..., g_k),
 * create all possible combinations of all groups. basically, in the end,
 * each combination is a Map<Integer,Integer>, where the first Integer is user ID, and the second Integer is group ID.
 * For example, [(u_1,g_1), (u_2,g_1)....,(u_n, g_1)] is one possible combination.
 * There will be k^n combinations.
 */

public class UserGroupCombinations {
    public static void main(String[] args) {
        List<?> groups = grouping(Arrays.asList(1,2), Arrays.asList(3,4));
        System.out.println(groups.size());
        System.out.println(groups);
    }

    static List<Map<Integer,Integer>> grouping(List<Integer> users, List<Integer> groups) {
        if (users.isEmpty()) {
            Map<Integer,Integer> empty = Collections.emptyMap();
            return Collections.singletonList(empty);
        } else {
            Integer user = users.get(0);
            List<Map<Integer,Integer>> subs = grouping(users.subList(1, users.size()), groups);

            List<Map<Integer,Integer>> solutions = new ArrayList<>();
            for (Integer group: groups) {
                for (Map<Integer,Integer> sub : subs) {
                    Map<Integer,Integer> m = new HashMap<>(sub);
                    m.put(user, group);
                    solutions.add(m);
                }
            }
            return solutions;
        }
    }
}
