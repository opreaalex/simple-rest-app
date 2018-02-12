package com.opreaalex.resource;

import com.opreaalex.domain.Stock;
import com.opreaalex.dto.StockDTO;
import com.opreaalex.dto.StockListDTO;
import com.opreaalex.resource.form.CreateStockForm;
import com.opreaalex.resource.form.UpdateStockAmountForm;
import com.opreaalex.resource.validation.ValidationError;
import com.opreaalex.resource.validation.ValidationErrorBuilder;
import com.opreaalex.service.StockService;
import com.opreaalex.util.UriUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigInteger;
import java.net.URI;

@RestController
@RequestMapping("/api")
public class ApiResource {

    @Autowired
    private StockService stockService;

    @RequestMapping(path = "/stocks", method = RequestMethod.GET)
    public ResponseEntity<StockListDTO> getStocks() {
        return ResponseEntity.ok(new StockListDTO(stockService.findAll()));
    }

    @RequestMapping(path = "/stocks/{id}", method = RequestMethod.GET)
    public ResponseEntity<StockDTO> getStock(@PathVariable(name = "id") final BigInteger id) {
        return stockService.findById(id)
                .map(StockDTO::new)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @RequestMapping(path = "/stocks", method = RequestMethod.POST)
    public ResponseEntity postStock(@Valid @RequestBody CreateStockForm form) {
        final Stock stock = stockService.create(
                form.getName(), new BigInteger(form.getAmount()));
        final URI uri = UriUtil.getUriWithStockId(stock.getId());

        return ResponseEntity.accepted()
                .header("Location", uri.toString())
                .build();
    }

    @RequestMapping(path = "/stocks/{id}", method = RequestMethod.PUT)
    public ResponseEntity putStock(@PathVariable(name = "id") final BigInteger id,
                                   @Valid @RequestBody UpdateStockAmountForm form) {
        if (stockService.updateAmount(id, new BigInteger(form.getAmount()))) {
            return ResponseEntity.accepted().build();
        }
        return ResponseEntity.badRequest().build();
    }

    @ExceptionHandler
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ValidationError handleException(final MethodArgumentNotValidException exception) {
        return ValidationErrorBuilder.fromBindingErrors(exception.getBindingResult());
    }
}
