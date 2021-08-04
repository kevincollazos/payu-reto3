package com.payulatam.recruiting;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class NetworkPrioritization {
		
    public enum Criteria {
        RESPONSE_TIME, COST;
    }

    public static int[] prioritizeNetwork(int[] responseTimes, int[] cost, Criteria priority) {
    	TreeMap<Integer, Integer> mapResponse = new TreeMap<Integer,Integer>();
    	int[] arregloRespuesta = new int[responseTimes.length];
    	if(priority == Criteria.RESPONSE_TIME ) {
    		int lessTime = 0;    		
    		for (int k = 0; k < responseTimes.length; k++) {
    			if(mapResponse.containsKey(responseTimes[k])) {
    				int costo = cost[k]; 
                    int otrocosto = cost[mapResponse.get(responseTimes[k])]; 
                    if(costo > otrocosto){ 
                    	mapResponse.put(responseTimes[k]+1, k); 
                    } else{ 
                    	mapResponse.put(responseTimes[k]-1, k); 
                    }
    			} else {
    				mapResponse.put(responseTimes[k], k);
    			}    			
            }        		 
    	} else {
    		int lessCost = 0;
    		for (int k = 0; k < cost.length; k++) {
                mapResponse.put(cost[k], k);
            }    
    	}
    	
    	Iterator it = mapResponse.keySet().iterator();
    	int contador = 0; 
        while (it.hasNext()){ 
            Integer doc = (Integer)it.next(); 
            arregloRespuesta[contador] = mapResponse.get(doc); 
            contador++; 
        }
    	return arregloRespuesta;
    }
}
