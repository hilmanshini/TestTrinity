package dependencies

import implementation
import org.gradle.api.artifacts.dsl.DependencyHandler

val nav_version = "2.5.3"
fun DependencyHandler.navGraph(){
    implementation("androidx.navigation:navigation-fragment-ktx:$nav_version")
    implementation("androidx.navigation:navigation-ui-ktx:$nav_version")
}