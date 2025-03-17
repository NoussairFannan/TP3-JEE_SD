# Gestion des Patients avec Spring Boot

## Description
Ce projet est une application web développée en **Spring Boot**, **Spring MVC**, **Thymeleaf**, et **Spring Data JPA** permettant la gestion des patients. 

## Fonctionnalités
- Afficher la liste des patients
- Ajouter un nouveau patient
- Rechercher un patient
- Paginer les résultats
- Supprimer un patient
- Validation des formulaires

## Technologies utilisées
- **Spring Boot 3.2**
- **Spring MVC**
- **Thymeleaf**
- **Spring Data JPA**
- **H2 Database**
- **Lombok**
- **Maven**

## Structure du projet
```sh
├── src
│   ├── main
│   │   ├── java/ma/enset/hospitalapp
│   │   │   ├── entities (Modele Patient)
│   │   │   ├── repositories (Acces aux donnees)
│   │   │   ├── web (Rest Services)
│   │   ├── resources
│   │   │   ├── templates (Vues Thymeleaf)
│   │   │   ├── application.properties (Configuration BD)

