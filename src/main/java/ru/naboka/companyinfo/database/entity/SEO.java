package ru.naboka.companyinfo.database.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@Entity(name = "seo")
@Table(name = "company_seo")
public class SEO implements BaseEntity<Integer>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "seo_lastname", nullable = false)
    private String lastName;

    @Column(name = "seo_patronymicname",nullable = false)
    private String Patronymicname;

    @Column(name = "seo_firstname", nullable = false)
    private String firstName;

    @Column(name = "seo_birth_date", nullable = false)
    private LocalDate seoBirthDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private SEO company;

}
