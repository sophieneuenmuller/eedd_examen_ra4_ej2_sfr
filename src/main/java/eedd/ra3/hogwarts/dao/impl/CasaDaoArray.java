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
        Casa Casa = null;
        for (Casa CasaLista : listaCasas) {
            if (CasaLista.getIdentificador() == identificador) {
                Casa = CasaLista;
                break;
            }
        }
        return Casa;
    }

    @Override
    public Casa actualizarCasa(Casa Casa) {
        Casa CasaActualizado = null;

        for (int i = 0; i < listaCasas.size(); i++) {
            Casa CasaLista = listaCasas.get(i);
            if (CasaLista.getIdentificador() == Casa.getIdentificador()) {
                listaCasas.set(i, Casa);
                CasaActualizado = Casa;
                break;
            }
        }
        return CasaActualizado; // no encontrado
    }

    @Override
    public Casa crearCasa(Casa Casa) {
        listaCasas.add(Casa);
        return Casa;
    }

    @Override
    public void borrarCasa(Casa Casa) {
        listaCasas.removeIf(c -> c.getIdentificador() == Casa.getIdentificador());
    }

    @Override
    public List<Casa> obtenerListaCasas() {
        return new ArrayList<>(listaCasas); // devolvemos copia
    }

    @Override
    public List<Casa> obtenerCasaPorNombre(String nombre) {
        List<Casa> listaCasasMarca= null;

        for (Casa Casa : listaCasas) {
            if (Casa.getNombre().equals(nombre)) {
                if (listaCasasMarca == null) {
                    listaCasasMarca = new ArrayList<>();
                }
                listaCasasMarca.add(Casa);
            }
        }

        return listaCasasMarca;
    }
}
