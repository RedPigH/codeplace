package com.spring.codeplace.question.entity;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Data
@DynamicInsert
@Table(name = "CPDOCUMENT")
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

    public Long getOid() { return oid; }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public Long getParentsoid() {
        return parentsoid;
    }

    public void setParentsoid(Long parentsoid) {
        this.parentsoid = parentsoid;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreatoroid() {
        return creatoroid;
    }

    public void setCreatoroid(String creatoroid) {
        this.creatoroid = creatoroid;
    }

    public Date getCreatedat() {
        return createdat;
    }

    public void setCreatedat(Date createdat) {
        this.createdat = createdat;
    }

    public Date getLastmodifiedat() {
        return lastmodifiedat;
    }

    public void setLastmodifiedat(Date lastmodifiedat) {
        this.lastmodifiedat = lastmodifiedat;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getDoctype() {
        return doctype;
    }

    public void setDoctype(String doctype) {
        this.doctype = doctype;
    }

    public int getViewcnt() {
        return viewcnt;
    }

    public void setViewcnt(int viewcnt) {
        this.viewcnt = viewcnt;
    }

    public int getLikecnt() {
        return likecnt;
    }

    public void setLikecnt(int likecnt) {
        this.likecnt = likecnt;
    }

    public int getCmtcnt() {
        return cmtcnt;
    }

    public void setCmtcnt(int cmtcnt) {
        this.cmtcnt = cmtcnt;
    }

    public int getReportcnt() {
        return reportcnt;
    }

    public void setReportcnt(int reportcnt) {
        this.reportcnt = reportcnt;
    }


    @Builder
    public Question(Long parentsoid, String title, String creatoroid, Date createdat, Date lastmodifiedat, String contents, String doctype, int viewcnt, int likecnt, int cmtcnt, int reportcnt){
        this.parentsoid = parentsoid;
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
    }
}
