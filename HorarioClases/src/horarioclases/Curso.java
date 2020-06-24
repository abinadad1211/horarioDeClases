/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package horarioclases;
import java.util.*; 

/**
 *
 * @author Alexis
 */


import java.util.Scanner;

class Curso{
  public static void main (String[] args){
  Scanner in = new Scanner(System.in);

  int busqueda = 0;
  
      Lista nuevo = new Lista();
      nuevo.insertar("1");
      nuevo.insertar("2");
      nuevo.insertar("3");
      nuevo.insertar("4");
      System.out.print("Inserte el NRC a buscar: ");
      int NrcBusqueda = in.nextInt();
      busqueda = NrcBusqueda - 1;
      nuevo.buscarIndice(busqueda);
      //System.out.print(nuevo.imprimir());
  }
}

class Lista
{
    public static Nodo nodoInicial;

    public static void insertar(String valor)
    {
        Nodo nodo = new Nodo();
        nodo.dato = valor;
        if(nodoInicial == null)
        {
            nodoInicial = nodo;
        }

        else
        {
            Nodo ultimoNodo = nodoInicial;
            //Encontrar el ultimo nodo
            while(ultimoNodo.puntero != null) //Cambiar if por while
            {            
                ultimoNodo = ultimoNodo.puntero;
            }
            //Asignar el nuevo nodo al puntero del ultimo nodo
            ultimoNodo.puntero = nodo; 
        }
    } //Fin Metodo insertar

    public static String imprimir()
    {
        Nodo tmp = nodoInicial;
        //Nodo apuntador = puntero;
        String resultado="";
        while(tmp != null)
        {
            resultado = resultado +  "\nNodo: "+tmp.dato;
            tmp = tmp.puntero;
        }
        return resultado;
    }

    public static void buscarIndice(int indicebuscado)
    {
        Nodo nodo = nodoInicial;

        int cont = 0;
        
        while((nodo != null) && (cont != indicebuscado ))
        {
            nodo = nodo.puntero;
            cont++;
        }
        if(nodo==null)
        {
            System.out.println("El elemento no se encuentra en la lista");
        }
        else
        {
            System.out.println("El elemento si se encuentra en el sistema, los datos son:\n\nNRC:" + nodo.dato + "\nMateria: Requerimientos de Software" + "\nMaestro: Dr. Patricia Martinez Moreno");
        }

    }


}

class Nodo
{
    public String dato;
    public Nodo puntero;

}
