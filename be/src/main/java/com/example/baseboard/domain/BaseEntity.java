package com.example.baseboard.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@NoArgsConstructor
public abstract class BaseEntity {

    @Column
    protected Long createUserId;

    @Column
    @CreationTimestamp
    protected LocalDateTime createDateTime;

    @Column
    @CreationTimestamp
    protected LocalDateTime updateDateTime;

    @Column(nullable = false)
    @ColumnDefault("'Y'")
    protected Character useYn;

    @Column(nullable = false)
    @ColumnDefault("'N'")
    protected Character delYn;

    protected BaseEntity(Long createUserId
            , LocalDateTime createDateTime
            , LocalDateTime updateDateTime
            , char useYn
            , char delYn
    ){
        this.createUserId = createUserId;
        this.createDateTime = createDateTime;
        this.updateDateTime = updateDateTime;
        this.useYn = useYn;
        this.delYn = delYn;
    }
}
