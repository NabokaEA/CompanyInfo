package ru.naboka.companyinfo.database.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "company")
public class Company implements BaseEntity<Integer> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "full_name", unique = true, nullable = false)
    private String fullName;

    @Column(name = "short_name",nullable = false)
    private String shortName;

    @Column(unique = true, nullable = false)
    private String inn;

    @Column(unique = true, nullable = false)
    private String ogrn;

    @Column(name = "post_address",nullable = false)
    private String postAddress;

    @Column(name = "legal_address", nullable = false)
    private String legalAddress;

    @Builder.Default
    @OneToMany(mappedBy = "company")
    private List<SEO> seo = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "company")
    private List<Branch> branch = new ArrayList<>();
}
