package no.hvl.data102;

import no.hvl.dat102.LinearNode;
import no.hvl.data102.Film.Sjanger;
import no.hvl.data102.adt.FilmarkivADT;

public class Filmarkiv2 implements FilmarkivADT {

	private int antall;
	private LinearNode<Film> start;

	public Filmarkiv2() {
		start = null;
		antall = 0;
	}

	@Override
	public Film[] hentFilmtab() {
		Film[] filmtab = new Film[antall];
		LinearNode<Film> node = start;
		int i = 0;
		while (i < antall && node != null) {
			filmtab[i] = node.getElement();
			node = node.getNeste();
			i++;
		}
		return filmtab;
	}

	@Override
	public void leggTilFilm(Film nyFilm) {
	
		LinearNode<Film> temp = new LinearNode<Film>(nyFilm);

		temp.setNeste(start);
		start = temp;
		antall++;
		
	}
	private LinearNode<Film> finnFilm(int filmnr) {
		LinearNode<Film> p = start;
		LinearNode<Film> q = start;
		while (p != null) {
			if (p.getElement().getFilmnummer() == filmnr) {
				return q;
			}
			q = p;
			p = p.getNeste();
			
		}
		return null;
	}

	@Override
	public boolean slettFilm(int filmnr) {
//		boolean slettet = false;
//		LinearNode<Film> node = start;
//		LinearNode<Film> forrigenode = null;
//		
//		for(int i = 0; (node !=null && !slettet); i++) {
//			if(node.getElement().getFilmnummer() == filmnr && i!= 0){
//				start = node.getNeste();
//				antall--;
//				slettet = true;
//			}
//			else if(node.getElement().getFilmnummer() == filmnr) {
//				forrigenode.setNeste(node.getNeste());
//				antall--;
//				slettet = true;
//			}
//			forrigenode = node;
//			node = node.getNeste();
//		}
//		return slettet;
		//***************************************************************************
		boolean slettet = false;
	
		// 1. må søke etter node og sammenlige filmnr
		LinearNode<Film> node = finnFilm(filmnr);
		
		// 2. Slette filmen
		if (node != null) {
			node.setNeste(node.getNeste());
			node = start;
			antall--;
			slettet = true;
		}
		// 3. returnerer true hvis noden blir slettet
		return slettet;
		}
		
	

	@Override
	public Film[] søkTittel(String delstreng) {
		
		Film[] filmtab = new Film[antall];
		LinearNode<Film> node = start;
		int i = 0;
		while(i<antall && node !=null) {
			if(node.getElement().getTittel().contains(delstreng)) {
				filmtab[i] = node.getElement();
			}
			node = node.getNeste();
			i++;
		}
 		return filmtab;
	}

	@Override
	public Film[] søkProdusent(String delstreng) {
		Film[] filmtab = new Film[antall];
		LinearNode<Film> node = start;
		int i = 0;
		while(i<antall && node !=null) {
			if(node.getElement().getProdusent().contains(delstreng)) {
				filmtab[i] = node.getElement();
			}
			node = node.getNeste();
			i++;
		}
 		return filmtab;
	}

	@Override
	public int antall(Sjanger sjanger) {
		int antallsjanger = 0;
		LinearNode<Film> node = start;
		int i = 0;
		while(i<antall && node != null) {
			if(node.getElement().getSjanger().equals(sjanger)) {
				antallsjanger++;
			}
			node = node.getNeste();
			i++;
			
		}
		return antallsjanger;
		
		
	}

	@Override
	public int antall() {
		return antall;
	}

}
