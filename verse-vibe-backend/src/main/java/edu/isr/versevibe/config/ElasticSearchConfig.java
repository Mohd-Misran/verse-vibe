package edu.isr.versevibe.config;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;

public class ElasticSearchConfig {
    private static final String HOST = "localhost";
    private static final int PORT = 9200;

    public ElasticsearchClient createClient() {
        try {

            final RestClient restClient = RestClient.builder(new HttpHost(HOST, PORT)).build();
            final ElasticsearchTransport transport = new RestClientTransport(restClient, new JacksonJsonpMapper());
            return new ElasticsearchClient(transport);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
