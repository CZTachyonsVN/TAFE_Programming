---
tags:
  - notes
unit: Java
semester: 2
week: 6
---
If given number is larger (equal) than current node => move to the right
	Else => move to left
If there is no more node to compare with => become a node

When deleting
	Replace with the right-most node that in on the left side of the deleted node.

### Rules of traversal
**Pre-order** Print => left => right
	useful for replicating a binary tree
**Post-order** Left => right => print
**In-order** Left => print => right
	Prints values in sorted manner