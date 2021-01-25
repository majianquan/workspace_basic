class Node {
    constructor(key,left,right) {
        this.key = key
        this.left = left
        this.right = right
    }
}
class BinarySearchTree {
    constructor() {
        this.root = null
    }
    // 向树中插入一个新的键
    insert(key) {
        let newNode = new Node(key)
        if(this.root === null) {
            this.root = newNode
        } else {
            this._insetNode(this.root, newNode)
        }
    }
    _insetNode(node, newNode) {
        if(node.key < newNode.key) {
            if(node.left === null) {
                node.left = newNode
            } else {
                this._insetNode(node.left, newNode)
            }
        }  else {
            if(node.right === null) {
                node.right = newNode
            } else {
                this._insetNode(node.right, newNode)
            }
        }
    }
    // 前序遍历
    preOrderTraverse(callback) {
        if(this.root === null) {
            throw new Error('二叉树为空')
        }
        this._preOrderTraverse(this.root, callback)
    }
    _preOrderTraverse(node, callback) {
        if(node !== null) {
            callback(node)
            this._preOrderTraverse(node.left)
            this._preOrderTraverse(node.right)
        }
    }
    // 中序遍历
    inOrderTraverse(callback) {
        if(this.root === null) {
            throw new Error('二叉树为空')
        }
        this._inOrderTraverse(this.root, callback)
    }
    _inOrderTraverse(node, callback) {
        if(node !== null) {
            this._preOrderTraverse(node.left)
            callback(node)
            this._preOrderTraverse(node.right)
        }
    }
    // 后序遍历
    postOrderTraverse(callback) {
        if(this.root === null) {
            throw new Error('二叉树为空')
        }
        this._postOrderTraverse(this.root, callback)
    }
    _postOrderTraverse(node, callback) {
        if(node !== null) {
            this._preOrderTraverse(node.left)
            this._preOrderTraverse(node.right)
            callback(node)
        }
    }
    // 返回树中最小的值/键
    min() {
        return this._minNode(root)
    }
    _minNode(node) {
        if(node) {
            while (node.left != null) {
                node = node.left
            }
            return node.key
        }
        return null
    }
    // 返回树中最大的值/键
    max() {
        return this._maxNode(this.root)
    }
    _maxNode(node) {
        if(node) {
            while (node.right != null) {
                node = node.right
            }
            return node.key
        }
        return null
    }
    // 从树中移除某个键
    remove(key) {
        return this._removeNode(this.root, key)
    }
    _removeNode(node, key) {
        if(node == null) {
            return null
        }
        if(node.key > key) {
            node.left = this._removeNode(node.left, key)
            return node
        } else if(node.key < key) {
            node.right = this._removeNode(node.right, key)
            return node
        } else {
            if(node.right == null && node.left == null) {
                node = null
                return node
            }
            if(node.left == null) {
                node = node.right;
                return node
            } else if(node.right == null) {
                node = node.left
                return node
            }
            var aux = this._minNode(node.right)
            node.key = aux.key
            node.right = this._removeNode(node.right, aux.key)
        }
    }
    // 在树中查找一个键，如果节点存在，则返回 true ；如果不存在，则返回false
    search(key) {
        return this._searchNode(this.root, key)
    }
    _searchNode(node, key) {
        if(node == null) {
            return false
        } else {
            if(node.key > key) {
                return this._searchNode(node.left,key)
            } else if(node.key < key) {
                return this._searchNode(node.right,key)
            } else {
                return true
            }
        }
    }
}