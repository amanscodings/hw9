class TreeNode:
  def __init__(self, val=0, left=None, right=None):
      self.val = val
      self.left = left
      self.right = right

class Solution:
  def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
      if root is None:
          return None

      if root.val > p.val and root.val > q.val:
          return self.lowestCommonAncestor(root.left, p, q)
      elif root.val < p.val and root.val < q.val:
          return self.lowestCommonAncestor(root.right, p, q)
      else:
          return root

# Test cases
solution = Solution()

# Creating the tree
root = TreeNode(4)
root.left = TreeNode(3)
root.left.left = TreeNode(1)
root.right = TreeNode(8)
root.right.left = TreeNode(5)
root.right.right = TreeNode(9)

# Test cases
p1 = root.left.left  # Node with value 1
q1 = root.left       # Node with value 3
p2 = root.left       # Node with value 3
q2 = root.right.left  # Node with value 5

# Output for test cases
print(solution.lowestCommonAncestor(root, p1, q1).val)  # Output: 3
print(solution.lowestCommonAncestor(root, p2, q2).val)  # Output: 4