pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "CoinPrice"
include(":app")
include(":core")
include(":core:navigation")
include(":core:network")
include(":core:utilities")
include(":core:ui")

include(":features")
include(":features:detail")
include(":features:home")
include(":features:signup")
