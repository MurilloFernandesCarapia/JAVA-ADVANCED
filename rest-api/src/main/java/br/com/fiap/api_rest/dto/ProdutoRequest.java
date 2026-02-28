package br.com.fiap.api_rest.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ProdutoRequest(
        @NotBlank (message = "Não é possível deixar o nome em branco ou vazio!")
        @Size(min = 3, max= 150)
        String nome,
        @NotNull(message = "O preço é obrigatório!")
        @DecimalMin(value = "0.99", message = "O valor mínimo deve ser 0.99")
        BigDecimal preco,
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate expiracao
) {
}
