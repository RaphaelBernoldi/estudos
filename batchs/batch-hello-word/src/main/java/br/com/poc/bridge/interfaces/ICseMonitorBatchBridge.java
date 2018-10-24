package br.com.poc.bridge.interfaces;

import br.com.poc.exception.CustomGenericException;
import br.com.poc.model.bo.ControleJobCruzeiroBO;

public interface ICseMonitorBatchBridge {

	ControleJobCruzeiroBO criaMonitoracao(String name) throws CustomGenericException;
}
