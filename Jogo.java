/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package torredehanoi;

import static java.lang.Thread.sleep;
import java.util.Scanner;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author willi
 */
public class Jogo {
   /**
     * Jogo torre de hanoi, consiste em vc transferir todas as peças da torre 1 para torre 2 em ordem decrescente 
     * sem colocar o maior em cima do menor
     * 
     */
   /**
    * Função para começar o jogo
    */
    public void iniciar(){
        Stack<Hanoi> pilha1 = new Stack<>();
        Stack<Hanoi> pilha2 = new Stack<>();
        Stack<Hanoi> pilha3 = new Stack<>();
        pilha1.add(Hanoi.Baixo);
        pilha1.add(Hanoi.Meio);
        pilha1.add(Hanoi.Cima);
        System.out.println("!!!TORRE DE HANOI!!!");
        System.out.println("Objetivo: Torre 2 ficar iqual torre 1");
        
        imprimirTorres(pilha1,pilha2,pilha3);
        String w = "!!!WINNER!!!";
        jogar(pilha1,pilha2,pilha3);
        
        for(int i = 0 ; i < w.length() ; i++ ){
            try {
                sleep(500);
                System.out.println(w.charAt(i));
            } catch (InterruptedException ex) {
                Logger.getLogger(Jogo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private int contador = 0;
    
    /**
     * 
     * @param pilha1
     * @param pilha2
     * @param pilha3 
     * 
     * Aqui o gameloop irá começar e chamar o que for preciso
     */
    private void jogar(Stack<Hanoi> pilha1, Stack<Hanoi> pilha2, Stack<Hanoi> pilha3){
        contador++;
        Scanner s = new Scanner(System.in);
        System.out.print("Faça sua Jogada:\nDe qual TORRE será retirado um pino?( 1, 2 ou 3): ");
        int jogada = s.nextInt();
        System.out.print("Para qual torre vai este pino?( 1, 2 ou 3): ");
        int jogada2 = s.nextInt();
        
        /**
         *  teste para validar a troca de pinos
         */
        try{
        switch (jogada){
            case 1:
                switch (jogada2) {
                    case 2:
                        pilha2.push(pilha1.peek());
                        pilha1.pop();
                        break;
                    case 3:
                        pilha3.push(pilha1.peek());
                        pilha1.pop();
                        break;
                    default:
                        System.out.println("\nTorre invalída");                        
                        break;
                }
                break;
            case 2:
                switch (jogada2) {
                    case 1:
                        pilha1.push(pilha2.peek());
                        pilha2.pop();
                        break;
                    case 3:
                        pilha3.push(pilha2.peek());
                        pilha2.pop();
                        break;
                    default:
                        System.out.println("\nTorre invalída");                
                        break;
                }
                break;
            case 3:
                switch (jogada2) {
                    case 1:
                        pilha1.push(pilha3.peek());
                        pilha3.pop();
                        break;
                    case 2:
                        pilha2.push(pilha3.peek());
                        pilha3.pop();
                        break;
                    default:
                        System.out.println("\nTorre invalída");
                        break;
                }
                break;
            default:
                System.out.println("\nTorre invalída");
                break;       
            }
        }catch(java.util.EmptyStackException ex){
            System.out.println("\n!!!!!Torre "+jogada+" vazia!!!!");

        }
        
        /**
         * recomeçando a torre para continuar o jogo
         */
        imprimirTorres(pilha1,pilha2,pilha3);
        Stack<Hanoi> pilha4 = new Stack<>();
        pilha4.add(Hanoi.Baixo);
        pilha4.add(Hanoi.Meio);
        pilha4.add(Hanoi.Cima);
        
        /**
         * Testando para saber se o jogo foi finalizado
         */
        if( pilha2.equals(pilha4)){
            System.out.println("Jogo Finalizado!!!"+"\nTotal de jogadas:"+contador);
        }else{
            jogar(pilha1,pilha2,pilha3);
        }
        
    }
    
    /**
     * 
     * @param pilha1
     * @param pilha2
     * @param pilha3 
     * 
     * Essa funçao é responsavel por imprimir todas as torres e facilitar o game loop
     */
    private void imprimirTorres(Stack<Hanoi> pilha1, Stack<Hanoi> pilha2, Stack<Hanoi> pilha3){
        System.out.println("\n-----------");
        System.out.println("| Torre 1 |");
        for(int i = pilha1.size()-1; i >= 0; i--){
            System.out.println("| "+pilha1.get(i).getTipo()+"  |");
        }
        System.out.println("-----------");
        
        System.out.println("| Torre 2 |");
        for(int y = pilha2.size()-1; y >= 0; y--){
            System.out.println("| "+pilha2.get(y).getTipo()+"  |");
        }
        
        System.out.println("-----------");
        System.out.println("| Torre 3 |");
        for(int z = pilha3.size()-1; z >= 0; z--){
            System.out.println("| "+pilha3.get(z).getTipo()+"  |");
        }
        System.out.println("-----------\n");
    }
}
