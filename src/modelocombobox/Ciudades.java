/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelocombobox;

/**
 *
 * @author danierfresley
 */
public class Ciudades {
    
    int idciudad;
    String nombre_ciudad;  

    public Ciudades(int idciudad, String nombre_ciudad) {
        this.idciudad = idciudad;
        this.nombre_ciudad = nombre_ciudad;
    }
    
    public int getIdciudad() {
        return idciudad;
    }

    public void setIdciudad(int idciudad) {
        this.idciudad = idciudad;
    }

    public String getNombre_ciudad() {
        return nombre_ciudad;
    }

    public void setNombre_ciudad(String nombre_ciudad) {
        this.nombre_ciudad = nombre_ciudad;
    }

    @Override
    public String toString() {
        return nombre_ciudad;
    }
    
    
    
}
