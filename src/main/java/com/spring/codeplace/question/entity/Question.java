package com.spring.codeplace.question.entity;

import com.spring.codeplace.user.Entity.User;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Data
@DynamicInsert
@Table(name = "CPQUESTION")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long oid;

    @Column
    private Long parentsoid;

    @Column
    private String tag;

    @Column
    private String title;

    @Column
    private String creatoroid;

    @Column
    private Date createdat;

    @Column
    private Date lastmodifiedat;

    @Column
    private String contents;

    @Column
    private String doctype;

    @Column
    private int viewcnt;

    @Column
    private int likecnt;

    @Column
    private int cmtcnt;

    @Column
    private int reportcnt;

    @OneToOne(fetch = FetchType.LAZY)
    private User user;

    @Builder
    public Question(Long parentsoid, String tag, String title, String creatoroid, Date createdat, Date lastmodifiedat, String contents, String doctype, int viewcnt, int likecnt, int cmtcnt, int reportcnt, User user){
        this.parentsoid = parentsoid;
        this.tag = tag;
        this.title = title;
        this.creatoroid =creatoroid;
        this.createdat = createdat;
        this.lastmodifiedat = lastmodifiedat;
        this.contents = contents;
        this.doctype = doctype;
        this.viewcnt = viewcnt;
        this.likecnt = likecnt;
        this.cmtcnt = cmtcnt;
        this.reportcnt = reportcnt;
        this.user = user;
    }
}
