/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectosemana8.pkg2;

/**
 *
 * @author disma
 */
class Arma {
    private String tipo; //Tipo de arma
    private double multiplicadorDaño; //Multiplicador del daño para el arma
    private int nivel; //Nivel del Arma

    public Arma(String tipo) { //Builder cargado
        this.tipo = tipo;
        this.multiplicadorDaño = 1.0;
        this.nivel = 0;
    }
    
    public int getNivel() {//Getter para el nivel del arma
        return nivel;
    }

    public void mejorarArma() { //Metodo para mejora del arma
        nivel++; //Incrementar el contador para el nivel del arma, subiendo +1
        multiplicadorDaño += 0.2; //Sumandole 0.2 al multiplicador de daño por mejora
    }

    public String getNombre() { //Nombre del Arma (solo le pongo un +n lol)
        if (nivel > 0) { //Nadie quiere que pongan arma +0 verdad?
            return tipo + " +" + nivel; //Ahora si, el arma +n
        } else {
            return tipo; //Reiterando, nadie quiere que le pongan arma +0 verdad?
        }
    }

    public double getMultiplicadorDaño() {
        return multiplicadorDaño; //This might sound crazy...
    }
}