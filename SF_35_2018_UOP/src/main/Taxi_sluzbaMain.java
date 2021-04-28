package main;

import osobe.Dispecer;
import java.time.LocalDateTime;

import osobe.Musterija;
import osobe.Odeljenje;
import osobe.Pol;
import osobe.Vozac;
import taxi_sluzba.Taxi_sluzba;
import voznja.StatusVoznje;
import voznja.Voznja;


import automobil.Automobil;
import automobil.VrstaAutomobila;

public class Taxi_sluzbaMain {
	

	private static String DISPECER_FAJL = "dispeceri.txt";
	private static String MUSTERRIJA_FAJL = "musterije.txt";
	private static String VOZAC_FAJL = "vozaci.txt";
	private static String VOZNJA_FAJL = "voznje.txt";
	
	public static void main(String[] args) {
		
		Taxi_sluzba taxi_sluzba = new Taxi_sluzba(1, 123, "Crveni taxi", "Fruskogorska 1", 90, 40 );
		System.out.println(taxi_sluzba.toString());
		taxi_sluzba.ucitajDispecere(DISPECER_FAJL);
		taxi_sluzba.ucitajVoznje(VOZNJA_FAJL);
		//taxi_sluzba.ucitajMusterije(MUSTERRIJA_FAJL);
		
		
		Dispecer dispecer1 = new Dispecer("Perap", "123", "Pera", "Peric", "123456", "Narodnog fronta 2", Pol.MUSKI,
				1, 1000.0, "0211234", Odeljenje.Odeljenje_za_prijem_voznji);
		System.out.println("Dipsecer je: " + dispecer1);
		Dispecer dispecer2 = new Dispecer("Mikam", "456", "Mika", "Mikic", "978545", "Modene 2", Pol.MUSKI,
				2, 2000.0, "0211234", Odeljenje.Odeljenje_za_prijem_voznji);
		
		taxi_sluzba.dodajDispecera(dispecer1);
		taxi_sluzba.dodajDispecera(dispecer2);
		
		
		Musterija musterija1 = new Musterija("Simas", "789", "Sima", "Simic", "45634", "Bul Oslobodjenja 4",
				Pol.MUSKI, 1);
		System.out.println("Musteija je: " + musterija1);
		Musterija musterija2 = new Musterija("Maram", "913", "Mara", "Maric", "9876", "Bul Cara Lazara 5",
				Pol.ZENSKI, 2);
		
		taxi_sluzba.dodajMusteriju(musterija1);
		taxi_sluzba.dodajMusteriju(musterija2);
		
		taxi_sluzba.cuvanjeMusterije(MUSTERRIJA_FAJL);
		
		Automobil automobil1 = new Automobil(1, "a3", "Audi", 2016, "NS223TX", "1", VrstaAutomobila.putnicki);
		Automobil automobil2 = new Automobil(1, "Vento", "Mercedes", 2017, "NS768TX", "2", VrstaAutomobila.kombi);
		
		
		Vozac vozac1 = new Vozac("Petarp","abc", "Petar", "Petrovic", "534347",
				"Mihajla Pupina 8", Pol.MUSKI, 1, 1000.0, "1", automobil1);
		Vozac vozac2 = new Vozac("Lukal", "567", "Luka", "Lukic", "8674634",
				"Bul Oslobodjenja 45", Pol.MUSKI, 2, 1500.0, "1", automobil2);
		
		taxi_sluzba.dodajVozace(vozac1);
		taxi_sluzba.dodajVozace(vozac2);
		System.out.println("\nTaxi je: " + taxi_sluzba);
		
		taxi_sluzba.cuvanjeVozaca(VOZAC_FAJL);
		Voznja voznja1 = new Voznja(1, LocalDateTime.of(2020, 2, 3, 3, 5), "Ravanicka 5", "Modene 1", musterija1, vozac1, 3.0,
				5.0, StatusVoznje.zavrsena);
		Voznja voznja2 = new Voznja(2, LocalDateTime.of(2021, 5, 12, 8, 10), "Futoska 2", "Mihajla Puina 5", musterija2, vozac2, 5.5,
				8.0, StatusVoznje.zavrsena);
		
		taxi_sluzba.dodajVoznju(voznja1);
		taxi_sluzba.dodajVoznju(voznja2);
		
		taxi_sluzba.cuvanjeVoznji(VOZNJA_FAJL);
		
//		taxi_sluzba.cuvanjeDispecera(DISPECER_FAJL);
		
	}

}
