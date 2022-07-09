import SwiftUI

@main
struct iOSApp: App {
	var body: some Scene {
		WindowGroup {
            PhotoView(viewModel: Injector.injectViewModel())
		}
	}
}
