package com.lomovskiy.android.lib.camera.buildsrc

object Config {

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

    }

    object Modules {

        const val app: String = ":app"
        const val lib: String = ":lib"

    }

    object Libs {

        const val kotlinStd: String = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
        const val mdc: String = "com.google.android.material:material:${Versions.mdc}"

    }

}
