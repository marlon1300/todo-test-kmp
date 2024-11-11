import Foundation
import shared
import SwiftUI

extension Image {
    init(resource: KeyPath<SharedRes.images, shared.ImageResource>) {
        self.init(uiImage: SharedRes.images()[keyPath: resource].toUIImage()!)
    }
}

extension Image {
    init(resource: shared.ImageResource) {
        self.init(uiImage: resource.toUIImage()!)
    }
}

extension String {
    init(resource: shared.StringResource) {
        self = resource.desc().localized()
    }
}
