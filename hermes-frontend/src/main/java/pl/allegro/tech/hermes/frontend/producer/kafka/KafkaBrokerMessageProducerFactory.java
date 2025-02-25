package pl.allegro.tech.hermes.frontend.producer.kafka;

import org.glassfish.hk2.api.Factory;
import pl.allegro.tech.hermes.common.config.ConfigFactory;
import pl.allegro.tech.hermes.common.metric.HermesMetrics;

import javax.inject.Inject;

public class KafkaBrokerMessageProducerFactory implements Factory<KafkaBrokerMessageProducer> {

    private final Producers producers;
    private final KafkaTopicMetadataFetcher kafkaTopicMetadataFetcher;
    private final HermesMetrics hermesMetrics;
    private final KafkaHeaderFactory kafkaHeaderFactory;
    private final ConfigFactory configFactory;

    @Inject
    public KafkaBrokerMessageProducerFactory(Producers producers,
                                             KafkaTopicMetadataFetcher kafkaTopicMetadataFetcher,
                                             HermesMetrics hermesMetrics,
                                             KafkaHeaderFactory kafkaHeaderFactory,
                                             ConfigFactory configFactory) {
        this.producers = producers;
        this.kafkaTopicMetadataFetcher = kafkaTopicMetadataFetcher;
        this.hermesMetrics = hermesMetrics;
        this.kafkaHeaderFactory = kafkaHeaderFactory;
        this.configFactory = configFactory;
    }

    @Override
    public KafkaBrokerMessageProducer provide() {
        return new KafkaBrokerMessageProducer(producers, kafkaTopicMetadataFetcher, hermesMetrics, kafkaHeaderFactory, configFactory);
    }

    @Override
    public void dispose(KafkaBrokerMessageProducer instance) {

    }

}
