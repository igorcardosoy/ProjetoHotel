package model.enums;

import model.Indentificacao;
import model.pessoas.Hospede;

public enum TipoDoc {
  CPF("CPF"),
  RG("RG"),
  PASSAPORTE("Passaporte");

  private String tipoDoc;

    TipoDoc(String tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    public String getTipoDoc() {
        return tipoDoc;
    }

}
