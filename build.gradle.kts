buildscript {
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath(com.lomovskiy.lib.ui.buildsrc.Config.GradlePlugins.kotlin)
        classpath(com.lomovskiy.lib.ui.buildsrc.Config.GradlePlugins.android)
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        maven {
            setUrl("https://jitpack.io")
        }
    }
}
