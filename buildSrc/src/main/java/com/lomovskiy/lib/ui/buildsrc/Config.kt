package com.lomovskiy.lib.ui.buildsrc

object Config {

    object Publish {
        const val groupId = "com.lomovskiy.lib"
        const val artifactId = "ui"
    }

    object GradlePlugins {

        const val android: String = "com.android.tools.build:gradle:${Versions.androidGradlePlugin}"
        const val kotlin: String = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"

    }

    object Versions {

        const val code = 8
        const val name = "1.0.7"

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
