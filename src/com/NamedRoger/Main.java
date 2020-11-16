package com.NamedRoger;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        MenuAgenda menuAgenda = new MenuAgenda(sc);
        boolean running;
        do {
            running = true;

            try{
                var op = menuAgenda.menuPrincipal();
                isValid(op);

                switch (op){
                    case 1:
                        menuAgenda.menuLista();
                        break;
                    case 2:
                        menuAgenda.menuAgregar();
                        break;
                    case 3:
                        menuAgenda.menuEliminiar();
                        break;
                    default:
                        running = false;
                        break;
                }
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }


        }while (running);
    }

    public static void isValid(int op) throws Exception {
        if(op < 1 || op > 4){
            throw new Exception("Introduce una opcion valida");
        }
    }
}
