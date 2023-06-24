package main.java;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import main.java.dto.Student;
import main.java.dto.StudentTicket;
import main.java.dto.Ticket;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String args[]) {
        StudentTicket[] studentTickets;
        studentTickets = data();
        boolean continuar = true;
        String _if = "y";
        while (continuar){
            login(studentTickets);
            scanner.nextLine();
            _if = scanner.nextLine();
            if(_if.equals("n")){
               continuar = false;
            }

        }

    }

    private static String fechaHora(){
        LocalDateTime now = LocalDateTime.now();
        String hora = now.format(DateTimeFormatter.ofPattern("HH:mm"));
        String fecha = now.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        return "=======" + hora + " " + fecha + "=======";
    }

    private static StudentTicket[] data() {
        List<StudentTicket> studentTickets = new ArrayList<>();

        Student st01 = new Student("Juan", "pass", true, true);
        Student st02 = new Student("Pedro", "pass", true, false);
        Student st03 = new Student("Maria", "hello", true, true);

        Ticket tk01 = new Ticket("Juan", "Perez", "8-444-2222", "juan@mail.com", "Lic. Desarrollo");
        Ticket tk02 = new Ticket("Pedro", "Ramos", "2-000-111", "pedro@mail.com", "Lic. comunicacion");

        StudentTicket studentTicket01 = new StudentTicket(st01);
        studentTicket01.addTicket(tk01);

        StudentTicket studentTicket02 = new StudentTicket(st02);
        studentTicket02.addTicket(tk02);

        studentTickets.add(studentTicket01);
        studentTickets.add(studentTicket02);

        // Agregar más estudiantes y tickets según sea necesario...

        return studentTickets.toArray(new StudentTicket[0]);
    }


    private static void login(StudentTicket[] estudiantes){
        scanner.nextLine();
        String user;
        String password;
        boolean continuar = true;
        while (continuar) {
            System.out.println("===== Login Page =====");
            System.out.println(fechaHora());
            System.out.print("User: ");
            user = scanner.nextLine();
            System.out.println("");
            System.out.print("password: ");
            password = scanner.nextLine();
            System.out.println("");
            Student student = findStudent(user, estudiantes);
            if (student == null) {
                System.out.println("El usuario ingresado no existe");
                continue;
            }
            if (!student.getPass().equals(password)) {
                System.out.println("! PASSWORD INCORRECTO!");
                continue;
            }
            if(!student.getFirstLogin()) {
                menu(estudiantes, student.getUser());
                continue;
            } else {
                while(!changePass(student)) {}
                menu(estudiantes, student.getUser());
            }
            scanner.nextLine();
            System.out.println("desea iniciar sesion de nuevo? (y/n)");
            String str = scanner.nextLine();
            if(str.equals("n")){
                continuar = false;
            }
        }

    }
    private static Student findStudent(String user, StudentTicket[] estudiantes){
        scanner.nextLine();
        for (StudentTicket estudiante : estudiantes) {
            if(estudiante.getStudent().getUser().equals(user)){
                return estudiante.getStudent();
            }
        }
        System.out.println("! ESTUDIANTE NO ENCONTRADO!");
        return null;
    }

    private static Boolean changePass(Student student){
        scanner.nextLine();
        String pasString = student.getPass();
        String old;
        String newPass1;
        String newPass2;
        System.out.println("===== Change Password Page =====");
        System.out.print("Old Password: ");
        old = scanner.nextLine();
        System.out.println("");
        System.out.print("New Password: ");
        newPass1 = scanner.nextLine();
        System.out.println("");
        System.out.print("New Password: ");
        newPass2 = scanner.nextLine();
        if(!pasString.equals(old)){
            System.out.println("la contrasena actual no concuerda");
            return false;
        }
        if (!newPass1.equals(newPass2)) {
            System.out.println("las contrasenas \"new Password\" deben ser iguales");
            return false;
        }
        student.setPass(newPass1);
        System.out.println("You have change your password");
        return true;
    }

    private static void menu(StudentTicket[] studentTickets, String user){
        scanner.nextLine();
        // switch case, 1 "subir ticket" 2 "ver tickets" 3 "salir"
        int opcion=0;
        while (opcion!=3) {
            System.out.println("===== Menu Page =====");
            System.out.println("1. Subir Ticket");
            System.out.println("2. Ver Tickets");
            System.out.println("3. Salir");
            System.out.print("Opcion: ");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    subirTicket(studentTickets, user);
                    break;
                case 2:
                    verTickets(studentTickets, user);
                    break;
                case 3:
                    System.out.println("cerrando sesion");
                    System.out.println(fechaHora());
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;

            }
        }
}

private static void verTickets(StudentTicket[] studentTickets, String user) {
    scanner.nextLine();
    System.out.println("===== Student Ticket Page =====");
        String nombreEstudiante = user;
        scanner.nextLine();
        boolean estudianteEncontrado = false;
        String idTicket;
        System.out.println("Ingrese el ID del ticket que desea ver");
        idTicket = scanner.nextLine();

        for (StudentTicket studentTicket : studentTickets) {
            if (studentTicket.getStudent().getUser().equals(nombreEstudiante)) {
                for (Ticket ticket : studentTicket.getTickets()) {
                    if (ticket.getTicketID().equals(idTicket)) {
                        System.out.println("Ticket asignado al estudiante " + nombreEstudiante + ":");
                        System.out.println(ticket.toString());
                        estudianteEncontrado = true;
                    }
                }
                break; // Detener la iteración una vez que se encuentra el estudiante
            }
        }

        if (!estudianteEncontrado) {
            System.out.println("No se encontró el ticket con ID " + idTicket + " para el estudiante " + nombreEstudiante);
        }
    }




    private static void subirTicket(StudentTicket[] studentTickets, String user) {
        scanner.nextLine();
        System.out.println("===== Assign student Ticket Page =====");
        String nombreEstudiante = user;

        boolean estudianteEncontrado = false;

        for (StudentTicket studentTicket : studentTickets) {
            if (studentTicket.getStudent().getUser().equals(nombreEstudiante)) {
                System.out.println("Ingrese los datos del nuevo ticket:");
                System.out.print("Nombre: ");
                String nombre = scanner.nextLine();
                System.out.print("Apellido: ");
                String apellido = scanner.nextLine();
                System.out.print("ID: ");
                String id = scanner.nextLine();
                System.out.print("Email: ");
                String email = scanner.nextLine();
                System.out.print("Carrera: ");
                String carrera = scanner.nextLine();

                Ticket nuevoTicket = new Ticket(nombre, apellido, id, email, carrera);
                studentTicket.addTicket(nuevoTicket);
                estudianteEncontrado = true;
                System.out.println(nuevoTicket);
                System.out.println("Se ha asignado un nuevo ticket al estudiante " + nombreEstudiante + " exitosamente.");
                break;
            }
        }

        if (!estudianteEncontrado) {
            System.out.println("No se encontró ningún estudiante con el nombre " + nombreEstudiante);
        }
    }

}
