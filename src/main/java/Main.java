import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RecursiveListTasks {

    // 1. מקבלת מערך, בונה ומחזירה רשימה עם הערכים שלו
    public static List<Integer> arrayToList(int[] array) {
        return arrayToListHelper(array, 0);
    }

    private static List<Integer> arrayToListHelper(int[] array, int index) {
        if (index == array.length) { // בסיס: הגעה לסוף המערך
            return new ArrayList<>();
        }
        List<Integer> list = arrayToListHelper(array, index + 1);
        list.add(0, array[index]); // מוסיפים בתחילת הרשימה
        return list;
    }

    // 2. מדפיסה רשימה נתונה בשורות נפרדות
    public static void printList(List<Integer> list) {
        if (list.isEmpty()) {
            return;
        }
        System.out.println(list.get(0));
        printList(list.subList(1, list.size())); // רקורסיה עם הרשימה ללא האיבר הראשון
    }

    // 3. מדפיסה מהסוף להתחלה
    public static void printListReverse(List<Integer> list) {
        if (list.isEmpty()) {
            return;
        }
        printListReverse(list.subList(1, list.size())); // קודם מדפיסים את שאר הרשימה
        System.out.println(list.get(0));
    }

    // 4. קולטת מהמשתמש מספרים חיוביים ובונה רשימה עד לקליטת 1-
    public static List<Integer> readPositiveNumbers() {
        Scanner scanner = new Scanner(System.in);
        return readPositiveNumbersHelper(scanner);
    }

    private static List<Integer> readPositiveNumbersHelper(Scanner scanner) {
        int num = scanner.nextInt();
        if (num == -1) { // בסיס: משתמש קלט 1-
            return new ArrayList<>();
        }
        List<Integer> list = readPositiveNumbersHelper(scanner);
        list.add(0, num); // מוסיפים בתחילת הרשימה
        return list;
    }

    // 5. מדפיסה את המספרים הזוגיים בלבד ברשימה נתונה
    public static void printEvenNumbers(List<Integer> list) {
        if (list.isEmpty()) {
            return;
        }
        if (list.get(0) % 2 == 0) {
            System.out.println(list.get(0));
        }
        printEvenNumbers(list.subList(1, list.size())); // ממשיכים עם הרשימה ללא האיבר הראשון
    }

    // 6. מחזירה האם מספר נתון מופיע ברשימה נתונה
    public static boolean containsNumber(List<Integer> list, int number) {
        if (list.isEmpty()) {
            return false;
        }
        if (list.get(0) == number) {
            return true;
        }
        return containsNumber(list.subList(1, list.size()), number);
    }

    // 7. מחיקה של חוליה עם ערך מסוים (ברשימה)
    public static List<Integer> deleteFirstOccurrence(List<Integer> list, int number) {
        if (list.isEmpty()) {
            return new ArrayList<>();
        }
        if (list.get(0) == number) {
            return list.subList(1, list.size()); // מדלגים על האיבר הראשון
        }
        List<Integer> newList = deleteFirstOccurrence(list.subList(1, list.size()), number);
        newList.add(0, list.get(0));
        return newList;
    }

    // 8. מחיקה של חוליה לפי אינדקס נתון
    public static List<Integer> deleteAtIndex(List<Integer> list, int index) {
        if (list.isEmpty() || index < 0) {
            return list;
        }
        if (index == 0) {
            return list.subList(1, list.size());
        }
        List<Integer> newList = deleteAtIndex(list.subList(1, list.size()), index - 1);
        newList.add(0, list.get(0));
        return newList;
    }

    // 9. מחזירה האם כל ערכי L1 מופיעים ב-L2
    public static boolean allValuesInList(List<Integer> L1, List<Integer> L2) {
        if (L1.isEmpty()) {
            return true;
        }
        if (!L2.contains(L1.get(0))) {
            return false;
        }
        return allValuesInList(L1.subList(1, L1.size()), L2);
    }

    // 10. הדפסת ערכי L1 שמופיעים ב-L2
    public static void printCommonValues(List<Integer> L1, List<Integer> L2) {
        if (L1.isEmpty()) {
            return;
        }
        if (L2.contains(L1.get(0))) {
            System.out.println(L1.get(0));
        }
        printCommonValues(L1.subList(1, L1.size()), L2);
    }

    // 11. בניית רשימה עם הערכים המשותפים של L1 ו-L2 (כולל חזרות)
    public static List<Integer> commonValues(List<Integer> L1, List<Integer> L2) {
        if (L1.isEmpty()) {
            return new ArrayList<>();
        }
        List<Integer> list = commonValues(L1.subList(1, L1.size()), L2);
        if (L2.contains(L1.get(0))) {
            list.add(0, L1.get(0));
        }
        return list;
    }

    // 12. מחיקת כל החוליות ב-L1 עם ערכים המופיעים ב-L2
    public static List<Integer> deleteAllOccurrences(List<Integer> L1, List<Integer> L2) {
        if (L1.isEmpty()) {
            return new ArrayList<>();
        }
        List<Integer> list = deleteAllOccurrences(L1.subList(1, L1.size()), L2);
        if (!L2.contains(L1.get(0))) {
            list.add(0, L1.get(0));
        }
        return list;
    }

    // Main להרצה ובדיקה
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        List<Integer> list = arrayToList(array);

        System.out.println("Original list:");
        printList(list);

        System.out.println("\nReversed list:");
        printListReverse(list);

        System.out.println("\nEven numbers:");
        printEvenNumbers(list);

        System.out.println("\nContains number 3: " + containsNumber(list, 3));

        List<Integer> updatedList = deleteFirstOccurrence(list, 3);
        System.out.println("\nList after deleting 3:");
        printList(updatedList);
    }
}
