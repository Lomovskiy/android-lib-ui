buildscript {
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath(com.lomovskiy.android.lib.camera.buildsrc.Config.GradlePlugins.kotlin)
        classpath(com.lomovskiy.android.lib.camera.buildsrc.Config.GradlePlugins.android)
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}
