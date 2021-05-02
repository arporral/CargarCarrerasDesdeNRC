/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.titus.cargarcarreras;

import com.google.gson.Gson;
import com.titus.carreras.Activities;
import com.titus.carreras.Matriz;
import com.titus.carreras.Summaries;
import com.titus.tablas.Carreirasnrc;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TimeZone;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class CargarCarreras {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("carrerasPU");
    static int num = 1;    

    public static void main(String[] args) throws IOException {

        Gson gson = new Gson();
        Matriz matriz = null;        

        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        String fichero = null;

        try {           
            archivo = new File("F:\\ANALISIS Y PROGRAMACION\\Programas java\\CargarCarrerasDesdeNRC\\ficheros\\activities.json");
            
            // utilizo la clase InputStreamReader para poder aplicar el charset "utf-8" que me permite obtener los acentos correctamente
            br = new BufferedReader(new InputStreamReader(new FileInputStream(archivo), "utf-8"));

            // Lectura del fichero
            while ((fichero = br.readLine()) != null) {
                matriz = gson.fromJson(fichero, Matriz.class);
                
                if (matriz != null) {
                    CargarCarreras cc = new CargarCarreras(matriz);
                } else {
                    System.out.println("Error. no hay datos.");
                }
            }
        } catch (IOException e) {
        } finally {            
            try {
                if (null != fr) {
                    fr.close();
                    System.out.println("Se han insertado " + num + " registros en la tabla.");
                }
            } catch (IOException e2) {
            }
        }              
    }

    public CargarCarreras(Matriz matriz) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        Map<String, String> sensa = new HashMap<>();         
        sensa.put("TIRED", "Cansado");
        sensa.put("SO_SO", "Normal");
        sensa.put("GREAT", "Bien");
        sensa.put("UNSTOPPABLE", "Imparable");
        sensa.put("AMPED", "Sensacional");
 
        Map<String, String> tiempo = new HashMap<>();         
        tiempo.put("CLOUDY", "Nublado");
        tiempo.put("AMPED", "Sensacional");
        tiempo.put("RAINY", "Lluvioso"); 
        tiempo.put("SUNNY", "Soleado");
        tiempo.put("PARTLY_SUNNY", "Parcialmente soleado");
        tiempo.put("CLEAR_NIGHT", "Noche clara");
        tiempo.put("FOG", "Niebla");
        tiempo.put("PARTLY_CLOUDY_NIGHT", "Noche parcialmente nubosa");
        
        Map<String, String> firme = new HashMap<>();         
        firme.put("ROAD", "Carretera");
        firme.put("TRAIL", "Trail");
        firme.put("AMPED", "Sensacional");
        firme.put("BEACH", "Playa");
        firme.put("TRACK", "Pista");
        
        Map<String, String> tenis = new HashMap<>();              
        tenis.put("288e8781-fc59-435b-8e95-e66c443596f1", "Guays");
        tenis.put("8e8673c9-045e-46fc-9725-ecc907bf991c", "Adidas boost");
        tenis.put("b01d7eb5-521c-45eb-adcc-c0e49e85c35d", "Brooks Glycerin 17 negras");
        tenis.put("cb99af73-8e9d-459b-915b-7d0e0cd71a70", "Basket");
        tenis.put("dd08460d-7e70-40b4-bd16-0821c6bb464b", "Blancos cutres");        
        tenis.put("e3946771-6e12-4e06-98cb-f96f6b63d87e", "Mizuno verdes");
        tenis.put("e5c5170f-3e54-4034-957e-d4efea5022ed", "Brooks Glycerin 18 azules");
        tenis.put("ee85de5c-c6da-42b1-951c-ce7fcb137549", "Mizuno azul-limón");
        tenis.put("f61c4505-90e9-473f-8f02-792125e7081c", "Adidas booster azules");
 
        Iterator it = matriz.getActivities().iterator();

        tx.begin();              
        
        while (it.hasNext()) {                                 
            Activities nrc = (Activities) it.next();

            // Fecha
            //DateTimeFormatter formatEurope = DateTimeFormatter.ofPattern("yyyy-MM-dd");            
            //LocalDate fecha = LocalDate.parse(formatEurope.format(new Date(nrc.getStart_epoch_ms().longValue())), formatEurope);
            //LocalDate fecha = Instant.ofEpochMilli(nrc.getStart_epoch_ms().longValue()).atZone(ZoneId.systemDefault()).toLocalDate();
            //LocalDate fecha = Instant.ofEpochMilli(nrc.getStart_epoch_ms().longValue()).atZone(ZoneId.of("UTC")).toLocalDate();
            //System.out.println("Fecha = " + sdf.format(fecha));
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MMM-dd");
            sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
            Date fecha = new Date(nrc.getStart_epoch_ms().longValue());
            System.out.println("Fecha = " + fecha);

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
                if (summary.getMetric().equals("distance")) {
                    kms = summary.getValue();
                }
                if (summary.getMetric().equals("calories")) {
                    calorias = summary.getValue();
                }
                if (summary.getMetric().equals("steps")) {
                    pasos = (int) summary.getValue();
                }
            }

            System.out.println("Kms = " + kms);
            System.out.println("Calorias = " + calorias);
            System.out.println("Pasos = " + pasos);

            // recorrido, sensaciones, calzado, clima, terreno y temperatura (se encuentran en el array de tags).
            String nombre = nrc.getTags().getComNikeName();
            String sensaciones = nrc.getTags().getEmotion();
            String calzado = (nrc.getTags().getShoes() == null) ? nrc.getTags().getShoe_id() : nrc.getTags().getShoes();
            String terreno = nrc.getTags().getTerrain();
            String clima = (nrc.getTags().getWeather() == null) ? nrc.getTags().getComNikeWeather() : nrc.getTags().getWeather();
            String temperatura = (nrc.getTags().getTemperature() == null) ? nrc.getTags().getComNikeTemperature() : nrc.getTags().getTemperature();
            
            for (String key : sensa.keySet()) {
                if (sensaciones != null && key.equals(sensaciones.toUpperCase())){
                    sensaciones = sensa.get(key);
                }
            }
            for (String key : tiempo.keySet()) {
                if (clima != null && key.equals(clima.toUpperCase())){
                    clima = tiempo.get(key);
                }
            }
            for (String key : firme.keySet()) {
                if (terreno != null && key.equals(terreno.toUpperCase())){
                    terreno = firme.get(key);
                }
            }
            for (String key : tenis.keySet()) {
                if (calzado != null && key.equals(calzado)){
                    calzado = tenis.get(key);
                }
            }
            
            System.out.println("Nombre = " + nombre);
            System.out.println("Sensaciones = " + sensaciones);
            System.out.println("Calzado = " + calzado);
            System.out.println("Terreno = " + terreno);
            System.out.println("Clima = " + clima);
            System.out.println("Temperatura = " + temperatura);

            Carreirasnrc c = new Carreirasnrc();
            c.setFecha(fecha);            
            c.setDuracion(duracion);  
            c.setKms(kms);
            c.setRecorrido(nombre);
            c.setTipoDeEjercicio("correr");
            c.setSensaciones(sensaciones);
            c.setClima(clima);
            c.setCalzado(calzado);
            c.setCalorias(calorias);
            c.setPasos(pasos);
            c.setTemperatura(temperatura);
            c.setTerreno(terreno);
            
            em.persist(c);              
            
            num++;
            
            tx.commit();
            tx.begin();
            em.clear();
        }
        tx.commit();
        em.close();        
    }
}
