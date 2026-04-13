package eedd.ra3.hogwarts;

import java.util.List;

import eedd.ra3.hogwarts.dao.ICasaDAO;
import eedd.ra3.hogwarts.dao.impl.CasaDaoArray;
import eedd.ra3.hogwarts.vo.Casa;

/**
 *
 * AppConcesionario: Clase que realiza el tratamiento de los Casas de un
 * concesionario.
 * 
 * @author Isidoro Nevares Martín - IES Virgen de la Paloma
 * @date 4 dic 2025
 * 
 * 
 */

public class AppHogwarts {

    private ICasaDAO iCasaDAO;

    public static void main(String[] args) {
        AppHogwarts app = new AppHogwarts();

        // Consulta inicial de Casas
        app.consultarCasas("INICIAL");

        // Consulta por ID
        app.consultarPorId(3);

        // Alta de un nuevo Casa
        app.altaCasa();

        // Actualización de un Casa existente
        app.actualizarCasa();

        // Borrado de un Casa por ID
        app.borrarCasa(2);

        // Consulta de Casas por "nombre"
        app.consultarCasasNombre("Ravenclaw");

        // Consulta final de Casas
        app.consultarCasas("FINAL");
    }

    public AppHogwarts() {
        iCasaDAO = new CasaDaoArray();
    }

    private void consultarCasas(String momento) {
        try {
            List<Casa> listaCasas = iCasaDAO.obtenerListaCasas();

            System.out.println("#########################################");
            System.out.println("LISTADO DE CASAS " + momento);
            System.out.println("#########################################");

            for (Casa Casa : listaCasas) {
                System.out.println(Casa);
            }
            System.out.println("-------------------------------------------------\n\n");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void consultarPorId(int id) {
        System.out.println("#########################################");
        System.out.println("CONSULTA CASA POR ID: " + id);
        System.out.println("#########################################\n");

        Casa Casa = iCasaDAO.obtenerCasaPorID(id);

        if (Casa != null) {
            System.out.println(Casa);
        } else {
            System.out.println("No existe Casa con id " + id);
        }
        System.out.println("-------------------------------------------------\n\n");
    }

    private void altaCasa() {
        System.out.println("#########################################");
        System.out.println("ALTA DE CASA");
        System.out.println("#########################################\n");

        Casa CasaNuevo = new Casa();
        CasaNuevo.setIdentificador(8);
        CasaNuevo.setNombre("Aula magna");

        iCasaDAO.crearCasa(CasaNuevo);

        System.out.println("Casa creada: " + CasaNuevo);
        System.out.println("-------------------------------------------------\n\n");
    }

    private void actualizarCasa() {
        System.out.println("ACTUALIZAR CASA");
        System.out.println("#########################################\n");

        Casa Casa = new Casa(1, "Gryffindorrrr");
        Casa CasaActualizado = iCasaDAO.actualizarCasa(Casa);

        if (CasaActualizado != null) {
            System.out.println("Casa actualizado: " + CasaActualizado);
        } else {
            System.out.println("No se encontró el Casa para actualizar");
        }
        System.out.println("-------------------------------------------------\n\n");
    }

    private void borrarCasa(int id) {
        System.out.println("#########################################");
        System.out.println("BORRAR CASA ID: " + id);
        System.out.println("#########################################\n");

        Casa Casa = iCasaDAO.obtenerCasaPorID(id);

        if (Casa != null) {
            iCasaDAO.borrarCasa(Casa);
            System.out.println("Casa borrado correctamente");
        } else {
            System.out.println("No existe Casa con id " + id);
        }
        System.out.println("-------------------------------------------------\n\n");
    }

    /**
     * @param string
     */
    private void consultarCasasNombre(String nombre) {
        System.out.println("#########################################");
        System.out.println("CONSULTA CASA POR Nombre: " + nombre);
        System.out.println("#########################################\n");

        List<Casa> listaCasas = iCasaDAO.obtenerCasaPorNombre(nombre);

        for (Casa casa : listaCasas) {
            System.out.println(casa);
        }

        System.out.println("-------------------------------------------------\n\n");
    }

}
