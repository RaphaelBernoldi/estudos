package br.com.jaiminho.provider;

import br.com.jaiminho.enuns.EnunsProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class StrategyProviderService {

    private Map<EnunsProvider, Provider> mapProviders;

    @Autowired
    private SmsDevProvider smsDevProvider;

    @Autowired
    private KomuniqueProviderService komuniqueProviderService;

    @PostConstruct
    private void posConsctruct(){
        mapProviders = new HashMap<>();
        mapProviders.put(EnunsProvider.SMS_DEV, smsDevProvider);
        mapProviders.put(EnunsProvider.KOMUNIQUE, komuniqueProviderService);
    }

    public Provider getProvider(String name){
        return mapProviders.get(EnunsProvider.getByName(name));
    }
}
