import java.sql.*;
import java.util.Locale;
import java.util.Scanner;

public class ProgBBDD {

    static void añadirAlumno() {
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);

        int codigo;
        String nombre;
        double media;
        String curso;
        String fechaNacimiento;

        System.out.println("Introduce el código del alumno: ");
        codigo = sc.nextInt();
        sc.nextLine();

        System.out.println("Introduce el nombre del alumno: ");
        nombre = sc.nextLine();

        System.out.println("Introduce la media del alumno: ");
        media = sc.nextDouble();
        sc.nextLine();

        System.out.println("Introduce el curso del alumno: ");
        curso = sc.nextLine();

        System.out.println("Introduce la fecha de nacimiento del alumno (YYYY-MM-DD): ");
        fechaNacimiento = sc.nextLine();

        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost/instituto1DAM", "root", "1234")) {
            Statement sentencia = con.createStatement();
            String sql = "INSERT INTO alumnos VALUES (" + codigo + ", '" + nombre + "', " + media + ", '" + curso + "', '" + fechaNacimiento + "')";
            sentencia.executeUpdate(sql);
            System.out.println("Alumno insertado correctamente.");
        } catch (SQLException ex) {
            System.out.println("Error al insertar alumno: " + ex.getMessage());
        }
    }

    static void eliminarAlumno() {
        Scanner sc = new Scanner(System.in);
        int codigo;
        int filasAfectadas;
        
        System.out.println("Introduce el código del alumno que quiere eliminar: ");
        codigo = sc.nextInt();

        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost/instituto1DAM", "root", "1234")) {
            Statement sentencia = con.createStatement();
            String sql = "DELETE FROM alumnos WHERE num=" + codigo;
            
            
            filasAfectadas = sentencia.executeUpdate(sql);
            
            if (filasAfectadas > 0) {
                System.out.println("Alumno eliminado correctamente.");
            } else {
                System.out.println("No se encontró ningún alumno con ese código.");
            }
        } catch (SQLException ex) {
            System.out.println("Error al eliminar alumno: " + ex.getMessage());
        }
    }

    static void menu() {
        Scanner sc = new Scanner(System.in);
        int n;

        System.out.println("¿Qué desea hacer, añadir un alumno (1) o eliminar un alumno (2)?");
        n = sc.nextInt();

        if (n == 1) {
            añadirAlumno();
        } else {
            eliminarAlumno();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int repetir = 1;
        
        while (repetir==1){
            menu();
            
            System.out.println("¿Desea realizar otra operación? 1.SI 2.NO");
            repetir = sc.nextInt();
        }
        
    }
}
