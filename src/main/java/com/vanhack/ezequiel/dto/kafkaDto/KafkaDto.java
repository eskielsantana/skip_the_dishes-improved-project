package com.vanhack.ezequiel.dto.kafkaDto;

import com.vanhack.ezequiel.dto.restDto.OrderRestDto;
import com.vanhack.ezequiel.entity.Customer;
import com.vanhack.ezequiel.util.JsonUtils;

import java.util.ArrayList;

public class KafkaDto {

    private enum KafkaDtoTypes{

        ORDER_CREATION("Order Creation"),
        ORDER_STATUS_CHECK("Order Status Check"),
        ORDER_CANCELLATION("Order Cancellation"),
        PERSON_CREATION("Person Creation"),
        PERSON_AUTH("Person Auth");

        private final String type;
        KafkaDtoTypes(String valor){this.type = valor;}
        public String getType() {return type;}
    }

    private String type;
    private String payload;
    private Object object;

    public KafkaDto() { }

    public void convert(){

        if(this.type.equals(KafkaDtoTypes.ORDER_CANCELLATION.getType())){
            this.object = JsonUtils.convertToObject(payload, Integer.class);
        }else if(this.type.equals(KafkaDtoTypes.ORDER_CREATION.getType())){
            this.object = JsonUtils.convertToObject(payload, OrderRestDto.class);
        }else if(this.type.equals(KafkaDtoTypes.ORDER_STATUS_CHECK.getType())){
            this.object = Integer.parseInt(payload);
        }else if(this.type.equals(KafkaDtoTypes.PERSON_CREATION.getType())){
            this.object = JsonUtils.convertToObject(payload, Customer.class);
        }else if(this.type.equals(KafkaDtoTypes.PERSON_AUTH.getType())){
            this.object = JsonUtils.convertToObject(payload, ArrayList.class);
        }else{

        }
    }
}
