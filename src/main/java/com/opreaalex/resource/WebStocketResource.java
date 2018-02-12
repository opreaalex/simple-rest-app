package com.opreaalex.resource;

import com.opreaalex.dto.StockDTO;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebStocketResource {

    @MessageMapping("stocks.sendStock")
    @SendTo("/topic/public")
    public StockDTO sendStock(@Payload final StockDTO dto) {
        return dto;
    }
}
