package main;

import osobe.Dispecer;
import osobe.Musterija;
import osobe.Odeljenje;
import osobe.Pol;
import osobe.Vozac;
import taxi_sluzba.Taxi_sluzba;
import automobil.Automobil;

public class Taxi_sluzbaMain {
	

	private static String DISPECER_FAJL = "dispeceri.txt";
	private static String MUSTERRIJA_FAJL = "musterije.txt";
	private static String VOZAC_FAJL = "vozaci.txt";

	
	public static void main(String[] args) {
		System.out.println("Run");
		
		Taxi_sluzba taxi_sluzba = new Taxi_sluzba(1, 123, "Crveni taxi", "Fruskogorska 1", 90, 40 );
		System.out.println(taxi_sluzba.toString());
		taxi_sluzba.ucitajDispecere(DISPECER_FAJL);
		
		
//		Dispecer dispecer1 = new Dispecer("Perap", "123", "Pera", "Peric", "123456", "Narodnog fronta 2", Pol.MUSKI,
//				1, 1000.0, "0211234", Odeljenje.Odeljenje_za_prijem_voznji);
//		System.out.println("Dipsecer je: " + dispecer1);
//		Dispecer dispecer2 = new Dispecer("Mikam", "456", "Mika", "Mikic", "978545", "Modene 2", Pol.ZENSKI,
//				2, 2000.0, "0211234", Odeljenje.Odeljenje_za_prijem_voznji);
//		
//		taxi_sluzba.dodajDispecera(dispecer1);
//		taxi_sluzba.dodajDispecera(dispecer2);
		System.out.println("Taxi je: " + taxi_sluzba);
//		taxi_sluzba.cuvanjeDispecera(DISPECER_FAJL);
		
	}

}
