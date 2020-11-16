package com.NamedRoger;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AddressBook {
    private HashMap<String,Contact> contacts = new HashMap<>();

    public void load() throws IOException {
        String separator = FileSystems.getDefault().getSeparator();
        String fileName = String.format("src%scom%sNamedRoger%scontacts.csv",separator,separator,separator);
        Path path = Paths.get(fileName);

        ArrayList<String> lines = new ArrayList<>();

        if(!Files.exists(path)){
            File file = new File(String.valueOf(path));
            file.createNewFile();
        }

        lines = (ArrayList<String>) Files.readAllLines(path);

        for (var line : lines){
            var contactInfo = line.split(",");
            var contact = new Contact(contactInfo[1],contactInfo[0]);

            contacts.put(contact.getTelefono(),contact);
        }
    }

    public void save() throws IOException {
        String separator = FileSystems.getDefault().getSeparator();
        String fileName = String.format("src%scom%sNamedRoger%scontacts.csv",separator,separator,separator);
        Path path = Paths.get(fileName);

        ArrayList<String> saveContacts = new ArrayList<>();
        for (var contact : contacts.entrySet()){
            saveContacts.add(contact.getKey()+", "+ contact.getValue());
        }

        Files.write(path,saveContacts);
    }

    public void list() {
        for(var contact : contacts.entrySet()){
            System.out.println(String.format("Numero: %s, Nombre: %s",
                    contact.getKey(),contact.getValue().getNombre()));
        }
    }

    public void create(String nombre, String telefono) throws Exception {
        if(contacts.containsKey(telefono)){
            throw new Exception("El contacto ya existe");
        }
        Contact contact = new Contact(nombre,telefono);
        contacts.put(telefono,contact);
        save();
        load();
    }

    public void delete(String telefono) throws Exception {
        if(contacts.containsKey(telefono)){
            throw new Exception("No existe este telefono");
        }
        var p = contacts.remove(telefono);
        save();
        load();
    }
}
