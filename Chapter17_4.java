/********************************************************************************************************************
 ********************************************************************************************************************
 *****                                         Chapter 17: Problem 4                                            *****
 *****__________________________________________________________________________________________________________*****
 *****                  4. Create a Student class which consists of name, major, gpa (double),                  *****
 *****           classrank (int) and KY resident (boolean). Have the Student implement Serializable.            *****
 *****          Create an array of Students and then output the array, one element at a time to a file.         *****
 *****                      Change your Student so that KY resident is transient and repeat.                    *****
 *****                   NOTE: the output file is a binary file so is not going to be readable.                 *****
 ********************************************************************************************************************
 ********************************************************************************************************************/

// IMPORTS of needed tools and plug-ins
import java.io.*;


public class Chapter17_4 {


    // Inner-Class Student that implements the Serializable Interface
    private static class Student implements Serializable {

        // CLASS VARIABLE(s) declaration(s)
        private String name;
        private String major;
        private double gpa;
        private int classRank;
        private transient boolean kyResident;


        // 5-arg constructor to be able to set all the instance data values by passing their values in as parameters
        public Student(String name, String major, double gpa, int classRank, boolean kyResident){
            this.name = name;
            this.major = major;
            this.gpa = gpa;
            this.classRank = classRank;
            this.kyResident = kyResident;
        }


        // toString used for simple output
        public String toString() {
            return name + "\t" + major + "\t" + gpa + "\t" + classRank + "\t" + kyResident;
        }
    }



    public static void main(String[] args) {

        // LOCAL VARIABLE(s) declaration(s)
        String filename = "studentsFile.dat";
        Student[] students = new Student[6];

        // Arrays used to fill in the students Array
        String[] studentNames = {"Ryan Barringer", "Richard Fox", "Kevin Howell", "Ryan Huffman", "Prekshya Nepal",
                                 "Thomas Ryan"};
        String[] studentMajors = {"BIT", "Education", "Mathematics", "Computer Science", "Business", "Computer Science"};
        double[] studentGPAs = {3.0, 4.0, 3.5, 2.0, 2.9, 3.2};
        int[] studentClassRanks = {4, 1, 2, 6, 5, 3};
        boolean[] studentKYResidents = {false, true, true, false, false, true};

        // for loop used to instantiate all the Student objects in the students Array
        for(int i = 0; i < students.length; i++){
            students[i] = new Student(studentNames[i], studentMajors[i], studentGPAs[i],
                    studentClassRanks[i], studentKYResidents[i]);
        }

        // try block used to attempt to open the ObjectOutputStream
        try {
            ObjectOutputStream studentOOS = new ObjectOutputStream(new FileOutputStream(filename));

            // Enhanced for loop used to output the Student objects, one-by-one, to the File and
                // for testing purposes, the console
            for(Student item : students){
                // Write to the File
                studentOOS.writeObject(item);

                // Print to the console, for testing purposes
                System.out.println(item);
            }

            // Close the ObjectOutputStream
            studentOOS.close();
        }
        // catch block used in case of a IOException
        catch(IOException iOExc){
            System.out.println(iOExc);
        }
    }
}
