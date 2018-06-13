package classes;
// Generated 13/jun/2018 18:32:28 by Hibernate Tools 4.3.1


import java.sql.Blob;

/**
 * Musica generated by hbm2java
 */
public class Musica  implements java.io.Serializable {


     private int musicaId;
     private Utilizador utilizador;
     private Album album;
     private String nome;
     private String genero;
     private Integer duracao;
     private Blob audio;

    public Musica() {
    }

	
    public Musica(int musicaId, Utilizador utilizador, String nome, Blob audio) {
        this.musicaId = musicaId;
        this.utilizador = utilizador;
        this.nome = nome;
        this.audio = audio;
    }
    public Musica(int musicaId, Utilizador utilizador, Album album, String nome, String genero, Integer duracao, Blob audio) {
       this.musicaId = musicaId;
       this.utilizador = utilizador;
       this.album = album;
       this.nome = nome;
       this.genero = genero;
       this.duracao = duracao;
       this.audio = audio;
    }
   
    public int getMusicaId() {
        return this.musicaId;
    }
    
    public void setMusicaId(int musicaId) {
        this.musicaId = musicaId;
    }
    public Utilizador getUtilizador() {
        return this.utilizador;
    }
    
    public void setUtilizador(Utilizador utilizador) {
        this.utilizador = utilizador;
    }
    public Album getAlbum() {
        return this.album;
    }
    
    public void setAlbum(Album album) {
        this.album = album;
    }
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getGenero() {
        return this.genero;
    }
    
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public Integer getDuracao() {
        return this.duracao;
    }
    
    public void setDuracao(Integer duracao) {
        this.duracao = duracao;
    }
    public Blob getAudio() {
        return this.audio;
    }
    
    public void setAudio(Blob audio) {
        this.audio = audio;
    }




}


