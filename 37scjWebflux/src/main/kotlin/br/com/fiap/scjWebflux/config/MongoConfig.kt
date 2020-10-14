package br.com.fiap.scjWebflux.config

import br.com.fiap.scjWebflux.repository.PessoaRepository
import com.mongodb.reactivestreams.client.MongoClient
import com.mongodb.reactivestreams.client.MongoClients
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.ReactiveMongoDatabaseFactory
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration
import org.springframework.data.mongodb.core.ReactiveMongoTemplate
import org.springframework.data.mongodb.core.SimpleReactiveMongoDatabaseFactory
import org.springframework.data.mongodb.core.convert.MappingMongoConverter
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories

@Configuration
@EnableReactiveMongoRepositories(basePackageClasses = [PessoaRepository::class])
class MongoConfig : AbstractReactiveMongoConfiguration() {

    override fun getDatabaseName() = "mongoDatabase"

    override fun reactiveMongoClient(): MongoClient = mongoClient()

    @Bean
    fun mongoClient(): MongoClient = MongoClients.create()

//    @Bean
//    fun reactiveMongoDatabaseFactory(): ReactiveMongoDatabaseFactory = SimpleReactiveMongoDatabaseFactory(mongoClient(), databaseName)

    override fun reactiveMongoTemplate(databaseFactory: ReactiveMongoDatabaseFactory, mongoConverter: MappingMongoConverter): ReactiveMongoTemplate {
        return ReactiveMongoTemplate(mongoClient(), databaseName)
    }

//    @Bean
//    override fun reactiveMongoTemplate()
//            = ReactiveMongoTemplate(mongoClient(), databaseName)

}