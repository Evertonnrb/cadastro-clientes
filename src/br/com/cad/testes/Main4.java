/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cad.testes;

import javax.persistence.Persistence;

/**
 *
 * @author eveton
 */
public class Main4 {
    public static void main(String[] args) {
        Persistence.createEntityManagerFactory("ifsulPU");
    }
}
