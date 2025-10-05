package com.example.cp05.dto;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public class EmprestimoForm {
    @NotNull private Long livroId;
    @NotNull private Long usuarioId;
    @NotNull private LocalDate dataRetirada;
    @NotNull private LocalDate dataPrevistaDevolucao;

    public EmprestimoForm() {}

    public Long getLivroId() { return livroId; }
    public void setLivroId(Long livroId) { this.livroId = livroId; }
    public Long getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; }
    public LocalDate getDataRetirada() { return dataRetirada; }
    public void setDataRetirada(LocalDate dataRetirada) { this.dataRetirada = dataRetirada; }
    public LocalDate getDataPrevistaDevolucao() { return dataPrevistaDevolucao; }
    public void setDataPrevistaDevolucao(LocalDate dataPrevistaDevolucao) { this.dataPrevistaDevolucao = dataPrevistaDevolucao; }
}
