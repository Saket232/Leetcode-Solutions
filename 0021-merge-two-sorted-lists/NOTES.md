**Dummy Node:**
​
We create a dummy node to act as the starting point of our merged list. This approach simplifies the merging process by avoiding special cases for the head node. The final merged list will start from dummy.next.
**Merging in Sorted Order:**
​
We loop while both list1 and list2 have nodes.
For each iteration, we compare the values of the current nodes in list1 and list2. We append the node with the smaller value to current.next, and then move the pointer (either list1 or list2) to the next node.
**Appending Remaining Nodes:**
​
After the loop, one of the lists may still have nodes remaining (because it had larger elements at the end). We simply point current.next to the remaining nodes in either list1 or list2.
Return the Merged List:
​
Since dummy is an artificial starting point, the actual head of the merged list is dummy.next.
**Complexity Analysis
Time Complexity:**
𝑂(𝑛+𝑚)
O(n+m), where
n is the number of nodes in list1 and
m is the number of nodes in list2. We only traverse each list once.
**Space Complexity:**
O(1), as we only use a constant amount of extra space.