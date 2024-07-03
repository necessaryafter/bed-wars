plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}

rootProject.name = "bed-wars"

val excludedModules = setOf(
    ":test:exclude",
    ":test2:to-exclude"
)

rootDir.walkTopDown()
    .filter { it.isDirectory }
    .filter { dir -> dir.listFiles()?.any { it.name == "build.gradle.kts" } == true }
    .map { it.toRelativeString(rootDir).replace(File.separatorChar, ':') }
    .filter { it !in excludedModules }
    .forEach { include(it) }

