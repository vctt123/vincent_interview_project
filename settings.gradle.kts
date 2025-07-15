pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        @Suppress("JcenterRepositoryObsolete") // 可選，避免 IDE 提示 jcenter 已過時
        jcenter()
        maven(url = "https://jitpack.io")
    }
}

rootProject.name = "vincent_interview_project"
include(":app")
 