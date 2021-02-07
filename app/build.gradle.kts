import com.lomovskiy.android.lib.ui.buildsrc.Config

plugins {
    id("com.android.application")
    id("kotlin-android")
}

android {

    defaultConfig {
        applicationId("com.lomovskiy.android.lib.ui.sample")
        minSdkVersion(com.lomovskiy.android.lib.ui.buildsrc.Config.Versions.Android.min)
        targetSdkVersion(com.lomovskiy.android.lib.ui.buildsrc.Config.Versions.Android.target)
        compileSdkVersion(com.lomovskiy.android.lib.ui.buildsrc.Config.Versions.Android.compile)
        buildToolsVersion(com.lomovskiy.android.lib.ui.buildsrc.Config.Versions.buildTools)
        versionCode(1)
        versionName("1.0")

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
//        release {
//            minifyEnabled false
//            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
//        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(com.lomovskiy.android.lib.ui.buildsrc.Config.Libs.kotlinStd)
    implementation(com.lomovskiy.android.lib.ui.buildsrc.Config.Libs.mdc)
    implementation(project(com.lomovskiy.android.lib.ui.buildsrc.Config.Modules.lib))

}