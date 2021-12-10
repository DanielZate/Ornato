/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Model.medio;
import java.util.List;

/**
 *
 * @author user
 */
public interface CRUDmedio {
      public List listar();
    public medio list(int id);
    public boolean add(medio medio);
    public boolean edit(medio medio);
    public boolean eliminat(int id);
}
