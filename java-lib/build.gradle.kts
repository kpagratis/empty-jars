plugins {
    `java-library`
    java
    `java-test-fixtures`
    id("org.gradlex.extra-java-module-info")
    id("org.kordamp.gradle.jandex")
}

repositories {
    mavenCentral()
    mavenLocal()
}

dependencies {
    implementation("jakarta.enterprise:jakarta.enterprise.cdi-api:4.0.1")
}

group = "empty-jar-repro"
version = "0.1.0"

java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
    options.compilerArgs.add("-parameters")
}

tasks.testFixturesJar {
    manifest {
        attributes("Automatic-Module-Name" to "java.test.fixtures")
    }
}
