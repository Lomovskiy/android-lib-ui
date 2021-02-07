buildscript {
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath(com.lomovskiy.android.lib.ui.buildsrc.Config.GradlePlugins.kotlin)
        classpath(com.lomovskiy.android.lib.ui.buildsrc.Config.GradlePlugins.android)

        classpath("com.jfrog.bintray.gradle:gradle-bintray-plugin:1.8.4")
        classpath("com.github.dcendents:android-maven-gradle-plugin:1.5")
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}
