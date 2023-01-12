plugins {
    id("java")
}

group = "eu.ansquare.mctextrandomizer"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
    //implementation("com.googlecode.json-simple:json-simple:1.1")
    implementation("com.fasterxml.jackson.core:jackson-core:2.3.2")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.3.2")




}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}