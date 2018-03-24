//package com.vanhack.ezequiel.service.kafka;
//
//import com.google.common.collect.Maps;
//import org.apache.kafka.clients.consumer.*;
//import org.apache.kafka.common.serialization.Deserializer;
//import org.apache.log4j.Logger;
//import org.springframework.scheduling.annotation.Scheduled;
//
//import javax.annotation.PostConstruct;
//import java.lang.reflect.ParameterizedType;
//import java.util.Collections;
//import java.util.Map;
//import java.util.Properties;
//
//public abstract class KafkaGenericConsumer<K, V> {
//
//    private static final Logger log = Logger.getLogger(KafkaGenericConsumer.class);
//
//    private static Map<String, Deserializer<?>> deserializerMap = Maps.newHashMap();
//    private static final String SERVER_IP = "127.0.0.1";
////    private static final String topicName = "CancelFlightInputQueue";
////    private static final String groupId = "1";
//    protected abstract String getTopic();
//
//    private Consumer<K, V> consumer;
//
//    protected abstract void handleEvent(K key, V value);
//
//    //do not override this method. "final" modifier was dropped for Spring scheduler to make proxy for this method.
//    @Scheduled(fixedDelayString = "${kafka.scheduler.fixedDelay.ms:2000}")
//    public void handleEvent() {
//            ConsumerRecords<K, V> consumerRecords = this.consumer.poll(1000);
//            for (ConsumerRecord<K, V> consumerRecord : consumerRecords) {
//                try {
//                    if(log.isDebugEnabled()){
//                        log.debug(String.format("Consumer received event: key %s, value %s", consumerRecord.key(), consumerRecord.value()));
//                    }
//                    handleEvent(consumerRecord.key(), consumerRecord.value());
//                }catch (Exception e){
//                    e.printStackTrace();
//                }
//                consumer.commitAsync();
//            }
//    }
//
//    @PostConstruct
//    protected final void init() {
////        if (this.kafkaConfiguration.isKafkaEnabled()) {
//            Deserializer<K> keyDeserializer = getKeyDeserializer();
//            Deserializer<V> valueDeserializer = getValueDeserializer();
//
//            this.consumer = new KafkaConsumer<>(getKafkaProperties(),keyDeserializer, valueDeserializer);
//            this.consumer.subscribe(Collections.singletonList(getTopic()));
////        }
//
//    }
//
//    /* Get Key<K> Deserializer
// *  Default deserializer, currently (String) is present in the deserializer map */
//    private Deserializer<K> getKeyDeserializer() {
//        Deserializer<K> keyDeserializer;
//        String keyClassName = this.<K>getGenericClass(0).getSimpleName();
//
//        if (deserializerMap.containsKey(keyClassName)) {
//            keyDeserializer = (Deserializer<K>) deserializerMap.get(keyClassName);
//        }
//        else {
//            ReflectAvroSerde<K> keySerde = this.kafkaConfiguration.buildReflectKeySerde(this.<K>getGenericClass(0));
//            keyDeserializer = keySerde.deserializer();
//        }
//
//        return keyDeserializer;
//    }
//
//    /* Get Value<V> Deserializer
//  *  Default Deserializers, currently (String) is present in the Deserializer map */
//    private Deserializer<V> getValueDeserializer() {
//        Deserializer<V> valueDeserializer;
//        String valueClassName = this.<V>getGenericClass(1).getSimpleName();
//
//        if (deserializerMap.containsKey(valueClassName)) {
//            valueDeserializer = (Deserializer<V>) deserializerMap.get(valueClassName);
//        }
//        else {
//            ReflectAvroSerde<V> valueSerde = this.kafkaConfiguration.buildReflectSerde(this.<V>getGenericClass(1));
//            valueDeserializer = valueSerde.deserializer();
//        }
//
//        return valueDeserializer;
//    }
//
//    @SuppressWarnings("unchecked")
//    private <T> Class<T> getGenericClass(int position) {
//        return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[position];
//    }
//
//    private Properties getKafkaProperties(){
//        Properties configProperties = new Properties();
//        configProperties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, SERVER_IP + ":9092");
//        configProperties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
//        configProperties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
//        configProperties.put(ConsumerConfig.GROUP_ID_CONFIG, 1);
//        configProperties.put(ConsumerConfig.CLIENT_ID_CONFIG, "simple");
//        return configProperties;
//    }
//}
