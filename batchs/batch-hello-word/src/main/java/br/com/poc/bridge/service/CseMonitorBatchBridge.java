package br.com.poc.bridge.service;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import br.com.poc.bridge.AbstractBridge;
import br.com.poc.bridge.interfaces.ICseMonitorBatchBridge;
import br.com.poc.exception.CustomGenericException;
import br.com.poc.model.bo.ControleJobCruzeiroBO;
import br.com.poc.model.enums.EnumStatusJobCruzeiro;
import br.com.poc.util.EndPoint;
import br.com.poc.util.HttpUtil;

@Service
public class CseMonitorBatchBridge extends AbstractBridge implements ICseMonitorBatchBridge {

	@Autowired
	private EndPoint endPoint;
	
	private static final Logger logger = Logger.getLogger(CseMonitorBatchBridge.class.getName());

	@Override
	public ControleJobCruzeiroBO criaMonitoracao(String name) throws CustomGenericException {
		String url = endPoint.getCriaMonitoracao();
		try {
			ControleJobCruzeiroBO controleJobCruzeiroBO = new ControleJobCruzeiroBO();
			
			controleJobCruzeiroBO.setName(name);
			controleJobCruzeiroBO.setStatus(EnumStatusJobCruzeiro.ATIVO);
			
			return post(url
					   , controleJobCruzeiroBO
					   , ControleJobCruzeiroBO.class
					   , HttpUtil.isHttps(url));
			
		}catch (HttpClientErrorException e) {
			String msg = mensagemErroDefault(e.getMessage(), url);
			logger.log(Level.SEVERE, msg);
			throw new CustomGenericException(msg);
		}
	}

}
