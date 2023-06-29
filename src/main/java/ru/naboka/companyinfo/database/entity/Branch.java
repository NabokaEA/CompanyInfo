package ru.naboka.companyinfo.database.entity;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@Entity(name = "branch")
@Table(name = "company_branch")
public class Branch implements BaseEntity<Integer>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "full_name", unique = true, nullable = false)
    private String fullName;

    @Column(name = "short_name",nullable = false)
    private String shortName;

    @Column(name = "post_address",nullable = false)
    private String postAddress;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinColumn(name = "company_id")
    private Company company;

}
