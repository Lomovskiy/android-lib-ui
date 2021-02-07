buildscript {
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath(com.lomovskiy.lib.ui.buildsrc.Config.GradlePlugins.kotlin)
        classpath(com.lomovskiy.lib.ui.buildsrc.Config.GradlePlugins.android)

        classpath("com.jfrog.bintray.gradle:gradle-bintray-plugin:1.8.4")
        classpath("com.github.dcendents:android-maven-gradle-plugin:1.5")
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        maven {
            setUrl("https://dl.bintray.com/lomovskiy/android_libs")
        }
    }
}
