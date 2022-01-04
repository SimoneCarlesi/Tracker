package com.perigea.tracker.timesheet.dto;

import java.util.Date;

import com.perigea.tracker.timesheet.enumerator.TipoCommessaFatturabileType;
import com.perigea.tracker.timesheet.enumerator.TipoCommessaType;

public class CommessaFatturabileDto extends CommessaDto {
	
	private String descrizioneCommessaPerigea;
	private String descrizioneCommessaCliente;
	private Date dataInizioCommessa;
	private Date dataFineCommessa;
	private TipoCommessaFatturabileType tipoCommessa;
	private Double importoCommessaInizialePresunto;
	private Double totaleEstensioni;
	private Double ordineInternoCorrente;
	private Double totaleOrdineClienteFormale;
	private Double totaleOrdine;
	private Double totaleRicaviDaInizioCommessa;
	private Double totaleRicaviDaInizioAnno;
	private Double totaleCostiDaInizioCommessa;
	private Double totaleCostiDaInizioAnno;
	private Double totaleFatturatoreDaInizioCommessa;
	private Double totaleFatturatoDaInizioAnno;
	private Double margineIniziale;
	private Double margineDaInizioCommessa;
	private Double margineDaInizioAnno;
	private Double percentualeAvanzamentoCosti;
	private Double percentualeAvanzamentoFatturazione;
	private Double percentualeSconto;
	private String responsabileCommerciale;
	
	public CommessaFatturabileDto() {
		super();
	}
	



	public String getDescrizioneCommessaPerigea() {
		return descrizioneCommessaPerigea;
	}

	public void setDescrizioneCommessaPerigea(String descrizioneCommessaPerigea) {
		this.descrizioneCommessaPerigea = descrizioneCommessaPerigea;
	}

	public String getDescrizioneCommessaCliente() {
		return descrizioneCommessaCliente;
	}

	public void setDescrizioneCommessaCliente(String descrizioneCommessaCliente) {
		this.descrizioneCommessaCliente = descrizioneCommessaCliente;
	}

	public Date getDataInizioCommessa() {
		return dataInizioCommessa;
	}

	public void setDataInizioCommessa(Date dataInizioCommessa) {
		this.dataInizioCommessa = dataInizioCommessa;
	}

	public Date getDataFineCommessa() {
		return dataFineCommessa;
	}

	public void setDataFineCommessa(Date dataFineCommessa) {
		this.dataFineCommessa = dataFineCommessa;
	}

	public TipoCommessaFatturabileType getTipoCommessa() {
		return tipoCommessa;
	}

	public void setTipoCommessa(TipoCommessaFatturabileType tipoCommessa) {
		this.tipoCommessa = tipoCommessa;
	}

	public Double getImportoCommessaInizialePresunto() {
		return importoCommessaInizialePresunto;
	}

	public void setImportoCommessaInizialePresunto(Double importoCommessaInizialePresunto) {
		this.importoCommessaInizialePresunto = importoCommessaInizialePresunto;
	}

	public Double getTotaleEstensioni() {
		return totaleEstensioni;
	}

	public void setTotaleEstensioni(Double totaleEstensioni) {
		this.totaleEstensioni = totaleEstensioni;
	}

	public Double getOrdineInternoCorrente() {
		return ordineInternoCorrente;
	}

	public void setOrdineInternoCorrente(Double ordineInternoCorrente) {
		this.ordineInternoCorrente = ordineInternoCorrente;
	}

	public Double getTotaleOrdineClienteFormale() {
		return totaleOrdineClienteFormale;
	}

	public void setTotaleOrdineClienteFormale(Double totaleOrdineClienteFormale) {
		this.totaleOrdineClienteFormale = totaleOrdineClienteFormale;
	}

	public Double getTotaleOrdine() {
		return totaleOrdine;
	}

	public void setTotaleOrdine(Double totaleOrdine) {
		this.totaleOrdine = totaleOrdine;
	}

	public Double getTotaleRicaviDaInizioCommessa() {
		return totaleRicaviDaInizioCommessa;
	}

	public void setTotaleRicaviDaInizioCommessa(Double totaleRicaviDaInizioCommessa) {
		this.totaleRicaviDaInizioCommessa = totaleRicaviDaInizioCommessa;
	}

	public Double getTotaleRicaviDaInizioAnno() {
		return totaleRicaviDaInizioAnno;
	}

	public void setTotaleRicaviDaInizioAnno(Double totaleRicaviDaInizioAnno) {
		this.totaleRicaviDaInizioAnno = totaleRicaviDaInizioAnno;
	}

	public Double getTotaleCostiDaInizioCommessa() {
		return totaleCostiDaInizioCommessa;
	}

	public void setTotaleCostiDaInizioCommessa(Double totaleCostiDaInizioCommessa) {
		this.totaleCostiDaInizioCommessa = totaleCostiDaInizioCommessa;
	}

	public Double getTotaleCostiDaInizioAnno() {
		return totaleCostiDaInizioAnno;
	}

	public void setTotaleCostiDaInizioAnno(Double totaleCostiDaInizioAnno) {
		this.totaleCostiDaInizioAnno = totaleCostiDaInizioAnno;
	}

	public Double getTotaleFatturatoreDaInizioCommessa() {
		return totaleFatturatoreDaInizioCommessa;
	}

	public void setTotaleFatturatoreDaInizioCommessa(Double totaleFatturatoreDaInizioCommessa) {
		this.totaleFatturatoreDaInizioCommessa = totaleFatturatoreDaInizioCommessa;
	}

	public Double getTotaleFatturatoDaInizioAnno() {
		return totaleFatturatoDaInizioAnno;
	}

	public void setTotaleFatturatoDaInizioAnno(Double totaleFatturatoDaInizioAnno) {
		this.totaleFatturatoDaInizioAnno = totaleFatturatoDaInizioAnno;
	}

	public Double getMargineIniziale() {
		return margineIniziale;
	}

	public void setMargineIniziale(Double margineIniziale) {
		this.margineIniziale = margineIniziale;
	}

	public Double getMargineDaInizioCommessa() {
		return margineDaInizioCommessa;
	}

	public void setMargineDaInizioCommessa(Double margineDaInizioCommessa) {
		this.margineDaInizioCommessa = margineDaInizioCommessa;
	}

	public Double getMargineDaInizioAnno() {
		return margineDaInizioAnno;
	}

	public void setMargineDaInizioAnno(Double margineDaInizioAnno) {
		this.margineDaInizioAnno = margineDaInizioAnno;
	}

	public Double getPercentualeAvanzamentoCosti() {
		return percentualeAvanzamentoCosti;
	}

	public void setPercentualeAvanzamentoCosti(Double percentualeAvanzamentoCosti) {
		this.percentualeAvanzamentoCosti = percentualeAvanzamentoCosti;
	}

	public Double getPercentualeAvanzamentoFatturazione() {
		return percentualeAvanzamentoFatturazione;
	}

	public void setPercentualeAvanzamentoFatturazione(Double percentualeAvanzamentoFatturazione) {
		this.percentualeAvanzamentoFatturazione = percentualeAvanzamentoFatturazione;
	}

	public Double getPercentualeSconto() {
		return percentualeSconto;
	}

	public void setPercentualeSconto(Double percentualeSconto) {
		this.percentualeSconto = percentualeSconto;
	}

	public String getResponsabileCommerciale() {
		return responsabileCommerciale;
	}

	public void setResponsabileCommerciale(String responsabileCommerciale) {
		this.responsabileCommerciale = responsabileCommerciale;
	}

	
	
	
}
