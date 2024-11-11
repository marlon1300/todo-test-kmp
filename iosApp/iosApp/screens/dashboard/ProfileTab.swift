import SwiftUI
import Routing
import shared

struct ProfileTab: View {
    @StateObject var router: Router<MainNavigation>
    
    init(router: Router<MainNavigation>) {
        _router = StateObject(wrappedValue: router)
    }

    var body: some View {
        BaseScreen(content: {
            VStack {
                // Profile Header Section
                VStack {
                    Spacer().frame(height: 40)
                    Text(Strings().get(id: SharedRes.strings().profile_title, args: []))
                        .font(.largeTitle)
                        .fontWeight(.bold)
                    
                    Image(resource: \.img_profile_photo) // Replace with your actual asset name
                        .resizable()
                        .scaledToFill()
                        .frame(width: 90, height: 90)
                        .clipShape(Circle()) // Optional: if you want the image to be circular
                    
                    Spacer().frame(height: 20)
                    
                    Text("John Doe")
                        .font(.title3)
                        .foregroundColor(.black)
                    
                    Spacer().frame(height: 20)
                    
                    // Log Out Button
                    Button(action: {router.routeTo(.login)}) {
                        HStack {
                            Image(resource: \.vec_ic_logout)
                                .resizable()
                                .aspectRatio(contentMode: .fill)// Replace with actual asset name for logout icon
                                .frame(width: 24, height: 24)
                            Spacer().frame(width: 8)
                            Text(Strings().get(id: SharedRes.strings().button_logout, args: []))
                                .fontWeight(.bold)
                                .foregroundColor(.red)
                        }
                        .padding(.vertical, 12)
                        .padding(.horizontal, 32)
                        .background(Color.red.opacity(0.2))
                        .cornerRadius(32)
                    }
                    .frame(height: 50)
                }
                .frame(maxWidth: .infinity, alignment: .center)

                Spacer().frame(height: 60)

                // Personal Information Section
                Text(Strings().get(id: SharedRes.strings().profile_title_info, args: []))
                    .font(.title2)
                    .fontWeight(.semibold)
                
                Spacer().frame(height: 40)

                // Full Name and Email Address
                ShowText(label: Strings().get(id: SharedRes.strings().profile_title_full_name, args: []), text: "John Doe", icon: \.vec_ic_email)
                
                Spacer().frame(height: 24)
                
                ShowText(label: Strings().get(id: SharedRes.strings().profile_title_email_address, args: []), text: "johndoe@gmail.com", icon: \.vec_ic_tab_profile)
            }
            .padding()
        })
    }
}


struct ProfileScreen_Preview: PreviewProvider {
    static var previews: some View {
        RoutingView(MainNavigation.self) { router in
            ProfileTab(router: router)
                .previewLayout(.sizeThatFits)
                .padding()
        }
    }
}
