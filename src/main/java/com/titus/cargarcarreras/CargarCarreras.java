/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.titus.cargarcarreras;

import com.google.gson.Gson;
import com.titus.carreras.Activities;
import com.titus.carreras.Matriz;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.TimeZone;

public class CargarCarreras {
        
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("carrerasPU");

    public static void main(String[] args) throws IOException {
        
        Gson gson = new Gson();            
        Matriz matriz = null;

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
                
        matriz = gson.fromJson(fichero, Matriz.class);        
                
        CargarCarreras cc = new CargarCarreras();

        if (matriz != null) {
            cc.insertCarreira(matriz);        
        } else {
            System.out.println("Error. no hay datos.");
        }        
    }

    public void insertCarreira(Matriz matriz) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        int num = 0;
        final int batchSize = 50;
        Iterator it = matriz.getActivities().iterator();
        
        tx.begin();

        while (it.hasNext()) {
            if (num > 0 && num % batchSize == 0) {
                tx.commit();
                tx.begin();
                em.clear();
            }
            
            Activities nrc = (Activities) it.next();

//            Carreiras c = new Carreiras();
//            c.setFecha(new Date(nrc.getStart_epoch_ms()));            
//            em.persist(c);
            
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            sdf.setTimeZone(TimeZone.getTimeZone("UTC"));            
            Date fecha = new Date(nrc.getStart_epoch_ms().longValue());
            System.out.println("Fecha = " + sdf.format(fecha));            
            
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MMM-dd HH:mm:ss");
            sdf = new SimpleDateFormat("HH:mm:ss");
            sdf.setTimeZone(TimeZone.getTimeZone("UTC"));  
            Date duracion = new Date(nrc.getActive_duration_ms().longValue());
            System.out.println("Duracion = " + sdf.format(duracion));          

            num++;
        }
        tx.commit();
        em.close();
    }    
}