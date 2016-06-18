/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

import java.util.Map;
import java.util.TreeMap;


public class Dto {

    private Map<String, Object> diccionario;    
    public Dto(){
        diccionario = new TreeMap<>();
    }
    public boolean agregarElemento (String pLlave, Object pValor){
        if(!diccionario.containsKey(pLlave.toLowerCase())){
            diccionario.put(pLlave.toLowerCase(), pValor);
            return true;
        }
        return false;
    }
    
    public Object buscarLlave(String pLlave){
        Object valor = "";
        
        if(diccionario.containsKey(pLlave.toLowerCase()))
            valor = diccionario.get(pLlave.toLowerCase());
        
        return valor;
    }
    
    public void eliminarLlave(String pLlave){
        diccionario.remove(pLlave.toLowerCase());
    }
    
    @Override
    public String toString(){
        String strDiccionario = "";
        
        for (Map.Entry<String, Object> dato : diccionario.entrySet()){
            strDiccionario = strDiccionario + " Llave : " + dato.getKey() + " - Valor : " + dato.getValue() + "\n";
        }
        
        return strDiccionario;
    }

    
}