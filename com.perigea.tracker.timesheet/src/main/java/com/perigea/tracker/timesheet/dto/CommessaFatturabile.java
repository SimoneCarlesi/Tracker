package com.perigea.tracker.timesheet.dto;

import java.util.Date;

import com.perigea.tracker.timesheet.enumerator.TipoCommessaFatturabileType;
import com.perigea.tracker.timesheet.enumerator.TipoCommessaType;

public class CommessaFatturabile extends Commessa {
	
	private String descrizioneCommessaPerigea;
	private String descrizioneCommessaCliente;
	private Date dataInizioCommessa;
	private Date dataFineCommessa;
	private TipoCommessaFatturabileType tipoCommessa;
	private double importoCommessaInizialePresunto;
	private double totaleEstensioni;
	private double ordineInternoCorrente;
	private double totaleOrdineClienteFormale;
	private double totaleOrdine;
	private double totaleRicaviDaInizioCommessa;
	private double totaleRicaviDaInizioAnno;
	private double totaleCostiDaInizioCommessa;
	private double totaleCostiDaInizioAnno;
	private double totaleFatturatoreDaInizioCommessa;
	private double totaleFatturatoDaInizioAnno;
	private double margineIniziale;
	private double margineDaInizioCommessa;
	private double margineDaInizioAnno;
	private double percentualeAvanzamentoCosti;
	private double percentualeAvanzamentoFatturazione;
	private double percentualeSconto;
	private String responsabileCommerciale;
	
	public CommessaFatturabile(String codiceCommessa, TipoCommessaType tipoCommessaType, Date createTimestamp,
			Date lastUpdateTimestamp, String createUser, String lastUpdateUser, String descrizioneCommessaPerigea,
			String descrizioneCommessaCliente, Date dataInizioCommessa, Date dataFineCommessa,
			TipoCommessaFatturabileType tipoCommessa, double importoCommessaInizialePresunto, double totaleEstensioni,
			double ordineInternoCorrente, double totaleOrdineClienteFormale, double totaleOrdine,
			double totaleRicaviDaInizioCommessa, double totaleRicaviDaInizioAnno, double totaleCostiDaInizioCommessa,
			double totaleCostiDaInizioAnno, double totaleFatturatoreDaInizioCommessa,
			double totaleFatturatoDaInizioAnno, double margineIniziale, double margineDaInizioCommessa,
			double margineDaInizioAnno, double percentualeAvanzamentoCosti, double percentualeAvanzamentoFatturazione,
			double percentualeSconto, String responsabileCommerciale) {
		super(codiceCommessa, tipoCommessaType, createTimestamp, lastUpdateTimestamp, createUser, lastUpdateUser);
		this.descrizioneCommessaPerigea = descrizioneCommessaPerigea;
		this.descrizioneCommessaCliente = descrizioneCommessaCliente;
		this.dataInizioCommessa = dataInizioCommessa;
		this.dataFineCommessa = dataFineCommessa;
		this.tipoCommessa = tipoCommessa;
		this.importoCommessaInizialePresunto = importoCommessaInizialePresunto;
		this.totaleEstensioni = totaleEstensioni;
		this.ordineInternoCorrente = ordineInternoCorrente;
		this.totaleOrdineClienteFormale = totaleOrdineClienteFormale;
		this.totaleOrdine = totaleOrdine;
		this.totaleRicaviDaInizioCommessa = totaleRicaviDaInizioCommessa;
		this.totaleRicaviDaInizioAnno = totaleRicaviDaInizioAnno;
		this.totaleCostiDaInizioCommessa = totaleCostiDaInizioCommessa;
		this.totaleCostiDaInizioAnno = totaleCostiDaInizioAnno;
		this.totaleFatturatoreDaInizioCommessa = totaleFatturatoreDaInizioCommessa;
		this.totaleFatturatoDaInizioAnno = totaleFatturatoDaInizioAnno;
		this.margineIniziale = margineIniziale;
		this.margineDaInizioCommessa = margineDaInizioCommessa;
		this.margineDaInizioAnno = margineDaInizioAnno;
		this.percentualeAvanzamentoCosti = percentualeAvanzamentoCosti;
		this.percentualeAvanzamentoFatturazione = percentualeAvanzamentoFatturazione;
		this.percentualeSconto = percentualeSconto;
		this.responsabileCommerciale = responsabileCommerciale;
	}
	
	

}
