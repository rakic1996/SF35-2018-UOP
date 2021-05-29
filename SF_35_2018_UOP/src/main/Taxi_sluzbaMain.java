package main;

import java.time.LocalDateTime;

import automobil.Automobil;
import automobil.VrstaAutomobila;
import gui.LoginProzor;
import gui.FormeZaPrikaz.DispeceriProzor;
import gui.FormeZaPrikaz.MusterijaProzor;
import gui.FormeZaPrikaz.VozacProzor;
import osobe.Dispecer;
import osobe.Musterija;
import osobe.Odeljenje;
import osobe.Pol;
import osobe.Uloga;
import osobe.Vozac;
import taxi_sluzba.Taxi_sluzba;
import voznja.StatusVoznje;
import voznja.Voznja;

public class Taxi_sluzbaMain {
	private static String DISPECER_FAJL = "dispeceri.txt";
	public static String MUSTERRIJA_FAJL = "musterije.txt";
	public static String VOZAC_FAJL = "vozaci.txt";
	public static String VOZNJA_FAJL = "voznje.txt";
	public static String AUTOMOBILI_FAJL = "automobili.txt";

	public static void main(String[] args) {
		Taxi_sluzba taxi_sluzba = new Taxi_sluzba(1, 123, "Crveni taxi", "Fruskogorska 1", 90, 40 );
		
		saveData(taxi_sluzba);
		
		taxi_sluzba.ucitajDispecere(DISPECER_FAJL);
		taxi_sluzba.ucitajMusterije(MUSTERRIJA_FAJL);
		taxi_sluzba.ucitajVoznje(VOZNJA_FAJL);
		taxi_sluzba.ucitajAutomobile(AUTOMOBILI_FAJL);
		taxi_sluzba.ucitajVozace(VOZAC_FAJL);
		
		System.out.println(taxi_sluzba.toString());  

		
		
		
		

		
		LoginProzor lp = new LoginProzor(taxi_sluzba);
		lp.setVisible(true);
		
//		DispeceriProzor dp = new DispeceriProzor(taxi_sluzba);
//		dp.setVisible(true);
//		
//		MusterijaProzor mp = new MusterijaProzor(taxi_sluzba);
//		mp.setVisible(true);
//		
//		VozacProzor vp = new VozacProzor(taxi_sluzba);
//		vp.setVisible(true);

	}
	
	private static void saveData(Taxi_sluzba taxi_sluzba) {
		Dispecer dispecer1 = new Dispecer("Perap", "123", "Pera", "Peric", "123456",
				  "Narodnog fronta 2", Pol.MUSKI, "1223456", false, 1, 1000.0, "0211234",
				  Odeljenje.Odeljenje_za_prijem_voznji, Uloga.DISPECER); 
		Dispecer dispecer2 = new Dispecer("Mikam", "456", "Mika", "Mikic", "978545",
						  "Modene 2", Pol.MUSKI, "785634", false, 2, 2000.0, "0211234",
						  Odeljenje.Odeljenje_za_prijem_voznji, Uloga.DISPECER); 
		
		taxi_sluzba.dodajDispecera(dispecer1); 
		taxi_sluzba.dodajDispecera(dispecer2);
		taxi_sluzba.cuvanjeDispecera(DISPECER_FAJL);
		
		
		Musterija musterija1 = new Musterija("Simas", "789", "Sima", "Simic",
							 "45634", "Bul Oslobodjenja 4", Pol.MUSKI, "854523", false, 1, Uloga.MUSTERIJA);
		Musterija musterija2 = new Musterija("Maram", "913", "Mara", "Maric", "9876", "Bul Cara Lazara 5",
							  Pol.ZENSKI, "0903450", false, 2, Uloga.MUSTERIJA);
		
		taxi_sluzba.dodajMusteriju(musterija1);
		taxi_sluzba.dodajMusteriju(musterija2);
		taxi_sluzba.cuvanjeMusterije(MUSTERRIJA_FAJL);
		
		
		Automobil automobil1 = new Automobil(1, "a3", "Audi", 2016, "NS223TX", "1", VrstaAutomobila.putnicki, false); 
		Automobil automobil2 = new Automobil(2, "Vento","Mercedes", 2017, "NS768TX", "2", VrstaAutomobila.kombi, false);
		
		taxi_sluzba.dodajAutomobil(automobil1);
		taxi_sluzba.dodajAutomobil(automobil2);
		taxi_sluzba.cuvanjeAutomobila(AUTOMOBILI_FAJL);
		
		Vozac vozac1 = new Vozac("Petarp","abc", "Petar", "Petrovic", "534347",
				 "Mihajla Pupina 8", Pol.MUSKI, "04231245", false, 1, 1000.0, "1", automobil1, Uloga.VOZAC); 
		Vozac vozac2 = new Vozac("Lukal", "567", "Luka", "Lukic", "8674634", "Bul Oslobodjenja 45",
				Pol.MUSKI, "12054956", false, 2, 1500.0, "1", automobil2, Uloga.VOZAC); 
		
		taxi_sluzba.dodajVozace(vozac1); 
		taxi_sluzba.dodajVozace(vozac2);
		taxi_sluzba.cuvanjeVozaca(VOZAC_FAJL); 
		
		
		Voznja voznja1 = new Voznja(1, LocalDateTime.of(2020, 2, 3, 3, 5), "Ravanicka 5", "Modene 1", musterija1,
					  vozac1, 3.0, 5.0, StatusVoznje.zavrsena, false); 
		Voznja voznja2 = new Voznja(2, LocalDateTime.of(2021, 5, 12, 8, 10), "Futoska 2", "Mihajla Puina 5",
					  musterija2, vozac2, 5.5, 8.0, StatusVoznje.zavrsena, false);
		
		taxi_sluzba.dodajVoznju(voznja1); 
		taxi_sluzba.dodajVoznju(voznja2);
		taxi_sluzba.cuvanjeVoznji(VOZNJA_FAJL);
		
		
		// CRUD
//		taxi_sluzba.obrisiVoznju(voznja1, VOZNJA_FAJL);
		
		
		Voznja voznja3 = new Voznja(3, LocalDateTime.of(2021, 5, 12, 8, 10), "Futoska 2", "Mihajla Puina 5",
				  musterija2, vozac2, 5.5, 8.0, StatusVoznje.zavrsena, false);
		taxi_sluzba.sacuvajVoznjuUFajl(voznja3, VOZNJA_FAJL);
		voznja3.setAdresa_destinacije("EDITOVANAAAAA");
		
		taxi_sluzba.izmeniVoznjuUFajlu(voznja3, VOZNJA_FAJL);
	}
	
//	private static void crud(Taxi_sluzba taxi_sluzba) {
//		
//	}

}
