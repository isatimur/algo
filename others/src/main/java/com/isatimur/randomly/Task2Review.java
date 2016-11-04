package com.isatimur.randomly;

import java.util.TreeSet;

/**
 * Created by Isachenko Timur on 19.10.2016.
 */
public class Task2Review {

    public static void main(String[] args) {
        //create an ArrayList object
        TreeSet set = new TreeSet();

        //Add elements to Arraylist
        set.add("1");
        set.add("4");
        set.add("2");
        set.add("5");
        set.add("3");

    /*
      To Search an element of Java ArrayList using binary search algorithm use,
      static int binarySearch(List list, Object element) method of Collections class.

      This method returns the index of the value to be searched, if found in the
      ArrayList.
      Otherwise it returns (- (X) - 1)
      where X is the index where the the search value would be inserted.
      i.e. index of first element that is grater than the search value
      or ArrayList.size(), if all elements of an ArrayList are less
      than the search value.

      Please note that the ArrayList MUST BE SORTED before it can be searched
      using binarySearch method.
    */

        //First sort an ArrayList using sort method of Collections class
        System.out.println("Sorted ArrayList contains : " + set);

        //search an element using binarySearch method of Collections class
        System.out.println("Element found at : " + (set.contains("4") ? set.headSet("4").size() : -1));
    }
}

