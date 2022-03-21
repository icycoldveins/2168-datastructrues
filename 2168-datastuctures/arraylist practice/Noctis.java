
import java.util.ArrayList;
import java.util.List;

public class Noctis {
    //takes in a List and returns true if all
    //the items in the List are unique. All the items are unique if none of them are
    //the same.2 Return false otherwise.
    public static <E> boolean unique(List<E> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = 1 + i; j < list.size(); j++) {
                if (list.get(i).equals(list.get(j))) {
                    return false;
                }

            }
        }
        return true;
    }

    //The method returns a new List of integers which contains all of the
    //numbers from the input list which are multiples of the given int.
    //contain [25, 5, 30, 25].
    public static List<Integer> allMultiples(List<Integer> multiples, int n) {
        List<Integer> newlist = new ArrayList<>();
        for (int x : multiples) {
            if (x % n == 0) {
                newlist.add(x);
            }

        }
        return newlist;
    }

    //The method returns a new List<String> which contains all the Strings from the original list that are length characters long.
    public static List<String> allStringsOfSize(List<String> duplicate, int n) {
        List<String> Tengu = new ArrayList<>();
        for (String x : duplicate) {
            // if the length of the string is equal to n then a new list is added all the values
            //that match the desired length
            if (x.length() == n) {
                Tengu.add(x);
            }
        }
        return Tengu;
    }

    // It returns true if the Lists are permutations of each
    //other and false if not.
    public static <E> boolean isPermutation(List<E> newlist1, List<E> newlist2) {
        // checks if the lists are the same size
        if (newlist1.size() == newlist2.size()) {
            for (int i = 0; i < newlist1.size(); i++) {
                for (int j = 0; j < newlist2.size(); j++) {
                    // since checking an index causes a shift to the left and a
                    //negative number is not a valid index
                    //we can check after the end of for loop i and if the values that are
                    //leftover from both lists are equal then we can say that they are both equal
                    if (newlist1.get(i).equals(newlist2.get(j)) && i != 0) {
                        newlist1.remove(i);
                        newlist2.remove(j);
                        i--;
                        j--;
                    }
                }
            }
            if (newlist1.equals(newlist2)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    // separates String where whitespaces exist, appends them to an array, then said array is iterated
    //and added to a list
    public static List<String> StringtoListOfWords(String convertee) {
        List<String> list = new ArrayList<>();
        String[] m = convertee.split("\\s+");
        // loops through the array and adds the elements in the array to a list
        for (String x : m) {
            list.add(x);
        }
        return list;
    }

    //remove all instances of an object in a list
    public static <E> void removeallInstances(List<E> list, E obj) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == obj) {
                list.remove(i);
                //after value at i index is removed, i is shifted to the left because all elemenets are shifted to the left
                i--;
            }

        }

    }


    public static void main(String[] args) {
        List<String> n = new ArrayList<>();
        String m = ("Hello, world!");
        n = StringtoListOfWords(m);
        System.out.println(n);
    }
}




