/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.titus.cargarcarreras;

import com.google.gson.Gson;
import com.titus.carreras.Activities;
import com.titus.carreras.Carreirasnrc;
import com.titus.carreras.Matriz;
import com.titus.carreras.Summaries;
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
            archivo = new File("F:\\ANALISIS Y PROGRAMACION\\Programas java\\CargarCarrerasDesdeNRC\\resources\\prueba-0.json");
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

            // Fecha
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            sdf.setTimeZone(TimeZone.getTimeZone("UTC"));            
            Date fecha = new Date(nrc.getStart_epoch_ms().longValue());
            System.out.println("Fecha = " + sdf.format(fecha));            
            
            // Duracion
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MMM-dd HH:mm:ss");
            sdf = new SimpleDateFormat("HH:mm:ss");
            sdf.setTimeZone(TimeZone.getTimeZone("UTC"));  
            Date duracion = new Date(nrc.getActive_duration_ms().longValue());
            System.out.println("Duracion = " + sdf.format(duracion));          

            // Kms, calorias y pasos (se encuentran en el array de summaries).
            double kms = 0.0;
            double calorias = 0.0;
            int pasos = 0;
            
            for (Summaries summary : nrc.getSummaries()) {
                if (summary.getMetric().equals("distance")){
                    kms = summary.getValue();
                }
                if (summary.getMetric().equals("calories")){
                    calorias = summary.getValue();
                }
                if (summary.getMetric().equals("steps")){
                    pasos = (int) summary.getValue();
                }
            }

            System.out.println("Kms = " + kms);
            System.out.println("Calorias = " + calorias);
            System.out.println("Pasos = " + pasos);
            
            // recorrido, sensaciones, calzado, clima, terreno y temperatura (se encuentran en el array de tags).
            String nombre = nrc.getTags().getComNikeName();
            String sensaciones = nrc.getTags().getEmotion();
            String calzado = (nrc.getTags().getShoes() == null)? nrc.getTags().getShoe_id():nrc.getTags().getShoes();
            String terreno = nrc.getTags().getTerrain();
            String clima = (nrc.getTags().getWeather() == null)? nrc.getTags().getComNikeWeather():nrc.getTags().getWeather();          
            String temperatura = (nrc.getTags().getTemperature() == null)? nrc.getTags().getComNikeTemperature():nrc.getTags().getTemperature();            
            
            System.out.println("Nombre = " + nombre);
            System.out.println("Sensaciones = " + sensaciones);
            System.out.println("Calzado = " + calzado);
            System.out.println("Terreno = " + terreno);
            System.out.println("Clima = " + clima);
            System.out.println("Temperatura = " + temperatura);
            
//            Carreirasnrc c = new Carreirasnrc();
//            c.setFecha(fecha);            
//            c.setDuracion(duracion);  
//            c.setKms(kms);
//            c.setRecorrido(nombre);
//            c.setTipoDeEjercicio("correr");
//            c.setSensaciones(sensaciones);
//            c.setClima(clima);
//            c.setCalzado(calzado);
//            c.setCalorias(calorias);
//            c.setPasos(pasos);
//            c.setTemperatura(temperatura);
//            c.setTerreno(terreno);
//            
//            em.persist(c);            

            num++;
        }
        tx.commit();
        em.close();
        System.out.println("Se han insertado " + num + " en la tabla Carreirasnrc.");
    }    
}