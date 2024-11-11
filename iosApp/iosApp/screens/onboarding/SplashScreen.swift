import SwiftUI
import Routing

struct SplashScreen: View {
    @State private var isActive = false
    @State private var size = 0.8
    @State private var opacity = 0.5
    
    @StateObject var router: Router<MainNavigation>
    
    init(router: Router<MainNavigation>) {
        _router = StateObject(wrappedValue: router)
    }
    
    var body: some View {
        BaseScreen(content: {
            ZStack {
                Color.white
                    .ignoresSafeArea()
                VStack {
                    Image(resource: \.vec_ic_splash) // Replace with your image name in Assets
                        .resizable()
                        .scaledToFit()
                        .frame(width: 135, height: 180)
                }
                .scaleEffect(size)
                .opacity(opacity)
                .onAppear {
                    withAnimation(.easeIn(duration: 1.2)) {
                        self.size = 0.9
                        self.opacity = 1.0
                    }
                }
            }.onAppear{
                DispatchQueue.main.asyncAfter(deadline: .now() + 2) {
                    withAnimation{
                        self.isActive = true
                        router.routeTo(.onboarding)
                    }
                }
            }
        })
    }
}

struct SplashScreen_Preview: PreviewProvider {
    static var previews: some View {
        RoutingView(MainNavigation.self) { router in
            SplashScreen(router: router)
                .previewDevice("iPhone 16 Pro")
        }
    }
}
