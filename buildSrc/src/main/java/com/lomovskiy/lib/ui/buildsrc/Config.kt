package com.lomovskiy.lib.ui.buildsrc

object Config {

    val bintrayRepo = "android_libs"
    val bintrayName = "ui"
    val publishedGroupId = "com.lomovskiy.lib"
    val artifact = "ui"
    val libraryVersion = "1.0.1"
    val gitUrl = "https://github.com/Lomovskiy/android_lib_ui"
    val allLicenses = arrayOf("MIT")

    object GradlePlugins {

        const val android: String = "com.android.tools.build:gradle:${Versions.androidGradlePlugin}"
        const val kotlin: String = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"

    }

    object Versions {

        object Android {

            const val target: Int = 30
            const val compile: Int = 30
            const val min: Int = 16

        }

        const val androidGradlePlugin: String = "4.1.2"
        const val buildTools: String = "30.0.3"

        const val kotlin: String = "1.4.30"
        const val mdc: String = "1.3.0"
        const val threeTenAbp: String = "1.3.0"
        const val picasso: String = "2.71828"

    }

    object Modules {

        const val app: String = ":app"
        const val lib: String = ":lib"

    }

    object Libs {

        const val kotlinStd: String = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
        const val mdc: String = "com.google.android.material:material:${Versions.mdc}"
        const val threeTenAbp: String = "com.jakewharton.threetenabp:threetenabp:${Versions.threeTenAbp}"
        const val picasso: String = "com.squareup.picasso:picasso:${Versions.picasso}"

    }

}