package dependencies

import implementation
import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.compressor(){
    implementation("id.zelory:compressor:3.0.1")
}