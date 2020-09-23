package br.com.fiap.stockbatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;

import javax.sql.DataSource;

@SpringBootApplication
@EnableBatchProcessing
public class StockbatchChunkApplication {

	Logger logger = LoggerFactory.getLogger(StockbatchChunkApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(StockbatchChunkApplication.class, args);
	}

	@Bean
	public FlatFileItemReader<Pessoa> itemReader(@Value("${file.chunk}") Resource resource){
		return new FlatFileItemReaderBuilder<Pessoa>()
				.name("Pessoa item reader")
				.targetType(Pessoa.class)
				.resource(resource)
				.delimited().delimiter(";").names("nome", "cpf")
				.build();
	}

	@Bean
	public ItemProcessor<Pessoa, Pessoa> itemProcessor(){
		return (pessoa) -> {
			pessoa.setNome(pessoa.getNome().toUpperCase());
			pessoa.setCpf(pessoa.getCpf().replaceAll("\\.","").replace("-",""));
			return pessoa;
		};
	}

	@Bean
	public JdbcBatchItemWriter<Pessoa> itemWriter(DataSource dataSource){
		return new JdbcBatchItemWriterBuilder<Pessoa>()
				.dataSource(dataSource)
				.sql("insert into TB_PESSOA (nome, cpf) values (:nome, :cpf)")
				.beanMapped()
				.build();
	}

	@Bean
	public Step step(StepBuilderFactory stepBuilderFactory,
					 ItemReader<Pessoa> itemReader,
					 ItemProcessor<Pessoa, Pessoa> itemProcessor,
					 ItemWriter<Pessoa> itemWriter){
		return stepBuilderFactory.get("Step chunk file -> jdbc")
				.<Pessoa, Pessoa>chunk(2)
				.reader(itemReader)
				.processor(itemProcessor)
				.writer(itemWriter)
				.build();
	}

	@Bean
	public Job job(JobBuilderFactory jobBuilderFactory,
				   Step step){
		return jobBuilderFactory.get("Job chunk")
				.start(step)
				.build();
	}

}
