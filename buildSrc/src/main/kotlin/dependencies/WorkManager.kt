package dependencies

import androidTestImplementation
import implementation
import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.workManager(){
    val work_version = "2.8.1"
    // Kotlin + coroutines
    implementation("androidx.work:work-runtime-ktx:$work_version")
    androidTestImplementation("androidx.work:work-testing:$work_version")
    
    // optional - GCMNetworkManager support
    //implementation("androidx.work:work-gcm:$work_version")
    // optional - Multiprocess support
    //implementation("androidx.work:work-multiprocess:$work_version")
}