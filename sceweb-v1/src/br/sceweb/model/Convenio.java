package br.sceweb.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;

public class Convenio {
	private String cnpj;
	private DateTime dataInicio;
	private DateTime dataTermino;
	Logger logger = Logger.getLogger(Convenio.class);

	public Convenio(String cnpj, String dataInicio, String dataTermino) {
		setCNPJ(cnpj);
		setDataInicio(dataInicio);
		setDataTermino(dataTermino);
	}

	public String getCnpj() {
		return cnpj;
	}

	/*
	 * /* atribui o cnpj ‐ vefica se o cnpj tem no minimo 14 caracteres
	 */
	public void setCNPJ(String cnpj) {
		logger.info("CNPJ = " + cnpj);
		if (cnpj.length() == 14) {
			this.cnpj = cnpj;
			logger.info("CNPJ from Class = " + this.cnpj);
		} else
			throw new IllegalArgumentException("CNPJ inválido!");
	}

	public DateTime getDataInicio() {
		return dataInicio;
	}

	/**
	 * atribui a data de inicio da vigência de um convenio
	 * 
	 * @param dataInicio
	 *            ‐ data no formato dd/mm/aaaa
	 * @throws IllegalArgumentException
	 */
	public void setDataInicio(String dataInicio) throws IllegalArgumentException {
		logger.info("parameter data inicio = " + dataInicio);
		if (validaData(dataInicio)) {
			this.dataInicio = new DateTime(Integer.parseInt(dataInicio.substring(6, 10)),
					Integer.parseInt(dataInicio.substring(3, 5)), Integer.parseInt(dataInicio.substring(0, 2)), 0, 0);
			logger.info("data inicio from Class = " + this.dataInicio.toString());
		} else {
			throw new IllegalArgumentException("data invalida");
		}
	}

	public DateTime getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(String dataTermino) throws IllegalArgumentException {
		logger.info("data termino = " + dataTermino);
		if (validaData(dataTermino)) {
			this.dataTermino = new DateTime(Integer.parseInt(dataTermino.substring(6, 10)),
					Integer.parseInt(dataTermino.substring(3, 5)), Integer.parseInt(dataTermino.substring(0, 2)), 0, 0);
			logger.info("data termino from Class = " + this.dataTermino.toString());
			
		} else {
			throw new IllegalArgumentException("data invalida");
		}
	}

	/**
	 * valida o formato da data
	 * 
	 * @param data
	 *            no formato dd/MM/yyyy
	 * @return true se a data estiver no formato valido e false para formato
	 *         invalido
	 */
	public boolean validaData(String data) {
		logger.info("A data " + data);
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		df.setLenient(false); //
		try {
			df.parse(data); // data válida
			logger.info(" é valida.");
			return true;
		} catch (ParseException ex) {
			logger.error("Erro na validacao de data ‐ " + ex.getMessage());
			return false;
		}
	}
}
