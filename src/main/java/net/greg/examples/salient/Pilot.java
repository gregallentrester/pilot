package net.greg.examples.salient;

import java.util.*;
import java.util.stream.*;


public final class Pilot {

  private static List<String> list =
    Arrays.asList("a", "b", "c");


  private void filter() {

    List<String> list =
      Arrays.asList("spring", "node", "java");

    List<String> result =
      list.stream().
        filter(s -> ! "node".equals(s)).
        collect(Collectors.toList());

    result.forEach(System.out::println);
  }

  private void join() {

    var answer =
      list.stream().
        map(x -> x.toLowerCase()).
        filter(s -> ! "b".equals(s)).
          collect(Collectors.joining(" "));

    System.err.println("\nanswer | " + answer);
  }

  private void groupBy() {

    List<Employee> employeeList =
     Arrays.asList(
      new Employee("allen","farady"),
      new Employee("cat","stillman"),
      new Employee("adam","allen"),
      new Employee("cat","helms"),
      new Employee("allen","jones"),
      new Employee("cat","jones"),
      new Employee("bryan","jones"));

    Map<String, List<Employee>> answer =
      employeeList.stream().
        filter(s -> ! "cat".equals(s.getName())).
        collect(
          Collectors.groupingBy(Employee::getName));

    System.err.println("\nanswer | " + answer);
  }


  public static void main(String[] a) {

    //new Pilot().filter();
    //new Pilot().join();
    new Pilot().groupBy();
  }


  private static final class Employee {

    public Employee(String fname, String lname) { name = fname; lastname = lname; }

    private String name;
    private String getName() { return name; }
    private void setName(String value) { name = value; }

    private String lastname;
    private String getLastname() { return lastname; }
    private void setLastname(String value) { lastname = value; }

    @Override
    public String toString() {

      return
        "\n     name: " + getName() +
        "\n lastname: " + getLastname();
    }
  }
}
