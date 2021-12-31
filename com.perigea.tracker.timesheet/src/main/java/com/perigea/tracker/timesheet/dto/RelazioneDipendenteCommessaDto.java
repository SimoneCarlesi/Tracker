package com.perigea.tracker.timesheet.dto;

import java.util.Date;

public class RelazioneDipendenteCommessaDto {

	private String codiceCommessa;
	private String codicePersona;
	private Date dataInizioAllocazione;
	private Date dataFineAllocazione;
	private Double tariffa;
	private Integer giorniPrevisti;
	private Integer giorniErogati;
	private Integer giorniResidui;
	private Double importoPrevisto;
	private Double importoErogato;
	private Double importoResiduo;
	private String createUser;
	private String lastUpdateUser;

	public RelazioneDipendenteCommessaDto() {
		super();

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

	public Double getTariffa() {
		return tariffa;
	}

	public void setTariffa(Double tariffa) {
		this.tariffa = tariffa;
	}

	public Integer getGiorniPrevisti() {
		return giorniPrevisti;
	}

	public void setGiorniPrevisti(Integer giorniPrevisti) {
		this.giorniPrevisti = giorniPrevisti;
	}

	public Integer getGiorniErogati() {
		return giorniErogati;
	}

	public void setGiorniErogati(Integer giorniErogati) {
		this.giorniErogati = giorniErogati;
	}

	public Integer getGiorniResidui() {
		return giorniResidui;
	}

	public void setGiorniResidui(Integer giorniResidui) {
		this.giorniResidui = giorniResidui;
	}

	public Double getImportoPrevisto() {
		return importoPrevisto;
	}

	public void setImportoPrevisto(Double importoPrevisto) {
		this.importoPrevisto = importoPrevisto;
	}

	public Double getImportoErogato() {
		return importoErogato;
	}

	public void setImportoErogato(Double importoErogato) {
		this.importoErogato = importoErogato;
	}

	public String getCodiceCommessa() {
		return codiceCommessa;
	}

	public void setCodiceCommessa(String codiceCommessa) {
		this.codiceCommessa = codiceCommessa;
	}

	public Double getImportoResiduo() {
		return importoResiduo;
	}

	public void setImportoResiduo(Double importoResiduo) {
		this.importoResiduo = importoResiduo;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getLastUpdateUser() {
		return lastUpdateUser;
	}

	public void setLastUpdateUser(String lastUpdateUser) {
		this.lastUpdateUser = lastUpdateUser;
	}

	
}
