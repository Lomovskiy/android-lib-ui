buildscript {
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath(com.lomovskiy.android.lib.ui.buildsrc.Config.GradlePlugins.kotlin)
        classpath(com.lomovskiy.android.lib.ui.buildsrc.Config.GradlePlugins.android)
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}
