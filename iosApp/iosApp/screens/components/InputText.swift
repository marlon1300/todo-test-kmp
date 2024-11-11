import SwiftUI
import shared

struct InputText: View {
    let label: String
    var keyboardType: UIKeyboardType = .default
    @Binding var text: String
    var onTextChanged: (String) -> Void
    var invalid: Bool = false
    var icon: KeyPath<SharedRes.images, shared.ImageResource> = \.vec_ic_email
    @State var secure: Bool = false
    
    @State private var toggleSecureEntry = true
    
    var body: some View {
        VStack(alignment: .leading, spacing: 8) {
            // Label for the input field
            Text(label)
                .font(.body)
                .foregroundColor(.black)
            
            HStack {
                // Icon to the left of the text field
                Image(resource: icon)
                    .resizable()
                    .aspectRatio(contentMode: .fill)
                    .frame(width: 24, height: 24)
                
                Spacer().frame(width: 8)
                
                // Text Field or Secure Field based on the secure flag
                
                ZStack() {
                    if secure {
                        if toggleSecureEntry {
                            SecureField("", text: $text)
                                .textFieldStyle(RoundedBorderTextFieldStyle())
                                .keyboardType(keyboardType)
                                .autocapitalization(.none)
                                .disableAutocorrection(true)
                                .padding()
                        } else {
                            TextField("", text: $text)
                                .textFieldStyle(RoundedBorderTextFieldStyle())
                                .keyboardType(keyboardType)
                                .autocapitalization(.none)
                                .disableAutocorrection(true)
                                .padding()
                        }
                    } else {
                        TextField("", text: $text)
                            .textFieldStyle(RoundedBorderTextFieldStyle())
                            .keyboardType(keyboardType)
                            .autocapitalization(.none)
                            .disableAutocorrection(true)
                            .padding()
                    }
                    
                    if secure {
                        HStack {
                            Button(action: {
                                toggleSecureEntry.toggle()
                            }) {
                                Image(resource: \.vec_ic_eye)
                                    .resizable()
                                    .aspectRatio(contentMode: .fill)
                                    .frame(width: 24, height: 24)
                            }
                            .padding(.trailing, 20)
                        }.frame(maxWidth: .infinity, alignment: .trailing)
                    }
                }
            }
            
            // Bottom border (line) and invalid styling
            Divider()
                .background(invalid ? Color.red : Color.gray)
                .frame(height: 1)
        }
        .padding(.horizontal, 16)
        //        .background(Color.gray)
    }
}

struct InputText_Previews: PreviewProvider {
    static var previews: some View {
        InputText(label: "Email Address", text: .constant("test@test.com"), onTextChanged: { _ in }, secure: false)
            .previewLayout(.sizeThatFits)
            .padding()
    }
}
