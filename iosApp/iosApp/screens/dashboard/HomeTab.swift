import SwiftUI
import KMPObservableViewModelSwiftUI
import shared

struct HomeTab: View {
    @StateViewModel var viewModel = ToDoViewModel(toDoRepository: KoinDependencies().toDoRepository)
    @State private var todos = [ToDo] ()
    
    var body: some View {
        ScrollView {
            VStack {
                ForEach(todos, id: \.self) { todo in
                    Text("\(todo.todo)")
                        .frame(maxWidth: .infinity, minHeight: 50)
                        .background(Color.blue)
                        .padding(.leading, 4)
                        .padding(.trailing, 4)
                        .foregroundStyle(.white)
                        .clipShape(RoundedRectangle(cornerRadius: 10))
                }
            }
            .padding(.bottom, 50)
            .onAppear{
                DispatchQueue.main.asyncAfter(deadline: .now()) {
                    todos.removeAll()
                    viewModel.fetchToDos(completionHandler: {toDos,_ in
                        if let succes = toDos {
                            let todoResult = (succes as ToDos).todos
                            todoResult.forEach { todo in
                                todos.append(todo as ToDo)
                            }

                        } else {
                            print("empty")
                        }
                    })
                }
            }
        }
    }
}

#Preview {
    HomeTab()
}
