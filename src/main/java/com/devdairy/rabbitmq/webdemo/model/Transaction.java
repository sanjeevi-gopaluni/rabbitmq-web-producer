
package com.devdairy.rabbitmq.webdemo.model;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id", scope = Transaction.class)
public class Transaction {
    private String transId;
    private Double amt;
    private String debitor;
    private String creditor;
    private String type;
    private Long timestamp;
}
