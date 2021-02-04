package no.hvl.data102;

import java.util.Scanner;

import no.hvl.data102.Film.Sjanger;
import no.hvl.data102.adt.FilmarkivADT;

public class Testgrensesnitt {
	
	public static void main(String[] args) {
		Film g = lesFilm();
		
		System.out.println(g);
		
	}

	public static Film lesFilm(){
		Scanner inf = new Scanner(System.in);
		
		System.out.println("Filmnummer: ");
		int filmnummer = inf.nextInt();

		System.out.println("Produsent: ");
		String produsent = inf.nextLine();

		inf.nextLine();
		System.out.println("Tittel: ");
		String tittel = inf.nextLine();

		System.out.println("År: ");
		int år = inf.nextInt();

		System.out.println("Selskap: ");
		String selskap = inf.nextLine();
		inf.nextLine();

		System.out.println("Sjanger: ");
		Sjanger sjanger = Sjanger.valueOf(inf.nextLine().toUpperCase());

		
		Film ny = new Film(filmnummer, produsent, tittel, år, sjanger, selskap);
		
		inf.close();
		return ny;
		

	}
	
	public void visFilm(Film film) {
		
		
		
	}

	public void delstrengSkrivUt(String delstreng, FilmarkivADT filmer) {

		Film[] tab = filmer.hentFilmtab();

		for (int i = 0; i < tab.length; i++) {

			if (tab[i].getTittel().contains(delstreng)) {
				System.out.println(tab[i].getTittel());
			}

		}

	}

	public void produsentSkrivUt(FilmarkivADT filmer, String produsent) {

		Film[] tab = filmer.hentFilmtab();

		System.out.println("Filmer av: " + produsent);
		System.out.println();

		for (int i = 0; i < tab.length; i++) {
			if (tab[i].getProdusent().equals(produsent)) {
				System.out.println(tab[i].getTittel());
			}
		}

	}

	public void statistikk(FilmarkivADT filmer) {

		System.out.println("Antall filmer totalt:");
		System.out.println(filmer.antall());

		System.out.println("Antall filmer i hver sjanger: ");

		Film[] tab = filmer.hentFilmtab();
		int antall = 0;
//		int sjantall = Sjanger.values().length;

		for (Sjanger sjang : Sjanger.values()) {

			System.out.print("Antall filmer i sjanger" + sjang + ":");
			antall = 0;
			for (int i = 0; i < tab.length; i++) {
				if (tab[i].getSjanger().equals(sjang)) {
					antall++;
				}
			}
			System.out.println(antall);

		}

		System.out.println("Antall ");

	}

}
