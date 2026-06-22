package core_java_practice.scenario_based_problems;

import java.io.*;
import java.util.*;

public class StudentGradeManager {

    static final int SUBJECTS = 5;

    
    public static int calculateTotal(int[] marks) {
        int total = 0;
        for (int m : marks) {
            total += m;
        }
        return total;
    }

    
    public static String calculateGrade(double avg) {

        if (avg >= 90) {
            if (avg >= 95)
                return "A+";
            else
                return "A";
        } else if (avg >= 80) {
            if (avg >= 85)
                return "B+";
            else
                return "B";
        } else if (avg >= 70) {
            return "C";
        } else if (avg >= 60) {
            return "D";
        } else {
            return "F";
        }
    }

    
    public static void searchStudent(String searchName,
                                     String[] names,
                                     int[] totals,
                                     String[] grades,
                                     int count) {

        boolean found = false;

        for (int i = 0; i < count; i++) {
            if (names[i].equalsIgnoreCase(searchName)) {
                System.out.println("\nStudent Found");
                System.out.println("Name : " + names[i]);
                System.out.println("Total: " + totals[i]);
                System.out.println("Grade: " + grades[i]);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student not found.");
        }
    }

    
    public static void bubbleSort(String[] names,
                                  int[] totals,
                                  String[] grades,
                                  int count) {

        for (int i = 0; i < count - 1; i++) {
            for (int j = 0; j < count - i - 1; j++) {

                if (totals[j] < totals[j + 1]) {

                    int tempTotal = totals[j];
                    totals[j] = totals[j + 1];
                    totals[j + 1] = tempTotal;

                    String tempName = names[j];
                    names[j] = names[j + 1];
                    names[j + 1] = tempName;

                    String tempGrade = grades[j];
                    grades[j] = grades[j + 1];
                    grades[j + 1] = tempGrade;
                }
            }
        }
    }

    public static void main(String[] args) {

        String[] names = new String[100];
        int[] totals = new int[100];
        String[] grades = new String[100];

        int count = 0;

        try {

            Scanner fileReader = new Scanner(new File("students.txt"));

            while (fileReader.hasNext()) {

                String name = fileReader.next();

                int[] marks = new int[SUBJECTS];

                for (int i = 0; i < SUBJECTS; i++) {
                    marks[i] = fileReader.nextInt();
                }

                int total = calculateTotal(marks);
                double avg = total / 5.0;

                names[count] = name;
                totals[count] = total;
                grades[count] = calculateGrade(avg);

                count++;
            }

            fileReader.close();

            bubbleSort(names, totals, grades, count);

            Scanner sc = new Scanner(System.in);

            System.out.print("Enter student name to search: ");
            String searchName = sc.nextLine();

            searchStudent(searchName, names, totals, grades, count);

            FileWriter writer = new FileWriter("report.txt");

            writer.write("===== STUDENT REPORT =====\n\n");

            for (int i = 0; i < count; i++) {

                writer.write(
                    "Name  : " + names[i] +
                    "\nTotal : " + totals[i] +
                    "\nGrade : " + grades[i] +
                    "\n----------------------\n"
                );
            }

            writer.close();

            System.out.println("\nReport written to report.txt");

        }

        catch (FileNotFoundException e) {
            System.out.println("Error: students.txt file not found.");
        }

        catch (InputMismatchException e) {
            System.out.println("Error: Invalid marks format in file.");
        }

        catch (IOException e) {
            System.out.println("Error while writing report file.");
        }

        catch (Exception e) {
            System.out.println("Unexpected Error: " + e.getMessage());
        }
    }
}