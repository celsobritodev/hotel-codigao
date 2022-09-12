/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import dominio.Lider;
import dominio.Romaria;
import java.util.ArrayList;

/**
 *
 * @author Celso
 */
public class RomariaBD {
    private static ArrayList<Romaria> lista = new ArrayList<Romaria>();
    
    
    public static void inserir(Romaria novaRomaria) {
        lista.add(novaRomaria);
    }
    public static  void alterar(Romaria romariaAlterada) {
        excluir(romariaAlterada.getCodigo());
        inserir(romariaAlterada);
    }
    
    public static void excluir(int codigo) {
        for(int i=0; i<lista.size(); i++) {
          Romaria  cadaRomaria = lista.get(i);
          if (cadaRomaria.getCodigo()==codigo) {
              lista.remove(i);
              break;
          }
        }
    }
    
   public  static ArrayList<Romaria> listar() {
       return lista; 
    }
}
