# HashMap & HashSet

## In one sentence
A hash map stores key → value pairs and finds any key in O(1) on average by turning the key into a bucket index; 
A hash set stores unique values the same way.

## The core rule
- key.hashCode() → bucket index → jump straight there (no searching).
- Average O(1) for get, put, contains, remove.
- Worst case O(n): many keys collide in the same bucket.
- Trades memory for speed: O(n) extra space.

## HashMap vs HashSet
|                       | HashMap<K, V>                             | HashSet<E> |
|---                    |---                                        |---|
| Stores                | Key → value pairs                         | Unique values only |
| Add                   | put(key, value) (overwrites existing key) | add(x) (returns false if present) |
| Lookup                | get(key), containsKey(key)                | contains(x) |
| Interview pattern     | Counting, value → index (Two Sum)         | "Seen before?" (Contains Duplicate) |


## When to reach for hashing
- "Have I seen this?" → HashSet
- "How many times?" → HashMap counting
- "Find a pair that sums to X" → HashMap of value → index
- Turns many O(n^2) brute-force solutions into O(n).


## Interview answer
A HashMap stores key-value pairs and uses the key's hash code to jump directly to a bucket, giving O(1) average lookups, inserts, and deletes.
The worst case is O(n) with heavy collisions.
A HashSet works the same way but stores unique values. 
Use HashSet to turn brute-force O(n^2) solutions into O(n), like Two Sum with a map of value to index, at the cost of O(n) extra space.