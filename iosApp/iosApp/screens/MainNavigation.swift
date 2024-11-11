import SwiftUI
import Routing



enum MainNavigation: Routable {
    case splash
    case onboarding
    case login
    case dashboard
    
    @ViewBuilder
    func viewToDisplay(router: Router<MainNavigation>) -> some View {
        switch self {
        case .splash:
            SplashScreen(router: router)
        case .onboarding:
            OnboardingScreen(router: router)
        case .dashboard:
            DashboardScreen(router: router)
        case .login:
            LoginScreen(router: router)
        }
    }
    
    var navigationType: NavigationType {
        switch self {
        case .splash:
            return .push
        case .onboarding:
            return .push
        case .dashboard:
            return .push
        case .login:
            return .push
        }
    }
}
