plugins {
    kotlin("jvm") version "2.4.0-Beta1"
    id("java-library")

    id("com.gradleup.shadow") version "8.3.0"
    id("xyz.jpenilla.run-paper") version "2.3.1"
}

group = "org.example.wleku"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/") {
        name = "papermc-repo"
    }
    maven ("https://repo.nightexpressdev.com/releases")
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:1.21.11-R0.1-SNAPSHOT")
    compileOnly("net.luckperms:api:5.4")
    compileOnly("su.nightexpress.excellenteconomy:ExcellentEconomy:2.8.0")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
}


tasks {
    runServer {
        // Configure the Minecraft version for our task.
        // This is the only required configuration besides applying the plugin.
        // Your plugin's jar (or shadowJar if present) will be used automatically.
        minecraftVersion("1.21")
    }
}

val targetJavaVersion = 25

kotlin {
    jvmToolchain(targetJavaVersion)
}

java {
    toolchain.languageVersion = JavaLanguageVersion.of(targetJavaVersion)
}

tasks.build {
    dependsOn("shadowJar")
}

tasks.processResources {
    val props = mapOf("version" to version)
    inputs.properties(props)
    filteringCharset = "UTF-8"
    filesMatching("plugin.yml") {
        expand(props)
    }
}