pluginManagement {
    val quarkusPluginVersion: String by settings
    val quarkusPluginId: String by settings
    repositories {
        mavenCentral()
        gradlePluginPortal()
        mavenLocal()
    }
    plugins {
        id(quarkusPluginId) version quarkusPluginVersion
        id("org.gradlex.extra-java-module-info") version "1.5"
        id("org.kordamp.gradle.jandex") version "1.1.0"

    }
}
rootProject.name="empty-jars"

include("quarkus-lib")
include("java-lib")