package br.com.web_pi.ado1.records;

import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record AlunoRecord(

    @NotBlank(message = "Preencha o campo nome")
    String nome,

    @NotBlank(message = "Preencha o campo CEP")
    @Size(min = 8, max = 8, message = "O campo deve seguir o padrão de 8 caracteres Ex: 01010101")
    String cep,

    @NotNull(message = "Preencha o campo número")
    @Max(Integer.MAX_VALUE)
    @Min(1)
    Integer numero,

    @NotBlank(message = "Preencha o campo complemento")
    @Size(max = 45, message = "Limite de caracteres atingido")
    String complemento,

    @NotNull(message = "Preencha o campo nota da ADO 1")
    @DecimalMax("10.00")
    @DecimalMin("0.00")
    @Digits(integer = 4, fraction = 2, message = "Limite de digitos atingido")
    BigDecimal notaAdo1,

    @NotNull(message = "Preencha o campo nota do PI")
    @DecimalMax("10.00")
    @DecimalMin("0.00")
    @Digits(integer = 4, fraction = 2, message = "Limite de digitos atingido")
    BigDecimal notaPi
) {
    
}
