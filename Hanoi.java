/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package torredehanoi;

/**
 *
 * @author willi
 */
public enum Hanoi {
   Cima("  __  "),Meio(" ____ "),Baixo("______"),Vazio("");
    
   private String tipo = "";
   Hanoi(String tipo){ 
       this.tipo = tipo;
   }
   public String getTipo() {
       return tipo;
   }
    
}

