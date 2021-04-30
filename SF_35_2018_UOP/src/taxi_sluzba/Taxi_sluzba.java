package taxi_sluzba;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.event.InternalFrameEvent;

import automobil.Automobil;
import automobil.VrstaAutomobila;
import osobe.Dispecer;
import osobe.Musterija;
import osobe.Odeljenje;
import osobe.Pol;
import osobe.Vozac;
import voznja.StatusVoznje;
import voznja.Voznja;

public class Taxi_sluzba {
	
	private long id;
	private int pib;
	private String naziv;
	private String adresa;
	private int cena_start;
	private int cena_km;
	
	private ArrayList<Dispecer> dispeceri;
	private ArrayList<Musterija> musterije;
	private ArrayList<Vozac> vozaci;
	private ArrayList<Voznja> voznje;
	private ArrayList<Automobil> automobili;
	
	
	
	public Taxi_sluzba() {
		
		this.dispeceri= new ArrayList<Dispecer>();
		this.musterije = new ArrayList<Musterija>();
		this.vozaci = new ArrayList<Vozac>();
		this.voznje = new ArrayList<Voznja>();
		this.automobili = new ArrayList<Automobil>();
		
	}
	
	


	public Taxi_sluzba(long id, int pib, String naziv, String adresa, int cena_start, int cena_km) {
		super();
		this.id = id;
		this.pib = pib;
		this.naziv = naziv;
		this.adresa = adresa;
		this.cena_start = cena_start;
		this.cena_km = cena_km;
		this.dispeceri= new ArrayList<Dispecer>();
		this.musterije = new ArrayList<Musterija>();
		this.vozaci = new ArrayList<Vozac>();
		this.voznje = new ArrayList<Voznja>();
		this.automobili = new ArrayList<Automobil>();
	
	}
	
	
	public void dodajDispecera(Dispecer dispecer) {
		this.dispeceri.add(dispecer);
	}
	

	public void cuvanjeDispecera(String imeFajla) {
		try {
			File file = new File("src/fajlovi/" + imeFajla);
			String content = "";
			for (Dispecer dispecer : dispeceri) {
				content += dispecer.getKorIme() + "|" + dispecer.getLozinka() + "|"
						+ dispecer.getIme() + "|" + dispecer.getPrezime() + "|"
						+ dispecer.getPol() + "|" + dispecer.getId() + "|"
						+ dispecer.getPlata() + "|" + dispecer.getTelefonska_linija() 
						+ "|" + dispecer.getOdeljenje()+ "|" + dispecer.getAdresa() 
						+ "|" + dispecer.getJmbg() + "\n";
			}
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(content);
			writer.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja dispecera.");
		}
	}
		

