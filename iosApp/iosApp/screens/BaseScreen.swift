import SwiftUI

struct BaseScreen<Content: View>: View {
    let content: Content
    
    init(@ViewBuilder content: () -> Content) {
        self.content = content()
    }
    
    var body: some View {
        ZStack {
            Color.white
                .edgesIgnoringSafeArea(.all)
            content
                .padding(.horizontal, 20)
                .padding(.vertical, 20)
                .frame(maxWidth: .infinity, maxHeight: .infinity, alignment: .top)
                .navigationBarBackButtonHidden(true)
        }
    }
}
