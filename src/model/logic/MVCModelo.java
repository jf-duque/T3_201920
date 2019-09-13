package model.logic;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.opencsv.CSVReader;

import model.data_structures.Array;
import model.data_structures.ArregloDinamico;
import model.data_structures.IArregloDinamico;

/**
 * Definicion del modelo del mundo
 *
 */
public class MVCModelo {
	/**
	 * Atributos del modelo del mundo
	 */
	private IArregloDinamico datos;
	
	private Array<UBERTrip> lista;
	
	private static String TBLANCO="\u001b[1;37m";
	 private static String TROJO="\u001b[1;31m";
	 private static String TVERDECLARO="\u001b[1;32m";
	 private static String TAMARILLO="\u001b[1;33m";
	 private static String TAZUL="\u001b[1;34m";
	 private static String TROSA="\u001b[1;35m";
	 private static String TAZULCLARO="\u001b[1;36m";
	 
	 private static String FBLANCO="\u001b[1;47m";
	 private static String FROJO="\u001b[1;41m";
	 private static String FVERDECLARO="\u001b[1;42m";
	 private static String FAMARILLO="\u001b[1;43m";
	 private static String FAZUL="\u001b[1;44m";
	 private static String FROSA="\u001b[1;45m";
	 private static String FAZULCLARO="\u001b[1;46m";
	 private static String FNEGRO="\u001b[1;40m";
	 
	 private static String FF="\u001b[0m";
	
	/**
	 * Constructor del modelo del mundo con capacidad predefinida
	 */
	public MVCModelo()
	{
		datos = new ArregloDinamico(7);
		lista = new Array<UBERTrip>();
	}
	
	/**
	 * Constructor del modelo del mundo con capacidad dada
	 * @param tamano
	 */
	public MVCModelo(int capacidad)
	{
		datos = new ArregloDinamico(capacidad);
	}
	
	/**
	 * Servicio de consulta de numero de elementos presentes en el modelo 
	 * @return numero de elementos presentes en el modelo
	 */
	public int darTamano()
	{
		return datos.darTamano();
	}

	/**
	 * Requerimiento de agregar dato
	 * @param dato
	 */
	public void agregar(String dato)
	{	
		datos.agregar(dato);
	}
	
	/**
	 * Requerimiento buscar dato
	 * @param dato Dato a buscar
	 * @return dato encontrado
	 */
	public String buscar(String dato)
	{
		return datos.buscar(dato);
	}
	
	/**
	 * Requerimiento eliminar dato
	 * @param dato Dato a eliminar
	 * @return dato eliminado
	 */
	public String eliminar(String dato)
	{
		return datos.eliminar(dato);
	}
	
	public void leerArchivo()
	{
			
			CSVReader reader = null;
			try {
				reader = new CSVReader(new FileReader("./data/bogota-cadastral-2018-2-All-HourlyAggregate.csv"));			
				String[] nextline = reader.readNext();
				nextline = reader.readNext();
				
				//Debido a la memoria limitada de java solo guarda 3238053 viajes.
				
				while(nextline != null && lista.size() < 100)
				{					
						int    sourceid = Integer.parseInt(nextline[0]);
						int    dstid = Integer.parseInt(nextline[1]);
						int    hod = Integer.parseInt(nextline[2]);
						double mean_travel_time = Double.parseDouble(nextline[3]);
						double standard_deviation_travel_time = Double.parseDouble(nextline[4]);
						double geometric_mean_travel_time = Double.parseDouble(nextline[5]);
						double geometric_standard_deviation_travel_time = Double.parseDouble(nextline[6]);	
						UBERTrip nuevo = new UBERTrip(sourceid, dstid, hod, mean_travel_time, standard_deviation_travel_time, geometric_mean_travel_time, geometric_standard_deviation_travel_time);
						lista.add(nuevo);

						nextline = reader.readNext();					
				}
				System.out.println("");
				System.out.println(FVERDECLARO + TBLANCO + "La cantidad de viajes cargados fue: " + lista.size() + "." + FF + FF);
				System.out.println("");
				reader.close();
				
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
	
	private static void exch(Array<UBERTrip> lista2, int i, int j) {
        Object swap = lista2.get(i);
        lista2.get(i) = lista2.get(j);
        lista2.get(j) = swap;
    }
	
	public void asd()
	{
		sort(lista);
	}
	
	public  void sort(Array<UBERTrip> lista2) {
        int n = lista2.size();

        // 3x+1 increment sequence:  1, 4, 13, 40, 121, 364, 1093, ... 
        int h = 1;
        while (h < n/3) h = 3*h + 1; 

        while (h >= 1) {
            // h-sort the array
            for (int i = h; i < n; i++) {
                for (int j = i; j >= h && less(lista2.get(j), lista2.get(j-h)); j -= h) {
                    exch(lista2, j, j-h);
                }
            }
        }

}
	}
