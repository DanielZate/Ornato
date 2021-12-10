/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import Model.rol;
import java.util.List;

/**
 *
 * @author crist
 */
public interface CRUD {
    public List listar();
    public rol list(int id);
    public boolean add(rol rol);
    public boolean edit(rol rol);
    public boolean eliminat(int id);
    
}
