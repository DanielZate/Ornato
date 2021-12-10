/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Model.proyecto;
import java.util.List;

/**
 *
 * @author user
 */
public interface CRUDproyecto {
      public List listar();
    public proyecto list(int id);
    public boolean add(proyecto proyecto);
    public boolean edit(proyecto proyecto);
    public boolean eliminat(int id);
}
