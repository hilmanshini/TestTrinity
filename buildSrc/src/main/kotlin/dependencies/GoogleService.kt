package dependencies

import implementation
import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.googleService() {
    implementation(platform("com.google.firebase:firebase-bom:32.0.0"))
    implementation("com.google.firebase:firebase-analytics-ktx")
    implementation("com.google.firebase:firebase-crashlytics-ktx")

}