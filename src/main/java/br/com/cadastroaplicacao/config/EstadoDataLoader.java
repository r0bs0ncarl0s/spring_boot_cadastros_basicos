package br.com.cadastroaplicacao.config;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.com.cadastroaplicacao.models.Estado;
import br.com.cadastroaplicacao.repositories.EstadoRepository;

@Component
public class EstadoDataLoader implements CommandLineRunner {
    private final Logger logger = LoggerFactory.getLogger(EstadoDataLoader.class);

    @Autowired 
    EstadoRepository estadoRepository;
    
    @Override
    public void run(String... args) throws Exception{
        loadData();
    }

    private void loadData(){
        if(estadoRepository.count()==0){
        	HashMap<Integer, String[]> mapEstados = new HashMap<>();
        	mapEstados.put(1, new String[]{"Acre","AC"});
        	mapEstados.put(2,new String[]{"Alagoas","AL"});
        	mapEstados.put(3,new String[]{"Amapá","AP"});
        	mapEstados.put(4,new String[]{"Amazonas","AM"});
        	mapEstados.put(5,new String[]{"Bahia","BA"});
        	mapEstados.put(6,new String[]{"Ceará","CE"});
        	mapEstados.put(7,new String[]{"Distrito Federal","DF"});
        	mapEstados.put(8,new String[]{"Espírito Santo","ES"});
        	mapEstados.put(9,new String[]{"Goiás","GO"});
        	mapEstados.put(10,new String[]{"Maranhão","MA"});
        	mapEstados.put(11,new String[]{"Mato Grosso","MT"});
        	mapEstados.put(12,new String[]{"Mato Grosso do Sul","MS"});
        	mapEstados.put(13,new String[]{"Minas Gerais","MG"});
        	mapEstados.put(14,new String[]{"Pará","PA"});
        	mapEstados.put(15,new String[]{"Paraíba","PB"});
        	mapEstados.put(16,new String[]{"Paraná","PR"});
        	mapEstados.put(17,new String[]{"Pernambuco","PE"});
        	mapEstados.put(18,new String[]{"Piauí","PI"});
        	mapEstados.put(19,new String[]{"Rio de Janeiro","RJ"});
        	mapEstados.put(20,new String[]{"Rio Grande do Norte","RN"});
        	mapEstados.put(21,new String[]{"Rio Grande do Sul","RS"});
        	mapEstados.put(22,new String[]{"Rondônia","RO"});
        	mapEstados.put(23,new String[]{"Roraima","RR"});
        	mapEstados.put(24,new String[]{"Santa Catarina","SC"});
        	mapEstados.put(25,new String[]{"São Paulo","SP"});
        	mapEstados.put(26,new String[]{"Sergipe","SE"});
        	mapEstados.put(27,new String[]{"Tocantins","TO"});
        	for (int i = 0; i < mapEstados.size(); i++) {
        		String[] item = mapEstados.get(i);
        		if(item!=null) {
        			Estado itemEstado = new Estado(item[0], item[1]);;
	                estadoRepository.save(itemEstado);
        		}
			}
        }
        logger.info("Numero de estados: {}", estadoRepository.count());
    }
}
