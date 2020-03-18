/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDeDatos;

import java.util.LinkedList;

/**
 *
 * @author Usuario
 */
public class pruebaBases {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ConexionOracle conexion = new ConexionOracle();
        /*String consulta  = "select * from usuarios "; 
        System.out.println("consulta: "+consulta);
        LinkedList <String> resultado = conexion.consulUsuarios(consulta); 
        System.out.println("tamaño: "+resultado.size());
        for (int i = 0; i < resultado.size(); i++) {
            System.out.println("=> "+resultado.get(i));
        }*/
        
        System.out.println("insetar usuario: "+conexion.agregarUsuario("asf","a","d","e","A"));
        
        
    }
    
}
