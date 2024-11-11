import SwiftUI
import shared

struct ButtonSocial: View {
    var text: String
    var enabled: Bool = true
    var action: () -> Void
    var icon: KeyPath<SharedRes.images, shared.ImageResource> = \.vec_ic_google // Assuming you have the image asset named "google_icon"

    var body: some View {
        Button(action: action) {
            HStack {
                Image(resource: icon) // Use a system icon or replace with your asset
                    .resizable()
                    .scaledToFit()
                    .frame(width: 24, height: 24)
                Spacer().frame(width: 12)
                Text(text)
                    .font(.body) // Adjust the font to match the `labelLarge` style
                    .foregroundColor(.black)
                    .padding(.vertical, 2)
            }
            .frame(maxWidth: .infinity)
            .padding() // Optional padding for the button
            .background(Color.gray.opacity(0.3)) // LightGray background
            .cornerRadius(10) // RectangleShape equivalent
             // Equivalent to `fillMaxWidth()`
        }
        .disabled(!enabled)
        // Disable the button if `enabled` is false
    }
}

struct ButtonSocial_Preview: PreviewProvider {
    static var previews: some View {
        ButtonSocial(text: "Next", action: {})
            .previewLayout(.sizeThatFits)
            .padding()
    }
}
