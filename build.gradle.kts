import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    base
    id("io.spring.dependency-management") version "1.0.14.RELEASE" apply false
    id("org.springframework.boot") version "2.7.4" apply false
    id("idea")
    kotlin("jvm") version "1.6.21"
    kotlin("plugin.spring") version "1.6.21" apply false
}

allprojects {
    group = "com.ras.persona"
    version = "1.0.0"

    repositories {
        mavenCentral()
    }

    tasks {
        withType<JavaCompile>().configureEach {
            options.encoding = "UTF-8"
        }

        withType<Javadoc>().configureEach {
            options.encoding = "UTF-8"
        }

        withType<KotlinCompile> {
            kotlinOptions {
                freeCompilerArgs = listOf("-Xjsr305=strict")
                jvmTarget = "11"
            }
        }

        withType<Test> {
            useJUnitPlatform()
        }
    }
}

subprojects {
    repositories {
        mavenCentral()
    }

    apply(plugin = "io.spring.dependency-management")
    apply(plugin = "org.jetbrains.kotlin.jvm")
    apply(plugin = "idea")

    java {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    dependencies {
        implementation(kotlin("reflect"))
        implementation(kotlin("stdlib-jdk8"))

        implementation("org.slf4j:slf4j-api:1.7.30")
        implementation("ch.qos.logback:logback-classic:1.2.3")
        implementation("ch.qos.logback:logback-core:1.2.3")
    }
}

