import com.lomovskiy.lib.ui.buildsrc.Config

plugins {
    id("com.android.application")
    id("kotlin-android")
}

android {

    defaultConfig {
        applicationId("com.lomovskiy.lib.ui.sample")
        minSdkVersion(Config.Versions.Android.min)
        targetSdkVersion(Config.Versions.Android.target)
        compileSdkVersion(Config.Versions.Android.compile)
        buildToolsVersion(Config.Versions.buildTools)
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

    implementation(Config.Libs.kotlinStd)
    implementation(Config.Libs.mdc)
    implementation("com.lomovskiy.lib:ui:1.0")
//    implementation(project(Config.Modules.lib))

}