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

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public Long getTargetoid() {
        return targetoid;
    }

    public void setTargetoid(Long targetoid) {
        this.targetoid = targetoid;
    }

    public Long getCreatoroid() {
        return creatoroid;
    }

    public void setCreatoroid(Long creatoroid) {
        this.creatoroid = creatoroid;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public Date getCreatedat() {
        return createdat;
    }

    public void setCreatedat(Date createdat) {
        this.createdat = createdat;
    }

    public Date getModifiedat() {
        return modifiedat;
    }

    public void setModifiedat(Date modifiedat) {
        this.modifiedat = modifiedat;
    }

    public String getDeletestatus() {
        return deletestatus;
    }

    public void setDeletestatus(String deletestatus) {
        this.deletestatus = deletestatus;
    }

    public int getReportcnt() {
        return reportcnt;
    }

    public void setReportcnt(int reportcnt) {
        this.reportcnt = reportcnt;
    }
}
