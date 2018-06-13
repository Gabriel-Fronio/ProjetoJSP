/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBO;

/**
 *
 * @author gabri
 */
public class DBOUsuarioIngresso {
    String idUsuario;
    int idIngresso;

    public DBOUsuarioIngresso(String idUsuario, int idIngresso) {
        this.idUsuario = idUsuario;
        this.idIngresso = idIngresso;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdIngresso() {
        return idIngresso;
    }

    public void setIdIngresso(int idIngresso) {
        this.idIngresso = idIngresso;
    }
    
}
