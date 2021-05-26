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
import gui.LoginProzor;

public class Taxi_sluzbaMain {
	private static String DISPECER_FAJL = "dispeceri.txt";
	private static String MUSTERRIJA_FAJL = "musterije.txt";
	private static String VOZAC_FAJL = "vozaci.txt";
	private static String VOZNJA_FAJL = "voznje.txt";

	public static void main(String[] args) {
		Taxi_sluzba taxi_sluzba = new Taxi_sluzba();
		taxi_sluzba.ucitajDispecere(DISPECER_FAJL);
		taxi_sluzba.ucitajMusterije(MUSTERRIJA_FAJL);
		taxi_sluzba.ucitajVoznje(VOZNJA_FAJL);
		taxi_sluzba.ucitajVozace(VOZAC_FAJL);

		LoginProzor lp = new LoginProzor(taxi_sluzba);
		lp.setVisible(true);

	}

}
