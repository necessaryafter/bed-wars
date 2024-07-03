plugins {
    kotlin("jvm") version "2.0.0"
    id("java-library")
    id("com.github.johnrengelman.shadow") version ("7.0.0")
}

group = "com.redewinter"
version = "1.0-SNAPSHOT"

allprojects {
    apply(plugin = "kotlin")
    apply(plugin = "java-library")
    apply(plugin = "com.github.johnrengelman.shadow")

    repositories {
        mavenCentral()

        maven(url = "https://jitpack.io")
        maven(url = "https://repo.nickuc.com/maven2/")
        maven(url = "https://repo.nickuc.com/maven-releases/")
        maven(url = "https://repo.dmulloy2.net/repository/public/")
        maven(url = "https://repo.bg-software.com/repository/nms/")
        maven(url = "https://oss.sonatype.org/content/groups/public/")
        maven(url = "https://oss.sonatype.org/content/repositories/snapshots")
        maven(url = "https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
        maven(url = "https://repo.extendedclip.com/content/repositories/placeholderapi/")
        maven(url = "https://repo.hpfxd.com/releases/")
        maven(url = "https://mvnrepository.com/artifact/com.github.azbh111/craftbukkit-1.8.8")
        maven(url = "https://repo.codemc.io/repository/maven-public/")
        maven(url = "https://repo.extendedclip.com/content/repositories/placeholderapi/")
        maven(url = "https://repo.papermc.io/repository/maven-public/")
        maven {
            url = uri("https://158.69.18.74:8080/releases")
            credentials {
                username = "redewinter"
                password = "8e7H0791Puae"
            }
        }
    }

    tasks.withType<JavaCompile> {
        options.encoding = "UTF-8"
    }

    java {
        toolchain.languageVersion.set(JavaLanguageVersion.of(21))
    }
}