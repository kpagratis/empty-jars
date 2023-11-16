plugins {
    java
    `java-test-fixtures`
    id("io.quarkus")
    id("org.gradlex.extra-java-module-info")
}

repositories {
    mavenCentral()
    mavenLocal()
}

val quarkusPlatformGroupId: String by project
val quarkusPlatformArtifactId: String by project
val quarkusPlatformVersion: String by project

dependencies {
    implementation(enforcedPlatform("${quarkusPlatformGroupId}:${quarkusPlatformArtifactId}:${quarkusPlatformVersion}"))
    implementation("io.quarkus:quarkus-arc")
    implementation("io.quarkus:quarkus-resteasy-reactive")
    implementation(project(mapOf("path" to ":java-lib")))
    testImplementation("io.quarkus:quarkus-junit5")
    testImplementation("io.rest-assured:rest-assured")
    testImplementation(testFixtures(project(mapOf("path" to ":java-lib"))))
    testFixturesImplementation(testFixtures(project(mapOf("path" to ":java-lib"))))
}

group = "empty-jar-repro"
version = "0.1.0"

java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}

tasks.withType<Test> {
    systemProperty("java.util.logging.manager", "org.jboss.logmanager.LogManager")
}
tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
    options.compilerArgs.add("-parameters")
}

tasks.testFixturesJar {
    manifest {
        attributes("Automatic-Module-Name" to "test.fixtures")
    }
}

