package dependencies

import org.gradle.api.artifacts.dsl.DependencyHandler
import implementation
import debugImplementation

const val composeVersion = "1.4.2"
const val lifecycle_version = "2.6.1"

fun DependencyHandler.compose() {
    implementation("androidx.compose.ui:ui:$composeVersion")
    implementation("androidx.compose.material:material:$composeVersion")
    implementation("androidx.activity:activity-compose:1.4.0")
    implementation("androidx.navigation:navigation-compose:$nav_version")
    implementation("androidx.compose.material:material-icons-extended:$composeVersion")
    implementation("androidx.hilt:hilt-navigation-compose:1.0.0")
    implementation("androidx.compose.runtime:runtime-livedata:$composeVersion")

    implementation("androidx.compose.material3:material3:1.0.1")
    implementation("androidx.constraintlayout:constraintlayout-compose:1.0.1")

    val accompanistVersion = "0.30.1"
    implementation("com.google.accompanist:accompanist-navigation-material:$accompanistVersion")
    implementation("com.google.accompanist:accompanist-placeholder:$accompanistVersion")
    implementation("androidx.compose.ui:ui-tooling-preview:$composeVersion")
    debugImplementation("androidx.compose.ui:ui-tooling:$composeVersion")

//    debugImplementation("androidx.compose.ui:ui-tooling:$composeVersion")
    debugImplementation("androidx.compose.ui:ui-test-manifest:$composeVersion")
    implementation("androidx.constraintlayout:constraintlayout-compose:1.0.1")
    implementation("androidx.compose.material:material-icons-extended:$composeVersion")
    implementation("androidx.hilt:hilt-navigation-compose:1.0.0")
    implementation("androidx.compose.runtime:runtime-livedata:$composeVersion")
    implementation("androidx.compose.ui:ui-util:${composeVersion}")
    implementation("androidx.lifecycle:lifecycle-runtime-compose:${lifecycle_version}")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:$lifecycle_version")

}