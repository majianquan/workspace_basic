class Graph {
    constructor() {
        this.virtices = []
        this.edges = new Map()
    }
    addVertex(v) {
        this.virtices.push(v)
        this.edges.set(v, [])
    }
    addEdge(v, w) {
        let vEdge = this.edges.get(v)
        vEdge.push(w)
        let wEdge = this.edges.get(w)
        wEdge.push(v)
        this.edges.set(v, vEdge)
        this.edges.set(w, wEdge)
    }
    toString() {
        let s = ''
        for (let i = 0; i < this.virtices.length; i++) {
            s +=  this.virtices[i] + '=>'
            let neighbor =  this.edges.get(this.virtices[i])
            for (let j = 0; j < neighbor.length; j++) {
                s += neighbor[j] + ' '
            }
            s += '\n'
        }
        return s
    }
    dfs() {
        let marked = {}
        const that = this
        function dfsVisit(u) {
            marked[u] = true
            console.log(u)
            let neighbor = that.edges.get(u)
            for (let i = 0; i < neighbor.length; i++) {
                let w = neighbor[i]
                if(!marked[w]) {
                    dfsVisit(w)
                }
            }
        }
        for (let i = 0; i < this.virtices.length; i++) {
            if(!marked[this.virtices[i]]) {
                dfsVisit(this.virtices[i])
            }
        }
    }
    bfs(v) {
        let queue = []
        let marked = {}
        marked[v] = true
        queue.push(v)
        while (queue.length > 0) {
            let s = queue.shift()
            if(this.edges.get(v)) {
                console.log('visited vertex:', s)
            }
            let neighbor = this.edges.get(s)
            for (let i = 0; i < neighbor.length; i++) {
                let w = neighbor[i]
                marked[w] = true
                queue.push(w)
            }
        }
    }
}