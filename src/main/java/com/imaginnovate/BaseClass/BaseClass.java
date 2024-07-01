package com.imaginnovate.BaseClass;

import java.time.LocalDateTime;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseClass extends PanacheEntityBase {

    public int createdBy;

    @Column(name = "created_on")
    public LocalDateTime created_On;

    @Column(name = "modified_by")
    public Integer modifiedBy;

    @Column(name = "modified_on")
    public LocalDateTime modifiedOn;

    @Column(name = "deleted_by")
    public Integer deletedBy;

    @Column(name = "deleted_on")
    public LocalDateTime deletedOn;
    
    public BaseClass() {
        this.created_On = LocalDateTime.now();
    }

    public BaseClass(int createdBy, LocalDateTime created_On, Integer modifiedBy, LocalDateTime modifiedOn, Integer deletedBy, LocalDateTime deletedOn) {
        this.createdBy = createdBy;
        this.created_On = created_On != null ? created_On : LocalDateTime.now();
        this.modifiedBy = modifiedBy;
        this.modifiedOn = modifiedOn;
        this.deletedBy = deletedBy;
        this.deletedOn = deletedOn;
    }
}
