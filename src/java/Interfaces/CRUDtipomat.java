/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Model.tipomaterial;
import java.util.List;

/**
 *
 * @author user
 */
public interface CRUDtipomat {
     public List listar();
    public tipomaterial list(int id);
    public boolean add(tipomaterial tipomaterial);
    public boolean edit(tipomaterial tipomaterial);
    public boolean eliminat(int id);
}
