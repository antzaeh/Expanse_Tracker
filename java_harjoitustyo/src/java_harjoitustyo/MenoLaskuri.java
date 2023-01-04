package java_harjoitustyo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class MenoLaskuri extends Menot implements Serializable{
	static ArrayList<Menot> menolista = new ArrayList<Menot>();
	static String viesti = "1. Syötä uusi meno 2. Näytä päivän menot 3. Hae menoja päivänmäärällä"
			+ " 4. Näytä yhteenveto pylväskaavio 5. Lue/tallenna menoja tiedostoon X. Lopetus";
	static MenoLaskuri meno = new MenoLaskuri();

	public static void main(String[] args) {
		System.out.println(viesti);

		Scanner s = new Scanner(System.in);
		String input = s.nextLine().toLowerCase();

		while (input != "x") {
			switch (input) {
			case "1":
				uusiMeno();
				System.out.println(viesti);
				input = s.nextLine().toLowerCase();
				break;
			case "2":
				laskeMenot();
				System.out.println(viesti);
				input = s.nextLine().toLowerCase();
				break;
			case "3":
				paivanMenot(menolista);
				System.out.println(viesti);
				input = s.nextLine().toLowerCase();
				break;
			case "4":

				System.out.println(viesti);
				input = s.nextLine().toLowerCase();
				break;
			case "5":
				tiedosto();
				System.out.println(viesti);
				input = s.nextLine().toLowerCase();
				break;
			case "x":
				System.exit(0);
			}
		}
	}

	private static void tiedosto() {
		System.out.println("1. Luetaan tiedostosta 2. Tallenetaan tiedostoon");
		Scanner s = new Scanner(System.in);
		String input = s.nextLine().toLowerCase();
		switch (input) {
		case "1":
			lueTiedosto();
			break;
		case "2":
			tallennaTiedosto();
			break;
			default:
				System.out.println("Virheellinen syöte");
				break;
		}

	}

	private static void tallennaTiedosto() {
		System.out.println("Where is your file located");
		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);
		String tiedosto = s.nextLine();
        try {
        	FileOutputStream fos = new FileOutputStream(tiedosto);
        	ObjectOutputStream file_out = new ObjectOutputStream(fos);
            file_out.writeObject(menolista);
            fos.close();
            file_out.close();
        }
        	
        
        catch(Exception e) {
            System.out.println("Problems with " + tiedosto);
            e.printStackTrace();
        }
		
	}

//F:\Koulu\Kakkosvuos\olio\testi.dat
	@SuppressWarnings("unchecked")
	private static void lueTiedosto() {
		System.out.println("Anna tiedoston polku");
		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);
		String tiedosto = s.nextLine();
        try (ObjectInputStream file_in 
            = new ObjectInputStream(new FileInputStream(tiedosto))){
            menolista = (ArrayList<Menot>)file_in.readObject();
            file_in.close();
        }
        catch(Exception e) {
            System.out.println("Ongelmia " + tiedosto + " kanssa");
            e.printStackTrace();
        }
     
	}

		
	

	private static void paivanMenot(ArrayList<Menot> menolista) {
		System.out.println("Etsi menoja päivänmäärällä \n" + "Syötä päivänmäärä muodossa pp.kk.vv");
		Scanner s = new Scanner(System.in);
		String etsi = s.nextLine();

		for (int i = 0; i < menolista.size(); i++) {
			if (menolista.get(i).getPvm().contains(etsi)) {
				System.out.println(menolista.get(i));
			}

		}
	}

	private static void uusiMeno() {
		String menoViesti = "1. Auto 2. Lasku 3. Kauppa 4. Viihde 5. Muu 0. Paluu";
		System.out.println("Syötä päivänmäärä muodossa pp.kk.vv");
		Scanner s = new Scanner(System.in);
		String pvm = s.nextLine();
		System.out.println(menoViesti);
		Scanner s1 = new Scanner(System.in);
		String input = s1.nextLine().toLowerCase();
		while (input != "x") {
			switch (input) {
			case "1": {
				String meno = "Auto";
				uusiMeno(pvm, meno);
				System.out.println(menoViesti);
				input = s.nextLine().toLowerCase();
				break;
			}
			case "2": {
				String meno = "Lasku";
				uusiMeno(pvm, meno);
				System.out.println(menoViesti);
				input = s.nextLine().toLowerCase();
				break;
			}

			case "3": {
				String meno = "Kauppa";
				uusiMeno(pvm, meno);
				System.out.println(menoViesti);
				input = s.nextLine().toLowerCase();
				break;
			}
			case "4": {
				String meno = "Viihde";
				uusiMeno(pvm, meno);
				System.out.println(menoViesti);
				input = s.nextLine().toLowerCase();
				break;
			}

			case "5": {
				String meno = "Muu";
				uusiMeno(pvm, meno);
				System.out.println(menoViesti);
				input = s.nextLine().toLowerCase();
				break;
			}

			case "0": {
				return;
			}
			default:
				System.out.println("Virheellinen valinta");
				System.out.println(menoViesti);
				break;
			}
		}

	}

	@SuppressWarnings("resource")
	private static void uusiMeno(String pvm, String meno) {
		String kategoria = meno;
		System.out.println(kategoria);
		System.out.println("Hinta");
		Scanner s1 = new Scanner(System.in);
		double hinta = s1.nextDouble();
		System.out.println("Kuvaus");
		Scanner s2 = new Scanner(System.in);
		String kuvaus = s2.nextLine();
		menolista.add(new Menot(kategoria, hinta, kuvaus, pvm));
		System.out.println(menolista);
		return;

	}

	public static void laskeMenot() {

		double menot = 0;
		for (int i = 0; i < menolista.size(); i++) {
			menot += menolista.get(i).getHinta();
		}
		System.out.println("Menot yhteensä: " + menot);
		System.out.println(menolista);
	}
}
