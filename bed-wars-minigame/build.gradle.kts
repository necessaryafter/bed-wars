plugins {
    id("io.papermc.paperweight.userdev") version "1.7.1"
}

dependencies {
    paperweight.paperDevBundle("1.20.4-R0.1-SNAPSHOT")

    compileOnly(project(":bed-wars-common:spigot"))
    compileOnly(project(":bed-wars-lobby"))

    compileOnly(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
}