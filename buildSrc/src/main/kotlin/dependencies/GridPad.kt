package dependencies

import implementation
import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.GridPad() {
    implementation ("com.google.accompanist:accompanist-flowlayout:0.30.1")

}