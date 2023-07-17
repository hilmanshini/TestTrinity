package dependencies

import implementation
import org.gradle.api.artifacts.dsl.DependencyHandler


fun DependencyHandler.widgets(){
    implementation("com.facebook.shimmer:shimmer:0.5.0")
}