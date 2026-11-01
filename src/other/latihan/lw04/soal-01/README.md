# ES234317 – Data Structure and Algorithms

## Labwork 04 – Sorting and Searching

**Language:** Java  
**Mode:** Individual Practical Work
**AI Tools:** ChatGPT

---

## Case: Time Hop Championship

Rid is organizing a Time Hop Championship in which participants compete based on their timeline stability scores.

Each participant has a stability score ranging from 1 to 10. Before the championship results are announced, Rid must arrange the scores from the highest to the lowest.

However, the sorting machine has limited energy. It can only perform a certain number of sorting passes before it automatically shuts down.

Rid uses the same sorting algorithm every time, but he does not remember which algorithm he programmed. You are given three old records showing the initial array and the resulting array after three passes.

Your task is to identify the sorting algorithm, process the championship scores, and find the positions of the requested stability scores.

### A. Algorithm Identification

Rid's machine uses one of the following sorting algorithms:

1. Bubble Sort
2. Selection Sort
3. Insertion Sort

All algorithms sort in descending order.

The following records were recovered:

**Record 1**

| Before | After 3 Passes |
|:---|:---|
| 3 7 1 9 5 8 2 | 9 7 3 1 5 8 2 |

**Record 2**

| Before | After 3 Passes |
|:---|:---|
| 2 5 8 1 10 6 3 | 8 5 2 1 10 6 3 |

**Record 3**

| Before | After 3 Passes |
|:---|:---|
| 4 6 2 10 3 8 1 | 10 6 4 2 3 8 1 |

Determine which sorting algorithm produces all three results.

**Note:** This identification must be done outside your Java program. Your program only needs to implement the identified algorithm.

---

### B. Exact Behaviour

Your program must follow these requirements:

1. Read the input from `championship.txt` using `Scanner`.
2. The first line contains an integer `N`, representing the number of participants.
   - `5 <= N <= 15`
3. The second line contains `N` integer stability scores, separated by spaces.
   - Each score is between 1 and 10.
   - Duplicate scores are allowed.
4. The third line contains an integer `P`, representing the number of sorting passes.
   - `1 <= P <= N - 1`
5. The fourth line contains an integer `M`, representing the number of target scores.
   - `1 <= M <= 5`
6. The fifth line contains `M` target scores.

**Sorting Requirements:**

- Store all stability scores in an `int[]` array.
- Implement only the sorting algorithm identified from Rid's records.
- Sort the array in descending order.
- Perform exactly `P` passes.
- Stop immediately after the specified number of passes, even if the array is not fully sorted.

**Searching Requirements:**

- Search for every target score using Linear Search.
- Search the entire array, starting from index 0.
- If a target appears more than once, report all its indices.
- If a target does not exist, display `NOT FOUND`.
- The search results must follow the original target order in the input file.

---

### C. Tasks

#### A1. Implementation and Demonstration

Create a Java program that processes the championship scores using Sorting and Searching algorithms.

1. **Identify the Sorting Algorithm**
   - Use Rid's three records to determine which sorting algorithm he uses.

2. **Read the Input**
   - Read `championship.txt` using `Scanner`.
   - Read `N` and the `N` stability scores.
   - Read `P`, `M`, and the `M` target scores.
   - Store the stability scores and targets in separate `int[]` arrays.

3. **Perform Sorting**
   - Implement the identified sorting algorithm.
   - Sort the array in descending order.
   - Perform exactly `P` passes.
   - Stop after the specified number of passes.

4. **Perform Searching**
   - Search for each target using Linear Search.
   - Find all indices where the target appears.
   - Count the total occurrences of each target.

5. **Display the Results**
   - Display the array after sorting.
   - Display the search results for each target.
   - Follow the required output format.

#### A2. Required Checks

Your program must be able to handle:

- An array that is not fully sorted after the specified passes.
- A target that appears only once.
- A target that appears multiple times.
- A target that does not exist in the array.
- The maximum number of participants.
- Different numbers of sorting passes.

#### A3. Additional Demonstration

Explain briefly:

1. Why the selected sorting algorithm matches all three records.
2. Why the resulting array might not be fully sorted.
3. Why Linear Search is appropriate for searching the partially sorted array.
4. What happens when a target appears multiple times.

---

### D. Example Input

**Input file: `championship.txt`**

```text
10
6 2 10 4 8 1 7 3 8 2
4
4
8 2 5 7
```

**Input Description:**

| Line | Description | Value |
|:---:|:---|:---|
| 1 | Number of participants (`N`) | 10 |
| 2 | Stability scores | 6 2 10 4 8 1 7 3 8 2 |
| 3 | Number of sorting passes (`P`) | 4 |
| 4 | Number of targets (`M`) | 4 |
| 5 | Target scores | 8 2 5 7 |

---

### E. Expected Program Output

```text
=== Championship Scores After Sorting ===
10 8 6 4 2 1 7 3 8 2

=== Search Results ===
8: FOUND at indices 1, 8
   Total occurrences: 2

2: FOUND at indices 4, 9
   Total occurrences: 2

5: NOT FOUND

7: FOUND at index 6
   Total occurrences: 1
```

**Note:** Array indices start from 0.

### F. Sorting Demonstration

The identified algorithm is Insertion Sort.

Starting array:

```text
6 2 10 4 8 1 7 3 8 2
```

The array changes after each pass as follows:

| Pass | Array |
|:---:|:---|
| Initial | 6 2 10 4 8 1 7 3 8 2 |
| 1 | 6 2 10 4 8 1 7 3 8 2 |
| 2 | 10 6 2 4 8 1 7 3 8 2 |
| 3 | 10 6 4 2 8 1 7 3 8 2 |
| 4 | 10 8 6 4 2 1 7 3 8 2 |

The array is not completely sorted because the program stops immediately after the fourth pass.

**Important:** The searching process must use the resulting array after the specified number of sorting passes, not the completely sorted array.

---

*This is a practice simulation based on the Pre-lab 4 learning materials. It is not an official question.*