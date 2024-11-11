import SwiftUI
import Routing
import shared

struct OnboardingScreen: View {
    @State private var pageNumber = 0
    private let onboardingSteps = OnboardingData.companion.doInitData()
    @StateObject var router: Router<MainNavigation>
    
    init(router: Router<MainNavigation>) {
        _router = StateObject(wrappedValue: router)
    }
    var body: some View {
        BaseScreen(content: {
            VStack {
                Spacer()
                // Current Onboarding Content
                OnboardingContent(content: onboardingSteps[pageNumber])
                Spacer()
                
                // Next Button
                ButtonPrimary(text:Strings().get(id: SharedRes.strings().button_next, args: [])) {
                    if pageNumber < 2 {
                        pageNumber += 1
                    } else {
                        router.routeTo(.login)
                    }
                }
            }
            .background(Color.white)
            .edgesIgnoringSafeArea(.all)
        })
    }
}

struct OnboardingContent: View {
    let content: OnboardingData
    
    var body: some View {
        VStack(spacing: 40) {
            Image(resource: content.res)
                .resizable()
                .scaledToFit()
                .frame(width: 213, height: 277)
            
            TextHeader(text: String(resource: content.title))
            
            TextBody(text: String(resource: content.body))
                .multilineTextAlignment(.center)
        }
        .padding()
        .frame(maxWidth: .infinity)
    }
}

struct ButtonPrimary: View {
    let text: String
    let action: () -> Void
    
    var body: some View {
        Button(action: action) {
            Text(text)
                .font(.headline)
                .frame(maxWidth: .infinity)
                .padding()
                .background(Color.blue)
                .foregroundColor(.white)
                .cornerRadius(8)
        }
    }
}

struct OnboardingScreen_Previews: PreviewProvider {
    static var previews: some View {
        RoutingView(MainNavigation.self) { router in
            OnboardingScreen(router: router)
                .previewDevice("iPhone 16 Pro")
        }
    }
}
