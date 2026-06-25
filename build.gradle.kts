import org.jetbrains.intellij.platform.gradle.TestFrameworkType

plugins {
    id("org.jetbrains.kotlin.jvm")
    id("org.jetbrains.intellij.platform")
    id("org.jetbrains.changelog")
    id("org.jetbrains.grammarkit")
}

repositories {
    mavenCentral()
    intellijPlatform {
        defaultRepositories()
    }
}

sourceSets {
    main {
        java.srcDirs("src/main/kotlin")
    }
}

dependencies {
    testImplementation("junit:junit:4.13.2")

    // IntelliJ Platform Gradle Plugin Dependencies Extension - read more: https://plugins.jetbrains.com/docs/intellij/tools-intellij-platform-gradle-plugin-dependencies-extension.html
    intellijPlatform {
        intellijIdeaCommunity("2024.2.1")
        testFramework(TestFrameworkType.Platform)
    }
}

tasks {
    generateLexer {
        sourceFile = file("src/main/kotlin/com/github/paddax/nc64/lexer/nc64.flex")
        targetOutputDir = file("src/main/kotlin/com/github/paddax/nc64/lexer/gen")
        purgeOldFiles = true
    }
    
    withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
        dependsOn(generateLexer)
    }
}
