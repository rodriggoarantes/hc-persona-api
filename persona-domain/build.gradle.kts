plugins {
    id("idea")
    id("eclipse")
    kotlin("jvm")
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.2")
    testImplementation("org.mockito:mockito-core:4.3.1")
    // testImplementation("com.nhaarman.mockitokotlin2:mockito-kotlin:${property("mockitoKotlinVersion")}")
}

