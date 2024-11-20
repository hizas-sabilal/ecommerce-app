package com.ecommerce.inventory.messaging.publisher;
//
//import com.ecommerce.kafka.inventory.avro.model.OrderRequestAvroModel;
import com.ecommerce.kafka.order.avro.model.OrderRequestAvroModel;
import com.ecommerce.kafka.producer.KafkaMessageHelper;
import com.ecommerce.kafka.producer.service.KafkaProducer;
import com.ecommerce.inventory.domain.config.InventoryServiceConfigData;
import com.ecommerce.inventory.domain.event.InventoryCreatedEvent;
import com.ecommerce.inventory.domain.ports.output.message.publisher.order.InventoryCreatedOrderRequestMessagePublisher;
import com.ecommerce.inventory.messaging.mapper.InventoryMessagingDataMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
//
@Slf4j
@Component
public class CreateInventoryKafkaMessagePublisher implements InventoryCreatedOrderRequestMessagePublisher {
//
    private final InventoryMessagingDataMapper inventoryMessagingDataMapper;
    private final InventoryServiceConfigData inventoryServiceConfigData;
    private final KafkaProducer<String, OrderRequestAvroModel> kafkaProducer;
    private final KafkaMessageHelper inventoryKafkaMessageHelper;

    public CreateInventoryKafkaMessagePublisher(InventoryMessagingDataMapper inventoryMessagingDataMapper,
                                            InventoryServiceConfigData inventoryServiceConfigData,
                                            KafkaProducer<String, OrderRequestAvroModel> kafkaProducer,
                                            KafkaMessageHelper kafkaMessageHelper) {
        this.inventoryMessagingDataMapper = inventoryMessagingDataMapper;
        this.inventoryServiceConfigData = inventoryServiceConfigData;
        this.kafkaProducer = kafkaProducer;
        this.inventoryKafkaMessageHelper = kafkaMessageHelper;
    }

    @Override
    public void publish(InventoryCreatedEvent domainEvent) {
        String inventoryId = domainEvent.getInventory().getId().getValue().toString();
        log.info("Received InventoryCreatedEvent for inventory id: {}", inventoryId);

        try {
            OrderRequestAvroModel orderRequestAvroModel = inventoryMessagingDataMapper
                    .inventoryCreatedEventToOrderRequestAvroModel(domainEvent);

            kafkaProducer.send(inventoryServiceConfigData.getOrderRequestTopicName(),
                    inventoryId,
                    orderRequestAvroModel,
                    inventoryKafkaMessageHelper
                            .getKafkaCallback(inventoryServiceConfigData.getOrderResponseTopicName(),
                                    orderRequestAvroModel,
                                    inventoryId,
                                    "OrderRequestAvroModel"));

            log.info("OrderRequestAvroModel sent to Kafka for inventory id: {}", orderRequestAvroModel.getInventoryId());
        } catch (Exception e) {
            log.error("Error while sending OrderRequestAvroModel message" +
                    " to kafka with inventory id: {}, error: {}", inventoryId, e.getMessage());
        }
    }
}
