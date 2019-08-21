package greencity.entity;

import greencity.entity.enums.ROLE;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String firstName;

    @Column(nullable = false, length = 20)
    private String lastName;

    @Column(unique = true, nullable = false, length = 50)
    private String email;

    @OneToOne(mappedBy = "user")
    private Photo photo;

    @Enumerated(value = EnumType.ORDINAL)
    @Column(nullable = false)
    private ROLE role;

    @Column(nullable = false)
    private LocalDateTime lastVisit;

    @Column(nullable = false)
    private LocalDateTime dateOfRegistration = LocalDateTime.now();

    @OneToMany(mappedBy = "user")
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<FavoritePlace> favoritePlaces = new ArrayList<>();

    @OneToMany(mappedBy = "author")
    private List<Place> addedPlaces = new ArrayList<>();

    @OneToOne(mappedBy = "user")
    private UserOwnSecurity userOwnSecurity;

    @OneToOne(mappedBy = "user")
    private VerifyEmail verifyEmail;

    @OneToMany(mappedBy = "user")
    private List<Rate> rates = new ArrayList<>();
}