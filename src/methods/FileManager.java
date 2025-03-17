package methods;

import gestiondealumnos.Student;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author grier
 */
public class FileManager {

     /**
     * Metodo para añadir estudiantes
     *
     * @author grier
     * @param students
     * @param sc
     */
    public static void addStudent(ArrayList<Student> students, Scanner sc) {
        System.out.println("== Add student ==");
        System.out.print("DNI: ");
        String dni = sc.nextLine().trim();

        if (!isDniUnique(students, dni) || !isDniUniqueInFile(dni)) {
            System.out.println("Error: A student with this DNI already exists");
            System.out.println("");
            return;
        }

        System.out.print("Name: ");
        String name = sc.nextLine().trim();
        System.out.print("Surname: ");
        String surname = sc.nextLine().trim();
        System.out.print("Scholar year: ");
        String course = sc.nextLine().trim();
        System.out.print("Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        Student student = new Student(name, surname, age, course, dni);
        students.add(student);
        System.out.println("Student added: " + student.toString());

        try {
            FileWriter fw = new FileWriter("register.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(name + ";" + surname + ";" + course + ";" + dni + ";" + age + System.lineSeparator());
            bw.close();
            System.out.println("Student saved");
            System.out.println("");
        } catch (IOException e) {
            System.err.println("Error");
            System.out.println("");
        }
    }
    
    /**
     * Metodo para mostrar estudiante
     *
     * @author grier0
     */
    public static void showStudents() {
        try {
            String allStudents = Files.readString(Path.of("register.txt"));
            System.out.println("== Show all the students ==");
            System.out.println(allStudents);
        } catch (IOException e) {
            System.err.println("Error");
            System.out.println("");
        }
    }

    /**
     * Metodo para borrar estudiantes
     *
     * @author grier
     */
    public static void deleteStudent(ArrayList<Student> students, Scanner sc) {
        System.out.println("== Delete a student ==");
        System.out.println("");
        showStudents();
        String result = readDNI(students, sc);
        if (result != null) {
            String[] data = result.split(";");
            String dni = data[3];
            students.removeIf(student -> student.getDni().equals(dni));
            try {
                BufferedReader br = new BufferedReader(new FileReader("register.txt"));
                BufferedWriter bw = new BufferedWriter(new FileWriter("temp.txt"));
                String line;
                while ((line = br.readLine()) != null) {
                    if (!line.contains(dni)) {
                        bw.write(line);
                        bw.newLine();
                    }
                }
                br.close();
                bw.close();
                Files.delete(Path.of("register.txt"));
                Files.move(Path.of("temp.txt"), Path.of("register.txt"));
                System.out.println("Student removed successfully.");
                System.out.println("");
            } catch (IOException e) {
                System.err.println("Error updating file");
                System.out.println("");
            }
        } else {
            System.out.println("Student not found");
            System.out.println("");
        }
    }

     /**
     * Metodo para buscar estudiantes por su DNI
     *
     * @author grier
     */
    public static void findByDNI(ArrayList<Student> students, Scanner sc) {
        System.out.println("== Search a student by DNI ==");
        String result = readDNI(students, sc);
        if (result != null) {
            System.out.println("Student found: " + result);
            System.out.println("");
        } else {
            System.out.println("Student not found");
            System.out.println("");
        }
    }

     /**
     * Metodo para leer el dni insertado por el usuario
     *
     * @author grier
     */
    public static String readDNI(ArrayList<Student> students, Scanner sc) {
        try {
            System.out.println("[INFO] By entering just one digit, the first matching student will be displayed. Enter the exact DNI for a precise search");
            System.out.print("Write the DNI of the student: ");
            String dni = sc.nextLine();
            BufferedReader br = new BufferedReader(new FileReader("register.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains(dni)) {
                    System.out.println("[INFO] Showing the first match found. If this is not the student you were looking for, enter the exact DNI for a precise search");
                    br.close();
                    return line;
                }
            }
            System.out.println("[WARNING] No student found with this DNI. Try entering more digits");
            br.close();
        } catch (IOException e) {
            System.err.println("Error reading file");
            System.out.println("");
        }
        return null;
    }

     /**
     * Metodos para verificar que el dni sean unicos y que no se repitan
     *
     * @author grier
     */
    public static boolean isDniUnique(ArrayList<Student> students, String dni) {
        dni = dni.toLowerCase();
        for (Student student : students) {
            if (student.getDni().toLowerCase().equals(dni)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isDniUniqueInFile(String dni) {
        dni = dni.toLowerCase();
        try (BufferedReader br = new BufferedReader(new FileReader("register.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(";");
                if (data.length > 3 && data[3].toLowerCase().equals(dni)) {
                    return false;
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file");
        }
        return true;
    }

}
