package br.edu.cruzeirodosul.config;

import java.util.List;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.edu.cruzeirodosul.bo.PoloComissaoBatchBO;
import br.edu.cruzeirodosul.listenerjobs.RepassePoloNotificationListener;
import br.edu.cruzeirodosul.processor.AberturaRepassePoloProcessor;
import br.edu.cruzeirodosul.processor.EnfileiraRepassePolosComissaoIniciadosItemProcessor;
import br.edu.cruzeirodosul.processor.FinalizaCalculoRepassePoloComissaoItemProcessor;
import br.edu.cruzeirodosul.processor.IniciaCalculoRepassePoloComissaoItemProcessor;
import br.edu.cruzeirodosul.reader.AberturaRepassePoloItemReader;
import br.edu.cruzeirodosul.reader.EnfileiraRepassePolosComissaoIniciadosItemReader;
import br.edu.cruzeirodosul.reader.FinalizaCalculoRepassePoloComissaoItemReader;
import br.edu.cruzeirodosul.reader.IniciaCalculoRepassePoloComissaoItemReader;
import br.edu.cruzeirodosul.writer.AberturaRepassePoloWriter;
import br.edu.cruzeirodosul.writer.EnfileiraPolosComissaoIniciadosItemWriter;
import br.edu.cruzeirodosul.writer.FinalizaCalculoRepassePoloComissaoItemWriter;
import br.edu.cruzeirodosul.writer.IniciaCalculoRepassePoloComissaoItemWriter;

@Configuration
public class BatchConfig {

	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	/************************** JOBS *********************************/
	@Bean
	public Job iniciaProcessamento(RepassePoloNotificationListener listener) {
		System.out.println("iniciaProcessamento - " + jobBuilderFactory);

		return jobBuilderFactory.get("iniciaProcessamento")
				.incrementer(new RunIdIncrementer()).listener(listener)
				.flow(controleCalculoStep1()).end().build();
	}

	@Bean
	public Job enfileiraControlesPoloComissao(
			RepassePoloNotificationListener listener) {
		System.out.println(
				"enfileiraControlesPoloComissao - " + jobBuilderFactory);

		return jobBuilderFactory.get("enfileiraControlesPoloComissao")
				.incrementer(new RunIdIncrementer()).listener(listener)
				.flow(controleCalculoStep2()).end().build();
	}

	@Bean
	public Job iniciaCalculoPoloComissao(
			RepassePoloNotificationListener listener) {
		System.out.println("iniciaCalculoPoloComissao - " + jobBuilderFactory);

		return jobBuilderFactory.get("iniciaCalculoPoloComissao")
				.incrementer(new RunIdIncrementer()).listener(listener)
				.flow(controleCalculoStep3()).end().build();
	}

	@Bean
	public Job finalizaCalculoPoloComissao(
			RepassePoloNotificationListener listener) {
		System.out
				.println("finalizaCalculoPoloComissao - " + jobBuilderFactory);

		return jobBuilderFactory.get("finalizaCalculoPoloComissao")
				.incrementer(new RunIdIncrementer()).listener(listener)
				.flow(controleCalculoStep4()).end().build();
	}

	/************************** STEPS *********************************/
	@Bean
	public Step controleCalculoStep1() {
		System.out.println("controleCalculoStep1 ");

		return stepBuilderFactory.get("controleCalculoStep1")
				.<List<String>, String>chunk(1)/*
												 * Este método é muito
												 * importante, pois realiza a
												 * configuração da quantidade de
												 * processamento paralela que
												 * será realizada por vez
												 * (STEP), Os dois campos
												 * genéricos colocados também
												 * merecem bastante atenção pois
												 * são os Input/Output
												 * respectivamente, portanto, se
												 * não forem bem pensados e
												 * estiverem combinando com os
												 * ItemReader, ItemProcess e
												 * ItemWriter a aplicação não
												 * compila.
												 */
				// .faultTolerant()
				.reader(new AberturaRepassePoloItemReader()) // Busca
																// todos
																// os
																// ControleCalculoComissao
																// Pendentes
				.processor(new AberturaRepassePoloProcessor()) // Processa um
																// por um
				.writer(new AberturaRepassePoloWriter()) // Persiste as
															// alterações no
															// Banco
				.build();
	}

	@Bean
	public Step controleCalculoStep2() {
		System.out.println("controleCalculoStep2 ");

		return stepBuilderFactory.get("controleCalculoStep2")
				.<PoloComissaoBatchBO, Long>chunk(1)
				.reader(new EnfileiraRepassePolosComissaoIniciadosItemReader())
				.processor(
						new EnfileiraRepassePolosComissaoIniciadosItemProcessor())
				.writer(new EnfileiraPolosComissaoIniciadosItemWriter())
				.build();
	}

	@Bean
	public Step controleCalculoStep3() {
		System.out.println("controleCalculoStep3 ");

		return stepBuilderFactory.get("controleCalculoStep3")
				.<PoloComissaoBatchBO, PoloComissaoBatchBO>chunk(1)
				.reader(new IniciaCalculoRepassePoloComissaoItemReader())
				.processor(new IniciaCalculoRepassePoloComissaoItemProcessor())
				.writer(new IniciaCalculoRepassePoloComissaoItemWriter())
				.build();
	}

	@Bean
	public Step controleCalculoStep4() {
		System.out.println("controleCalculoStep4 ");

		return stepBuilderFactory.get("controleCalculoStep4")
				.<PoloComissaoBatchBO, PoloComissaoBatchBO>chunk(1)
				.reader(new FinalizaCalculoRepassePoloComissaoItemReader())
				.processor(
						new FinalizaCalculoRepassePoloComissaoItemProcessor())
				.writer(new FinalizaCalculoRepassePoloComissaoItemWriter())
				.build();
	}

}
