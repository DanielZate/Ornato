/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Model.producto;
import java.util.List;

/**
 *
 * @author user
 */
public interface CRUDproducto {
      public List listar();
    public producto list(int id);
    public boolean add(producto producto);
    public boolean edit(producto producto);
    public boolean eliminat(int id);
}
