package com.NamedRoger;

import java.io.IOException;
import java.util.Scanner;

public class MenuAgenda {
    private  Scanner sc;
    private AddressBook addressBook;

    public MenuAgenda(Scanner sc) {
        this.sc = sc;
        addressBook = new AddressBook();
    }

    public  int menuPrincipal() throws IOException {
        addressBook.load();
        System.out.println("---------------Agenda Personal---------------");
        System.out.println("" +
                "(1) Ver contactos \n" +
                "(2) Agregar Contactos \n" +
                "(3) Eliminar Contacto \n" +
                "(4) Salir");
        
        return sc.nextByte();
    }

    public void menuAgregar() throws Exception {
        Scanner in = new Scanner(System.in);

        System.out.println("Nombre: ");
        String nombre = in.nextLine();

        System.out.println("Telefono: ");
        var telefono = in.nextLine();

        addressBook.create(nombre,telefono);
    }

    public void menuEliminiar() throws Exception {
        System.out.printf("Numero: ");
        var telefono = sc.next();

        addressBook.delete(telefono);
        System.out.println();
    }

    public void menuLista() throws IOException {
        addressBook.list();
        System.out.println();
    }

    private String getNombre(){
        var nombre = sc.nextLine();
        System.out.println("Nombre");
        return nombre;
    }
}
