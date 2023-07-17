package dependencies

import org.gradle.api.artifacts.dsl.DependencyHandler
import implementation

fun DependencyHandler.joda() {
    implementation("joda-time:joda-time:2.12.5")

}