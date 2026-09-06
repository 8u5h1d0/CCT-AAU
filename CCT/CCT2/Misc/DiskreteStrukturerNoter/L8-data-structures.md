# L8 — Basic Data Structures (≈2h block)

**Topic & reading**: Dynamic sets, stacks, queues, linked lists, (binary/rooted) trees, heaps, dictionaries/direct-address tables, and their operation complexities — **Cormen 10.1, 10.2, 10.4** (Lecture 9, "Basic Data Structures").

Exam relevance: Part 2 (final topic). Expect: trace operations, give the complexity table, choose the right structure.

---

## Key definitions

- **Data structure (datastruktur)** — a way of organising/storing data for efficient access; the concrete representation of a **dynamic set** (a set that grows/shrinks over time).
- **Dynamic set operations**: `SEARCH(S,k)`, `INSERT(S,x)`, `DELETE(S,x)`, `MINIMUM`, `MAXIMUM`, `SUCCESSOR`, `PREDECESSOR`.
- **Stack (stak)** — **LIFO** (last-in first-out). `PUSH`, `POP`, `STACK-EMPTY`. Overflow on push to full array; underflow on pop of empty.
- **Queue (kø)** — **FIFO** (first-in first-out). `ENQUEUE` at tail, `DEQUEUE` at head; array implementation wraps around circularly (`Q.head`, `Q.tail`).
- **Linked list (hægtet liste)** — nodes with `key` + pointer(s). **Singly** (`next`), **doubly** (`prev,key,next`); sorted/unsorted; circular (`next(tail)=head`).
- **Rooted / binary tree (træ)** — each non-root node has a `parent`; binary tree: `left-child`, `right-child` (fixed branching). Unbounded branching: `left-child` + `right-sibling`.
- **Heap (hob)** — nearly-complete binary tree stored in an array. **Max-heap**: $A[\text{parent}(i)]\ge A[i]$; **min-heap**: $\le$. Array navigation: `PARENT(i)=⌊i/2⌋`, `LEFT(i)=2i`, `RIGHT(i)=2i+1`.
- **Dictionary (opslagstabel)** / associative array — maps keys → data; ops `INSERT/DELETE/SEARCH`. Implemented by **direct-address tables** (array indexed by key, $O(1)$ but huge space) or **hash tables**.

## Pseudocode (Cormen)

```
STACK:  PUSH(S,x): S.top := S.top+1; S[S.top] := x
        POP(S): if STACK-EMPTY(S) error "underflow"; S.top := S.top-1; return S[S.top+1]

QUEUE:  ENQUEUE(Q,x): Q[Q.tail] := x; Q.tail := (Q.tail mod n)+1
        DEQUEUE(Q):  x := Q[Q.head]; Q.head := (Q.head mod n)+1; return x

LIST:   LIST-SEARCH(L,k): x := L.head; while x ≠ NIL and x.key ≠ k: x := x.next; return x
        LIST-INSERT(L,x): x.next := L.head; if L.head≠NIL: L.head.prev := x; L.head := x; x.prev := NIL
        LIST-DELETE(L,x): if x.prev≠NIL: x.prev.next := x.next else L.head := x.next;
                          if x.next≠NIL: x.next.prev := x.prev
```

## Complexity of operations

| Operation | Stack | Queue | Linked list | Direct-address table |
|---|---|---|---|---|
| Insert | $O(1)$ | $O(1)$ | $O(1)$ (at head) | $O(1)$ |
| Delete | $O(1)$ | $O(1)$ | $O(1)$ (node known) | $O(1)$ |
| Search | — | — | $O(n)$ | $O(1)$ |
| Access ends | top $O(1)$ | head/tail $O(1)$ | — | — |

Space: stack/queue/list $O(n)$; direct-address table $O(|U|)$ (size of key universe — can be huge). Heap: insert/extract-max $O(\log n)$, find-max $O(1)$.

## Worked example

**Stack vs queue on the sequence push/enqueue 1,2,3 then remove three:**
- Stack (LIFO): out order **3, 2, 1**.
- Queue (FIFO): out order **1, 2, 3**.

**Heap as array:** the max-heap `16,14,10,8,7,9,3,2,4,1` — node at index 2 (value 14) has children at indices 4,5 (values 8,7), parent at $⌊2/2⌋=1$ (value 16). Heap property $16\ge14$, $14\ge8$, $14\ge7$ all hold. ✓

## Practice problems

1. Start with empty stack. `PUSH 5, PUSH 8, POP, PUSH 2, POP, POP`. What is returned each POP, and the final stack?
2. Same sequence as enqueues/dequeues on a queue. Output order?
3. Why is search on an unsorted linked list $O(n)$ but indexing a direct-address table $O(1)$? What is the cost of the table?
4. Give array indices of the parent, left and right child of the element at index 6 in a heap.
5. Which structure for: (a) undo history, (b) print job spooler, (c) fast membership test over a small integer key range?

<details><summary>Solutions</summary>

1. POPs return 8, then 2, then 5; final stack empty.
2. Queue output: 5, then 8, then 2 (FIFO).
3. List has no index → must follow `next` pointers up to $n$ times. Table uses the key directly as an array index ($O(1)$) but needs an array as large as the whole key universe $|U|$ (large space).
4. Parent $⌊6/2⌋=3$, left $2\cdot6=12$, right $2\cdot6+1=13$.
5. (a) stack (LIFO), (b) queue (FIFO), (c) direct-address table / dictionary.
</details>

## Common pitfalls / exam tips
- LIFO vs FIFO is the classic exam discriminator — state which **end** each operation acts on.
- Array stack/queue can **overflow**; the queue array is **circular** (indices wrap with `mod`).
- Heap array uses 1-based indices for the clean $2i,\,2i+1,\,⌊i/2⌋$ formulas.
- Tie operation costs back to [[L6-growth-asymptotics]]; the right structure choice is what makes an algorithm efficient (link to [[L7-algorithm-design]]).
