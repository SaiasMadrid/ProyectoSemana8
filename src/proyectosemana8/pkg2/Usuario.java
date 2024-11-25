/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectosemana8.pkg2;

/**
 *
 * @author disma
 */
class Usuario {
    //Creando al usuario
    private String nombre;
    private String clase;
    private int hp;
    private int hpMaximo;
    private int ataque;
    private int defensa;
    private int oro;
    private Arma arma;

    public Usuario(String nombre, int claseSeleccionada) {
        this.nombre = nombre; //El nombre seleccionado
        this.oro = 100; //Iniciando al usuario con 100 de oro para que no se muera de hambre

        switch (claseSeleccionada) {
            case 1: //Si quere ser mercenario con stats balanceados
                //Setters para las estadisticas default de la clase
                this.clase = "Mercenario";
                this.hp = 80;
                this.hpMaximo = 100;
                this.ataque = 12;
                this.defensa = 12;
                this.arma = new Arma("Espada");
                break;
            case 2: //Un caballero blindado con mejores defensas que ofensas
                //Setters para las estadisticas default de la clase
                this.clase = "Caballero Blindado";
                this.hp = 100;
                this.hpMaximo = 120;
                this.ataque = 10;
                this.defensa = 15;
                this.arma = new Arma("Lanza");
                break;
            case 3: //Un herrero con mejores ofensas que defensas
                //Setters para las estadisticas default de la clase
                this.clase = "Herrero";
                this.hp = 70;
                this.hpMaximo = 90;
                this.ataque = 15;
                this.defensa = 10;
                this.arma = new Arma("Hacha");
                break;
            default: //Mira bro mejor hace caso, ahi no hay ningun numero mayor a 3 o menor a 1
                throw new IllegalArgumentException("Eso no se ve ni como un 1, 2 o 3 bro");
        }
    }

    public int getHp() { //Getter para HP
        return hp;
    }

    public int getHpMaximo() { //Getter para HP maximo
        return hpMaximo;
    }

    public void setHp(int hp) { //Setter para HP
        this.hp = hp;
    }

    public int getAtaque() { //Esto sirve para calculaciones de daño, el ataque total en este caso
        return (int) (ataque * arma.getMultiplicadorDaño());
    }

    public int getDefensa() { //Getter para defensa
        return defensa;
    }

    public int getOro() { //Getter para oro
        return oro;
    }

    public void setOro(int oro) { //Setter para oro
        this.oro = oro;
    }

    public void mejorarEstadisticas(int opcion) { //Para mejorar tus stats bro
        if (oro >= 50) { //Validacion de que no seas un pobre que no puede ganar batallas
            if (opcion == 1) { //Opcion pa HP
                hpMaximo += 2; //Subiendo 2 miseros puntos al HP porque podes subirte los stats cuanto se te ronque
                hp += 2;
                System.out.println("Tu HP ha mejorado por 2 puntos."); //Lee
            } else if (opcion == 2) { //Opcion pa DEF
                defensa += 2; //Subiendo 2 miseros puntos al DEF porque podes subirte los stats cuanto se te ronque
                System.out.println("Tu defensa ha mejorado por 2 puntos."); //Tambien lee
            }
            oro -= 50; //Me robo el dinero ehuehuehue
        } else {
            System.out.println("No tenes suficiente oro lol"); //Bro imaginate no tener oro
        }
    }

    public void mejorarArma() { //Mejorar el arma
        int costo = 100 + (arma.getNivel() * 50); // Calcular el costo basado en el nivel del arma (añadirle 50 pesos por mejora)
        
        if (oro >= costo) { //Validar que no estes pobre
            arma.mejorarArma(); //Llamamos el metodo para mejorar el arma
            oro -= costo; //Te quito tu dinero ehuehuehue
            System.out.println("Has mejorado tu arma a: " + arma.getNombre()); //Gracias bro
        } else {
            System.out.println("No tienes suficiente oro."); //Imagine
        }
    }

    public String toString() { //Pues tenia que incluir un toString
        return "Nombre: " + nombre + "\n" +
               "Clase: " + clase + "\n" +
               "HP: " + hp + "/" + hpMaximo + "\n" +
               "Ataque: " + getAtaque() + "\n" +
               "Defensa: " + defensa + "\n" +
               "Oro: " + oro + "\n" +
               "Arma: " + arma.getNombre() + " (Multiplicador: " + arma.getMultiplicadorDaño() + ")";
    }
}