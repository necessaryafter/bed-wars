plugins {
    id("io.papermc.paperweight.userdev") version "1.7.1"
}

dependencies {
    paperweight.paperDevBundle("1.21-R0.1-SNAPSHOT")

    compileOnly(libs.event.bus)
}