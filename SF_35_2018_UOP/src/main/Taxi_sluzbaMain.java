package main;

import osobe.Dispecer;
import osobe.Musterija;
import osobe.Vozac;
import taxi_sluzba.Taxi_sluzba;
import automobil.Automobil;

public class Taxi_sluzbaMain {
	

	private static String DISPECER_FAJL = "dispeceri.txt";
	private static String MUSTERRIJA_FAJL = "musterije.txt";
	private static String VOZAC_FAJL = "vozaci.txt";

	
	public static void main(String[] args) {
		Taxi_sluzba taxi_sluzba = new Taxi_sluzba();
		taxi_sluzba.ucitajDispecera(DISPECER_FAJL);
		taxi_sluzba.ucitajMusterija(MUSTERIJA_FAJL);
		taxi_sluzba.ucitajVozaca(VOZAC_FAJL);
		
		System.out.println("PODACI UCITANI IZ DATOTEKA: ");
		System.out.println("----------------------------------------");
		ispisiSvePodatke(taxi_sluzba);
		System.out.println("----------------------------------------");
		
		System.out.println("Dodavanje test podataka...");
		Dispecer testDispeceri = new Dispecer("jova", "jovic", "jovaj", "1234", DISPECERI_FAJL, DISPECERI_FAJL, null, DISPECERI_FAJL);
		taxi_sluzba.dodajDispecere(testDispeceri);
		
		Musterija testMusterija = new Musterija("aaa", "bbb", "ab", "5678", DISPECERI_FAJL, DISPECERI_FAJL, null, DISPECERI_FAJL);
		

	}


	private static void ispisiSvePodatke(Taxi_sluzba taxi_sluzba) {
		for(Dispecer dispeceri : taxi_sluzba.getDispeceri()) {
			System.out.println(dispeceri + "\n");
		}
	
		for(Musterija musterije : taxi_sluzba.getMusterije()) {
			System.out.println(musterije + "\n");
			
		}
		for(Vozac vozaci : taxi_sluzba.getVozaci()) {
			System.out.println(vozaci + "\n");
			
		
			
		}
			
		
	}

}
