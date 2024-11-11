import SwiftUI

struct TextHeader: View {
    let text: String
    var textAlign: TextAlignment = .leading
    
    var body: some View {
        Text(text)
            .font(.system(size: 24, weight: .bold)) // Font size and weight equivalent to headlineLarge
            .foregroundColor(.black) // Default color is black
            .multilineTextAlignment(textAlign) // Text alignment (leading, center, trailing)
    }
}

struct TextHeader_Previews: PreviewProvider {
    static var previews: some View {
        TextHeader(text: "Test")
            .previewLayout(.sizeThatFits) // Adjust the layout for better preview
            .padding() // Add padding for visibility in the preview
    }
}
