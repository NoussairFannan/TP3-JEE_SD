# TP-3-JEE-SB

## Description
Ce projet est une application web développée avec Spring Boot, implémentant une architecture MVC (Modèle-Vue-Contrôleur) avec une couche de sécurité. Il s'agit d'une application de gestion de patients avec des fonctionnalités CRUD (Create, Read, Update, Delete).

## Technologies Utilisées
- Java 17
- Spring Boot 3.4.3
- Spring Security
- Spring Data JPA
- Thymeleaf
- MySQL
- Bootstrap 5.3.3
- Lombok
- Maven

## Structure du Projet
```
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── example/
│   │           └── activite/
│   │               ├── ActiviteApplication.java
│   │               ├── Entities/
│   │               │   └── Patient.java
│   │               ├── Repositories/
│   │               │   └── PatientRepository.java
│   │               ├── Security/
│   │               └── Web/
│   └── resources/
└── test/
```

## Fonctionnalités Principales
- Authentification et autorisation avec Spring Security
- Interface utilisateur responsive avec Bootstrap
- Persistance des données avec JPA
- Validation des données
- Architecture MVC
- Gestion des patients (CRUD)
- Pagination des données
- Recherche de patients

## Modèle de Données

### Entité Patient
```java
@Entity
@Data @AllArgsConstructor @NoArgsConstructor
@Builder
public class Patient {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotEmpty
    @Size(min = 0, max = 40, message = "{Size.patient.name}")
    private String nom;
    
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateNaissance;
    
    private boolean malade;
    
    @DecimalMin("0")
    private int score;
}
```

### Repository Patient
```java
@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    Page<Patient> findByNomContains(String keyword, Pageable pageable);
}
```

## Dépendances Principales
- spring-boot-starter-web : Pour le développement d'applications web
- spring-boot-starter-data-jpa : Pour la persistance des données
- spring-boot-starter-security : Pour la sécurité
- spring-boot-starter-thymeleaf : Pour le templating
- mysql-connector-j : Pour la connexion à MySQL
- lombok : Pour réduire le code boilerplate
- bootstrap : Pour l'interface utilisateur
- bootstrap-icons : Pour les icônes
- thymeleaf-layout-dialect : Pour la gestion des layouts

## Configuration
Le projet utilise Maven comme gestionnaire de dépendances. La configuration principale se trouve dans le fichier `pom.xml`.

### Configuration de la Base de Données
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/patient_db
spring.datasource.username=root
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

## Sécurité
Le projet implémente Spring Security pour la gestion de l'authentification et de l'autorisation.

### Configuration de Sécurité
```java
@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/user/**").hasRole("USER")
                .requestMatchers("/admin/**").hasRole("ADMIN")
                .anyRequest().authenticated()
            )
            .formLogin(form -> form
                .loginPage("/login")
                .permitAll()
            );
        return http.build();
    }
}
```

## Interface Utilisateur
- Utilisation de Bootstrap 5.3.3 pour un design responsive
- Intégration d'icônes Bootstrap
- Templates Thymeleaf pour le rendu des vues

### Exemple de Template Thymeleaf
```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Liste des Patients</title>
    <link rel="stylesheet" th:href="@{/webjars/bootstrap/5.3.3/css/bootstrap.min.css}"/>
</head>
<body>
    <div class="container">
        <h1>Liste des Patients</h1>
        <table class="table">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nom</th>
                    <th>Date de Naissance</th>
                    <th>Score</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <tr th:each="patient : ${patients}">
                    <td th:text="${patient.id}"></td>
                    <td th:text="${patient.nom}"></td>
                    <td th:text="${#dates.format(patient.dateNaissance, 'dd/MM/yyyy')}"></td>
                    <td th:text="${patient.score}"></td>
                    <td>
                        <a th:href="@{/patients/edit/{id}(id=${patient.id})}" class="btn btn-primary">Modifier</a>
                        <a th:href="@{/patients/delete/{id}(id=${patient.id})}" class="btn btn-danger">Supprimer</a>
                    </td>
                </tr>
            </tbody>
        </table>
    </div>
</body>
</html>
```

## Base de Données
- Support pour MySQL
- Configuration JPA pour la persistance des données
- Schéma de base de données généré automatiquement
- Validation des données avec les annotations JPA

## Conclusion

Ce projet démontre une implémentation réussie d'une application web Spring Boot avec :

1. **Architecture** : MVC bien structurée avec Spring Boot 3.4.3
2. **Fonctionnalités** : CRUD patients, sécurité, interface responsive
3. **Technologies** : Spring Security, JPA, Thymeleaf, Bootstrap





