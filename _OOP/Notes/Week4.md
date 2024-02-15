# Shallow copy vs deep copy
- Using `=` for reference types will create a shallow copy
	- Variable does not contain a separate value but instead has a pointer to the same memory space where the value is stored
	- Changes to the value will affect all variables that has the reference
# Arrays
- Fixed size
- Easy to access
- Fast to iterate
- Recreated when resized
# List
- Resizable
- Easy random access
- Easy add/remove at the end of the list
- Expensive to add/remove in the middle
- Better version of ArrayList
- `list.Count` for size
# LinkedList
- Resizable
- Easy sequential operations
- Easy add/remove anywhere
- Expensive random access
# Queue
- FIFO
- ConcurrentQueue for multithreaded use
- `queue.Enqueue(object)` to add
- `queue.Dequeue()` to remove
# Stack
- LIFO
- ConcurrentStack for multithreaded use
- `stack.Push(object)` to add
- `stack.Pop()` to remove