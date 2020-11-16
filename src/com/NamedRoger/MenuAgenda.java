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
        System.out.printf("Nombre: ");
        var nombre = sc.next();

        System.out.printf("Numero: ");
        var telefono = sc.next();

        addressBook.create(nombre,telefono);
        System.out.println();
    }

    public void menuEliminiar() throws Exception {
        System.out.printf("Numero: ");
        var telefono = sc.next();

        addressBook.delete(telefono);
        System.out.println();
    }

    public void menuLista() {
        addressBook.list();
        System.out.println();
    }
}
