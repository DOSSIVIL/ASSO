# Étape 1 : Construire l'application
FROM maven:3.9.4-eclipse-temurin-21 AS builder

# Définir le répertoire de travail pour Maven
WORKDIR /micro_commandes

# Copier le fichier de configuration Maven et télécharger les dépendances
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copier le code source de l'application
COPY src ./src

# Compiler et créer le fichier .jar
RUN mvn clean package -DskipTests

# Étape 2 : Construire une image légère pour exécuter l'application
FROM openjdk:17-jdk-slim

# Définir le répertoire de travail pour l'application
WORKDIR /micro_commandes

# Copier le fichier .jar produit dans l'étape précédente
COPY --from=builder /micro_commandes/target/commande-0.0.1-SNAPSHOT.jar commande.jar

# Étape  : Définir les variables d'environnement pour la connexion à PostgreSQL
ENV DB_HOST=mysql_container
ENV DB_PORT=3306
ENV DB_NAME=commande
ENV DB_USER=root
ENV DB_PASSWORD=""

# Exposer le port défini dans votre application Spring Boot
EXPOSE 8081

# Commande pour exécuter l'application
CMD ["java", "-jar", "commande.jar"]
