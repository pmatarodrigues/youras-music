/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yourasmusic.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author pedro
 */
@Entity
@Table(name = "UTILIZADOR")
@NamedQueries({
    @NamedQuery(name = "Utilizador.findAll", query = "SELECT u FROM Utilizador u")})
public class Utilizador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "UTILIZADOR_ID")
    private Integer utilizadorId;
    @Basic(optional = false)
    @Column(name = "EMAIL")
    private String email;
    @Basic(optional = false)
    @Column(name = "PASSWORD_U")
    private String passwordU;
    @Basic(optional = false)
    @Column(name = "TIPO")
    private String tipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "artistaId")
    private List<Musica> musicaList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "utilizador")
    private Editora editora;
    @OneToMany(mappedBy = "requerenteId")
    private List<Reserva> reservaList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "utilizador")
    private DirEstudio dirEstudio;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "utilizador")
    private Artista artista;

    public Utilizador() {
    }

    public Utilizador(Integer utilizadorId) {
        this.utilizadorId = utilizadorId;
    }

    public Utilizador(Integer utilizadorId, String email, String passwordU, String tipo) {
        this.utilizadorId = utilizadorId;
        this.email = email;
        this.passwordU = passwordU;
        this.tipo = tipo;
    }
    
    public Utilizador(String email, String passwordU, String tipo) {
        this.email = email;
        this.passwordU = passwordU;
        this.tipo = tipo;
    }
    
    public Integer getUtilizadorId() {
        return utilizadorId;
    }

    public void setUtilizadorId(Integer utilizadorId) {
        this.utilizadorId = utilizadorId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordU() {
        return passwordU;
    }

    public void setPasswordU(String passwordU) {
        this.passwordU = passwordU;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<Musica> getMusicaList() {
        return musicaList;
    }

    public void setMusicaList(List<Musica> musicaList) {
        this.musicaList = musicaList;
    }

    public Editora getEditora() {
        return editora;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }

    public List<Reserva> getReservaList() {
        return reservaList;
    }

    public void setReservaList(List<Reserva> reservaList) {
        this.reservaList = reservaList;
    }

    public DirEstudio getDirEstudio() {
        return dirEstudio;
    }

    public void setDirEstudio(DirEstudio dirEstudio) {
        this.dirEstudio = dirEstudio;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (utilizadorId != null ? utilizadorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Utilizador)) {
            return false;
        }
        Utilizador other = (Utilizador) object;
        if ((this.utilizadorId == null && other.utilizadorId != null) || (this.utilizadorId != null && !this.utilizadorId.equals(other.utilizadorId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "yourasmusic.entities.Utilizador[ utilizadorId=" + utilizadorId + " ]";
    }
    
}