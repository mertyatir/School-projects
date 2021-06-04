package artVaultApplication;
import java.util.*;

public class ArrayListSorter
{
	public static void sortArtist(List<Artist> list,String whatToSortBy)
	{
			int n = list.size(); 
	        for (int i = 0; i < n-1; i++) 
	        { 
	            int min_idx = i; 
	            for (int j = i+1; j < n; j++)         
	                if (list.get(j).compareTo(list.get(min_idx), whatToSortBy)<0) 
	                    min_idx = j; 
	            Artist temp = list.get(min_idx); 
	            list.set(min_idx, list.get(i)); 
	            list.set(i, temp); 		
		}    
    } 

	public static void sortArchitect(List<Architect> list,String whatToSortBy)
	{
			int n = list.size(); 
	        for (int i = 0; i < n-1; i++) 
	        { 
	            int min_idx = i; 
	            for (int j = i+1; j < n; j++)         
	                if (list.get(j).compareTo(list.get(min_idx), whatToSortBy)<0) 
	                    min_idx = j; 
	            Architect temp = list.get(min_idx); 
	            list.set(min_idx, list.get(i)); 
	            list.set(i, temp); 		
		}    
    } 
	public static void sortPainting(List<Painting> list,String whatToSortBy)
	{
			int n = list.size(); 
	        for (int i = 0; i < n-1; i++) 
	        { 
	            int min_idx = i; 
	            for (int j = i+1; j < n; j++)         
	                if (list.get(j).compareTo(list.get(min_idx), whatToSortBy)<0) 
	                    min_idx = j; 
	            Painting temp = list.get(min_idx); 
	            list.set(min_idx, list.get(i)); 
	            list.set(i, temp); 		
		}    
    } 
	public static void sortSculpture(List<Sculpture> list,String whatToSortBy)
	{
			int n = list.size(); 
	        for (int i = 0; i < n-1; i++) 
	        { 
	            int min_idx = i; 
	            for (int j = i+1; j < n; j++)         
	                if (list.get(j).compareTo(list.get(min_idx), whatToSortBy)<0) 
	                    min_idx = j; 
	            Sculpture temp = list.get(min_idx); 
	            list.set(min_idx, list.get(i)); 
	            list.set(i, temp); 		
		}    
    } 
	public static void sortArchitecture(List<Architecture> list,String whatToSortBy)
	{
			int n = list.size(); 
	        for (int i = 0; i < n-1; i++) 
	        { 
	            int min_idx = i; 
	            for (int j = i+1; j < n; j++)         
	                if (list.get(j).compareTo(list.get(min_idx), whatToSortBy)<0) 
	                    min_idx = j; 
	            Architecture temp = list.get(min_idx); 
	            list.set(min_idx, list.get(i)); 
	            list.set(i, temp); 		
		}    
    }
	
	}
	

    
        
	 

