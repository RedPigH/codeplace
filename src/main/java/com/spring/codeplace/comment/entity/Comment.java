package com.spring.codeplace.comment.entity;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Setter
@Entity
@Data
@DynamicInsert
@Table(name = "CPCOMMENT")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long oid;

    @Column
    private Long targetoid;

    @Column
    private Long creatoroid;

    @Column
    private String contents;

    @Column
    private Date createdat;

    @Column
    private Date modifiedat;

    @Column
    private String deletestatus;

    @Column
    private int reportcnt;

    @Builder
    public Comment(Long targetoid, Long creatoroid, String contents, Date createdat, Date modifiedat, String deletestatus, int reportcnt){
        this.targetoid = targetoid;
        this.creatoroid = creatoroid;
        this.contents = contents;
        this.createdat = createdat;
        this.modifiedat = modifiedat;
        this.deletestatus = deletestatus;
        this.reportcnt = reportcnt;
    }
}
