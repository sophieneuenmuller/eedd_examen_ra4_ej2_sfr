package eedd.ra3.hogwarts.dao.impl;

import java.util.ArrayList;
import java.util.List;

import eedd.ra3.hogwarts.dao.ICasaDAO;
import eedd.ra3.hogwarts.vo.Casa;

public class CasaDaoArray implements ICasaDAO {

    private List<Casa> listaCasas;

    public CasaDaoArray() {
        listaCasas = new ArrayList<>();

        // Simulamos los inserts de la base de datos
        listaCasas.add(new Casa(1, "Gryffindor"));
        listaCasas.add(new Casa(2, "Slytherin"));
        listaCasas.add(new Casa(3, "Ravenclaw"));
        listaCasas.add(new Casa(4, "Hufflepuff"));
    }

    @Override
    public Casa obtenerCasaPorID(int identificador) {
        Casa casa = null;
        for (Casa casaLista : listaCasas) {
            if (casaLista.getIdentificador() == identificador) {
                casa = casaLista;
                break;
            }
        }
        return casa;
    }

    @Override
    public Casa actualizarCasa(Casa casa) {
        Casa casaActualizada = null;

        for (int i = 0; i < listaCasas.size(); i++) {
            Casa casaLista = listaCasas.get(i);
            if (casaLista.getIdentificador() == casa.getIdentificador()) {
                listaCasas.set(i, casa);
                casaActualizada = casa;
                break;
            }
        }
        return casaActualizada; // no encontrado
    }

    @Override
    public Casa crearCasa(Casa casa) {
        listaCasas.add(casa);
        return casa;
    }

    @Override
    public void borrarCasa(Casa casa) {
        listaCasas.removeIf(c -> c.getIdentificador() == casa.getIdentificador());
    }

    @Override
    public List<Casa> obtenerListaCasas() {
        return new ArrayList<>(listaCasas); // devolvemos copia
    }

    @Override
    public List<Casa> obtenerCasaPorNombre(String nombre) {
        List<Casa> listaCasasNombre= null;

        for (Casa casa : listaCasas) {
            if (casa.getNombre().equals(nombre)) {
                if (listaCasasNombre == null) {
                    listaCasasNombre = new ArrayList<>();
                }
                listaCasasNombre.add(casa);
            }
        }

        return listaCasasNombre;
    }
}
