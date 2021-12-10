/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import Model.usuario;
import java.util.List;

/**
 *
 * @author crist
 */
public interface CRUDusuarios {
    public List listar();
    public usuario list(int id);
    public boolean add(usuario usuario);
    public boolean edit(usuario usuario);
    public boolean eliminat(int id);
    
}
