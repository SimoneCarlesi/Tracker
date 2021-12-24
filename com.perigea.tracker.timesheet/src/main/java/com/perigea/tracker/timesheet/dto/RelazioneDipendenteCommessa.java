package com.perigea.tracker.timesheet.dto;

import java.util.Date;

public class RelazioneDipendenteCommessa extends OrdineCommessa {
	
	private String codicePersona;
	private Date dataInizioAllocazione;
	private Date dataFineAllocazione;
	private double tariffa;
	private int giorniPrevisti;
	private int giorniErogati;
	private int giorniResidui;
	private double importoPrevisto;
	private double importoErogato;
	
	public RelazioneDipendenteCommessa(String codiceCommessa, String numeroOrdineCliente, String ragioneSocialeCliente,
			Date dataOrdine, double importoOrdine, Date dataInizio, Date dataFine, double importoResiduo,
			Date createTimestamp, Date lastUpdateTimestamp, String createUser, String lastUpdateUser,
			String codicePersona, Date dataInizioAllocazione, Date dataFineAllocazione, double tariffa,
			int giorniPrevisti, int giorniErogati, int giorniResidui, double importoPrevisto, double importoErogato) {
		super(codiceCommessa, numeroOrdineCliente, ragioneSocialeCliente, dataOrdine, importoOrdine, dataInizio,
				dataFine, importoResiduo, createTimestamp, lastUpdateTimestamp, createUser, lastUpdateUser);
		this.codicePersona = codicePersona;
		this.dataInizioAllocazione = dataInizioAllocazione;
		this.dataFineAllocazione = dataFineAllocazione;
		this.tariffa = tariffa;
		this.giorniPrevisti = giorniPrevisti;
		this.giorniErogati = giorniErogati;
		this.giorniResidui = giorniResidui;
		this.importoPrevisto = importoPrevisto;
		this.importoErogato = importoErogato;
	}

	public String getCodicePersona() {
		return codicePersona;
	}

	public void setCodicePersona(String codicePersona) {
		this.codicePersona = codicePersona;
	}

	public Date getDataInizioAllocazione() {
		return dataInizioAllocazione;
	}

	public void setDataInizioAllocazione(Date dataInizioAllocazione) {
		this.dataInizioAllocazione = dataInizioAllocazione;
	}

	public Date getDataFineAllocazione() {
		return dataFineAllocazione;
	}

	public void setDataFineAllocazione(Date dataFineAllocazione) {
		this.dataFineAllocazione = dataFineAllocazione;
	}

	public double getTariffa() {
		return tariffa;
	}

	public void setTariffa(double tariffa) {
		this.tariffa = tariffa;
	}

	public int getGiorniPrevisti() {
		return giorniPrevisti;
	}

	public void setGiorniPrevisti(int giorniPrevisti) {
		this.giorniPrevisti = giorniPrevisti;
	}

	public int getGiorniErogati() {
		return giorniErogati;
	}

	public void setGiorniErogati(int giorniErogati) {
		this.giorniErogati = giorniErogati;
	}

	public int getGiorniResidui() {
		return giorniResidui;
	}

	public void setGiorniResidui(int giorniResidui) {
		this.giorniResidui = giorniResidui;
	}

	public double getImportoPrevisto() {
		return importoPrevisto;
	}

	public void setImportoPrevisto(double importoPrevisto) {
		this.importoPrevisto = importoPrevisto;
	}

	public double getImportoErogato() {
		return importoErogato;
	}

	public void setImportoErogato(double importoErogato) {
		this.importoErogato = importoErogato;
	}
	

	

}
