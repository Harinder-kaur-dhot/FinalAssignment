

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class studentAssignmentMark
{
  private String unitName;
  private List<Student> students = new ArrayList<>();
  private String firstName;
  private String lastName;
  private int studentID;
  private String assignment3;
  private double[] marks;
  private double totalMark;
 
  //F1//
  class Student {
      private String lastName;
      private String firstName;
      private String studentID;
      private double assignment1;
      private double assignment2;
      private double assignment3;
      
      public Student(String lastName, String firstName, String studentID, double assignment1, double assignment2, double assignment3) {
          this.lastName = lastName;
          this.firstName = firstName;
          this.studentID = studentID;
          this.assignment1 = assignment1;
          this.assignment2 = assignment2;
          this.assignment3 = assignment3;
      }
      
      public double calculateTotalMark() {
          return assignment1 + assignment2 + assignment3;
      }
      
      public String toString() {
          return lastName + "\t" + firstName + "\t" + studentID + "\t" + assignment1 + "\t" + assignment2 + "\t" + assignment3;
          
              
          }
      }
      
  }
  
public void readDataFromFile( String fileName) {
    try(BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
        String line;
        boolean readUnitName = true;
        while ((line = reader.readLine()) != null) {
            if(line.startsWith("last name")) {
                continue;
            }
            if (readUnitName) {
                unitName = line;
                readUnitName = false;
                
            } else {
                
                // this line confirms that data line includes all expected fields (lastName,firstname, studentID, and 3 assignments score)//
                String[] parts = line.split("\t");
                if (parts.length == 6) {
                    String lastName = parts[0].trim();
                    String firstName = parts[0].trim();
                    String studentID = parts[0].trim();
                    double assignment1 = Double.parseDouble(parts[3].trim());
                    double assignment2 = Double.parseDouble(parts[4].trim());
                    double assignment3 = Double.parseDouble(parts[5].trim());
                    
                    
                    Student student = new Student(lastName, firstName, studentID, assignment1, assignment2, assignment3);
                    students.add(student);
                }
                }

                }
                } catch (IOException e) {
                    System.err.println("Error reading from the file: " + e.getMessage());
                    
                }
            
                
        }
        
        //F2: To calculate and Print the total Marks//
        public void calculateAndPrintTotalMarks() {
            System.out.println("Name of Students in the list, studentID, assignment marks and total marks: ");
            
            for (Student student : students) {
                double totalMark = student.calculateTotalMark();
                System.out.println(student + "\tTotal Mark: " + totalMark);
                
            }
        }
        
        // to print the students below the threasold//
        public void printStudentBelowThreshold(double threshold) {
            System.out.println(" Students  total Marks" + threshold + ":");
            for (Student student : students) {
                double totalMark = student.calculateTotalMark();
                if(totalMark < threshold) {
                    System.out.println(student + "\tTotal Mark: " + totalMark);
                }
            }
        }
        
        //to print the names of top and bottom students on the list//
        
    }

  
  
  
