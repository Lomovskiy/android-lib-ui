import com.lomovskiy.lib.ui.buildsrc.Config

plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-parcelize")
    id("maven-publish")
}

android {

    defaultConfig {
        minSdkVersion(Config.Versions.Android.min)
        targetSdkVersion(Config.Versions.Android.target)
        compileSdkVersion(Config.Versions.Android.compile)
        buildToolsVersion(Config.Versions.buildTools)
        versionCode(Config.Versions.code)
        versionName(Config.Versions.name)
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
    api(Config.Libs.mdc)
    api(Config.Libs.threeTenAbp)
    api(Config.Libs.picasso)
    api(Config.Libs.activity)
    api(Config.Libs.fragment)

}

val sourcesJar by tasks.creating(Jar::class) {
    archiveClassifier.set("sources")
    from(android.sourceSets.getByName("main").java.srcDirs)
}

artifacts {
    archives(sourcesJar)
}

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("release") {
                from(components["release"])
                groupId = Config.Publish.groupId
                artifactId = Config.Publish.artifactId
                version = Config.Versions.name
            }
        }
    }
}
