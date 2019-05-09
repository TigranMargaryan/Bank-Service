package onlinebank.base.data.domain;

import onlinebank.base.config.UUId;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import java.io.Serializable;

@MappedSuperclass
public class BaseEntity implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setId() {
        this.id = UUId.UUid();
    }

    @PrePersist
    private void beforeSave() {
        setId();
    }
}
