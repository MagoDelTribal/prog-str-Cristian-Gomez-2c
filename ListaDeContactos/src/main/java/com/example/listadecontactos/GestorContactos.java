package com.example.listadecontactos;

import java.util.ArrayList;
import java.util.List;

public class GestorContactos {


    private final List<Contacto> listaContactos = new ArrayList<>();


    private final String[] opcionesParentesco = {
            "Padre", "Madre", "Hermano", "Hermana", "Abuelo", "Abuela", "Tío", "Tía"
    };

    public String[] getOpcionesParentesco() {
        return opcionesParentesco;
    }

    public List<Contacto> getContactos() {
        return listaContactos;
    }


    public void agregar(String nombre, String telefono, String parentesco) {
        validar(nombre, telefono, parentesco, true);
        listaContactos.add(new Contacto(nombre.trim(), telefono.trim(), parentesco));
    }

    public Contacto buscar(String nombre) {
        for (Contacto c : listaContactos) {
            if (c.getNombre().equalsIgnoreCase(nombre.trim())) {
                return c;
            }
        }
        return null;
    }

    public void actualizar(String nombre, String nuevoTel, String nuevoPar) {
        validar(nombre, nuevoTel, nuevoPar, false);
        Contacto c = buscar(nombre);
        if (c == null) throw new IllegalArgumentException("El contacto no existe.");

        c.setTelefono(nuevoTel.trim());
        c.setParentesco(nuevoPar);
    }

    public void eliminar(String nombre) {
        Contacto c = buscar(nombre);
        if (c == null) throw new IllegalArgumentException("El contacto no existe para eliminar.");
        listaContactos.remove(c);
    }


    private void validar(String nombre, String tel, String par, boolean esNuevo) {
        if (nombre == null || nombre.trim().isEmpty())
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        if (tel == null || !tel.trim().matches("\\d{10}"))
            throw new IllegalArgumentException("El teléfono debe tener exactamente 10 números.");
        if (par == null || par.trim().isEmpty())
            throw new IllegalArgumentException("Debes seleccionar un parentesco.");
        if (esNuevo && buscar(nombre) != null)
            throw new IllegalArgumentException("Ya existe un contacto con ese nombre.");
    }
}