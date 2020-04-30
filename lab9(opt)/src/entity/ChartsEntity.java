package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "charts")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ChartsEntity.findAll", query = "SELECT c FROM ChartsEntity c"),
    @NamedQuery(name = "ChartsEntity.findByRank", query = "SELECT c FROM ChartsEntity c WHERE c.rank = :rank"),
    @NamedQuery(name = "ChartsEntity.findById", query = "SELECT c FROM ChartsEntity c WHERE c.albumId = :id")})
public class ChartsEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "rank")
    private int rank;
    @Id
    @Basic(optional = false)
    @Column(name = "album_id")
    private Integer albumId;

    public ChartsEntity() {
    }

    public ChartsEntity(Integer albumId) {
        this.albumId = albumId;
    }

    public ChartsEntity(Integer albumId, int rank) {
        this.albumId = albumId;
        this.rank = rank;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public Integer getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (albumId != null ? albumId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ChartsEntity)) {
            return false;
        }
        ChartsEntity other = (ChartsEntity) object;
        if ((this.albumId == null && other.albumId != null) || (this.albumId != null && !this.albumId.equals(other.albumId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Charts[ albumId=" + albumId + " ]";
    }
    
}
