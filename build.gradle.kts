import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    base
    id("io.spring.dependency-management") version "1.0.11.RELEASE" apply false
    id("org.springframework.boot") version "2.6.3" apply false
    id("idea")
    id("eclipse")
    kotlin("plugin.spring") version "1.6.10" apply false
    kotlin("jvm") version "1.6.10"
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
    apply(plugin = "eclipse")

    java {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}
