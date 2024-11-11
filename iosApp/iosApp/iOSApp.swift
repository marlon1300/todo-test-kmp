import SwiftUI
import Routing
import shared

@main
struct iOSApp: App {
    init() {
        KoinKt.doInitKoin()
    }
    
    var body: some Scene {
        WindowGroup {
            RoutingView(MainNavigation.self) { router in
                SplashScreen(router: router)
            }
        }
    }
}
