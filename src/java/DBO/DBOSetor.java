/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBO;

/**
 *
 * @author u16168
 */
public class DBOSetor {
    
    public DBOSetor(int idEvento, int qtdIngressos, String nomeSetor) {
        this.idEvento = idEvento;
        this.qtdIngressos = qtdIngressos;
        this.nomeSetor = nomeSetor;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public int getQtdIngressos() {
        return qtdIngressos;
    }

    public void setQtdIngressos(int qtdIngressos) {
        this.qtdIngressos = qtdIngressos;
    }

    public String getNomeSetor() {
        return nomeSetor;
    }

    public void setNomeSetor(String nomeSetor) {
        this.nomeSetor = nomeSetor;
    }
    private int idEvento, qtdIngressos;
    private String nomeSetor;
}
