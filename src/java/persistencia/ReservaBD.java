/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import dominio.Lider;
import dominio.Reserva;
import java.util.ArrayList;

/**
 *
 * @author Celso
 */
public class ReservaBD {
    private static ArrayList<Reserva> lista = new ArrayList<Reserva>();
    
    
    public static void inserir(Reserva novaReserva) {
        lista.add(novaReserva);
    }
    public static  void alterar(Reserva reservaAlterada) {
        excluir(reservaAlterada.getCodigo());
        inserir(reservaAlterada);
    }
    
    public static void excluir(int codigo) {
        for(int i=0; i<lista.size(); i++) {
          Reserva cadaReserva =lista.get(i);
          if (cadaReserva.getCodigo()==codigo) {
              lista.remove(i);
              break;
          }
        }
    }
    
   public  static ArrayList<Reserva> listar() {
       return lista; 
    }
}
