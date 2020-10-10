import java.time.LocalDateTime

plugins {
    kotlin("js") version "1.4.10"
    kotlin("plugin.serialization") version "1.4.10"
}
group = "pro.devil"
version = "1.0-SNAPSHOT"

val kotlinPckVer = "16.13.1-pre.121-kotlin-1.4.10"
val kotlinStyledVer = "5.2.0-pre.121-kotlin-1.4.10"
val kotlinCoroutinesVer = "1.3.9"
val kotlinHtmlJsVer = "0.7.2"

repositories {
    mavenCentral()
    jcenter()
    maven {
        url = uri("https://dl.bintray.com/kotlin/kotlinx")
    }
    maven {
        url = uri("https://dl.bintray.com/kotlin/kotlin-js-wrappers")
    }
}
dependencies {
    testImplementation(kotlin("test-js"))
    implementation("org.jetbrains.kotlinx:kotlinx-html-js:$kotlinHtmlJsVer")
    implementation("org.jetbrains:kotlin-react:$kotlinPckVer")
    implementation("org.jetbrains:kotlin-react-dom:$kotlinPckVer")
    implementation("org.jetbrains:kotlin-styled:$kotlinStyledVer")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$kotlinCoroutinesVer")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.0.0-RC2") // JVM dependency

    implementation(npm("jquery", "3.5.1"))
    implementation(npm("popper.js", "^1.16.1"))
    implementation(npm("bootstrap", "4.5.2"))

}
kotlin {
    js(IR) {
        browser {
            binaries.executable()
            runTask {
                outputFileName = "main.bundle.js"
            }
            webpackTask {
                outputFileName = "main.bundle.js"
                cssSupport.enabled = true
            }
            runTask {
                cssSupport.enabled = true
            }
            testTask {
                useKarma {
                    useChromeHeadless()
                    webpackConfig.cssSupport.enabled = true
                }
            }

            tasks {
                task("deploy") {
                    group = "site"
                    dependsOn("build")

                    doLast {
                        val deployDir = "$projectDir/docs"
                        copy {
                            println("Copy dist files....")
                            from("$buildDir/distributions")
                            into(deployDir)
                        }

                        exec {
                            println("Add/Update files to git repository...")
                            workingDir(deployDir)
                            executable = "git"
                            args("add", "$deployDir/*")
                        }

                        exec {
                            println("Commit files to git repository...")
                            workingDir(deployDir)
                            executable = "git"
                            args("commit", "-m", "Site Deploy ${LocalDateTime.now()}")
                        }

                        exec {
                            println("Push files to git repository...")
                            workingDir(deployDir)
                            executable = "git"
                            args("push", "origin", "master")
                        }
                    }
                }
            }
        }
    }
}