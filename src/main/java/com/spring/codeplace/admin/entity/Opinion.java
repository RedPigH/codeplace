package com.spring.codeplace.admin.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Data
@Getter
@Setter
@Entity
@Table(name = "cpopinion")
public class Opinion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long oid;

    private String account;

    private String title;

    private String content;

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getTitle() {return title;}

    public void setTitle(String title) { this.title = title; }

    public String getContent() {return content;}

    public void setContent(String content) {this.content = content; }

}
