package com.shahriar.bookfinder.config;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
@EnableElasticsearchRepositories
public class BookFinderConfig {	

	    @Value("${elasticsearch.host}")
	    private String EsHost;

	    @Value("${elasticsearch.port}")
	    private String EsPort;

	    @Value("${elasticsearch.clustername}")
	    private String EsClusterName;

	    @Bean
	    RestHighLevelClient elasticsearchClient() {
	        final ClientConfiguration configuration = ClientConfiguration.localhost();
	        RestHighLevelClient client = RestClients.create(configuration).rest();
	        return client;
	    }

	    @Bean
	    ElasticsearchRestTemplate elasticsearchTemplate() {
	        return new ElasticsearchRestTemplate(elasticsearchClient());
	    }
}
