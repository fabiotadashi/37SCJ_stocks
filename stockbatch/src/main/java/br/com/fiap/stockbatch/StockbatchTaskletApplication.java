//package br.com.fiap.stockbatch;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.core.step.tasklet.Tasklet;
//import org.springframework.batch.repeat.RepeatStatus;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.Bean;
//
//import java.io.File;
//import java.nio.file.Paths;
//
//@SpringBootApplication
//@EnableBatchProcessing
//public class StockbatchTaskletApplication {
//
//	Logger logger = LoggerFactory.getLogger(StockbatchTaskletApplication.class);
//
//	public static void main(String[] args) {
//		SpringApplication.run(StockbatchTaskletApplication.class, args);
//	}
//
//	@Bean
//	public Tasklet tasklet(@Value("${file.path}") String filepath){
//		return (contribution, chunkContext) -> {
//			File file = Paths.get(filepath).toFile();
//			if(file.delete()){
//				logger.error("File deleted");
//			}else{
//				logger.error("Couldn't delete file");
//			}
//			return RepeatStatus.FINISHED;
//		};
//	}
//
//	@Bean
//	public Step step(StepBuilderFactory stepBuilderFactory,
//					 Tasklet tasklet){
//		return stepBuilderFactory.get("Delete file step")
//				.tasklet(tasklet)
//				.allowStartIfComplete(true)
//				.build();
//	}
//
//	@Bean
//	public Job job(JobBuilderFactory jobBuilderFactory,
//				   Step step){
//		return jobBuilderFactory.get("Delete file job")
//				.start(step)
//				.build();
//	}
//
//}
