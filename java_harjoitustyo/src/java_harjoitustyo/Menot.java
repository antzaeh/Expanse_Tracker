/***************************************************************************
*   Copyright (C) 2022 by Antti Kruuti & Miika Rinta-Korkeamäki   *
*   e2101587@edu.vamk.fi & e1900516@edu.vamk.fi   *
*                                                                         *
*   This program is free software; you can redistribute it and/or modify  *
*   it under the terms of the GNU General Public License as published by  *
*   the Free Software Foundation; either version 2 of the License, or     *
*   (at your option) any later version.                                   *
*                                                                         *
*   This program is distributed in the hope that it will be useful,       *
*   but WITHOUT ANY WARRANTY; without even the implied warranty of        *
*   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the         *
*   GNU General Public License for more details.                          *
*                                                                         *
*   You should have received a copy of the GNU General Public License     *
*   along with this program; if not, write to the                         *
*   Free Software Foundation, Inc.,                                       *
*   59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.             *
***************************************************************************/

/*********************************************************************

 1.  NAME

  Menot

 2.  DESCRIPTION

  Program, that includes attributes with getters and setters for Menolaskuri.java

 3.  VERSIONS
       Original:
         10.12.2022 / MRK

       Version history:

**********************************************************************/

package java_harjoitustyo;

import java.io.Serializable;

public class Menot implements Serializable{
	
	public Menot(String kategoria, double hinta, String kuvaus, String pvm) {
		super();
		this.kategoria = kategoria;
		this.hinta = hinta;
		this.kuvaus = kuvaus;
		this.pvm = pvm;
	}
	public Menot() {
		super();
	}
	private String kategoria;
	private double hinta;
	private String kuvaus;
	private String pvm;
	
	public String getKategoria() {
		return kategoria;
	}
	public void setKategoria(String kategoria) {
		this.kategoria = kategoria;
	}
	public double getHinta() {
		return hinta;
	}
	public void setHinta(double hinta) {
		this.hinta = hinta;
	}
	public String getKuvaus() {
		return kuvaus;
	}
	public void setKuvaus(String kuvaus) {
		this.kuvaus = kuvaus;
	}
	public String getPvm() {
		return pvm;
	}
	public void setPvm(String pvm) {
		this.pvm = pvm;
	}
	@Override
	public String toString() {
		return "Menot [kategoria= " + kategoria + ", hinta= " + hinta + ", kuvaus= " + kuvaus + ", pvm= " + pvm + "]";
	}
}
