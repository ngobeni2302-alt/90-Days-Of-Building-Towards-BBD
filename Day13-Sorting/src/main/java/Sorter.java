import java.util.ArrayList;
import java.util.List;

public class Sorter {

    public static List<Employee> bubbleSortBySalary(List<Employee> original) {
        List<Employee> list = new ArrayList<>(original);
        int n = list.size();

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (list.get(j).calculateSalary() > list.get(j + 1).calculateSalary()) {

                    Employee temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
        return list;
    }

    public static List<Employee> selectionSortById(List<Employee> original) {
        List<Employee> list = new ArrayList<>(original); // Defensive copy
        int n = list.size();

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (list.get(j).getId().compareTo(list.get(minIndex).getId()) < 0) {
                    minIndex = j;
                }
            }
            Employee temp = list.get(i);
            list.set(i, list.get(minIndex));
            list.set(minIndex, temp);
        }
        return list;
    }


    public static Employee binarySearchById(List<Employee> sortedById, String targetId) {
        int left = 0;
        int right = sortedById.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            String midId = sortedById.get(mid).getId();
            int comparison = midId.compareTo(targetId);

            if (comparison == 0) {
                return sortedById.get(mid);
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }
}