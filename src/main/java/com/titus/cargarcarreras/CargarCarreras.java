/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.titus.cargarcarreras;

import com.google.gson.Gson;
import com.titus.carreras.Activities;
import com.titus.carreras.CarreirasNRC;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;

public class CargarCarreras {
        
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("carrerasPU");

    public static void main(String[] args) throws IOException {
        
        Gson gson = new Gson();            
        Activities acts = null;
 
//        FileReader fr = null;
//        char[] a = new char[70000];
//        
//        try {
//            fr = new FileReader("F:\\activities-0.json");
//            fr.read(a);
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        } finally {
//            try {
//                if (null != fr) {
//                    fr.close();
//                }
//            } catch (IOException e2) {
//                System.out.println(e2.getMessage());
//            }
//        }
//        
//        StringBuilder sb = new StringBuilder(70000);
//        //Java for-each loop  
//        for (char chars : a) {
//        //appends the string representation of the char array   
//            sb.append(chars);
//        }
//        //the toString() method returns a string that represents data in the sequence  
//        String fichero = sb.toString();

        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        String fichero = null;

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File("F:\\prueba-0.json");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            fichero = br.readLine();
        } catch (IOException e) {
        } finally {
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta 
            // una excepcion.
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (IOException e2) {
            }
        }
        
//        System.out.println(fichero);                
                
        acts = gson.fromJson(fichero, Activities.class);
        
        CargarCarreras cc = new CargarCarreras();

        if (acts != null) {
            cc.insertCarreira(acts);        
        } else {
            System.out.println("Error. no hay datos.");
        }        
    }

    public void insertCarreira(Activities activities) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        int num = 0;
        final int batchSize = 50;
        Iterator it = activities.getCarreirasnrc().iterator();
        
        tx.begin();

        while (it.hasNext()) {
            if (num > 0 && num % batchSize == 0) {
                tx.commit();
                tx.begin();
                em.clear();
            }
            
            CarreirasNRC nrc = (CarreirasNRC) it.next();

//            Carreiras c = new Carreiras();
//            c.setFecha(new Date(nrc.getStart_epoch_ms()));            
//            em.persist(c);
            
            System.out.println("Fecha = "+ new Date(nrc.getStart_epoch_ms()));
            System.out.println("Duracion = "+ new Date(nrc.getActive_duration_ms()));

            num++;
        }
        tx.commit();
        em.close();
    }    
}
