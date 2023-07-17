package dependencies

import implementation
import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.calendar() {
    implementation("com.kizitonwose.calendar:compose:2.3.0")
}