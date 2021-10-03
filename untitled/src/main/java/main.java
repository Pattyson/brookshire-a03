import java.util.*;

public class main {


        public static void main(String[] args) {
            String[] colors = {"red", "white", "blue", "green", "gray",
                    "orange", "tan", "white", "cyan", "peach", "gray", "orange"};
            List<String> list = Arrays.asList(colors);

            convertToSet(list);
        }

        private static void convertToSet(Collection<String> values) {
            Set<String> set = new HashSet<>(values);

            System.out.print("Set: ");
            System.out.println(set);
        }

}