	public void ucitajDispecere(String imeFajla) {
		try {
			File file = new File("src/fajlovi/" + imeFajla);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while ((line = reader.readLine()) != null) {
				String[] split = line.split("\\|");
				String korIme = split[0];
				String lozinka = split[1];
				String ime = split[2];
				String prezime = split[3];
				String polString = split[4];
				Pol pol = Pol.valueOf(polString);
				String idString = split[5];
				int id = Integer.parseInt(idString);
				double plata = Double.parseDouble(split[6]);
				String telefonska_linija = split[7];
				String odeljenjeString = split[8];
				Odeljenje odeljenje = Odeljenje.valueOf(odeljenjeString);
				String adresa = split[9];
				String jmbg = split[10];
				Dispecer dispecer = new Dispecer(korIme, lozinka, ime, prezime,
						jmbg, adresa, pol, id, plata, telefonska_linija, odeljenje);
				this.dispeceri.add(dispecer);
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja podataka o dispecerima");
			e.printStackTrace();
		}
	}



		
	public void dodajMusteriju(Musterija musterija) {
		this.musterije.add(musterija);
	}
	
	
	public void cuvanjeMusterije(String imeFajla) {
		try {
			File file = new File("src/fajlovi/" + imeFajla);
			String content = "";
			for (Musterija musterija : musterije) {
				content += musterija.getKorIme() + "|" + musterija.getLozinka() + "|"
						+ musterija.getIme() + "|" + musterija.getPrezime() + "|"
						+ musterija.getJmbg() + "|" + musterija.getAdresa() + "|"
						+ musterija.getPol() + "|" + musterija.getId() + "|"  +"\n";
			}
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(content);
			writer.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja musterija.");
		}
	}
		
	
	
	public void ucitajMusterije(String imeFajla) {
		try {
			File file = new File("src/fajlovi/" + imeFajla);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while ((line = reader.readLine()) != null) {
				String[] split = line.split("\\|");
				String korIme = split[0];
				String lozinka = split[1];
				String ime = split[2];
				String prezime = split[3];
				String jmbg = split[4];
				String adresa = split[5];
				String polString = split[6];
				Pol pol = Pol.valueOf(polString);
				String idString = split[7];
				int id = Integer.parseInt(idString);
				Musterija musterija = new Musterija(korIme, lozinka, ime, prezime,
						jmbg, adresa, pol, id);
				this.musterije.add(musterija);
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja podataka o musterijama");
			e.printStackTrace();
		}		
		
	}
		
	public void dodajVozace(Vozac vozac) {
		this.vozaci.add(vozac);
	}
	
	
	public void cuvanjeVozaca(String imeFajla) {
		try {
			File file = new File("src/fajlovi/" + imeFajla);
			String content = "";
			for (Vozac vozac : vozaci) {
				content += vozac.getKorIme() + "|" + vozac.getLozinka() + "|"
						+ vozac.getIme() + "|" + vozac.getPrezime() + "|"
						+ vozac.getPol() + "|" + + vozac.getPlata() + "|"  + "|" + vozac.getAdresa() 
						+ vozac.getJmbg() + vozac.getId() + "|" + vozac.getPlata() 
						+ vozac.getClanska_karta() + vozac.getAutomobil() + "\n";
			}
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(content);
			writer.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja vozaca.");
		}
	}
		
	

	public void dodajVoznju(Voznja voznja) {
		this.voznje.add(voznja);
	}
		
	public void cuvanjeVoznji(String imeFajla) {
		try {
			File file = new File("src/fajlovi/" + imeFajla);
			String content = "";
			for (Voznja voznja : voznje) {
				content += voznja.getId() + "|" + voznja.getDatum_porudzbine() + "|"
						+ voznja.getAdresa_polaska() + "|" + voznja.getAdresa_destinacije() + "|"
						+ voznja.getMusterija().getId() + "|" + voznja.getPredjeni_km() + "|"
						+ voznja.getTrajanje_voznje() + "|" + voznja.getStatus_voznje() + "|" + voznja.getVozac().getId() + "|" + voznja.getVozac().getAutomobil().getId() +"\n";
			}
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(content);
			writer.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja voznje.");
		}
	}
				
				
	public void ucitajVoznje(String imeFajla) {
		try {
			File file = new File("src/fajlovi/" + imeFajla);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while ((line = reader.readLine()) != null) {
				String[] split = line.split("\\|");
				String idString = split[0];
				int id = Integer.parseInt(idString);
				String datum_porudzbine = split[1];
				String[] datum = datum_porudzbine.split("T");
				String[] delovi_datuma = datum[0].split("-");
				String[] delovi_vremena = datum[1].split(":");
				LocalDateTime datum_por = LocalDateTime.of(Integer.parseInt(delovi_datuma[0]), Integer.parseInt(delovi_datuma[1]), Integer.parseInt(delovi_datuma[2]),
						Integer.parseInt(delovi_vremena[0]), Integer.parseInt(delovi_vremena[1]));
				String adresa_polaska = split[2];
				String adresa_destinacije = split[3];
				String musterijaString = split[4];
				int musterijaId = Integer.parseInt(musterijaString);
				Musterija musterija = pronadjiMusteriju(musterijaId);
				String vozacString = split[8];
				int vozacId = Integer.parseInt(vozacString);
				
				Vozac vozac = pronadjiVozaca(vozacId);
				double predjeni_km = Double.parseDouble(split[5]);
				double trajanje_voznje = Double.parseDouble(split[6]);
				String status_voznje = split[7];
				StatusVoznje status = StatusVoznje.valueOf(status_voznje);
				Voznja voznja = new Voznja(id, datum_por, adresa_polaska,
						adresa_destinacije, musterija, vozac, predjeni_km, trajanje_voznje,
						status);
				this.voznje.add(voznja);
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja podataka o voznjama");
			e.printStackTrace();
		}
	}
	
	public Musterija pronadjiMusteriju(int id) {
		for(Musterija musterija: musterije) {
			if(musterija.getId() == id) {
				return musterija;
			}
		}
		return null;
	}
	
	public Vozac pronadjiVozaca(int id) {
		for(Vozac vozac: vozaci) {
			if(vozac.getId() == id) {
				return vozac;
			}
		}
		return null;
	}
	
	public Automobil pronadjiAutomobil(int id) {
		for(Vozac vozac: vozaci) {
			if(vozac.getAutomobil().getId() == id) {
				return vozac.getAutomobil();
			}
		}
		return null;
	}
	
	
			
			
			
	public void dodajAutomobil(Automobil automobil) {
		this.automobili.add(automobil);
	}
	

	public void cuvanjeAtomobila(String imeFajla) {
		try {
			File file = new File("src/fajlovi/" + imeFajla);
			String content = "";
			for (Automobil automobil : automobili) {
				content += automobil.getModel() + "|" + automobil.getProizvodjac() + "|"
						+ automobil.getGodProizvodnje() + "|" + automobil.getRegistracija() + "|"
						+ automobil.getBrVozila() + "|" + automobil.getVrstaAutomobila() + automobil.getId() + "\n";
			}
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(content);
			writer.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja automobila.");
		}
	}
		

	public void ucitajAutomobile(String imeFajla) {
		try {
			File file = new File("src/fajlovi/" + imeFajla);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while ((line = reader.readLine()) != null) {
				String[] split = line.split("\\|");
				String model = split[0];
				String proizvodjac = split[1];
				String godina_proizvodnjeString = split[2];
				int godina_proizvodnje = Integer.parseInt(godina_proizvodnjeString);
				String registracija = split[3];
				String brojVozila = split[4];
				String vrstaAutomobilaString = split[5];
				String idString = split[6];
				int id = Integer.parseInt(idString);
				VrstaAutomobila vrstaAutomobila = VrstaAutomobila.valueOf(vrstaAutomobilaString);
				Automobil automobil = new Automobil(id, model, proizvodjac, godina_proizvodnje,
						registracija, brojVozila, vrstaAutomobila);
				this.automobili.add(automobil);
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja podataka o automobilima");
			e.printStackTrace();
	}
		
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getPib() {
		return pib;
		
	}

	public void setPib(int pib) {
		this.pib = pib;
	}


	public String getNaziv() {
		return naziv;
	}


	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}


	public int getCena_start() {
		return cena_start;
	}


	public void setCena_start(int cena_start) {
		this.cena_start = cena_start;
	}


	public int getCena_km() {
		return cena_km;
	}


	public void setCena_km(int cena_km) {
		this.cena_km = cena_km;
	}


	public void setDispeceri(ArrayList<Dispecer> dispeceri) {
		this.dispeceri = dispeceri;
	}


	public void setMusterije(ArrayList<Musterija> musterije) {
		this.musterije = musterije;
	}
	


	public void setVozaci(ArrayList<Vozac> vozaci) {
		this.vozaci = vozaci;
	}

	public ArrayList<Dispecer> getDispeceri() {
		return dispeceri;
	}
	
	public void dodajDispecere(Dispecer dispeceri) {
		this.dispeceri.add(dispeceri);
	}
	
	public void obrisiDispecere(Dispecer dispeceri) {
		this.dispeceri.remove(dispeceri);
	}
	
	//////////////////////////////////////

	public ArrayList<Voznja> getVoznje() {
		return voznje;
	}




	public void setVoznje(ArrayList<Voznja> voznje) {
		this.voznje = voznje;
	}




	public ArrayList<Automobil> getAutomobili() {
		return automobili;
	}




	public void setAutomobili(ArrayList<Automobil> automobili) {
		this.automobili = automobili;
	}




	public ArrayList<Musterija> getMusterije() {
		return musterije;
	}




	public ArrayList<Vozac> getVozaci() {
		return vozaci;
	}




	@Override
	public String toString() {
		return "Taxi_sluzba [id=" + id + ", pib=" + pib + ", naziv=" + naziv + ", adresa=" + adresa + ", cena_start="
				+ cena_start + ", cena_km=" + cena_km + ", dispeceri=" + dispeceri + ", musterije=" + musterije
				+ ", vozaci=" + vozaci + ", voznje=" + voznje + ", automobili=" + automobili + "]";
	}

		
}