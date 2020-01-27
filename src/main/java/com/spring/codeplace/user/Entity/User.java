package com.spring.codeplace.user.Entity;

import com.spring.codeplace.enums.SocialType;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Data
@DynamicInsert
@Table(name = "CPUSER")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long oid;

    @Column
    private String account;

    @Column
    private String password;

    @Column
    private String name;

    @Column
    private String nickname;

    @Column
    private String grade;

    @Column
    private String gender;

    @Column
    private String email;

    @Column
    private String lastloginip;

    @Column
    private Date lastloginat;

    @Column
    private Date createdat;

    @Column
    private Date lastmodifiedat;

    @Column
    private String principal;

    @Column
    @Enumerated(EnumType.STRING)
    private SocialType socialType;

    @Builder
    public User(String account, String password, String name, String nickname, String grade, String gender, String email, String lastloginip, Date lastloginat, Date createdat, Date lastmodifiedat
        , String principal, SocialType socialType){
        this.account = account;
        this.password = password;
        this.name = name;
        this.nickname = nickname;
        this.grade = grade;
        this.gender = gender;
        this.email = email;
        this.lastloginip = lastloginip;
        this.lastloginat = lastloginat;
        this.createdat = createdat;
        this.lastmodifiedat = lastmodifiedat;
        this.principal = principal;
        this.socialType = socialType;
    }


}
