package br.com.santander.internetbanking.datailtransaction;

import br.com.santander.internetbanking.service.TransactionService;
import br.com.santander.internetbanking.transaction.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionDetailController {

    private final TransactionService transacaoService;

    @Autowired
    public TransactionDetailController(TransactionService transacaoService) {
        this.transacaoService = transacaoService;
    }

    @PostMapping("/withdraw/{clienteId}")
    public ResponseEntity<String> withdraw(@PathVariable Long clienteId, @RequestParam BigDecimal valor) {
        transacaoService.toWithdraw(clienteId, valor);
        return new ResponseEntity<>("Saque realizado com sucesso.", HttpStatus.OK);
    }

    @PostMapping("/deposit/{clienteId}")
    public ResponseEntity<String> deposit(@PathVariable Long clienteId, @RequestParam BigDecimal valor) {
        transacaoService.deposit(clienteId, valor);
        return new ResponseEntity<>("Depósito realizado com sucesso.", HttpStatus.OK);
    }

    @GetMapping("/historic")
    public ResponseEntity<List<Transaction>> getHistoricoTransacoesByDate(@RequestParam("data") @DateTimeFormat(pattern = "dd/MM/yyyy") Date data) {
        List<Transaction> historico = transacaoService.getHistoricoTransacoesByDate(data);
        return new ResponseEntity<>(historico, HttpStatus.OK);
    }

}
