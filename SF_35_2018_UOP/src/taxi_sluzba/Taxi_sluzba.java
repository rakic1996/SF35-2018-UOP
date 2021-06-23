package taxi_sluzba;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;

import automobil.Automobil;
import automobil.VrstaAutomobila;
import main.Taxi_sluzbaMain;
import osobe.Dispecer;
import osobe.Korisnik;
import osobe.Musterija;
import osobe.Odeljenje;
import osobe.Pol;
import osobe.Uloga;
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
		this.dispeceri = new ArrayList<Dispecer>();
		this.musterije = new ArrayList<Musterija>();
		this.vozaci = new ArrayList<Vozac>();
		this.voznje = new ArrayList<Voznja>();
		this.automobili = new ArrayList<Automobil>();
	}

	public Taxi_sluzba(long id, int pib, String naziv, String adresa, int cena_start, int cena_km) {
		this();
		this.id = id;
		this.pib = pib;
		this.naziv = naziv;
		this.adresa = adresa;
		this.cena_start = cena_start;
		this.cena_km = cena_km;
	}
	
	public ArrayList<Dispecer> sviNeobrisaniDispeceri() {
		ArrayList<Dispecer> neobrisani = new ArrayList<Dispecer>();
		for (Dispecer dispecer : dispeceri) {
			if(!dispecer.isObrisan()) {
				neobrisani.add(dispecer);
			}
		}
		return neobrisani;
		
	}

	public void cuvanjeDispecera(String imeFajla) {
		try {
			File file = new File("src/fajlovi/" + imeFajla);
			String content = "";
			for (Dispecer dispecer : dispeceri) {
				content += dispecer.getKorIme() + "|" + dispecer.getLozinka() + "|" + dispecer.getIme() + "|"
						+ dispecer.getPrezime() + "|" + dispecer.getPol() + "|" + dispecer.getBrTelefona() + "|"
						+ dispecer.isObrisan() + "|"
						+ dispecer.getPlata() + "|" + dispecer.getTelefonska_linija() + "|" + dispecer.getOdeljenje() + "|"
						+ dispecer.getAdresa() + "|" + dispecer.getJmbg() + "|" + dispecer.getUloga() + "|" + "\n";
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
				String brTelefona = split[5];
				boolean obrisan = Boolean.parseBoolean(split[6]);
				double plata = Double.parseDouble(split[7]);
				String telefonska_linija = split[8];
				String odeljenjeString = split[9];
				Odeljenje odeljenje = Odeljenje.valueOf(odeljenjeString);
				String adresa = split[10];
				String jmbg = split[11];
				String ulogaString = split[12];
				Uloga uloga = Uloga.valueOf(ulogaString);
				Dispecer dispecer = new Dispecer(korIme, lozinka, ime, prezime, jmbg,
						adresa, pol, brTelefona, obrisan, plata,telefonska_linija, odeljenje, uloga);
				this.dispeceri.add(dispecer);
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja podataka o dispecerima");
			e.printStackTrace();
		}
	}
	
	
	///////////// CRUD ZA DISPECERE
	
	public void obrisiDispecereIzFajla(Dispecer dispecer, String imeFajla) {
		obrisiSveDispecereIzFajla(imeFajla);
		for (Dispecer d : dispeceri) {
			if (d.getKorIme().equals(dispecer.getKorIme())) {
				d.setObrisan(true);
			}
		}
		cuvanjeDispecera(imeFajla);

	}

	public void sacuvajDispecereUFajl(Dispecer dispecer, String imeFajla) {
		for (Dispecer d : dispeceri) {
			if (d.getKorIme().equals(dispecer.getKorIme())) {
				return;
			}
		}
		obrisiSveDispecereIzFajla(imeFajla);
		dispeceri.add(dispecer);
		cuvanjeDispecera(imeFajla);
	}
	
	public void izmeniDispeceraUFajlu(Dispecer dispecer, String imeFajla) {
		obrisiSveDispecereIzFajla(imeFajla);
		for (Dispecer d : dispeceri) {
			if (d.getKorIme().equals(dispecer.getKorIme())) {
				d.setAdresa(dispecer.getAdresa());
				d.setBrTelefona(dispecer.getBrTelefona());
				d.setIme(dispecer.getIme());
				d.setKorIme(dispecer.getKorIme());
				d.setPrezime(dispecer.getPrezime());
				d.setJmbg(dispecer.getJmbg());
				d.setPol(dispecer.getPol());
				d.setOdeljenje(dispecer.getOdeljenje());
				d.setTelefonska_linija(dispecer.getTelefonska_linija());
				d.setPlata(dispecer.getPlata());
			}
		}
		cuvanjeDispecera(imeFajla);
		
	}
	
	public void obrisiSveDispecereIzFajla(String imeFajla) {
		try {
			PrintWriter writer = new PrintWriter(imeFajla);
			writer.print("");
			writer.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	///////////////////////////
	public Korisnik login(String korIme, String lozinka) {
		for (Dispecer dis: dispeceri) {
			if (dis.getKorIme().equalsIgnoreCase(korIme) && dis.getLozinka().equals(lozinka) ) {
				return dis;
			}	  
		}
		for (Musterija m: musterije) {
			if (m.getKorIme().equalsIgnoreCase(korIme) && m.getLozinka().equals(lozinka) ) {
				return m;
			}	  
		}
		for (Vozac v: vozaci) {
			if (v.getKorIme().equalsIgnoreCase(korIme) && v.getLozinka().equals(lozinka) ) {
				return v;
			}	  
		}
		return null;
	}
	 
	public ArrayList<Musterija> sveNeobrisaneMuterije() {
		ArrayList<Musterija> neobrisani = new ArrayList<Musterija>();
		for (Musterija musterija : musterije) {
			if(!musterija.isObrisan()) {
				neobrisani.add(musterija);
			}
		}
		return neobrisani;
	}

	///////////////// CRUD ZA MUSTERIJE
	
//	public void obrisiMusterijeIzFajla(Musterija musterija, String imeFajla) {
//		obrisiSveMusterijeIzFajla(imeFajla);
//		for (Musterija m : musterije) {
//			if (m.getId() == musterija.getId()) {
//				m.setObrisan(true);
//			}
//		}
//		cuvanjeMusterije(imeFajla);
//
//	}
//
//	public void sacuvajMusterijeUFajl(Musterija musterija, String imeFajla) {
//		for (Musterija m : musterije) {
//			if (m.getId() == musterija.getId()) {
//				return;
//			}
//		}
//		obrisiSveMusterijeIzFajla(imeFajla);
//		musterije.add(musterija);
//		cuvanjeMusterije(imeFajla);
//	}
//	
//	public void izmeniMusterijeUFajlu(Musterija musterija, String imeFajla) {
//		obrisiSveMusterijeIzFajla(imeFajla);
//		for (Musterija m : musterije) {
//			if (m.getId() == musterija.getId()) {
//				m.setAdresa(musterija.getAdresa());
//				m.setBrTelefona(musterija.getBrTelefona());
//				m.setIme(musterija.getIme());
//				m.setKorIme(musterija.getKorIme());
//				m.setPrezime(musterija.getPrezime());
//				m.setJmbg(musterija.getJmbg());
//				m.setPol(musterija.getPol());
//				m.setId(musterija.getId());
//				
//			}
//		}
//		cuvanjeMusterije(imeFajla);
//		
//	}
//	
//	public void obrisiSveMusterijeIzFajla(String imeFajla) {
//		try {
//			PrintWriter writer = new PrintWriter(imeFajla);
//			writer.print("");
//			writer.close();
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
//	}
	
	////////////////

	public void dodajMusteriju(Musterija musterija) {
		for (Musterija m : musterije) {
			if (m.getKorIme().equals(musterija.getKorIme())) {
				return;
			}
		}
		this.musterije.add(musterija);
	}

	public void cuvanjeMusterije(String imeFajla) {
		try {
			File file = new File("src/fajlovi/" + imeFajla);
			String content = "";
			for (Musterija musterija : musterije) {
				content += musterija.getKorIme() + "|" + musterija.getLozinka() + "|" + musterija.getIme() + "|"
						+ musterija.getPrezime() + "|" + musterija.getJmbg() + "|" + musterija.getAdresa() + "|"
						+ musterija.getPol() + "|" + musterija.getBrTelefona() + "|"
						+ musterija.isObrisan() + "|" + musterija.getUloga() + "|" + "\n";
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
				String brTelefona = split[7];
				boolean obrisan = Boolean.parseBoolean(split[8]);
				Pol pol = Pol.valueOf(polString);
				String ulogaString = split[9];
				Uloga uloga = Uloga.valueOf(ulogaString);

				Musterija musterija = new Musterija(korIme, lozinka, ime, prezime, jmbg, adresa, pol, brTelefona, obrisan, uloga);
				this.musterije.add(musterija);
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja podataka o musterijama");
			e.printStackTrace();
		}
	}

	public ArrayList<Vozac> sviNeobrisaniVozaci() {
		ArrayList<Vozac> neobrisani = new ArrayList<Vozac>();
		for (Vozac vozac : vozaci) {
			if(!vozac.isObrisan()) {
				neobrisani.add(vozac);
			}
		}
		return neobrisani;
	}
	
	///////////////// CRUD ZA VOCAZE
	public void obrisiVozacaIzFajla(Vozac vozac, String imeFajla) {
		obrisiSveVozaceIzFajla(imeFajla);
		for (Vozac v : vozaci) {
			if (v.getKorIme().equals(vozac.getKorIme())) {
				v.setObrisan(true);
			}
		}
		cuvanjeVozaca(imeFajla);

	}
	
	public void sacuvajVozaceUFajl(Vozac vozac, String imeFajla) {
		for (Vozac v : vozaci) {
			if (v.getKorIme().equals(vozac.getKorIme())) {
				return;
			}
		}
		obrisiSveVozaceIzFajla(imeFajla);
		vozaci.add(vozac);
		cuvanjeVozaca(imeFajla);
	}
	
	public void izmeniVozaceUFajlu(Vozac vozac, String imeFajla) {
		obrisiSveVozaceIzFajla(imeFajla);
		for (Vozac v : vozaci) {
			if (v.getKorIme().equals(vozac.getKorIme())) {
				v.setAdresa(vozac.getAdresa());
				v.setBrTelefona(vozac.getBrTelefona());
				v.setClanska_karta(vozac.getClanska_karta());
				v.setIme(vozac.getIme());
				v.setKorIme(vozac.getKorIme());
				v.setPrezime(vozac.getPrezime());
				v.setJmbg(vozac.getJmbg());
				v.setPlata(vozac.getPlata());
				v.setAutomobil(vozac.getAutomobil());
				v.setLozinka(vozac.getLozinka());
				v.setPol(vozac.getPol());
				
			}
		}
		cuvanjeVozaca(imeFajla);
	}
	
	public void obrisiSveVozaceIzFajla(String imeFajla) {
		try {
			PrintWriter writer = new PrintWriter(imeFajla);
			writer.print("");
			writer.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	////////////////

	public void dodajVozace(Vozac vozac) {
		for (Vozac v : vozaci) {
			if (vozac.getKorIme().equals(v.getKorIme())) {
				return;
			}
		}
		this.vozaci.add(vozac);
	}

	public void cuvanjeVozaca(String imeFajla) {
		try {
			File file = new File("src/fajlovi/" + imeFajla);
			String content = "";
			for (Vozac vozac : vozaci) {
				content += vozac.getKorIme() + "|" + vozac.getLozinka() + "|" + vozac.getIme() + "|"
						+ vozac.getPrezime() + "|" + vozac.getPol() + "|" + vozac.getBrTelefona() + "|"
						+ vozac.isObrisan() + "|" + +vozac.getPlata() + "|"
						+ vozac.getAdresa() + "|" + vozac.getJmbg() + "|"
						+ vozac.getClanska_karta() + "|" + vozac.getAutomobil().getId() + "|" + vozac.getUloga() + "\n";
			}
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(content);
			writer.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja vozaca.");
		}
	}

	public void ucitajVozace(String imeFajla) {
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
				String brTelefona = split[5];
				Boolean obrisan = Boolean.parseBoolean(split[6]);
				double plata = Double.parseDouble(split[7]);
				String adresa = split[8];
				String jmbg = split[9];
				String clanska_karta = split[10];
				String idAutomobil = split[11];
				int automobilId = Integer.parseInt(idAutomobil);
				Automobil automobil = pronadjiAutomobil(automobilId);
				String ulogaString = split[12];
				Uloga uloga = Uloga.valueOf(ulogaString);

				Vozac vozac = new Vozac(korIme, lozinka, ime, prezime, jmbg, adresa, pol, brTelefona, obrisan, 
						plata, clanska_karta, automobil, uloga);
				this.vozaci.add(vozac);
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja podataka o vozacima");
			e.printStackTrace();
		}
	
	}
	

		
	public ArrayList<Voznja> sveNeobrisaneVoznje() {
		ArrayList<Voznja> neobrisani = new ArrayList<Voznja>();
		for (Voznja voznja : voznje) {
			if(!voznja.isObrisan()) {
				neobrisani.add(voznja);
			}
		}
		return neobrisani;
		
	}
		
	
	////////// CRUD ZA VOZNJE
	public void obrisiVoznjuIzFajla(Voznja voznja, String imeFajla) {
		obrisiSveVoznjeIzFajla(imeFajla);
		for (Voznja v : voznje) {
			if (v.getId() == voznja.getId()) {
				v.setObrisan(true);
			}
		}
		cuvanjeVoznji(imeFajla);
	}
	
	public void dodajVoznju(Voznja voznja) {
		this.voznje.add(voznja);
	}
	
	public void sacuvajVoznjuUFajl(Voznja voznja, String imeFajla) {
		for (Voznja v : voznje) {
			if (v.getId() == voznja.getId()) {
				return;
			}
		}
		obrisiSveVoznjeIzFajla(imeFajla);
		voznje.add(voznja);
		cuvanjeVoznji(imeFajla);
	}
	
	public void izmeniVoznjuUFajlu(Voznja voznja, String imeFajla) {
		obrisiSveVoznjeIzFajla(imeFajla);
		for (Voznja v : voznje) {
			if (v.getId() == voznja.getId()) {
				v.setAdresa_destinacije(voznja.getAdresa_destinacije());
				v.setAdresa_polaska(voznja.getAdresa_polaska());
				v.setDatum_porudzbine(voznja.getDatum_porudzbine());
				v.setPredjeni_km(voznja.getPredjeni_km());
				v.setStatus_voznje(voznja.getStatus_voznje());
				v.setTrajanje_voznje(voznja.getTrajanje_voznje());
				v.setMusterija(voznja.getMusterija());
				v.setVozac(voznja.getVozac());
			}
		}
		cuvanjeVoznji(imeFajla);
	}
	
	public void obrisiSveVoznjeIzFajla(String imeFajla) {
		try {
			PrintWriter writer = new PrintWriter(imeFajla);
			writer.print("");
			writer.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	////////////////////////////

	public void cuvanjeVoznji(String imeFajla) {
		try {
			File file = new File("src/fajlovi/" + imeFajla);
			String content = "";
			for (Voznja voznja : voznje) {
				content += voznja.getId() + "|" + voznja.getDatum_porudzbine() + "|" + voznja.getAdresa_polaska() + "|"
						+ voznja.getAdresa_destinacije() + "|" + voznja.getMusterija().getKorIme() + "|"
						+ voznja.getPredjeni_km() + "|" + voznja.getTrajanje_voznje() + "|" + voznja.getStatus_voznje()
						+ "|" + voznja.getVozac().getKorIme() + "|" + voznja.isObrisan() + "\n";
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
				LocalDateTime datum_por = LocalDateTime.of(Integer.parseInt(delovi_datuma[0]),
						Integer.parseInt(delovi_datuma[1]), Integer.parseInt(delovi_datuma[2]),
						Integer.parseInt(delovi_vremena[0]), Integer.parseInt(delovi_vremena[1]));
				String adresa_polaska = split[2];
				String adresa_destinacije = split[3];
				String musterijaKorIme = split[4];
				Musterija musterija = pronadjiMusteriju(musterijaKorIme);

				double predjeni_km = Double.parseDouble(split[5]);
				double trajanje_voznje = Double.parseDouble(split[6]);
				String status_voznje = split[7];
				StatusVoznje status = StatusVoznje.valueOf(status_voznje);
				String vozacKorIme = split[8];
				Vozac vozac = pronadjiVozaca(vozacKorIme);
				
				Boolean obrisan = Boolean.parseBoolean(split[9]);

				Voznja voznja = new Voznja(id, datum_por, adresa_polaska, adresa_destinacije, musterija, vozac,
						predjeni_km, trajanje_voznje, status, obrisan);
				this.voznje.add(voznja);
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja podataka o voznjama");
			e.printStackTrace();
		}
	}
	
	
//	public Dispecer pronadjiDispecera(int id) {
//		for (Dispecer dispecer : dispeceri) {
//			if (dispecer.getKorIme() == id) {
//				return dispecer;
//			}
//		}
//		return null;
//	}
	
	///////////PRETRAGA DISPECERA PO KORISNICKOM IMENU
	public Dispecer pronadjiDispecera(String korIme) {
		for (Dispecer dispecer : dispeceri) {
			if (dispecer.getKorIme() == korIme) {
				return dispecer;
			}
		}
		return null;
	}
	
	
	
	// ovo pronalazi dispecera preko korisnika tako sto dispecer nasledjuje korisnika
		// a samim tim sve sto ima korisnik ima i dispecer pa proveravamo da li im je
		// zajednicko polje isto?
	public Dispecer pronadjiDispeceraPrekoKorisnika(Korisnik korisnik) {
		for (Dispecer d : dispeceri) {
			if (d.getKorIme().equals(korisnik.getKorIme())) {
				return d;
			}
		}
		return null;
	}

	public Musterija pronadjiMusteriju(String korIme) {
		for (Musterija musterija : musterije) {
			if (musterija.getKorIme().equals(korIme)) {
				return musterija;
			}
		}
		return null;
	}
	
	public Musterija pronadjiMusterijuPrekoKorisnika(Korisnik korisnik) {
		for (Musterija m : musterije) {
			if (m.getKorIme().equals(korisnik.getKorIme())) {
				return m;
			}
		}
		return null;
	}

	public Vozac pronadjiVozaca(String korIme) {
		for (Vozac vozac : vozaci) {
			if (vozac.getKorIme().equals(korIme)) {
				return vozac;
			}
		}
		return null;
	}
	
	public Vozac pronadjiVozacaPrekoKorisnika(Korisnik korisnik) {
		for (Vozac v : vozaci) {
			if (v.getKorIme().equals(korisnik.getKorIme())) {
				return v;
			}
		}
		return null;
	}

	public Automobil pronadjiAutomobil(int id) {
		for (Automobil auto : automobili) {
			if (auto.getId() == id) {
				return auto;
			}
		}
		return null;
	}

	public void dodajAutomobil(Automobil automobil) {
		this.automobili.add(automobil);
	}

	public void cuvanjeAutomobila(String imeFajla) {
		try {
			File file = new File("src/fajlovi/" + imeFajla);
			String content = "";
			for (Automobil automobil : automobili) {
				content += automobil.getModel() + "|" + automobil.getProizvodjac() + "|" + automobil.getGodProizvodnje()
						+ "|" + automobil.getRegistracija() + "|" + automobil.getBrVozila() + "|"
						+ automobil.getVrstaAutomobila() + "|" + automobil.getId() + "|" + automobil.isObrisan() + "\n";
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
				Boolean obrisan = Boolean.parseBoolean(split[7]);
				Automobil automobil = new Automobil(id, model, proizvodjac, godina_proizvodnje, registracija,
						brojVozila, vrstaAutomobila, obrisan);
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

	public void dodajDispecera(Dispecer dispecer) {
		for (Dispecer d : dispeceri) {
			if (d.getKorIme().equals(dispecer.getKorIme())) {
				return;
			}
		}
		this.dispeceri.add(dispecer);
	}

	public void obrisiDispecere(Dispecer dispeceri) {
		this.dispeceri.remove(dispeceri);
	}

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

	
	
	///////////////OVO JE KAO U REFERENTOM SNIMI ZAPOSLENE SAMO STO OVDE NISU KORISNICI NEGO NESTO DRUGO(ULOGA DA LI MOZE?)
	
//	public void snimiKorisnike(String imeFajla) {
//		try {
//			File file = new File("src/fajlovi/" + imeFajla);
//			BufferedWriter br = new BufferedWriter(new FileWriter(file));
//			String sadrzaj = "";
//			for (Korisnik korisnik : Uloga) {//////////////OVO PROVERITI
//				sadrzaj += korisnik.getIme() + "|" + korisnik.getPrezime() + "|" + korisnik.getPol().ordinal() + "|" 
//						+ korisnik.getKorIme() + "|" + korisnik.getLozinka() + "|" + korisnik.isObrisan() + "\n";
//			}
//			br.write(sadrzaj);
//			br.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//	}

}