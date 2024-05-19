plugins {
    id("java")
}

group = "kz.ableacademy"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(platform("org.junit:junit-bom:5.9.1"))
    implementation("org.junit.jupiter:junit-jupiter")
    implementation("com.codeborne:selenide:7.3.1")
    implementation("org.seleniumhq.selenium:selenium-java:4.21.0")
    implementation("org.slf4j:slf4j-nop:2.0.13")
}

tasks.test {
    useJUnitPlatform()
}