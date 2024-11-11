import SwiftUI
import Routing
import shared

struct DashboardScreen: View {
    private let dashboardTabs = DashboardTabItem.companion.doInitData()
    
    @State private var currentTab: String = "Home"
    @StateObject var router: Router<MainNavigation>
    
    init(router: Router<MainNavigation>) {
        _router = StateObject(wrappedValue: router)
    }
    
    var body: some View {
        BaseScreen(content: {
            ZStack(alignment: .bottomTrailing) {
                TabView(selection: $currentTab) {
                    HomeTab()
                        .tabItem {
                            Image(resource: currentTab == String(resource: dashboardTabs[0].title) ? dashboardTabs[0].selectedIcon : dashboardTabs[0].unselectedIcon)
                            Text(String(resource: dashboardTabs[0].title))
                        }
                        .tag(String(resource: dashboardTabs[0].title))
                    FilterTab()
                        .tabItem {
                            Image(resource: currentTab == String(resource: dashboardTabs[1].title) ? dashboardTabs[1].selectedIcon : dashboardTabs[1].unselectedIcon)
                            Text(String(resource: dashboardTabs[1].title))
                        }
                        .tag(String(resource: dashboardTabs[1].title))
                    NotificationTab()
                        .tabItem {
                            Image(resource: currentTab == String(resource: dashboardTabs[2].title) ? dashboardTabs[2].selectedIcon : dashboardTabs[2].unselectedIcon)
                            Text(String(resource: dashboardTabs[2].title))
                        }
                        .tag(String(resource: dashboardTabs[2].title))
                    ProfileTab(router: router)
                        .tabItem {
                            Image(resource: currentTab == String(resource: dashboardTabs[3].title) ? dashboardTabs[3].selectedIcon : dashboardTabs[3].unselectedIcon)
                            Text(String(resource: dashboardTabs[3].title))
                        }
                        .tag(String(resource: dashboardTabs[3].title))
                    
                }
                Button {} label: {
                    Image(systemName: "plus")
                        .font(.title.weight(.semibold))
                        .padding()
                        .background(Color.blue)
                        .foregroundColor(.white)
                        .clipShape(Circle())
                        .shadow(radius: 4, x: 0, y: 4)
                }
                .offset(y: -60)
                .padding()
            }.frame(maxHeight: .infinity)
        })
    }
}

#Preview {
    RoutingView(MainNavigation.self) { router in
        DashboardScreen(router: router)
    }
}
