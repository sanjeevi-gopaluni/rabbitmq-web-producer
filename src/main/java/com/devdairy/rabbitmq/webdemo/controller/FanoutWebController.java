package com.devdairy.rabbitmq.webdemo.controller;

import com.devdairy.rabbitmq.webdemo.model.Transaction;
import com.devdairy.rabbitmq.webdemo.service.RabbitMQSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fanout")
public class FanoutWebController {
    @Autowired
    RabbitMQSender sender;

    @RequestMapping(value="/")
    public String index(){
        return "send transaction details through endpoint /transaction";
    }
    @PostMapping(value="/transaction")
    public String produceTransaction(@RequestBody Transaction transaction){
        sender.send(transaction);
        return "Message sent to the Rabbit Mq";
    }
    @GetMapping(value="/transaction")
    public String produceTransactionGet(@RequestParam("exchange") String exchange,@RequestParam("id") String id,@RequestParam("amt") Double amt,@RequestParam("type") String type ){
        Transaction t = new Transaction();
        t.setTransId(id);
        t.setAmt(amt);
        t.setType(type);
        sender.sendWithCustomParams(exchange,t);
        return "GET Message sent to the Rabbit Mq";
    }
}
