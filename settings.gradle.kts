pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
        mavenLocal()
        maven(uri("https://s01.oss.sonatype.org/content/repositories/snapshots/"))
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        mavenLocal()
        maven(uri("https://s01.oss.sonatype.org/content/repositories/snapshots/"))
    }
}

rootProject.name = "kmm-s2s-test2"
include(":shared")