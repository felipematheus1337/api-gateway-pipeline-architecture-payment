package com.pipeline.service.domain;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum PaymentType {

    CREDIARIO("CREDIARIO"), DEBITO("DEBITO"), PIX("PIX");

    private final String tipo;

    public boolean isValid() {
        switch (this.tipo) {
            case "CREDIARIO" -> {
                return true;
            }
            case "DEBITO" ->  {
                return true;
            }
            case "PIX" ->  {
                return true;
            }
            case null, default -> {
                return false;
            }
        }

    }
}
