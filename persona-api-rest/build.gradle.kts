plugins {
    id("application")
    id("org.springframework.boot")

    kotlin("jvm")
    kotlin("plugin.spring")
}

application {
    mainClass.set("com.ras.persona.ApiApplicationKt")
}

springBoot {
    buildInfo()
}

dependencies {
    implementation(kotlin("reflect"))
    implementation(kotlin("stdlib-jdk8"))

    implementation("org.springframework.boot:spring-boot-starter-web") {
        exclude("org.springframework.boot", "spring-boot-starter-tomcat")
    }
    implementation("org.springframework.boot:spring-boot-starter-undertow")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
    }
}
