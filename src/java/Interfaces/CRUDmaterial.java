/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Model.material;
import java.util.List;

/**
 *
 * @author user
 */
public interface CRUDmaterial {
      public List listar();
    public material list(int id);
    public boolean add(material material);
    public boolean edit(material material);
    public boolean eliminat(int id);
}
