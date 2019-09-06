package model.logic;

public class UBERTrip implements Comparable<UBERTrip>
{
	//Identificador único de la zona de origen de los viajes relacionados
	public int sourceid;

	// Identificador único de la zona de destino de los viajes relacionados
	public int dstid;

	//número del mes de los viajes relacionados
	public int month;

	//tiempo promedio en segundos de los viajes relacionados
	public double mean_travel_time;

	//desviación estándar de los viajes relacionados
	public double standard_deviation_travel_time;

	//desviación estándar de los viajes relacionados
	public double geometric_mean_travel_time;

	//desviación estándar geométrica de los viajes relacionados
	public double geometric_standard_deviation_travel_time;

	public UBERTrip(int pSourceid, int pDstid, int pMonth, double pMean_travel_time, double pStandard_deviation_travel_time, double pGeometric_mean_travel_time, double pGeometric_standard_deviation_travel_time )
	{
		sourceid = pSourceid;
		dstid = pDstid;
		month=pMonth;
		mean_travel_time = pMean_travel_time;
		standard_deviation_travel_time = pStandard_deviation_travel_time;
		geometric_mean_travel_time = pGeometric_mean_travel_time;
		geometric_standard_deviation_travel_time = pGeometric_standard_deviation_travel_time;
	}

	public int getSourceid() {
		return sourceid;
	}

	public void setSourceid(int sourceid) {
		this.sourceid = sourceid;
	}

	public int getDstid() {
		return dstid;
	}

	public void setDstid(int dstid) {
		this.dstid = dstid;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public double getMean_travel_time() {
		return mean_travel_time;
	}

	public void setMean_travel_time(double mean_travel_time) {
		this.mean_travel_time = mean_travel_time;
	}

	public double getStandard_deviation_travel_time() {
		return standard_deviation_travel_time;
	}

	public void setStandard_deviation_travel_time(double standard_deviation_travel_time) {
		this.standard_deviation_travel_time = standard_deviation_travel_time;
	}

	public double getGeometric_mean_travel_time() {
		return geometric_mean_travel_time;
	}

	public void setGeometric_mean_travel_time(double geometric_mean_travel_time) {
		this.geometric_mean_travel_time = geometric_mean_travel_time;
	}

	public double getGeometric_standard_deviation_travel_time() {
		return geometric_standard_deviation_travel_time;
	}

	public void setGeometric_standard_deviation_travel_time(double geometric_standard_deviation_travel_time) {
		this.geometric_standard_deviation_travel_time = geometric_standard_deviation_travel_time;
	}

	@Override
	public int compareTo(UBERTrip comparador) 
	{		
		if(mean_travel_time == comparador.getMean_travel_time())
		{
			if(standard_deviation_travel_time==comparador.standard_deviation_travel_time)
				return 0;
			else if	(standard_deviation_travel_time<comparador.standard_deviation_travel_time)
				return -1;
			else
				return 1;
		}
		else if(mean_travel_time<comparador.getMean_travel_time())
		{
			return -1;
		}
		else
		return 1;
	}

}


