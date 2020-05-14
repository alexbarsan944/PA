package main.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Games {
    private int id;
    private Integer idPlayer1;
    private Integer idPlayer2;
    private int idCastigator;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "id_player1")
    public Integer getIdPlayer1() {
        return idPlayer1;
    }

    public void setIdPlayer1(Integer idPlayer1) {
        this.idPlayer1 = idPlayer1;
    }

    @Basic
    @Column(name = "id_player2")
    public Integer getIdPlayer2() {
        return idPlayer2;
    }

    public void setIdPlayer2(Integer idPlayer2) {
        this.idPlayer2 = idPlayer2;
    }

    @Basic
    @Column(name = "id_castigator")
    public int getIdCastigator() {
        return idCastigator;
    }

    public void setIdCastigator(int idCastigator) {
        this.idCastigator = idCastigator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Games games = (Games) o;
        return id == games.id &&
                idCastigator == games.idCastigator &&
                Objects.equals(idPlayer1, games.idPlayer1) &&
                Objects.equals(idPlayer2, games.idPlayer2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idPlayer1, idPlayer2, idCastigator);
    }
}
