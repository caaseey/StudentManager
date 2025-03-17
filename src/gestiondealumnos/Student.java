package gestiondealumnos;

/**
 * Clase que representa un estudiante.
 * Contiene atributos básicos como nombre, apellido, edad, curso y DNI.
 * Proporciona métodos para obtener y modificar estos valores.
 * 
 * @author grier
 */
public class Student {

    // Atributos privados del estudiante
    private String name;   // Nombre del estudiante
    private String surname; // Apellido del estudiante
    private int age;       // Edad del estudiante
    private String course; // Curso en el que está matriculado
    private String dni;    // Documento Nacional de Identidad (DNI)

    /**
     * Constructor con parámetros.
     * Permite crear un objeto Student con valores definidos.
     * 
     * @param name Nombre del estudiante.
     * @param surname Apellido del estudiante.
     * @param age Edad del estudiante.
     * @param course Curso en el que está matriculado.
     * @param dni DNI del estudiante.
     */
    public Student(String name, String surname, int age, String course, String dni) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.course = course;
        this.dni = dni;
    }

    /**
     * Constructor vacío.
     * Permite crear un objeto Student sin definir valores inicialmente.
     */
    public Student() {
    }

    // Métodos Getter y Setter para acceder y modificar los atributos

    /**
     * Obtiene el nombre del estudiante.
     * @return Nombre del estudiante.
     */
    public String getName() {
        return name;
    }

    /**
     * Modifica el nombre del estudiante.
     * @param name Nuevo nombre del estudiante.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Obtiene el apellido del estudiante.
     * @return Apellido del estudiante.
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Modifica el apellido del estudiante.
     * @param surname Nuevo apellido del estudiante.
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * Obtiene la edad del estudiante.
     * @return Edad del estudiante.
     */
    public int getAge() {
        return age;
    }

    /**
     * Modifica la edad del estudiante.
     * @param age Nueva edad del estudiante.
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Obtiene el curso en el que está matriculado el estudiante.
     * @return Curso del estudiante.
     */
    public String getCourse() {
        return course;
    }

    /**
     * Modifica el curso del estudiante.
     * @param course Nuevo curso del estudiante.
     */
    public void setCourse(String course) {
        this.course = course;
    }

    /**
     * Obtiene el DNI del estudiante.
     * @return DNI del estudiante.
     */
    public String getDni() {
        return dni;
    }

    /**
     * Modifica el DNI del estudiante.
     * @param dni Nuevo DNI del estudiante.
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * Sobrescribe el método toString para devolver una representación en texto del objeto.
     * @return Cadena de texto con los datos del estudiante.
     */
    @Override
    public String toString() {
        return name + ", " + surname + ", " + age + ", " + course + ", " + dni;
    }
}
