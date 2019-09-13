package model.logic;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.opencsv.CSVReader;

import model.data_structures.Array;
import model.data_structures.IStack;
import model.data_structures.Stack;

/**
 * Definicion del modelo del mundo
 *
 */
public class MVCModelo {
	
	/**
	 * Pila donde se van a cargar los datos de los archivos
	 */
	private IStack<UBERTrip> uberTrip;
	
	/**
	 * Constructor del modelo del mundo con capacidad predefinida
	 */
	public MVCModelo()
	{
		uberTrip = new Stack<UBERTrip>();
	}
	
	/**
	 * Carga el csv 
	 */
	public void leerArchivo()
	{
			
		int cantidadViajes=0;	
		CSVReader reader = null;
			try {
				reader = new CSVReader(new FileReader("./data/bogota-cadastral-2018-2-All-HourlyAggregate.csv"));			
				String[] nextline = reader.readNext();
				nextline = reader.readNext();
				
				
				while(nextline != null )
				{					
						int    sourceid = Integer.parseInt(nextline[0]);
						int    dstid = Integer.parseInt(nextline[1]);
						int    dow = Integer.parseInt(nextline[2]);
						double mean_travel_time = Double.parseDouble(nextline[3]);
						double standard_deviation_travel_time = Double.parseDouble(nextline[4]);
						double geometric_mean_travel_time = Double.parseDouble(nextline[5]);
						double geometric_standard_deviation_travel_time = Double.parseDouble(nextline[6]);	
						UBERTrip trip = new UBERTrip(sourceid, dstid, dow, mean_travel_time, standard_deviation_travel_time, geometric_mean_travel_time, geometric_standard_deviation_travel_time);
						uberTrip.push(trip);
						nextline = reader.readNext();					
						cantidadViajes++;
				}
				System.out.println("");
				System.out.println("La cantidad de viajes cargados fue: " + cantidadViajes + ".");
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


}
