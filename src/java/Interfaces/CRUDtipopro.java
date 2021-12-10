/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Model.tipoproducto;
import java.util.List;

/**
 *
 * @author user
 */
public interface CRUDtipopro {
      public List listar();
    public tipoproducto list(int id);
    public boolean add(tipoproducto tipoproducto);
    public boolean edit(tipoproducto tipoproducto);
    public boolean eliminat(int id);
}
