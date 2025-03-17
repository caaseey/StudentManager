package gestiondealumnos;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import static methods.FileManager.addStudent;
import static methods.FileManager.deleteStudent;
import static methods.FileManager.findByDNI;
import static methods.FileManager.showStudents;

/**
 * Clase principal para la gestión de alumnos.
 * Este programa permite a los usuarios realizar las siguientes acciones:
 * - Agregar un nuevo alumno.
 * - Mostrar la lista de alumnos registrados.
 * - Eliminar un alumno por su DNI.
 * - Buscar un alumno por su DNI.
 * - Salir del programa.
 * 
 * Se utilizan archivos para el almacenamiento de los datos y se maneja la entrada del usuario de manera segura.
 * 
 * @author grier
 */
public class StudentManagement {

    /**
     * Método principal que maneja la ejecución del programa y la interacción con el usuario.
     * Utiliza un sistema de menú con opciones para gestionar los alumnos.
     * 
     * @param args
     */
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>(); // Lista para almacenar alumnos (no se usa directamente con archivos)
        Scanner sc = new Scanner(System.in); // Scanner para la entrada del usuario
        int opc = -1; // Variable que almacena la opción seleccionada por el usuario

        do {
            try {
                // Mostrar el menú de opciones
                System.out.println("== Students menu ==");
                System.out.println("[1] Add student");
                System.out.println("[2] Show students");
                System.out.println("[3] Delete students");
                System.out.println("[4] Find by DNI");
                System.out.println("[0] Exit");
                System.out.print("Option: ");
                opc = sc.nextInt();
                System.out.println("");
                sc.nextLine(); // Limpia el buffer del scanner después de leer un número

                // Validación del rango de opciones
                if (opc < 0 || opc > 4) {
                    System.out.println("Option not valid (must be between 0 and 4)");
                    continue; // Volver a mostrar el menú
                }

                // Ejecutar la opción seleccionada
                switch (opc) {
                    case 1:
                        addStudent(students, sc); // Llamar al método para agregar un alumno
                        break;
                    case 2:
                        showStudents(); // Llamar al método para mostrar la lista de alumnos
                        break;
                    case 3:
                        deleteStudent(students, sc); // Llamar al método para eliminar un alumno por DNI
                        break;
                    case 4:
                        findByDNI(students, sc); // Llamar al método para buscar un alumno por su DNI
                        break;
                    case 0:
                        System.out.println("See you soon"); // Mensaje de despedida al salir
                        break;
                }
            } catch (InputMismatchException ex) {
                System.out.println("Invalid option, introduce a number"); // Manejo de error si el usuario introduce un valor no numérico
                sc.next(); // Limpiar el buffer de entrada para evitar bucles infinitos
            }
        } while (opc != 0); // Repetir el menú hasta que el usuario elija salir

        sc.close(); // Cerrar el scanner para liberar recursos
    }
}
