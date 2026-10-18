# Day 14 / 90 — MyLinkedList from scratch
### Building the shelf yourself, not buying it from the shop

Unlike an `ArrayList` (which is a contiguous row of indexed boxes), a `LinkedList` is like a treasure hunt: each node holds data and a pointer (clue) pointing to the next node in line.

### Core Components:
- **`Node<T>`**: The building block containing data and a reference to the next node.
- **`head`**: The entry point or start of the treasure hunt.
- **`size`**: Tracks the dynamic length of the list.

### Key Operations Implemented:
1. **`add(T data)`**: Traverses to the end of the list ($O(n)$) and appends a new node.
2. **`addFirst(T data)`**: Instantly prepends a node to the front ($O(1)$).
3. **`get(int index)`**: Walks the chain step-by-step to fetch data at a specific index.
4. **`remove(int index)`**: Bypasses the target node by updating pointer references.
5. **`reverse()`**: The ultimate BBD interview question—uses a 3-pointer trick (`prev`, `current`, `next`) to flip direction in-place in $O(n)$ time.
6. **Generics (`<T>`)**: Fully compatible with `String`, `Integer`, custom objects, and more.

### How to Run Tests:
```bash
mvn test