extraJavaModuleInfo {
    automaticModule("aopalliance:aopalliance", "aopalliance")
    automaticModule("com.google.guava:failureaccess", "failureaccess")
    automaticModule("com.thoughtworks.xstream:xstream", "xstream")
    automaticModule("commons-cli:commons-cli", "commons.cli")
    automaticModule("io.github.crac:org-crac", "org.crac")
    automaticModule("io.quarkus.arc:arc", "arc")
    automaticModule("io.quarkus.gizmo:gizmo", "gizmo")
    automaticModule("io.quarkus.resteasy.reactive:resteasy-reactive", "resteasy.reactive")
    automaticModule("io.quarkus.resteasy.reactive:resteasy-reactive-common", "resteasy.reactive.common")
    automaticModule("io.quarkus.resteasy.reactive:resteasy-reactive-common-types", "resteasy.reactive.common.types")
    automaticModule("io.quarkus.resteasy.reactive:resteasy-reactive-vertx", "resteasy.reactive.vertx")
    automaticModule("io.quarkus.security:quarkus-security", "quarkus.security")
    automaticModule("io.quarkus:quarkus-arc", "quarkus.arc")
    automaticModule("io.quarkus:quarkus-bootstrap-app-model", "quarkus.bootstrap.app.model")
    automaticModule("io.quarkus:quarkus-bootstrap-core", "quarkus.bootstrap.core")
    automaticModule("io.quarkus:quarkus-bootstrap-gradle-resolver", "quarkus.bootstrap.gradle.resolver")
    automaticModule("io.quarkus:quarkus-bootstrap-maven-resolver", "quarkus.bootstrap.maven.resolver")
    automaticModule("io.quarkus:quarkus-bootstrap-runner", "quarkus.bootstrap.runner")
    automaticModule("io.quarkus:quarkus-builder", "quarkus.builder")
    automaticModule("io.quarkus:quarkus-core", "quarkus.core")
    automaticModule("io.quarkus:quarkus-core-deployment", "quarkus.core.deployment")
    automaticModule("io.quarkus:quarkus-credentials", "quarkus.credentials")
    automaticModule("io.quarkus:quarkus-development-mode-spi", "quarkus.development.mode.spi")
    automaticModule("io.quarkus:quarkus-devtools-utilities", "quarkus.devtools.utilities")
    automaticModule("io.quarkus:quarkus-fs-util", "quarkus.fs.util")
    automaticModule("io.quarkus:quarkus-ide-launcher", "quarkus.ide.launcher")
    automaticModule("io.quarkus:quarkus-jsonp", "quarkus.jsonp")
    automaticModule("io.quarkus:quarkus-junit5", "quarkus.junit5")
    automaticModule("io.quarkus:quarkus-junit5-properties", "quarkus.junit5.properties")
    automaticModule("io.quarkus:quarkus-mutiny", "quarkus.mutiny")
    automaticModule("io.quarkus:quarkus-netty", "quarkus.netty")
    automaticModule("io.quarkus:quarkus-resteasy-reactive", "quarkus.resteasy.reactive")
    automaticModule("io.quarkus:quarkus-resteasy-reactive-common", "quarkus.resteasy.reactive.common")
    automaticModule("io.quarkus:quarkus-security-runtime-spi", "quarkus.security.runtime.spi")
    automaticModule("io.quarkus:quarkus-smallrye-context-propagation", "quarkus.smallrye.context.propagation")
    automaticModule("io.quarkus:quarkus-test-common", "quarkus.test.common")
    automaticModule("io.quarkus:quarkus-vertx", "quarkus.vertx")
    automaticModule("io.quarkus:quarkus-vertx-http", "quarkus.vertx.http")
    automaticModule("io.quarkus:quarkus-vertx-latebound-mdc-provider", "quarkus.vertx.latebound.mdc.provider")
    automaticModule("io.quarkus:quarkus-virtual-threads", "quarkus.virtual.threads")
    automaticModule("io.rest-assured:json-path", "json.path")
    automaticModule("io.rest-assured:rest-assured", "rest.assured")
    automaticModule("io.rest-assured:rest-assured-common", "rest.assured.common")
    automaticModule("io.rest-assured:xml-path", "xml.path")
    automaticModule("io.smallrye.beanbag:smallrye-beanbag", "smallrye.beanbag")
    automaticModule("io.smallrye.beanbag:smallrye-beanbag-maven", "smallrye.beanbag.maven")
    automaticModule("io.smallrye.beanbag:smallrye-beanbag-sisu", "smallrye.beanbag.sisu")
    automaticModule("io.smallrye.config:smallrye-config", "smallrye.config")
    automaticModule("io.smallrye.config:smallrye-config-common", "smallrye.config.common")
    automaticModule("io.smallrye.config:smallrye-config-core", "smallrye.config.core")
    automaticModule("io.smallrye.reactive:mutiny-smallrye-context-propagation", "mutiny.smallrye.context.propagation")
    automaticModule("io.smallrye.reactive:vertx-mutiny-generator", "vertx.mutiny.generator")
    automaticModule("io.smallrye:smallrye-context-propagation", "smallrye.context.propagation")
    automaticModule("io.smallrye:smallrye-context-propagation-api", "smallrye.context.propagation.api")
    automaticModule("io.smallrye:smallrye-context-propagation-storage", "smallrye.context.propagation.storage")
    automaticModule("io.smallrye:smallrye-fault-tolerance-vertx", "smallrye.fault.tolerance.vertx")
    automaticModule("javax.inject:javax.inject", "javax.inject")
    automaticModule("org.apache.maven.shared:maven-shared-utils", "maven.shared.utils")
    automaticModule("org.apache.maven.wagon:wagon-file", "wagon.file")
    automaticModule("org.apache.maven.wagon:wagon-http", "wagon.http")
    automaticModule("org.apache.maven.wagon:wagon-http-shared", "wagon.http.shared")
    automaticModule("org.apache.maven.wagon:wagon-provider-api", "wagon.provider.api")
    automaticModule("org.apache.maven:maven-api-meta", "maven.api.meta")
    automaticModule("org.apache.maven:maven-api-xml", "maven.api.xml")
    automaticModule("org.apache.maven:maven-artifact", "maven.artifact")
    automaticModule("org.apache.maven:maven-builder-support", "maven.builder.support")
    automaticModule("org.apache.maven:maven-core", "maven.core")
    automaticModule("org.apache.maven:maven-embedder", "maven.embedder")
    automaticModule("org.apache.maven:maven-model", "maven.model")
    automaticModule("org.apache.maven:maven-model-builder", "maven.model.builder")
    automaticModule("org.apache.maven:maven-plugin-api", "maven.plugin.api")
    automaticModule("org.apache.maven:maven-repository-metadata", "maven.repository.metadata")
    automaticModule("org.apache.maven:maven-resolver-provider", "maven.resolver.provider")
    automaticModule("org.apache.maven:maven-settings", "maven.settings")
    automaticModule("org.apache.maven:maven-settings-builder", "maven.settings.builder")
    automaticModule("org.apache.maven:maven-xml-impl", "maven.xml.impl")
    automaticModule("org.ccil.cowan.tagsoup:tagsoup", "tagsoup")
    automaticModule("org.codehaus.plexus:plexus-cipher", "plexus.cipher")
    automaticModule("org.codehaus.plexus:plexus-classworlds", "plexus.classworlds")
    automaticModule("org.codehaus.plexus:plexus-component-annotations", "plexus.component.annotations")
    automaticModule("org.codehaus.plexus:plexus-interpolation", "plexus.interpolation")
    automaticModule("org.codehaus.plexus:plexus-sec-dispatcher", "plexus.sec.dispatcher")
    automaticModule("org.codehaus.plexus:plexus-utils", "plexus.utils")
    automaticModule("org.codehaus.plexus:plexus-xml", "plexus.xml")
    automaticModule("org.eclipse.microprofile.config:microprofile-config-api", "microprofile.config.api")
    automaticModule("org.eclipse.microprofile.context-propagation:microprofile-context-propagation-api", "microprofile.context.propagation.api")
    automaticModule("org.eclipse.sisu:org.eclipse.sisu.inject", "org.eclipse.sisu.inject")
    automaticModule("org.eclipse.sisu:org.eclipse.sisu.plexus", "org.eclipse.sisu.plexus")
    automaticModule("org.jboss.logging:commons-logging-jboss-logging", "commons.logging.jboss.logging")
    automaticModule("org.jboss.logging:jboss-logging-annotations", "jboss.logging.annotations")
    automaticModule("org.jboss.slf4j:slf4j-jboss-logmanager", "slf4j.jboss.logmanager")
    automaticModule("org.jboss.threads:jboss-threads", "jboss.threads")
    automaticModule("org.wildfly.common:wildfly-common", "wildfly.common")
    automaticModule("xmlpull:xmlpull", "xmlpull")
}