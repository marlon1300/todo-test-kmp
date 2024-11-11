import SwiftUI

struct TextBody: View {
    let text: String
    var textAlign: TextAlignment = .leading
    var textColor: Color = .black
    
    var body: some View {
        Text(text)
            .font(.body) // This corresponds to MaterialTheme.typography.bodyLarge in Compose
            .foregroundColor(textColor) // Sets the text color
            .multilineTextAlignment(textAlign) // Aligns the text (left, center, right)
    }
}

struct TextBody_Previews: PreviewProvider {
    static var previews: some View {
        TextBody(text: "Test")
            .previewLayout(.sizeThatFits) // Adjust the layout for better preview
            .padding() // Add padding for visibility in the preview
    }
}
