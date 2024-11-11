import SwiftUI
import shared

struct ShowText: View {
    var label: String
    var text: String
    var icon: KeyPath<SharedRes.images, shared.ImageResource> // Use the system name for icons or asset names
    
    var body: some View {
        VStack(alignment: .leading) {
            Text(label)
                .font(.subheadline)
                .foregroundColor(.gray)
            
            Spacer().frame(height: 8)
            
            HStack() {
                Image(resource: icon) // Use system icon name or replace with your asset name
                    .resizable()
                    .aspectRatio(contentMode: .fill)
                    .frame(width: 24, height: 24)
                    .foregroundColor(.gray) // Optional: adjust icon color
                
                Spacer().frame(width: 12)
                
                Text(text)
                    .font(.body)
                    .foregroundColor(.black)
                    .lineLimit(1) // To avoid text overflowing
            }
            .frame(maxWidth: .infinity, alignment: .leading)
            .padding(.vertical, 8)
        }
        .frame(maxWidth: .infinity)
        .padding(.horizontal)
        
    }
}

struct ShowText_Preview: PreviewProvider {
    static var previews: some View {
        ShowText(label: "Email Address", text: "test@test.com", icon: \.vec_ic_email)
            .previewLayout(.sizeThatFits)
            .padding()
    }
}
