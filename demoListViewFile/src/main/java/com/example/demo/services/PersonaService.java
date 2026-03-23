package com.example.demo.services;

import com.example.demo.repositories.PersoneFileRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonaService {

    PersoneFileRepository repo = new PersoneFileRepository();

    public List<String> loadForListView() throws IOException {
        List<String> lines = repo.readAllLines();
        List<String> result = new ArrayList<>();

        for (String line : lines){
            if (line == null || line.isBlank()) continue;

            String[] parts = line.split(",");
            String name = parts[0].trim();
            String email = parts[1].trim();
            String edad = parts[2].trim();
            // CORRECCIÓN 3: Cambiado a >= 4 para que lea el código correctamente
            String code = parts.length >= 4 ? parts[3].trim() : "sin codigo :V";

            // Aquí lo unimos con guiones SOLO para mostrarlo bonito en la vista
            result.add(name + "-" + email + "-" + edad + "-" + code);
        }
        return result;
    }

    public void uppdatePerson(int index, String name, String email, String edad, String code) throws IOException {
        validate(name, email, Integer.parseInt(edad), code);
        List<String> listaOriginal = repo.readAllLines();
        List<String> cleanLines = new ArrayList<>();

        for (String line : listaOriginal){
            // CORRECCIÓN 1: "!=" y "!" (Si NO es nulo y NO está en blanco)
            if (line != null && !line.isBlank()) {
                cleanLines.add(line);
            }
        }
        // Sustituimos usando comas, que es el formato de tu "base de datos"
        cleanLines.set(index, name + "," + email + "," + edad + "," + code);
        repo.saveFile(cleanLines);
    }

    public void deletePerson(int index) throws IOException {
        List<String> listaOriginal = repo.readAllLines();
        List<String> cleanLines = new ArrayList<>();

        for (String line : listaOriginal){
            // CORRECCIÓN 1: Misma lógica aquí
            if (line != null && !line.isBlank()) {
                cleanLines.add(line);
            }
        }
        cleanLines.remove(index);
        repo.saveFile(cleanLines);
    }

    public void addPerson(String name, String email, String edad, String code) throws IOException {
        validate(name, email, Integer.parseInt(edad), code);
        // CORRECCIÓN 2: Cambiado el "-" por "," para mantener el formato CSV
        repo.addNewLine(name + "," + email + "," + edad + "," + code);
    }

    private void validate(String name, String email, int edad, String code) {
        if(name == null || name.isBlank() || name.length() < 3){
            throw new IllegalArgumentException("El nombre es incorrecto");
        }
        String em = (email == null) ? "" : email.trim();
        if (em.isBlank() || !em.contains("@") || !em.contains(".")){
            throw new IllegalArgumentException("El email no es valido");
        }
        if (edad < 17 || edad < 0 ){
            throw new IllegalArgumentException("La edad no es valida");
        }
        String cd = (code == null) ? "" : code.trim();
        if(cd == null || cd.isBlank() ){
            throw new IllegalArgumentException("El code no es valido");
        }
        if(cd.length() < 4 || cd.length() > 12){
            throw new IllegalArgumentException("El codigo no es de una longitud valida");
        }
        if(!cd.matches("^[a-zA-Z0-9]*$")){
            throw new IllegalArgumentException("El codigo no es alfanumerico");
        }
    }
}