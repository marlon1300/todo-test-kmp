import SwiftUI
import Routing
import KMPObservableViewModelSwiftUI
import shared

struct LoginScreen: View {
    @StateViewModel var viewModel = ToDoViewModel(toDoRepository: KoinDependencies().toDoRepository)
    @State private var email = "emilys"
    @State private var password = "emilyspass"
    @StateObject var router: Router<MainNavigation>
    @State private var loginError = false
    
    init(router: Router<MainNavigation>) {
        _router = StateObject(wrappedValue: router)
    }
    
    var body: some View {
        BaseScreen(content: {
            VStack(spacing: 0) {
                HStack{
                    Image(resource: \.vec_ic_back) // Replace with actual icon name if using asset
                        .resizable()
                        .frame(width: 44, height: 44)
                        .padding(.top, 60)
                   
                }.frame(maxWidth: .infinity, alignment: .leading)
                // Back button (Image)
                
                
                Spacer().frame(height: 60)
                
                // Header
                Text(Strings().get(id: SharedRes.strings().login_label_title, args: []))
                    .font(.title)
                    .fontWeight(.bold)
                    .padding(.horizontal)
                
                Spacer().frame(height: 40)
                
                // Email input
                InputText(label: Strings().get(id: SharedRes.strings().login_label_email, args: []), text: $email, onTextChanged: { _ in }, icon: \.vec_ic_email, secure: false).frame(maxWidth: .infinity)
                
                Spacer().frame(height: 14)
                
                // Password input
                InputText(label: Strings().get(id: SharedRes.strings().login_label_password, args: []), text: $password, onTextChanged: { _ in}, icon: \.vec_ic_lock, secure: true).frame(maxWidth: .infinity)
                
                Spacer().frame(height: 24)
                
                // Login button (Primary)
                ButtonPrimary(text: Strings().get(id: SharedRes.strings().button_login, args: []), action: {
                    DispatchQueue.main.asyncAfter(deadline: .now()) {
                        viewModel.login(username: email, password: password, completionHandler: {response,_ in
                            if let result = response {
                                let data = result as LoginResult
                                if !data.username.isEmpty  {
                                    loginError = false
                                    router.routeTo(.dashboard)
                                } else {
                                    loginError = true
                                }
                            }
                        })
                    }
                }).frame(maxWidth: .infinity)
                
                Spacer().frame(height: 24)
                
                // Divider with "or" in between
                HStack {
                    Divider().background(Color.gray).frame(height: 1)
                    Text(Strings().get(id: SharedRes.strings().separator_or, args: []))
                        .font(.body)
                        .padding(.horizontal, 4)
                    Divider().background(Color.gray).frame(height: 1)
                }
                .padding(.horizontal)
                
                Spacer().frame(height: 24)
                
                // Social Login buttons (Google and Apple)
                ButtonSocial(text: Strings().get(id: SharedRes.strings().button_social_google, args: []), action: {}, icon: \.vec_ic_google)
                Spacer().frame(height: 12)
                ButtonSocial(text: Strings().get(id: SharedRes.strings().button_social_apple, args: []), action: {}, icon: \.vec_ic_apple)
            }
            .padding(4)
            .background(Color.white) // Background color for the screen
            .edgesIgnoringSafeArea(.all)
        })
    }
}


struct LoginScreen_Preview: PreviewProvider {
    static var previews: some View {
        RoutingView(MainNavigation.self) { router in
            LoginScreen(router: router)
                .previewLayout(.sizeThatFits)
                .padding()
        }
    }
}
