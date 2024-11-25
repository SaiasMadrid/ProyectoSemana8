/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectosemana8.pkg2;

import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author disma
 */
public class ProyectoSemana82 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in); //Scanner
        Random ran = new Random(); //Random
        
        //Creando el usuario y su clase
        System.out.print("Ingresa tu nombre: ");
        String nombre = sc.nextLine();

        System.out.println("1) Mercenario");
        System.out.println("2) Caballero Blindado");
        System.out.println("3) Herrero");
        System.out.print("Elige una clase: ");
        int claseSeleccionada = sc.nextInt();
        System.out.println("");

        Usuario usuario = new Usuario(nombre, claseSeleccionada);
        
        //Menu de Acciones
        boolean menu = true;
        while (menu) {
            System.out.println("Menu de Acciones:");
            System.out.println("1) Batallar");
            System.out.println("2) Mejorar Arma");
            System.out.println("3) Mejorar Estadisticas");
            System.out.println("4) Ver Estadisticas");
            System.out.println("5) Salir");
            System.out.print("Selecciona tu Opcion: ");
            int opcion = sc.nextInt();
            System.out.println("");
            
            switch (opcion) {
                case 1: //Batallar ehuehuehue
                    String[] clasesEnemigos = {"Mercenario", "Caballero Blindado", "Herrero"}; //Creando las clases enemiga pal cpu
                    String claseEnemigo = clasesEnemigos[ran.nextInt(clasesEnemigos.length)]; //Elegir una clase random para batallar
                    int hpEnemigo = 15 + usuario.getHpMaximo() / 2 + ran.nextInt(20); // HP para el cpu
                    int ataqueEnemigo = 10 + usuario.getAtaque() / 2 + ran.nextInt(5); //ATK para el cpu
                    int defensaEnemigo = 5 + usuario.getDefensa() / 2 + ran.nextInt(5); //DEF para el cpu

                    System.out.println("Enemigo: " + claseEnemigo); //Definimos el enemigo que eligio el random
                    int turno = 1; //Contador de turnos

                    while (usuario.getHp() > 0 && hpEnemigo > 0) { //Condiciones de victoria / derrota
                        System.out.println("Turno " + turno + ":"); //Imprimir el numero del turno
                        System.out.println(usuario.getHp() + "/" + usuario.getHpMaximo() + " HP (Usuario)"); //Imprimir HP actual/HP maxima
                        System.out.println(hpEnemigo + " HP (Enemigo)"); //Imprimir HP actual del enemigo

                        int dañoUsuario = Math.max(0, usuario.getAtaque() - defensaEnemigo); //Llamamos el ataque del usuario para hacer daño
                        hpEnemigo -= dañoUsuario; //Reducir el HP del enemigo basado en el daño
                        System.out.println("Hiciste " + dañoUsuario + " daño."); //Imprimir de cuando daño se hizo al enemigo

                        if (hpEnemigo > 0) { //Validar que el desgraciado siga vivo
                            int dañoEnemigo = Math.max(0, ataqueEnemigo - usuario.getDefensa()); //Llamamos el ataque del cpu para hacer daño
                            usuario.setHp(usuario.getHp() - dañoEnemigo); //Reducir el HP del usuario basado en el daño
                            System.out.println("Recibiste " + dañoEnemigo + " daño."); //Imprimir cuanto daño se le hizo al usuario
                        }
                        System.out.println(""); 
                        turno++; //Contador de turnos que continua hasta que uno de los dos muera lol
                    }

                    if (usuario.getHp() > 0) { //Validar que el usuario siga vivo
                        System.out.println("Ganaste dog, toma 100 de oro por eso"); //Yippee, una recompensa
                        usuario.setOro(usuario.getOro() + 100); //Se le añade 100 de oro a su cuenta bancaria
                    } else { //Si el usuario murio (lol)
                        System.out.println("Perdiste lol, toma 50 de oro porque me das pena"); //Que degracia...
                        usuario.setOro(usuario.getOro() + 50); //Se le añade 50 de oro como consolacion
                        usuario.setHp(usuario.getHpMaximo()); //Reseteamos el HP del usuario al maximo
                    }
                    System.out.println("");
                break;

                case 2: //Mejorar Arma ehuehuehue
                    System.out.println("Cada mejora cuesta 50 de oro mas que la anterior"); //Lo que dice ahi jefe
                    usuario.mejorarArma(); //Llamamos el metodo para mejorar el arma
                    System.out.println("");
                break;

                case 3: //Mejorar tus stats
                    System.out.println("1) HP");
                    System.out.println("2) Defensa");
                    System.out.println("Cada mejora cuesta 50 de oro");
                    System.out.print("Que estadistica quieres mejorar?: ");
                    int mejoraSeleccionada = sc.nextInt(); //Seleccionamos el stat a mejorar
                    usuario.mejorarEstadisticas(mejoraSeleccionada); //Llamamos el metodo para mejorar stats
                    System.out.println("");
                break;

                case 4: //Mostrar stas
                    System.out.println(usuario); //Imprimiendo stats usando el toString
                    System.out.println("");
                break;

                case 5: //Cheque bro
                    System.out.println("Cheque bro"); //Cheque bro
                    menu = false; //Cheque bro
                break;
                
                default: //Validando para opciones validas dentro del menu
                    System.out.println("Esa no es una opcion valida"); //Pero es una opcion valida o no?
                    System.out.println("");
            }
        }
    }
}

